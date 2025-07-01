package com.saboraselva.saboraselva.Repo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.saboraselva.saboraselva.model.Usuario;


@Repository
public interface IUserRepository extends IGenericRepository<Usuario, Long> {
     Optional<Usuario> findByNombre(String nombre);
}
