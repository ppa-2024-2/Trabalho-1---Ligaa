package br.edu.ifrs.riogrande.tads.ppa.ligaa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.DisciplinaService;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.NovaDisciplina;

@RestController
public class DisciplinaController {
    private final DisciplinaService disciplinaService;

    // O AlunoService será "injetado" pelo Spring(framework)
    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    // Rotear
    @PostMapping(path = "/api/v1/disciplinas", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void novaDisciplina(@RequestBody NovaDisciplina disciplina) {
        System.out.println(disciplina);
        disciplinaService.cadastrarDisciplina(disciplina); // não deve ser IDEMPOTENTE
    }
}