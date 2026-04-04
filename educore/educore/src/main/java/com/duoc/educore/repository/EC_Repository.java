package com.duoc.educore.repository;
import com.duoc.educore.model.EC_Curso;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EC_Repository {
    private final List<EC_Curso> listaAlumnos = new ArrayList<>();
    public EC_Repository(){
        listaAlumnos.add(new EC_Curso(1, "Rodolfo", "3B", true, 1));
        listaAlumnos.add(new EC_Curso(2, "Laura", "3B", true, 1));
        listaAlumnos.add(new EC_Curso(3, "Julian", "3A", false, 1));
        listaAlumnos.add(new EC_Curso(4, "Maria", "3B", true, 2));
        listaAlumnos.add(new EC_Curso(5, "Carlos", "3C", true, 1));
        listaAlumnos.add(new EC_Curso(6, "Elena", "3A", true, 2));
        listaAlumnos.add(new EC_Curso(7, "Ricardo", "3B", false, 1));
        listaAlumnos.add(new EC_Curso(8, "Sofia", "3C", true, 2));
        listaAlumnos.add(new EC_Curso(9, "Fernando", "3A", true, 1));
        listaAlumnos.add(new EC_Curso(10, "Lucia", "3B", true, 2));
    }
    // Agregado y Funcional
    public List<EC_Curso> listarAlumnos(){return listaAlumnos;}
    // Agregado y Funcional
    public ResponseEntity<?> listarCurso(String curso) {
        try {
            ArrayList<EC_Curso> cursoListado = new ArrayList<>();
            for (EC_Curso ecCurso : listaAlumnos) {
                if (ecCurso.getCurso().equals(curso)) {
                    cursoListado.add(ecCurso);
                }
            }
            return ResponseEntity.ok(cursoListado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar curso");
        }
    }
    //Agregado
    public ResponseEntity<?> listarRegistrados (Boolean estRegistro){
        try{
            ArrayList<EC_Curso> registrados = new ArrayList<>();
            if(estRegistro == true){
                for (EC_Curso ecCurso : listaAlumnos) {
                    if (ecCurso.getEstadoRegistro() == estRegistro) {
                        registrados.add(ecCurso);
                    }
                }
            }
            else {
                for (EC_Curso ecCurso : listaAlumnos) {
                    if (ecCurso.getEstadoRegistro() == estRegistro) {
                        registrados.add(ecCurso);
                    }
                }
            }
            return ResponseEntity.ok(registrados);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar curso");
        }
    }

    public ResponseEntity<?> buscarPorNombre (String nombre){
        try{
        for (EC_Curso ecCurso : listaAlumnos){
            if(ecCurso.getNombre().trim().equalsIgnoreCase(nombre.trim())){
                return ResponseEntity.ok(ecCurso);
            }
        }
        return null;
    }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar por nombre");
        }
    }
    public ResponseEntity<?> agregarAlumno (EC_Curso alumno){
        try{
            listaAlumnos.add(alumno);
            return ResponseEntity.ok(alumno);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar alumno");
        }
    }
}
