package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

// import com.fasterxml.jackson.annotation.JsonProperty;

//Data Transfer  Object (DTO)
//JavaBean (classes que tem apenas getters e setters)
//Não é o model nem a entity, é apenas para empacotar dados
public class NovoAluno {
    // COC: Convencion over Configuration
    // Convenção antes de Configuração

    private String nome;
    private String email;
    private String cpf;

    // Quando o nome da variável não é igual a string criada
    // @JsonProperty("email")
    // private String enderecoEletronico;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "NovoAluno [nome=" + nome + ", email=" + email + ", cpf=" + cpf + "]";
    }
}