package com.duoc.educore.controller;

import com.duoc.educore.model.EC_Curso;
import com.duoc.educore.service.EC_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/educore")
public class EC_Controller {
    @Autowired //Importa la clase y sus metodos automaticamente
    private EC_Service ecService;
    /* Los comandos de la clase controller son los que deben manejar los errores
       de escritura en el ingreso de datos al metodo
       ≈ if null
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
       */
    @GetMapping
    public List<EC_Curso> listarAlumnos(){return ecService.getAlumnos();}
    @GetMapping("/curso/{curso}")
    public ResponseEntity<?> listarCurso(@PathVariable String curso){return ecService.getCurso(curso);}
    // Hace falta que el usuario ingrese el estado si tengo un metodo para verdadero o falso?
    @GetMapping("/registrados")
    public ResponseEntity<?> listarRegistrados(){ return ecService.getRegistrados(true);
    }
    @GetMapping("/noregistrados")
    public ResponseEntity<?> listarNoRegistrados(){return ecService.getNoRegistrados(false);}
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre){return ecService.getNombre(nombre);}
    // En el caso de el siguiente metodo, el cuerpo de la clase se da en formato JSON
    @PostMapping
    public ResponseEntity<?> agregarAlumno(@RequestBody EC_Curso alumno){
        if (alumno.getId() == null || alumno.getNombre() == null || alumno.getCurso() == null ||
        )
        return ecService.saveAlumno(alumno);}
}

