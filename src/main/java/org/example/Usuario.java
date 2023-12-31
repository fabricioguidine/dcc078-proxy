package org.example;
import java.util.Arrays;
import java.util.List;
public class Usuario implements  IUsuario{
    private String nome;
    private String cidade;
    private String celular;
    private String email;
    private String cpf;
    public Usuario(String cpf) {
        this.cpf = cpf;
        Usuario objeto = BD.getUsuario(cpf);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.celular = objeto.celular;
        this.email = objeto.email;
        this.cpf = objeto.cpf;
    }
    public Usuario(String nome, String cidade, String celular, String email, String cpf) {
        this.nome = nome;
        this.cidade = cidade;
        this.celular = celular;
        this.email = email;
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }
    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.cidade, this.cpf);
    }
    @Override
    public List<String> obterContatos(Administrador admin) {
        return Arrays.asList(this.celular, this.email);
    }
}