package GestaoInvestigacao;

import java.util.Date;

//Classe abstrata

public abstract class Pessoa {

    //Variáveis necessárias à implementação da classe

    private String nome;
    private String email;
    private Date datanasci;

    abstract String getType(); //metodo abstrato que devolve uma string para saber o tipo de classe presente


    //Construtor da classe
    //Recebe nome e email - campos obrigatórios
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    //Método overwrite. Método obrigatório a subscrever nas sub-classes
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
