package cafedamanha.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cafedamanha.api.dto.ItemCafeManhaDTO;
import cafedamanha.api.mapper.ItemCafeManhaMapper;
import cafedamanha.api.repository.PessoaItemCafeManhaRepository;

@Service
@Transactional(readOnly = true)
public class PessoaItemCafeManhaService {
	
	@Autowired
	private PessoaItemCafeManhaRepository repository;
	
	@Autowired
	private ItemCafeManhaMapper mapper;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<ItemCafeManhaDTO> pesquisarItemCafeManhaPorIdPessoa(Long idPessoa) {
		return mapper.toDto(repository.pesquisarItemCafeManhaPorIdPessoa(idPessoa));
		
	}
	
	

}
