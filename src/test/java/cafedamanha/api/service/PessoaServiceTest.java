package cafedamanha.api.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;

import cafedamanha.api.dto.ItemCafeManhaDTO;
import cafedamanha.api.dto.PessoaDTO;
import cafedamanha.api.entity.ItemCafeManha;
import cafedamanha.api.entity.Pessoa;
import cafedamanha.api.mapper.PessoaMapper;
import cafedamanha.api.repository.PessoaRepository;

public class PessoaServiceTest {

	  @InjectMocks
	    private PessoaService service;
	    @Mock
	    private PessoaRepository repository;
	    @Mock
	    private PessoaMapper mapper;
	    @Mock
	    private MessageSource messageSource;
	    
	    @Test
	    public void cadastrar_pessoa_com_sucesso() {
	        when(repository.inserir(Mockito.any(Pessoa.class)));
	        when(mapper.toEntity(Mockito.any(PessoaDTO.class))).thenReturn(montaEntity());
	        when(mapper.toDto(Mockito.any(Pessoa.class))).thenReturn(montaDTO());
	        PessoaDTO pessoaDTO = service.inserir(montaDTO());
	        Mockito.verify(repository, Mockito.atLeastOnce()).save(montaEntity());
	        assertNotNull(pessoaDTO);
	    }
	    private Pessoa montaEntity() {

			Pessoa pessoa = new Pessoa();
			pessoa.setNome("teste");
			pessoa.setCpf("99533270106");

			return pessoa;

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
	    
	    @Test
	    public void cadastrar_pessoa_sem_nome() {
	        when(repository.inserir(Mockito.any(Pessoa.class)));
	        when(mapper.toEntity(Mockito.any(PessoaDTO.class))).thenReturn(montaEntitySemNome());
	        when(mapper.toDto(Mockito.any(Pessoa.class))).thenReturn(montaDTOSemNome());
	        PessoaDTO pessoaDTO = service.inserir(montaDTOSemNome());
	        Mockito.verify(repository, Mockito.atLeastOnce()).save(montaEntitySemNome());
	        assertNotNull(pessoaDTO);
	    }
	    private Pessoa montaEntitySemNome() {

			Pessoa pessoa = new Pessoa();
			pessoa.setNome("");
			pessoa.setCpf("99533270106");

			return pessoa;

		}
	    private PessoaDTO montaDTOSemNome() {

			ItemCafeManhaDTO item = new ItemCafeManhaDTO();
			item.setId(1l);
			item.setNome("café");
			item.setDescricao("café 1 litro");

			List<ItemCafeManhaDTO> listaItensCafe = new ArrayList<ItemCafeManhaDTO>();
			listaItensCafe.add(item);

			PessoaDTO pessoaDTO = new PessoaDTO();
			pessoaDTO.setNome("");
			pessoaDTO.setCpf("99533270106");
			pessoaDTO.setListaSelecionado(listaItensCafe);

			return pessoaDTO;

		}
	    @Test
	    public void cadastrar_pessoa_sem_cpf() {
	        when(repository.inserir(Mockito.any(Pessoa.class)));
	        when(mapper.toEntity(Mockito.any(PessoaDTO.class))).thenReturn(montaEntitySemCPF());
	        when(mapper.toDto(Mockito.any(Pessoa.class))).thenReturn(montaDTOSemCPF());
	        PessoaDTO pessoaDTO = service.inserir(montaDTOSemCPF());
	        Mockito.verify(repository, Mockito.atLeastOnce()).save(montaEntitySemCPF());
	        assertNotNull(pessoaDTO);
	    }
	    private Pessoa montaEntitySemCPF() {

			Pessoa pessoa = new Pessoa();
			pessoa.setNome("teste");
			pessoa.setCpf("");

			return pessoa;

		}
	    private PessoaDTO montaDTOSemCPF() {

			ItemCafeManhaDTO item = new ItemCafeManhaDTO();
			item.setId(1l);
			item.setNome("café");
			item.setDescricao("café 1 litro");

			List<ItemCafeManhaDTO> listaItensCafe = new ArrayList<ItemCafeManhaDTO>();
			listaItensCafe.add(item);

			PessoaDTO pessoaDTO = new PessoaDTO();
			pessoaDTO.setNome("teste");
			pessoaDTO.setCpf("");
			pessoaDTO.setListaSelecionado(listaItensCafe);

			return pessoaDTO;

		}
	    @Test
	    public void cadastrar_pessoa_sem_lista() {
	        when(repository.inserir(Mockito.any(Pessoa.class)));
	        when(mapper.toEntity(Mockito.any(PessoaDTO.class))).thenReturn(montaEntitySemLista());
	        when(mapper.toDto(Mockito.any(Pessoa.class))).thenReturn(montaDTOSemLista());
	        PessoaDTO pessoaDTO = service.inserir(montaDTOSemLista());
	        Mockito.verify(repository, Mockito.atLeastOnce()).save(montaEntitySemLista());
	        assertNotNull(pessoaDTO);
	    }
	    private Pessoa montaEntitySemLista() {

			Pessoa pessoa = new Pessoa();
			pessoa.setNome("teste");
			pessoa.setCpf("99533270106");

			return pessoa;

		}
	    private PessoaDTO montaDTOSemLista() {

			ItemCafeManhaDTO item = new ItemCafeManhaDTO();
			item.setId(1l);
			item.setNome("café");
			item.setDescricao("café 1 litro");

			PessoaDTO pessoaDTO = new PessoaDTO();
			pessoaDTO.setNome("testes");
			pessoaDTO.setCpf("99533270106");
			pessoaDTO.setListaSelecionado(null);

			return pessoaDTO;

		}
	    @Test
	    public void cadastrar_pessoa_vazio() {
	        when(repository.inserir(Mockito.any(Pessoa.class)));
	        when(mapper.toEntity(Mockito.any(PessoaDTO.class))).thenReturn(montaEntityVazio());
	        when(mapper.toDto(Mockito.any(Pessoa.class))).thenReturn(montaDTOVazio());
	        PessoaDTO pessoaDTO = service.inserir(montaDTOVazio());
	        Mockito.verify(repository, Mockito.atLeastOnce()).inserir(montaEntityVazio());
	        assertNotNull(pessoaDTO);
	    }
	    private Pessoa montaEntityVazio() {

			Pessoa pessoa = new Pessoa();
			pessoa.setNome(null);
			pessoa.setCpf(null);

			return pessoa;

		}
	    private PessoaDTO montaDTOVazio() {


			PessoaDTO pessoaDTO = new PessoaDTO();
			pessoaDTO.setNome(null);
			pessoaDTO.setCpf(null);
			pessoaDTO.setListaSelecionado(null);

			return pessoaDTO;

		}
}
