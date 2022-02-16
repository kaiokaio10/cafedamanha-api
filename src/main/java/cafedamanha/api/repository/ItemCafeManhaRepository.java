package cafedamanha.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cafedamanha.api.entity.ItemCafeManha;

@Repository
public interface ItemCafeManhaRepository extends JpaRepository<ItemCafeManha, Long> {

	@Query(value = "SELECT * FROM ITEM_CAFE_MANHA ORDER BY NOME ASC", nativeQuery = true)
	List<ItemCafeManha> listarItemCafeManha();

}
