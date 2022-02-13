package cafedamanha.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import cafedamanha.api.dto.ItemCafeManhaDTO;
import cafedamanha.api.entity.ItemCafeManha;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemCafeManhaMapper extends BaseMapper<ItemCafeManha, ItemCafeManhaDTO> {

}
