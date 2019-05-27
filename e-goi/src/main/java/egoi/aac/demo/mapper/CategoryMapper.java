package egoi.aac.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import egoi.aac.demo.dto.CategoryDTO;
import egoi.aac.demo.entity.EgoiCategory;

@Component
public class CategoryMapper {
	
	public CategoryDTO mapRepoToDTO(EgoiCategory repoData) {
		CategoryDTO mappedDTO = new CategoryDTO();
		
		mappedDTO.setId(repoData.getId());
		mappedDTO.setName(repoData.getName());
		mappedDTO.setCreated(repoData.getCreated());
		mappedDTO.setModified(repoData.getModified());
		
		return mappedDTO;		
	}
	
	public List<CategoryDTO> mapRepoToDTOCollection(List<EgoiCategory> repoDataCollection) {
		List<CategoryDTO> dtoCollection = new ArrayList<CategoryDTO>();
		
		repoDataCollection.stream().forEach(x -> {
			CategoryDTO mappedDTO = new CategoryDTO();		
			mappedDTO.setId(x.getId());
			mappedDTO.setName(x.getName());
			mappedDTO.setCreated(x.getCreated());
			mappedDTO.setModified(x.getModified());
			
			dtoCollection.add(mappedDTO);
		});

		
		return dtoCollection;		
	}

}
