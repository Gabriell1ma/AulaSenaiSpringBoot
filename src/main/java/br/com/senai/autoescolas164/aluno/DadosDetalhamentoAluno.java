package br.com.senai.autoescolas164.aluno;

import br.com.senai.autoescolas164.endereco.Endereco;
import br.com.senai.autoescolas164.aluno.Aluno;

public record DadosDetalhamentoAluno(
        Long id,
        String nome,
        String email,
        String telefone,
        String cnh,
        Endereco endereco,
        boolean ativo
) {
    public DadosDetalhamentoAluno(Aluno aluno){
        this(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getTelefone(),
                aluno.getCpf(),
                aluno.getEndereco(),
                aluno.isAtivo()
        );
    }
}
