package cafedamanha.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cafedamanha.api.dto.request.PessoaDTO;
import cafedamanha.api.service.PessoaService;
import lombok.AllArgsConstructor;

@Controller
@RestController
@RequestMapping("/colaborador")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin("http://localhost:4200")
public class PessoaController {

	private final PessoaService service;

	@GetMapping("/teste")
	public String test() {
		return "teste api cafe da manha";
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> criarCliente(@RequestBody PessoaDTO pessoaDTO) {
		PessoaDTO dto = service.inserir(pessoaDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> deletarId(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.status(HttpStatus.OK).body("Pessoa removida com sucesso");
	}
	
	@PutMapping
	public ResponseEntity<?> atualizar(
			 @RequestBody PessoaDTO pessoaDTO)
			 {

		PessoaDTO dto = service.alterar(pessoaDTO);

		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/pesquisarnome/{nome}")
	public ResponseEntity<?> listarPorNome(@PathVariable(required = true) String nome) {

		List<?> dto = service.listar(nome);

		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}


}
