package cafedamanha.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cafedamanha.api.dto.ItemCafeManhaDTO;
import cafedamanha.api.dto.PessoaDTO;
import cafedamanha.api.dto.PessoaItemCafeManhaDTO;
import cafedamanha.api.mapper.ItemCafeManhaMapper;
import cafedamanha.api.mapper.PessoaItemCafeManhaMapper;
import cafedamanha.api.repository.ItemCafeManhaRepository;
import cafedamanha.api.repository.PessoaItemCafeManhaRepository;

@Service
@Transactional(readOnly = true)
public class ItemCafeManhaService {

	@Autowired
	private ItemCafeManhaMapper mapper;

	@Autowired
	private ItemCafeManhaRepository repository;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<ItemCafeManhaDTO> listarItemCafeManha() {
		return mapper.toDto(repository.listarItemCafeManha());

	}
	

}
