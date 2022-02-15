package cafedamanha.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cafedamanha.api.dto.ItemCafeManhaDTO;
import cafedamanha.api.dto.PessoaDTO;
import cafedamanha.api.service.PessoaService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PessoaController.class)
public class PessoaControllerTest {

	@MockBean
	private PessoaService service;
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void teste_criar_pessoa_controller() throws JsonProcessingException, Exception {
		PessoaDTO post = montaDTO();

		mockMvc.perform(post("/pessoa").contentType("application/json").content(objectMapper.writeValueAsString(post)))
				.andExpect(status().isCreated());
	}

	private PessoaDTO montaDTO() {

		ItemCafeManhaDTO item = new ItemCafeManhaDTO();
		item.setId(1l);
		item.setNome("café");
		item.setDescricao("café 1 litro");

		List<ItemCafeManhaDTO> listaItensCafe = new ArrayList<ItemCafeManhaDTO>();
		listaItensCafe.add(item);

		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setNome("teste");
		pessoaDTO.setCpf("99533270106");
		pessoaDTO.setListaSelecionado(listaItensCafe);

		return pessoaDTO;

	}
}
