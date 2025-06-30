package com.saboraselva.saboraselva.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saboraselva.saboraselva.Dto.ProductoDto;
import com.saboraselva.saboraselva.Service.IProductoService;
import com.saboraselva.saboraselva.mapper.IProductoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/productos") // Define la ruta base para este controlador

public class ProductoController {

private final IProductoService service; // update y createCustom personalizado
private final IProductoMapper iProductoMapper; // Mapper para convertir entre ProductoDto y Producto



@PostMapping("/create")
    @Operation(summary = "Crear un nuevo producto", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<ProductoDto> save(@RequestBody ProductoDto dto) {
        var producto = service.createCustom(dto);
        var responseDto = iProductoMapper.toDto(producto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
}


}
