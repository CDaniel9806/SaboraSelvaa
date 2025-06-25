package com.saboraselva.saboraselva.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;  

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saboraselva.saboraselva.Dto.ProductoDto;
import com.saboraselva.saboraselva.Service.IProductoService;
import com.saboraselva.saboraselva.mapper.IProductoMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producto")

public class ProductoController {

private final IProductoService service; // update y createCustom personalizado
private final IProductoMapper iProductoMapper; // Mapper para convertir entre ProductoDto y Producto

    @GetMapping("/{idProducto}")
    @Operation(summary = "Obtener producto por id", security = @SecurityRequirement(name = "bearerAuth")) /* Para probar con http://localhost:8080/swagger-ui.html */
    public ResponseEntity<ProductoDto> findById(@PathVariable("idProducto") Long idProducto) {
        try {
            var producto = service.readById(idProducto);
            var dto = iProductoMapper.toDto(producto);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
