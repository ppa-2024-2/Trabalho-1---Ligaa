package br.edu.ifrs.riogrande.tads.ppa.ligaa.controller;

import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.AlunoService;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.NovoAluno;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

//Rotear tudo "que tem a ver" com aluno!
@RestController
public class AlunoController {

    private final AlunoService alunoService;

    // O AlunoService será "injetado" pelo Spring(framework)
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // Rotear
    @PostMapping(path = "/api/v1/alunos", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void novoAluno(@RequestBody NovoAluno aluno) {
        System.out.println(aluno);
        alunoService.cadastrarAluno(aluno); // não deve ser IDEMPOTENTE
    }

    // Query Parameter: /aluno?cpf=123478
    @GetMapping(path = "/api/v1/alunos/{cpf}") // cpf é um identificador
    public ResponseEntity<Aluno> buscaCpf(@PathVariable("cpf") String cpf) {
        Aluno aluno = alunoService.buscarAluno(cpf);
        return ResponseEntity.ok(aluno); // 200
    }

    @GetMapping(path = "/api/v1/alunos")
    public ResponseEntity<List<Aluno>> buscaTodos() {
        return ResponseEntity.ok(alunoService.findAll()); // Outrs opções: 404 ou 204
    }
}