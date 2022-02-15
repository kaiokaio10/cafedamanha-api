package cafedamanha.api.repository;

import java.util.List;

import cafedamanha.api.entity.ItemCafeManha;

public interface PessoaItemCafeManhaQuery {

	List<ItemCafeManha> pesquisarItemCafeManhaPorIdPessoa(Long idPessoa);

}
