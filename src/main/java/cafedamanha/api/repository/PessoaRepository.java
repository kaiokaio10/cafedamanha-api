package cafedamanha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cafedamanha.api.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaQuery {

	

}
