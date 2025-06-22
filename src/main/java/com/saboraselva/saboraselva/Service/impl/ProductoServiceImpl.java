package com.saboraselva.saboraselva.Service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saboraselva.saboraselva.Repo.IGenericRepository;
import com.saboraselva.saboraselva.Service.IProductoService;
import com.saboraselva.saboraselva.exception.ModelNotFoundException;
import com.saboraselva.saboraselva.mapper.IProductoMapper;
import com.saboraselva.saboraselva.model.Producto;

import lombok.RequiredArgsConstructor;


@Service
@Transactional  /* Si todo el método se ejecuta correctamente, los cambios en la base de datos se confirman (commit).
                   Si ocurre una excepción, todos los cambios se revierten (rollback), evitando datos inconsistentes. */
@RequiredArgsConstructor
public class ProductoServiceImpl extends CRUDimpl<Producto, Long>  implements IProductoService {

    //Inizializar
    private final IGenericRepository<Producto, Long> repository; //esta linea es para inyectar el repositorio de Producto a la clase padre CRUDimpl 

    //Mapeo de Dto a Entity y viceversa
    private final IProductoMapper iProductoMapper; //Esta línea te permite usar el mapper para transformar objetos dentro de tu servicio



    // Pedimos al repositorio el Producto getRepo
    @Override                                                   //esta linea es para sobreescribir el metodo de la clase padre CRUDimpl
    protected IGenericRepository<Producto, Long> getRepo() {    // esta linea sirve para obtener el repositorio de Producto y tambien para inyectarlo en la interface IGenericRepository 
        return repository;                                      //retorna el repositorio de Producto
    }

    @Override
    public Producto update(Producto entidad, Long id) {         // este método es para actualizar un Producto por su id
    Producto original = this.readById(id);
    if (original == null) {
        throw new ModelNotFoundException("No existe el id : " + id);
    }
    String[] ignoreProperties = new String[]{"createdAt", "updatedAt"};
    BeanUtils.copyProperties(entidad, original, ignoreProperties);
    return super.update(original, id);
}
    @Override
    public List<Producto> getAll() { // este método es para obtener todos los Productos de la base de datos
    return super.getAll();
}

}
