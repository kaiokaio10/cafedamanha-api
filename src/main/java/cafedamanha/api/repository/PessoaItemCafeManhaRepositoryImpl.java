package cafedamanha.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cafedamanha.api.dto.PessoaItemCafeManhaDTO;
import cafedamanha.api.entity.ItemCafeManha;
import cafedamanha.api.entity.PessoaItemCafeManha;

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

	@Override
	public List<PessoaItemCafeManha> pesquisarItemCafeManhaPorIdItem(List<Long> idsItens, Long idPessoa) {
		StringBuilder sql = new StringBuilder();

		sql.append(" select pessoaItem.* from item_cafe_manha item ");
		sql.append(" inner join pessoa_item_cafe_manha pessoaItem  ");
		sql.append(" on pessoaItem.id_item_cafe_manha = item.id_item_cafe_manha ");
		sql.append(" where pessoaItem.id_item_cafe_manha in (:ids) ");

		if (idPessoa != null) {
			sql.append(" and pessoaItem.id_pessoa != :idPessoa ");
		}

		Query query = entityManager.createNativeQuery(sql.toString(), PessoaItemCafeManha.class).setParameter("ids",
				idsItens);
		if (idPessoa != null) {
			query.setParameter("idPessoa", idPessoa);
		}

		return query.getResultList();
	}

}
