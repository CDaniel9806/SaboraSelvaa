package com.saboraselva.saboraselva.mapper;
// Aquí puedes definir los métodos de mapeo que necesites, por ejemplo:
// ProductoDTO toDto(Producto producto);
// Producto toEntity(ProductoDTO productoDto);
// List<ProductoDTO> toDtoList(List<Producto> productos);
// List<Producto> toEntityList(List<ProductoDTO> productoDtos);

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.saboraselva.saboraselva.Dto.ProductoDto;
import com.saboraselva.saboraselva.model.Producto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING) /* poder usar el @Autowired Haz que este mapper funcione como un componente de Spring  */

public interface IProductoMapper {

    ProductoDto toDto(Producto producto);
        
    @InheritInverseConfiguration
    Producto toEntity(ProductoDto producto);
     
}
