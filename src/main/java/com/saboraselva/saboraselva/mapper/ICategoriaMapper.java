package com.saboraselva.saboraselva.mapper;
// Aquí puedes definir los métodos de mapeo que necesites, por ejemplo:
// CategoriaDTO toDto(Categoria categoria);
// Categoria toEntity(CategoriaDTO categoriaDto);
// List<CategoriaDTO> toDtoList(List<Categoria> categorias);
// List<Categoria> toEntityList(List<CategoriaDTO> categoriaDtos);

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.saboraselva.saboraselva.Dto.CategoriaDto;
import com.saboraselva.saboraselva.model.Categoria;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING) /* poder usar el @Autowired Haz que este mapper funcione como un componente de Spring  */

public interface ICategoriaMapper {

    
    CategoriaDto toDto(Categoria categoria);
        
    @InheritInverseConfiguration
    Categoria toEntity(CategoriaDto categoria);
     
    List<CategoriaDto> toDtoList(List<Categoria> categorias);
}
