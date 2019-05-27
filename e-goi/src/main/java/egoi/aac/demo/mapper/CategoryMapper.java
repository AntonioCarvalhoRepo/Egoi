package egoi.aac.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import egoi.aac.demo.dto.CategoryDTO;
import egoi.aac.demo.dto.SubCategoryDTO;
import egoi.aac.demo.entity.EgoiCategory;

@Component
public class CategoryMapper {

	public CategoryDTO mapRepoToDTO(EgoiCategory repoData, List<EgoiCategory> subCategoryList) {
		CategoryDTO simpleDTO = mapRepoToCategoryDTO(repoData);
		
		if(subCategoryList.size() > 0) {
			List<SubCategoryDTO> mySubCategories = new ArrayList<SubCategoryDTO>();
			subCategoryList.stream().forEach(x -> {
				mySubCategories.add(mapRepoToSubCategoryDTO(x));
			});
			simpleDTO.setSubCategories(mySubCategories);			
		}

		return simpleDTO;
	}

	public CategoryDTO mapRepoToCategoryDTO(EgoiCategory repoData) {
		CategoryDTO mappedCategoryDTO = new CategoryDTO();

		mappedCategoryDTO.setId(repoData.getId());
		mappedCategoryDTO.setName(repoData.getName());
		mappedCategoryDTO.setCreated(repoData.getCreated());
		mappedCategoryDTO.setModified(repoData.getModified());
		return mappedCategoryDTO;
	}
	
	private SubCategoryDTO mapRepoToSubCategoryDTO(EgoiCategory repoData) {
		SubCategoryDTO mappedSubCategoryDTO = new SubCategoryDTO();

		mappedSubCategoryDTO.setId(repoData.getId());
		mappedSubCategoryDTO.setName(repoData.getName());
		mappedSubCategoryDTO.setCreated(repoData.getCreated());
		mappedSubCategoryDTO.setModified(repoData.getModified());
		return mappedSubCategoryDTO;
	}
}
