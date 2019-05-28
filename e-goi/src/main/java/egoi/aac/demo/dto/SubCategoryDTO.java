package egoi.aac.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Instantiates a new sub category DTO.
 * @author Antonio Carvalho
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubCategoryDTO {
	
	/** The id. */
	@JsonProperty("id")
	private int id;
	
	/** The name. */
	@JsonProperty("name")
	private String name;
	
	/** The created. */
	@JsonProperty("created")
	private Date created;
	
	/** The modified. */
	@JsonProperty("modified")
	private Date modified;
}
