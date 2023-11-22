package com.blamovi.apiblamovi.repositories;

import com.blamovi.apiblamovi.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    UserDetails findByEmail(String email);
}