package com.duoc.educore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EC_Curso{
    private Integer id;
    private String nombre;
    private String curso; //Nombre del curso
    private Boolean estadoRegistro; //Registrado o no
    private Integer nivelCurso; //El año que se cursa
} // a

