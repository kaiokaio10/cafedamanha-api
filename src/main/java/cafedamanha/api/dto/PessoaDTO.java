package cafedamanha.api.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private String cpf;
	
	private List<ItemCafeManhaDTO> listaSelecionado;
	

}
