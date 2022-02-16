package cafedamanha.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

	private Long id;

	private String nome;

	private String cpf;

	private List<ItemCafeManhaDTO> listaSelecionado;

}
