package com.saboraselva.saboraselva.Repo;

import java.util.Optional;

import com.saboraselva.saboraselva.model.Role;
import com.saboraselva.saboraselva.model.Usuario;


public interface IRoleRepository extends IGenericRepository<Role, Long> {
     Optional<Usuario> findByNombre(String nombre);
}
