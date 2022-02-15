package cafedamanha.api.repository;

import java.util.List;

import cafedamanha.api.entity.ItemCafeManha;
import cafedamanha.api.entity.PessoaItemCafeManha;

public interface PessoaItemCafeManhaQuery {

	List<ItemCafeManha> pesquisarItemCafeManhaPorIdPessoa(Long idPessoa);
	
	List<PessoaItemCafeManha> pesquisarItemCafeManhaPorIdItem(List<Long> idsItens, Long idPessoa);

}
