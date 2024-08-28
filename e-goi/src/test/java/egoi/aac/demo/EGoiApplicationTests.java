package egoi.aac.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import egoi.aac.demo.entity.EgoiCategory;
import egoi.aac.demo.entity.EgoiCategoryRepository;

/**
 * The Class EGoiApplicationTests.
 * @author Antonio Carvalho
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class EGoiApplicationTests {
	
	/** The mvc. */
	@Autowired
	private MockMvc mvc;
	
	/** The category repo. */
	@Mock
	private EgoiCategoryRepository categoryRepo;

	/**
	 * Creates the category API.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void createCategoryAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/").content(asJsonString(new EgoiCategory(1, 1, "Test", null, null)))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}

	/**
	 * Update category then find by name API.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void updateCategoryThenFindByNameAPI() throws Exception {
		List<EgoiCategory> dummyList = new ArrayList<EgoiCategory>();
		EgoiCategory dummyCategory = new EgoiCategory(1, 1, "Test", null, null);
		Optional<EgoiCategory> optional = Optional.of(dummyCategory);
		
		when(categoryRepo.findById(dummyCategory.getId())).thenReturn(optional);
		when(categoryRepo.findAllbyName(dummyCategory.getName())).thenReturn(dummyList);
		mvc.perform(MockMvcRequestBuilders.put("/{id}", dummyCategory.getId())
				.content(asJsonString(new EgoiCategory(1, 1, "CategoryUpdate", null, null)))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
	}

	/**
	 * Delete category.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void deleteCategory() throws Exception {
		EgoiCategory dummyCategory = new EgoiCategory(1, 1, "Test", null, null);
		Optional<EgoiCategory> optional = Optional.of(dummyCategory);

		when(categoryRepo.findById(dummyCategory.getId())).thenReturn(optional);
		mvc.perform(delete("/{id}", dummyCategory.getId())).andExpect(status().isOk());
	}

	/**
	 * As json string.
	 *
	 * @param  obj
	 * @return the string
	 */
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
