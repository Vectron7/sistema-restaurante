package com.artur.pessoas;

import java.util.ArrayList;

import com.artur.gerenciamento.GerenciarPessoa;
import com.artur.interfaces.Identificacao;

public class Gerente extends GerenciarPessoa implements Identificacao{

	private String nome;
	private int idGerente;

	public Gerente(String nome) {
		this.nome = nome;
	}

	@Override
	public int getId() {
		return idGerente;
	}

	public void listar(ArrayList<?> lista) {
		// Implementar logica para listar o gerente (Verifique a classe cliente para se inspirar na implementação)
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}