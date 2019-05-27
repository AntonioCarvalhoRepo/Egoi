package egoi.aac.demo.gateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egoi.aac.demo.dto.CategoryDTO;
import egoi.aac.demo.entity.EgoiCategory;
import egoi.aac.demo.entity.EgoiCategoryRepository;
import egoi.aac.demo.mapper.CategoryMapper;
import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class EGoiGateway {
	@Autowired
    private EgoiCategoryRepository repository;
	
	@Autowired
	private CategoryMapper categoryMapper;

    @GetMapping(path = "/")
    public List<CategoryDTO> findAll() {
    	List<CategoryDTO> myMappedDTO = new ArrayList<CategoryDTO>();
    	
    	repository.findAll().stream().forEach(x ->{
    		myMappedDTO.add(categoryMapper.mapRepoToDTO(x,repository.findSubCategories(x.getId())));
    	});
    	
    	
    	return myMappedDTO;
    }
    
    @GetMapping(path = "/{name}")
    public List<CategoryDTO> find(@PathVariable("name") String name) { 	
        List<CategoryDTO> myMappedDTO = new ArrayList<CategoryDTO>();
    	
        repository.findAllbyName(name).stream().forEach(x ->{
    		myMappedDTO.add(categoryMapper.mapRepoToDTO(x,repository.findSubCategories(x.getId())));
    	});
    	
    	
    	return myMappedDTO;
    }
    
    @PostMapping(consumes = "application/json")
    public CategoryDTO createSimple(@RequestBody EgoiCategory EgoiCategory) {
        return categoryMapper.mapRepoToCategoryDTO(repository.save(EgoiCategory));
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") int id) {
        repository.deleteById(id);
    }

    @PutMapping(path = "{id}")
    public CategoryDTO update(@PathVariable("id") int id, @RequestBody EgoiCategory EgoiCategory) throws BadHttpRequest {
        if (repository.existsById(id)) {
            EgoiCategory.setId(id);
            return categoryMapper.mapRepoToCategoryDTO(repository.save(EgoiCategory));
        } else {
            throw new BadHttpRequest();
        }
    }
}
