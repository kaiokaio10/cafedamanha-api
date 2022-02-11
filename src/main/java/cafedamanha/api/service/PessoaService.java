package cafedamanha.api.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cafedamanha.api.dto.request.PessoaDTO;
import cafedamanha.api.entity.Pessoa;
import cafedamanha.api.exception.PessoaNaoEncontradoException;
import cafedamanha.api.mapper.PessoaMapper;
import cafedamanha.api.repository.PessoaRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@Transactional(readOnly = true)
public class PessoaService {
	
	@Autowired
	private PessoaMapper mapper;
	
	@Autowired
	private PessoaRepository repository;
	
	@Autowired 
	private MessageSource message;
	
	
	private void validacao(PessoaDTO dto)   {
		if (StringUtils.isBlank(dto.getNome())  ) {
			throw new PessoaNaoEncontradoException(message.getMessage("mensagem.campo.obrigatorio",
					new Object[] { "nome" }, LocaleContextHolder.getLocale()));
		} 
		
		if (StringUtils.isBlank(dto.getCpf())  ) {
			throw new PessoaNaoEncontradoException(message.getMessage("mensagem.campo.obrigatorio",
					new Object[] { "cpf" }, LocaleContextHolder.getLocale()));
		} 
		return;
		
	}
	
	private Pessoa verifyIfExists(Long id) {
		return repository.findById(id).orElseThrow(() -> new PessoaNaoEncontradoException());
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletar(Long id) {
		verifyIfExists(id);
		repository.deletar(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public PessoaDTO inserir(PessoaDTO dto) {
		

		repository.inserir(mapper.toEntity(dto));

		return dto;

	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public PessoaDTO alterar(PessoaDTO dto) {
		validacao(dto);

		repository.alterar(mapper.toEntity(dto));

		return dto;

	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public PessoaDTO consultarPorId(Long id) {

		PessoaDTO dto = mapper.toDto(repository.getById(id));

		return dto;
	}
	
	public List<?> listar(String nome) {
		return repository.listar(nome);
	}

}
