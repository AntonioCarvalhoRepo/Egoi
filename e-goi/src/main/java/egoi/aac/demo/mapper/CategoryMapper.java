package egoi.aac.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import egoi.aac.demo.dto.CategoryDTO;
import egoi.aac.demo.dto.SubCategoryDTO;
import egoi.aac.demo.entity.EgoiCategory;

/**
 * The Class CategoryMapper.
 * @author Antonio Carvalho
 */
@Component
public class CategoryMapper {

	/**
	 * Map repo to DTO.
	 *
	 * @param repoData the repo data
	 * @param subCategoryList the sub category list
	 * @return the category DTO
	 */
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

	/**
	 * Map repo to category DTO.
	 *
	 * @param repoData the repo data
	 * @return the category DTO
	 */
	public CategoryDTO mapRepoToCategoryDTO(EgoiCategory repoData) {
		CategoryDTO mappedCategoryDTO = new CategoryDTO();

		mappedCategoryDTO.setId(repoData.getId());
		mappedCategoryDTO.setName(repoData.getName());
		mappedCategoryDTO.setCreated(repoData.getCreated());
		mappedCategoryDTO.setModified(repoData.getModified());
		return mappedCategoryDTO;
	}
	
	/**
	 * Map repo to sub category DTO.
	 *
	 * @param repoData the repo data
	 * @return the sub category DTO
	 */
	private SubCategoryDTO mapRepoToSubCategoryDTO(EgoiCategory repoData) {
		SubCategoryDTO mappedSubCategoryDTO = new SubCategoryDTO();

		mappedSubCategoryDTO.setId(repoData.getId());
		mappedSubCategoryDTO.setName(repoData.getName());
		mappedSubCategoryDTO.setCreated(repoData.getCreated());
		mappedSubCategoryDTO.setModified(repoData.getModified());
		return mappedSubCategoryDTO;
	}
}
