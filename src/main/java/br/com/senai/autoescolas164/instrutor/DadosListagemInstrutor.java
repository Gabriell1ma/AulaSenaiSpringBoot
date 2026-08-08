package br.com.senai.autoescolas164.instrutor;

public record DadosListagemInstrutor(
        Long id,
        String nome,
        String email,
        Especialidade especialidade) {

    public DadosListagemInstrutor(Instrutor instrutor){
        this(
                instrutor.getId(),
                instrutor.getEmail(),
                instrutor.getNome(),
                instrutor.getEspecialidade());
    }
}
