package br.com.senai.autoescolas164.controller;

import br.com.senai.autoescolas164.aluno.DadosCadastroAluno;
import br.com.senai.autoescolas164.aluno.Aluno;
import br.com.senai.autoescolas164.aluno.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

        @Autowired
        private AlunoRepository repository;

        @PostMapping
        @Transactional
        public void cadastrarAluno(
                @RequestBody @Valid DadosCadastroAluno dados) {

            Aluno aluno = new Aluno(dados);
            repository.save(aluno);
        }

    }
