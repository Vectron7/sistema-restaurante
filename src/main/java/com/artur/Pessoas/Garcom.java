package com.artur.Pessoas;

import java.util.ArrayList;

public class Garcom extends Pessoa{

    private float salario;
    private String dataContratacao;
    private int idGarcom;

    public Garcom(String nome, float salario, String dataContratacao) {
    	super(nome);
        this.salario = salario;
        this.dataContratacao = dataContratacao;
    }
    
    @Override
    public void listar(ArrayList<?> lista) {
    	
    }

	public float getSalario() {
        return salario;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public int getIdGarcom() {
        return idGarcom;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

	public void setIdGarcom(int idGarcom) {
		this.idGarcom = idGarcom;
	}
 
	
	
    
    

}
