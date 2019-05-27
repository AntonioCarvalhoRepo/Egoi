package egoi.aac.demo.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {
	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("created")
	private Date created;
	@JsonProperty("modified")
	private Date modified;
	@JsonProperty("subcategories")
	private List<SubCategoryDTO> subCategories;
	
}
