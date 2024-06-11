package com.artur.pessoas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.artur.interfaces.Identificacao;

public class Garcom extends Pessoa implements Identificacao {

    private String dataContratacao;
    private float salario;
    private int idGarcom;
    private boolean ocupado;

    public Garcom(String nome, String endereco, String telefone, float salario) {
        super(nome, endereco, telefone);
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = hoje.format(formatador);

        this.salario = salario;
        this.dataContratacao = dataFormatada;
    }

    public Garcom(String nome,int idGarcom){
        super(nome);
        this.idGarcom = idGarcom;
    }

    public float getSalario() {
        return salario;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    @Override
    public int getId() {
        return idGarcom;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setIdGarcom(int idGarcom) {
        this.idGarcom = idGarcom;
    }

    public boolean isOcupado() { return ocupado; }

    public void setOcupado(boolean ocupado) { this.ocupado = ocupado; }

}