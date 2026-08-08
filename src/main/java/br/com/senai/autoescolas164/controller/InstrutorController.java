package br.com.senai.autoescolas164.controller;

import br.com.senai.autoescolas164.instrutor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarInstrutor(
            @RequestBody @Valid DadosCadastroInstrutor dados) {

        Instrutor instrutor = new Instrutor(dados);
        repository.save(instrutor);
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<Page<DadosListagemInstrutor>>istarInstrutores(Pageable paginacao    ) {
        Page page = repository
                .findAllByAtivoTrue(paginacao)
                .map(DadosListagemInstrutor::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public DadosDetalhamentoInstrutor detalharInstrutor(@PathVariable Long id){
        Instrutor instrutor = repository.getReferenceById(id);
        return new DadosDetalhamentoInstrutor(instrutor);
    }

    @PutMapping
    @Transactional
    public void atualizarInstrutor(
            @RequestBody @Valid DadosAtualizacaoInstrutor dados) {

        Instrutor instrutor = repository.getReferenceById(dados.id());

        instrutor.atualizar(dados);
    }

    @DeleteMapping("/id")
    @Transactional
    public void excluirInstrutor(@PathVariable Long id){
        Instrutor instrutor = repository.getReferenceById(id);
        repository.deleteById(id);
    }
}