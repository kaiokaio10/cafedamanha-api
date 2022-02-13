package cafedamanha.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import cafedamanha.api.dto.PessoaDTO;
import cafedamanha.api.service.PessoaService;
import lombok.AllArgsConstructor;

@Controller
@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin("https://cafemanhafront-api.herokuapp.com")
public class PessoaController {
	private final PessoaService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> inserir(@RequestBody PessoaDTO pessoaDTO) {
		PessoaDTO dto = service.inserir(pessoaDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		service.excluir(id);
		return ResponseEntity.status(HttpStatus.OK).body("Pessoa removida com sucesso");
	}

	@PutMapping
	public ResponseEntity<?> alterar(@RequestBody PessoaDTO pessoaDTO) {

		PessoaDTO dto = service.alterar(pessoaDTO);

		return ResponseEntity.ok(dto);
	}

	@PostMapping("/pesquisar")
	public ResponseEntity<?> pesquisar(@RequestBody PessoaDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.pesquisar(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> pesquisarPorId(@PathVariable(required = true) Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.pesquisarPorId(id));
	}
}
