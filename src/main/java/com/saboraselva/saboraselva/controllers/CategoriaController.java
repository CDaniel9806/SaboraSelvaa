package com.saboraselva.saboraselva.controllers;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saboraselva.saboraselva.Dto.CategoriaDto;
import com.saboraselva.saboraselva.Service.ICategoriaService;
import com.saboraselva.saboraselva.mapper.ICategoriaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/categorias") // Define la ruta base para este controlador

public class CategoriaController {

private final ICategoriaMapper iCategoriaMapper; // Mapper para convertir entre CategoriaDto y Categoria
private final ICategoriaService categoriaService; // Servicio para manejar las categorías`

@GetMapping
public ResponseEntity<List<CategoriaDto>> listarCategorias() {
    List<CategoriaDto> categorias = iCategoriaMapper.toDtoList(categoriaService.getAll());
    return ResponseEntity.ok(categorias);

    }
}
