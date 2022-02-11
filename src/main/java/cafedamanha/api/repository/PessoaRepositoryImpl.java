package cafedamanha.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cafedamanha.api.entity.Pessoa;

public class PessoaRepositoryImpl implements PessoaQuery {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void inserir(Pessoa entity) {

		String sql = "INSERT INTO PESSOA ( NOME, CPF) VALUES ( ?, ? )";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, entity.getNome());		
		query.setParameter(2, entity.getCpf());
		query.executeUpdate();

	}

	@Override
	public void deletar(Long id) {
		String sql = "DELETE FROM PESSOA WHERE ID = ?";
		Query query =  entityManager.createNativeQuery(sql);
		query.setParameter(1, id);
		query.executeUpdate();
		
	}

	@Override
	public void alterar(Pessoa entity) {
		String sql = "UPDATE Pessoa SET NOME = ?, CPF = ? WHERE ID = ?";
		
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(3, entity.getId());		
		query.setParameter(1, entity.getNome());
		query.setParameter(2, entity.getCpf());
		query.executeUpdate();

		
		
	}

	@Override
	public List<Pessoa> listar(String nome) {
		String sql = "SELECT p.* FROM PESSOA p WHERE lower(p.NOME) like lower (?)";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, "%" + nome + "%");
		return query.getResultList();
		
	}

}
