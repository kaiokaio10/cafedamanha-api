package cafedamanha.api.repository;

import java.util.List;

import cafedamanha.api.dto.PessoaDTO;
import cafedamanha.api.entity.Pessoa;

public interface PessoaQuery {

	Long inserir(Pessoa entity);

	void excluir(Long id);

	void alterar(Pessoa entity);

	List<Pessoa> pesquisar(PessoaDTO dto);

	Pessoa pesquisarPorId(Long id);
	
	List<Pessoa> listarTodos();

}
