package com.artur.pessoas;

import java.util.ArrayList;

import com.artur.gerenciamento.GerenciarPessoa;
import com.artur.interfaces.Identificacao;

public class Cliente extends GerenciarPessoa implements Identificacao{

	private String nome;
	private String endereco;
	private String dataNasc;
	private int idCliente;
	private String telefone;

	public Cliente(String nome, String endereco, String telefone, String dataNasc) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
	}

	@Override
	public void listar(ArrayList<?> lista) {

		for (Object obj : lista) {
			if (obj instanceof Cliente) {
				Cliente cliente = (Cliente) obj;
				System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome() + " | Endereco: "+ cliente.getEndereco() + " | Telefone: " + cliente.getTelefone() + " | Data de Nascimento: "+ cliente.getDataNasc());
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

	@Override
	public int getId() {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}