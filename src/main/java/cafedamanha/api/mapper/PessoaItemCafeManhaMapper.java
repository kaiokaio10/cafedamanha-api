package cafedamanha.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import cafedamanha.api.dto.PessoaItemCafeManhaDTO;
import cafedamanha.api.entity.PessoaItemCafeManha;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PessoaItemCafeManhaMapper extends BaseMapper<PessoaItemCafeManha, PessoaItemCafeManhaDTO> {

}
