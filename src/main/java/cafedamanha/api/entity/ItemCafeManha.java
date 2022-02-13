package cafedamanha.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ITEM_CAFE_MANHA")
public class ItemCafeManha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ITEM_CAFE_MANHA")
	private Long id;

	@Column(nullable = false, name = "NOME")
	private String nome;

	@Column(nullable = false, name = "DESCRICAO")
	private String descricao;

}
