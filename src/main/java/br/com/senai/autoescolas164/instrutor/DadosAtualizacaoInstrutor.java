package br.com.senai.autoescolas164.instrutor;

import br.com.senai.autoescolas164.endereco.Endereco;

public record DadosAtualizacaoInstrutor(
        Long id,
        String nome,
        String email,
        String telefone,
        Especialidade especialidade,
        Endereco endereco) {
}
