package com.saboraselva.saboraselva.Dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductoDto {

    @EqualsAndHashCode.Include
    
    @NotNull(message = "no puede ser nulo")
    private Long idProducto;

    @NotBlank(message = "no puede estar vacia")
    private String nombre;
    
    @NotBlank(message = "no puede estar vacia")
    private String descripcion;

    @NotNull(message = "no puede ser nulo")
    @Positive(message = "debe ser mayor a cero")
    private Double precio;    
    
}
