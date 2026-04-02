package com.duoc.educore.service;

import com.duoc.educore.model.EC_Curso;
import com.duoc.educore.repository.EC_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EC_Service {
    @Autowired //Importa la clase y sus metodos automaticamente
    private EC_Repository ecRepository;

    public List<EC_Curso> getAlumnos(){return ecRepository.listarAlumnos();
    }
    public ResponseEntity<?> getCurso(String curso){return ecRepository.listarCurso(curso);}

}
