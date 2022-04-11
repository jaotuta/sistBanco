package com.letscode.modulobanco811.repository;

import com.letscode.modulobanco811.dtos.UsuarioResponse;
import com.letscode.modulobanco811.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Page<Usuario> findByNome(String nome, Pageable pageable);

    Optional<UsuarioResponse> findByCpf(String cpf);

    Optional<Usuario> findByLogin(String login);

}
