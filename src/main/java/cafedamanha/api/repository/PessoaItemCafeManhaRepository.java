package cafedamanha.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cafedamanha.api.entity.PessoaItemCafeManha;

public interface PessoaItemCafeManhaRepository extends JpaRepository<PessoaItemCafeManha, Long> {

	@Query(value = "SELECT * FROM PESSOA_ITEM_CAFE_MANHA WHERE ID = :id", nativeQuery = true)
	List<PessoaItemCafeManha> pesquisarPessoaItemCafeManha(@Param("id") Long id);

	@Query(value = "INSERT INTO PESSOA_ITEM_CAFE_MANHA " 
			+ "( ID_PESSOA,ID_ITEM_CAFE_MANHA )"
			+ " VALUES ( :#{#pi.pessoa.id},:#{#pi.itemCafeManha.id} ) RETURNING ID_PESSOA_ITEM_CAFE_MANHA",
			nativeQuery = true)
	void inserir(@Param("pi") PessoaItemCafeManha entity);
	
	
}
