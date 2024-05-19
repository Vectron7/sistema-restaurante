package com.artur.Pessoas;

import java.util.UUID;

public class Garcom extends Pessoas{

    private float salario;
    private String dataContratacao;
    private UUID idGarcom;

    public Garcom(String nome, String endereco, String telefone, float salario, String dataContratacao) {
        super(nome, endereco);
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        idGarcom = UUID.randomUUID();
    }

    public float getSalario() {
        return salario;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public UUID getIdGarcom() {
        return idGarcom;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    } 

}
