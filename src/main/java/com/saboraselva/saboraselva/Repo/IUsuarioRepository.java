package com.saboraselva.saboraselva.Repo;

import com.saboraselva.saboraselva.model.Usuario;


public interface IUsuarioRepository extends IGenericRepository<Usuario, Long> {
     Usuario findByEmail(String email);
}
