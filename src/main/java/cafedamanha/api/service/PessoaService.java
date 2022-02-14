package cafedamanha.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cafedamanha.api.dto.ItemCafeManhaDTO;
import cafedamanha.api.dto.PessoaDTO;
import cafedamanha.api.dto.PessoaItemCafeManhaDTO;
import cafedamanha.api.entity.Pessoa;
import cafedamanha.api.entity.PessoaItemCafeManha;
import cafedamanha.api.exception.PessoaException;
import cafedamanha.api.mapper.ItemCafeManhaMapper;
import cafedamanha.api.mapper.PessoaItemCafeManhaMapper;
import cafedamanha.api.mapper.PessoaMapper;
import cafedamanha.api.repository.PessoaItemCafeManhaRepository;
import cafedamanha.api.repository.PessoaRepository;

@Service
@Transactional(readOnly = true)
public class PessoaService {

	@Autowired
	private PessoaMapper mapper;

	@Autowired
	private ItemCafeManhaMapper mapperItem;

	@Autowired
	private PessoaItemCafeManhaMapper mapperPessoaItem;

	@Autowired
	private PessoaRepository repository;

	@Autowired
	private PessoaItemCafeManhaRepository repositoryItem;

	@Autowired
	private MessageSource message;

	private void validacao(PessoaDTO dto) {
		if (StringUtils.isBlank(dto.getNome())) {
			throw new PessoaException(message.getMessage("mensagem.campo.obrigatorio", new Object[] { "nome" },
					LocaleContextHolder.getLocale()));
		}

		if (StringUtils.isBlank(dto.getCpf())) {
			throw new PessoaException(message.getMessage("mensagem.campo.obrigatorio", new Object[] { "cpf" },
					LocaleContextHolder.getLocale()));
		}
		return;

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void excluir(Long id) {
		repositoryItem.excluirPessoaItemCafeManha(id);
		repository.excluir(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public PessoaDTO inserir(PessoaDTO dto) {
		Long idPessoa = repository.inserir(mapper.toEntity(dto));

		for (ItemCafeManhaDTO itemCafeManhaDTO : dto.getListaSelecionado()) {
			PessoaItemCafeManha pessoaItem = new PessoaItemCafeManha();
			pessoaItem.setItemCafeManha(mapperItem.toEntity(itemCafeManhaDTO));
			pessoaItem.setPessoa(new Pessoa(idPessoa));
			repositoryItem.inserir(pessoaItem);
		}
		return dto;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public PessoaDTO alterar(PessoaDTO dto) {
		validacao(dto);
		Long idPessoa = dto.getId();
		repositoryItem.excluirPessoaItemCafeManha(idPessoa);
		for (ItemCafeManhaDTO itemCafeManhaDTO : dto.getListaSelecionado()) {
			PessoaItemCafeManha pessoaItem = new PessoaItemCafeManha();
			pessoaItem.setItemCafeManha(mapperItem.toEntity(itemCafeManhaDTO));
			pessoaItem.setPessoa(new Pessoa(idPessoa));
			repositoryItem.inserir(pessoaItem);
		}
		repository.alterar(mapper.toEntity(dto));
		return dto;

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<PessoaDTO> pesquisar(PessoaDTO dto) {
		return mapper.toDto(repository.pesquisar(dto));

	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<PessoaDTO> listarTodos() {
		
		
		List<PessoaDTO> listDTO = mapper.toDto(repository.listarTodos());
		
		for (PessoaDTO pessoaDTO : listDTO) {
			
			List<PessoaItemCafeManhaDTO> listaItensAssociado = mapperPessoaItem
					.toDto(repositoryItem.pesquisarPessoaItemCafeManhaPorId(pessoaDTO.getId()));
			
			
			for (PessoaItemCafeManhaDTO pessoaItemCafeDTO : listaItensAssociado) {
				if (pessoaDTO.getListaSelecionado() == null) {
					pessoaDTO.setListaSelecionado(new ArrayList<>());
				}
				pessoaDTO.getListaSelecionado().add(pessoaItemCafeDTO.getItemCafeManha());
			}
			
		}
		
		
		
		return listDTO;	
		
	}


	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public PessoaDTO pesquisarPorId(Long id) {
		PessoaDTO dto = mapper.toDto(repository.pesquisarPorId(id));

		List<PessoaItemCafeManhaDTO> listaItensAssociado = mapperPessoaItem
				.toDto(repositoryItem.pesquisarPessoaItemCafeManhaPorId(id));

		for (PessoaItemCafeManhaDTO pessoaItemCafeDTO : listaItensAssociado) {
			if (dto.getListaSelecionado() == null) {
				dto.setListaSelecionado(new ArrayList<>());
			}
			dto.getListaSelecionado().add(pessoaItemCafeDTO.getItemCafeManha());
		}
		return dto;

	}

}
