package com.duoc.educore.controller;

import com.duoc.educore.model.EC_Curso;
import com.duoc.educore.service.EC_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/educore")
public class EC_Controller {
    @Autowired //Importa la clase y sus metodos automaticamente
    private EC_Service ecService;

    @GetMapping
    public List<EC_Curso> listarAlumnos(){return ecService.getAlumnos();}
    @GetMapping
    public ResponseEntity<?> listarCurso(String curso){return ecService.getCurso(curso);}

}

