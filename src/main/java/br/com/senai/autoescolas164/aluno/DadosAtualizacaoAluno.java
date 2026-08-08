package br.com.senai.autoescolas164.aluno;

import br.com.senai.autoescolas164.endereco.Endereco;


public record DadosAtualizacaoAluno(
        Long id,
        String nome,
        String email,
        String telefone,
        Endereco endereco) {
}
