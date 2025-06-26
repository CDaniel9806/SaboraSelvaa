package com.saboraselva.saboraselva.Dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CategoriaDto {

    @EqualsAndHashCode.Include
    
    @NotNull(message = "no puede ser nulo")
    private Long idCategoria;

    @NotBlank(message = "no puede estar vacia")
    private String nombre;
    
    @NotBlank(message = "no puede estar vacia")
    private String descripcion;
   
    
    
}
    

