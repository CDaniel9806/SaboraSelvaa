package com.saboraselva.saboraselva.Repo;

import com.saboraselva.saboraselva.model.Categoria;

public interface ICategoriaRepository extends IGenericRepository<Categoria, Long> { /* mi interface personalizada para Categoria con los metodos de IgenericRepository y JpaRepository Save, findById tc */
    
    // Aquí puedes agregar métodos específicos para Categoria si es necesario
    // Por ejemplo:
    // List<Categoria> findByNombre(String nombre);
    
}
