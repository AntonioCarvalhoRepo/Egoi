package egoi.aac.demo.gateway;

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

import egoi.aac.demo.entity.EgoiCategory;
import egoi.aac.demo.entity.EgoiCategoryRepository;
import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class EGoiGateway {
	@Autowired
    private EgoiCategoryRepository repository;

    @GetMapping(path = "/")
    public Iterable<EgoiCategory> findAll() {
        return repository.findAll();
    }
    
    @GetMapping(path = "/{name}")
    public List<EgoiCategory> find(@PathVariable("name") String name) {
        return repository.findAllbyName(name);
    }

//    @PostMapping(consumes = "application/json")
//    public List<EgoiCategory> create(@RequestBody List<EgoiCategory> EgoiCategory) {
//        return repository.saveAll(EgoiCategory);
//    }
    
    @PostMapping(consumes = "application/json")
    public EgoiCategory createSimple(@RequestBody EgoiCategory EgoiCategory) {
        return repository.save(EgoiCategory);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") int id) {
        repository.deleteById(id);
    }

    @PutMapping(path = "{id}")
    public EgoiCategory update(@PathVariable("id") int id, @RequestBody EgoiCategory EgoiCategory) throws BadHttpRequest {
        if (repository.existsById(id)) {
            EgoiCategory.setId(id);
            return repository.save(EgoiCategory);
        } else {
            throw new BadHttpRequest();
        }
    }
}
