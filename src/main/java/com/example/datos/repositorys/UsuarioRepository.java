package com.example.datos.repositorys;

import com.example.datos.entitys.UsuarioEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEnity, Integer> {

    UsuarioEnity findById(int id);

    List<UsuarioEnity> findByAlias(String alias);

}
