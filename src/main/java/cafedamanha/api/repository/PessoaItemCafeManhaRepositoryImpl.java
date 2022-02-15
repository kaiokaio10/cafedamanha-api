package cafedamanha.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cafedamanha.api.entity.ItemCafeManha;

public class PessoaItemCafeManhaRepositoryImpl implements PessoaItemCafeManhaQuery {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ItemCafeManha> pesquisarItemCafeManhaPorIdPessoa(Long idPessoa) {
		StringBuilder sql = new StringBuilder();

		sql.append(" select item.* from item_cafe_manha item ");
		sql.append(" inner join pessoa_item_cafe_manha pessoaItem  ");
		sql.append(" on pessoaItem.id_item_cafe_manha = item.id_item_cafe_manha ");
		sql.append(" where pessoaItem.id_pessoa = ?   ");

		Query query = entityManager.createNativeQuery(sql.toString(), ItemCafeManha.class).setParameter(1, idPessoa);
		return query.getResultList();
	}

}
