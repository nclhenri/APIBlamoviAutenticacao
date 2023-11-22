package com.blamovi.apiblamovi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable, UserDetails {
        @Serial
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_Usuario", nullable = false)
        private int id;
        private String nome;

        @JsonIgnore
        private String senha;

        private String apelido;

        private String email;
        private String dataNasc;
        private String url_img;
        private TipoModel tipo_usuario;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                if (this.tipo_usuario == TipoModel.ADMIN){
                        return List.of(
                          new SimpleGrantedAuthority("ROLE_ADMIN"),
                          new SimpleGrantedAuthority("ROLE_USUARIO")
                        );
                } else if (this.tipo_usuario == TipoModel.usuario) {
                        return List.of(
                          new SimpleGrantedAuthority("ROLE_USUARIO")
                        );
                }
                return null;
        }

        @Override
        public String getPassword() {
                return senha;
        }

        @Override
        public String getUsername() {
                return email;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }
}