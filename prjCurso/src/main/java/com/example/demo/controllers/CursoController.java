package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Curso;
import com.example.demo.services.CursoService;

@RestController
@RequestMapping("/cursos")

public class CursoController {
    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public Curso createProduct(@RequestBody Curso curso) {
        return cursoService.saveCurso(curso);
    }

    @GetMapping("/{id}")
    public Curso getCurso(@PathVariable Long id) {
        return cursoService.getCursoById(id);
    }

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.getAllCursos();
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
    }
}
