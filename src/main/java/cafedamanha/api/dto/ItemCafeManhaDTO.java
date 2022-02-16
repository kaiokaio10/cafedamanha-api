package cafedamanha.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCafeManhaDTO  {

	private Long id;

	private String nome;

	private String descricao;

}
