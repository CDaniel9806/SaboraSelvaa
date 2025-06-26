package com.saboraselva.saboraselva.Service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saboraselva.saboraselva.Repo.IGenericRepository;
import com.saboraselva.saboraselva.Service.ICategoriaService;
import com.saboraselva.saboraselva.Service.IProductoService;
import com.saboraselva.saboraselva.mapper.ICategoriaMapper;
import com.saboraselva.saboraselva.mapper.IProductoMapper;
import com.saboraselva.saboraselva.model.Categoria;
import com.saboraselva.saboraselva.model.Producto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional  /* Si todo el método se ejecuta correctamente, los cambios en la base de datos se confirman (commit).
                   Si ocurre una excepción, todos los cambios se revierten (rollback), evitando datos inconsistentes. */
@RequiredArgsConstructor

public class CategoriaServiceImpl extends CRUDimpl<Categoria, Long>  implements ICategoriaService {

    //Inizializar
    private final IGenericRepository<Categoria, Long> repository; //esta linea es para inyectar el repositorio de Producto a la clase padre CRUDimpl 

    //Mapeo de Dto a Entity y viceversa
    private final ICategoriaMapper iCategoriaMapper; //Esta línea te permite usar el mapper para transformar objetos dentro de tu servicio

    // Pedimos al repositorio el Producto getRepo es neces
    @Override
    protected IGenericRepository<Categoria, Long> getRepo() {
    return repository;
}

}
