package com.saboraselva.saboraselva.Repo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.saboraselva.saboraselva.Enums.RoleList;
import com.saboraselva.saboraselva.model.Role;



@Repository
public interface IRoleRepository extends IGenericRepository<Role, Long> {
      Optional<Role> findByName(RoleList name);
}
