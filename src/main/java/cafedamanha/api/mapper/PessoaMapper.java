package cafedamanha.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import cafedamanha.api.dto.request.PessoaDTO;
import cafedamanha.api.entity.Pessoa;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PessoaMapper extends BaseMapper<Pessoa, PessoaDTO> {

}
