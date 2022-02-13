package cafedamanha.api.dto;

import lombok.Data;

@Data
public class PessoaItemCafeManhaDTO {

	private Long id;

	private PessoaDTO pessoa;

	private ItemCafeManhaDTO itemCafeManha;

}
