package com.saboraselva.saboraselva.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saboraselva.saboraselva.Dto.ProductoDto;
import com.saboraselva.saboraselva.Service.IProductoService;
import com.saboraselva.saboraselva.exception.BadRequestException;
import com.saboraselva.saboraselva.mapper.IProductoMapper;
import com.saboraselva.saboraselva.model.Producto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


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
