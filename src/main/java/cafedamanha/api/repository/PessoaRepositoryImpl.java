package cafedamanha.api.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import cafedamanha.api.dto.PessoaDTO;
import cafedamanha.api.entity.Pessoa;

public class PessoaRepositoryImpl implements PessoaQuery {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long inserir(Pessoa entity) {

		String sql = "INSERT INTO PESSOA ( NOME, CPF) VALUES ( ?, ? ) RETURNING ID_PESSOA";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, entity.getNome());
		query.setParameter(2, entity.getCpf());
		BigInteger id = (BigInteger) query.getSingleResult();
		return Long.valueOf(id.toString());

	}

	@Override
	public void excluir(Long id) {
		String sql = "DELETE FROM PESSOA WHERE ID_PESSOA = ?";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, id);
		query.executeUpdate();

	}

	@Override
	public void alterar(Pessoa entity) {
		String sql = "UPDATE Pessoa SET NOME = ?, CPF = ? WHERE ID_PESSOA = ?";

		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(3, entity.getId());
		query.setParameter(1, entity.getNome());
		query.setParameter(2, entity.getCpf());
		query.executeUpdate();

	}

	@Override
	public List<Pessoa> pesquisar(PessoaDTO dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM Pessoa p ");

		if (StringUtils.isNotBlank(dto.getNome())) {
			sql.append("WHERE lower(p.NOME) like lower (?)");
		}

		Query query = entityManager.createNativeQuery(sql.toString(), Pessoa.class);
		if (StringUtils.isNotBlank(dto.getNome())) {
			query.setParameter(1, "%" + dto.getNome() + "%");
		}
		return query.getResultList();
	}

	@Override
	public Pessoa pesquisarPorId(Long id) {
		String sql = "SELECT p.* FROM Pessoa p WHERE ID_PESSOA = ?";

		Query query = entityManager.createNativeQuery(sql, Pessoa.class);
		query.setParameter(1, id);
		return (Pessoa) query.getSingleResult();
	}

	@Override
	public List<Pessoa> listarTodos() {
	String sql = "SELECT * FROM Pessoa ";

	Query query = entityManager.createNativeQuery(sql, Pessoa.class);
	return (List<Pessoa>) query.getResultList();
}

}
