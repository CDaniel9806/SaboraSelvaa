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

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/producto") // Define la ruta base para este controlador

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
    @PostMapping("/create")
    @Operation(summary = "Crear un nuevo producto", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<ProductoDto> save(@RequestBody ProductoDto dto) {
        var producto = service.createCustom(dto);
        var responseDto = iProductoMapper.toDto(producto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
}
    
    @GetMapping("/all")
    public ResponseEntity<List<ProductoDto>> findByFiltro(){
        
        List<Producto> lst = service.getAll();
        List<ProductoDto> lstProductoDto = this.iProductoMapper.toDtoList(lst);

        return new ResponseEntity<>(lstProductoDto, HttpStatus.OK);
    }       
      
    @PutMapping("/{idProducto}")
    public ResponseEntity<ProductoDto> update( @PathVariable("idProducto") Long idProducto, @RequestBody @Valid ProductoDto dto){
    
        
        Producto objEntitySource = this.iProductoMapper.toEntity(dto);

        Producto obj =  service.update(objEntitySource, idProducto);
        
        return new ResponseEntity<>(this.iProductoMapper.toDto(obj) , HttpStatus.OK);
    }   

     @DeleteMapping("/{idProducto}")
    public ResponseEntity<ProductoDto> delete(@PathVariable("idProducto") Long idProducto){
    
        try {
            service.deleteById(idProducto);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
            
        } catch (DataAccessException e) {
            throw new BadRequestException(e.getMessage());
        }

    }
}
