package com.artur.Pessoas;

import java.util.ArrayList;

public class Cliente extends Pessoas{

	private String endereco;
	private String dataNasc;
	private int idCliente;
	private String telefone;

	public Cliente(String nome, String endereco, String telefone, String dataNasc) {
		super(nome);
		this.endereco = endereco;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
	}

	public void listar(ArrayList<?> lista) {

		for (Object obj : lista) {
			if (obj instanceof Cliente) {
				Cliente cliente = (Cliente) obj;
				System.out.println("ID: " + cliente.getIdCliente() + " | Nome: " + cliente.getNome() + " | Endereco: "+ cliente.getEndereco() + " | Telefone: " + cliente.getTelefone() + " | Data de Nascimento: "+ cliente.getDataNasc());
			}
		}

	}

	public String getEndereco() {
		return endereco;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
