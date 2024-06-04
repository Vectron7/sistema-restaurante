package com.artur.pessoas;

import java.util.ArrayList;

import com.artur.gerenciamento.GerenciarPessoa;
import com.artur.interfaces.Identificacao;

public class Garcom extends GerenciarPessoa implements Identificacao {

	private String nome;
	private float salario;
	private String dataContratacao;
	private int idGarcom;

	public Garcom(String nome, float salario, String dataContratacao) {
		this.nome = nome;
		this.salario = salario;
		this.dataContratacao = dataContratacao;
	}

	public void listar(ArrayList<?> lista) {
		// Implementar logica para listar os garçom (Verifique a classe cliente para se
				// inspirar na implementação)
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

	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public void setIdGarcom(int idGarcom) {
		this.idGarcom = idGarcom;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}