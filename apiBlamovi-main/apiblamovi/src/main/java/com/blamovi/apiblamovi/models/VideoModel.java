package com.blamovi.apiblamovi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "video")
public class VideoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idVideo", nullable = false)
    private int id;
    private String titulo;
    private String genero;
    private String diretor;
    private String duracao;
    private String temporadas;
    private String sinopse;
    private String ano;
    private String curtida;
    private String nota;
    private String elenco;
    private String tipo;
}