package egoi.aac.demo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The Interface EgoiCategoryRepository.
 * @author Antonio Carvalho
 */
@Repository
public interface EgoiCategoryRepository extends JpaRepository<EgoiCategory, Integer>{

	/**
	 * Find allby name.
	 *
	 * @param name the name
	 * @return the list
	 */
	@Query("SELECT egoi FROM EgoiCategory egoi WHERE egoi.name=?1")
	List<EgoiCategory> findAllbyName(String name);
	
	
	/**
	 * Find sub categories.
	 *
	 * @param category_id the category id
	 * @return the list
	 */
	@Query("SELECT egoi FROM EgoiCategory egoi WHERE egoi.category_id=?1")
	List<EgoiCategory> findSubCategories(int category_id);
}
