package br.com.senai.autoescolas164.aluno;


import br.com.senai.autoescolas164.aluno.Aluno;

public record DadosListagemAluno(
        Long id,
        String nome,
        String email
        ) {

    public DadosListagemAluno(Aluno aluno){
        this(
                aluno.getId(),
                aluno.getEmail(),
                aluno.getNome());
    }
}
