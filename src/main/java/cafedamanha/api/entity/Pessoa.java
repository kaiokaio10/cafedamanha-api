package cafedamanha.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PESSOA")
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PESSOA")
	private Long id;

	@Column(nullable = false, name = "NOME")
	private String nome;

	@Column(nullable = false, unique = true, name = "CPF")
	private String cpf;

	public Pessoa(Long id) {
		super();
		this.id = id;
	}

}
