package egoi.aac.demo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EgoiCategoryRepository extends JpaRepository<EgoiCategory, Integer>{

	@Query("SELECT egoi FROM EgoiCategory egoi WHERE egoi.name=?1")
	List<EgoiCategory> findAllbyName(String name);

}
