package com.blamovi.apiblamovi.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public record UsuarioDto(

    @NotBlank String nome,
    @NotBlank @Email(message = "O email deve estar em um formato válido!") String email,

    @NotBlank String senha,

    @NotBlank String apelido,

    @NotBlank String dataNasc,

    MultipartFile url_img
){

}
