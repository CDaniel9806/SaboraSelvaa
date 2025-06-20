package com.saboraselva.saboraselva.mapper;
// Aquí puedes definir los métodos de mapeo que necesites, por ejemplo:
// ProductoDTO toDto(Producto producto);
// Producto toEntity(ProductoDTO productoDto);
// List<ProductoDTO> toDtoList(List<Producto> productos);
// List<Producto> toEntityList(List<ProductoDTO> productoDtos);

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING) /* poder usar el @Autowired Haz que este mapper funcione como un componente de Spring  */
public interface IProductoMapper {

  
    
    
    
}
