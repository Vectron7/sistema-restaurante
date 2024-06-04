package com.artur.gerenciamento;

import java.util.ArrayList;
import com.artur.interfaces.Pessoa;
import com.artur.pessoas.*;

// Terminar o resto dos metodos

public class GerenciarPessoa implements Pessoa {

	private ArrayList<Cliente> listaClientes;
	private ArrayList<Garcom> listaGarcom;
	private ArrayList<Gerente> listaGerente;

	int ultimoIdCliente = 0;

	public GerenciarPessoa() {
		this.listaClientes = new ArrayList<>();
		this.listaGarcom = new ArrayList<>();
		this.listaGerente = new ArrayList<>();
	}

	@Override
	public void adicionarCliente(Cliente cliente) {

		cliente.setIdCliente(++ultimoIdCliente);
		listaClientes.add(cliente);

	}

	@Override
	public void removerCliente(int IdCliente) {

		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente r = listaClientes.get(i);
			if (r.getId() == IdCliente) {
				listaClientes.remove(r);
				System.out.println("Reserva removida com sucesso.");
			}

			for (int j = 0; j < listaClientes.size(); j++) {
				int novoID = listaClientes.get(j).getId() - 1;
				if (novoID >= 1) {
					listaClientes.get(j).setIdCliente(novoID);
				}
			}

			if (listaClientes.isEmpty()) {
				this.ultimoIdCliente = 0;
			}

		}
	}

	@Override
	public void adicionarGarcom(Garcom garcom) {
		// Adicionar Logica
	}

	@Override
	public void removerGarcom(int IdCarcom) {
		// Adicionar Logica
	}

	@Override
	public void adicionarGerente(Gerente gerente) {
		// Adicionar Logica
		// Apenas um Gerente por vez (nao permitir adicionar mais de um)
	}

	@Override
	public void removerGerente(int IdGerente) {
		// Adicionar Logica e parametros do metodo
	}

	@Override
	public void listar(ArrayList<?> lista) {
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ArrayList<Garcom> getListaGarcom() {
		return listaGarcom;
	}

	public void setListaGarcom(ArrayList<Garcom> listaGarcom) {
		this.listaGarcom = listaGarcom;
	}

	public ArrayList<Gerente> getListaGerente() {
		return listaGerente;
	}

	public void setListaGerente(ArrayList<Gerente> listaGerente) {
		this.listaGerente = listaGerente;
	}

}