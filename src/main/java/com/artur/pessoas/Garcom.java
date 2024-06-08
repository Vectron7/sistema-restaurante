package com.artur.pessoas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.artur.gerenciamento.GerenciarPessoa;
import com.artur.interfaces.Identificacao;

public class Garcom extends GerenciarPessoa implements Identificacao {

	private String nome;
	private String dataContratacao;
	private String endereco;
	private String telefone;
	private float salario;
	private int idGarcom;
	private boolean ocupado;

	public Garcom(String nome, String endereco, String telefone, float salario) {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = hoje.format(formatador);

		this.nome = nome;
		this.salario = salario;
		this.dataContratacao = dataFormatada;
		this.endereco = endereco;
		this.telefone = telefone;
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

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}