package cafedamanha.api.repository;

import java.util.List;

import cafedamanha.api.entity.Pessoa;

public interface PessoaQuery {
	
	void inserir(Pessoa entity);
	
	void deletar(Long id);
	
	void alterar(Pessoa entity);

	List<?> listar(String nome);
}
