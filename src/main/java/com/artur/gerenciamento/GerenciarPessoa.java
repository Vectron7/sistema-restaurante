package com.artur.gerenciamento;

import java.util.ArrayList;
import com.artur.interfaces.Pessoa;
import com.artur.pessoas.*;

// Terminar o resto dos metodos

public class GerenciarPessoa implements Pessoa {

	private ArrayList<Cliente> listaClientes;
	private ArrayList<Garcom> listaGarcom;
	private ArrayList<Gerente> listaGerente;

	private int ultimoIdCliente = 0;
	protected int ultimoIdGarcom = 0;

	public GerenciarPessoa(){
		this.listaClientes = new ArrayList<>();
		this.listaGarcom = new ArrayList<>();
		this.listaGerente = new ArrayList<>();
	}


	public void gerarGarcom(){
		adicionarGarcom(new Garcom("Thiago", "Capao Redondo", "1234-5678", 1412));
		adicionarGarcom(new Garcom("Ana", "Av. Paulista, 100", "9876-5432", 1413));
		adicionarGarcom(new Garcom("Carlos", "Rua Augusta, 200", "8765-4321", 1414));
		adicionarGarcom(new Garcom("Maria", "Av. Faria Lima, 300", "7654-3210", 1415));
		adicionarGarcom(new Garcom("Pedro", "Rua Oscar Freire, 400", "6543-2109", 1416));
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
				System.out.println("Cliente removido com sucesso.");
			}

            for (Cliente listaCliente : listaClientes) {
                int novoID = listaCliente.getId() - 1;
                if (novoID >= 1) {
                    listaCliente.setIdCliente(novoID);
                }
            }

		}

		if (listaClientes.isEmpty()) {
			this.ultimoIdCliente = 0;
		}
	}

	@Override
	public void adicionarGarcom(Garcom garcom) {
		// Adicionar Logica

		garcom.setIdGarcom(++ultimoIdGarcom);
		listaGarcom.add(garcom);
	}

	@Override
	public void removerGarcom(int IdGarcom) {
		for (int i = 0; i < listaGarcom.size(); i++) {
			Garcom g = listaGarcom.get(i);
			if (g.getId() == IdGarcom) {
				listaGarcom.remove(g);
				System.out.println("Garçom removido com sucesso.");
				break;
			}
		}

		// Atualizar os IDs dos garçons restantes
		for (int i = 0; i < listaGarcom.size(); i++) {
			listaGarcom.get(i).setIdGarcom(i + 1);
		}

		// Ajustar o último ID de garçom
		this.ultimoIdGarcom = listaGarcom.size();
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
	public void listarCliente() {
		for (Cliente cliente : listaClientes) {
			System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome() + " | Endereco: "+ cliente.getEndereco() + " | Telefone: " + cliente.getTelefone() + " | Data de Nascimento: "+ cliente.getDataNasc());

		}
	}

	@Override
	public void listarGarcom() {
		for(Garcom garcom : listaGarcom){
			System.out.print("ID: " + garcom.getId() + " | Nome: " + garcom.getNome() + " | Endereco: "+ garcom.getEndereco() + " | Telefone: " + garcom.getTelefone() + " | Salario: " + garcom.getSalario() + " | Data de Contratacao: "+ garcom.getDataContratacao());
			if (garcom.isOcupado()) {
				System.out.print(" | (Ocupado) ");
			} else {
				System.out.println(" | (Livre) ");
			}
		}
	}

	@Override
	public void listarGerente() {

	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}


	public ArrayList<Garcom> getListaGarcom() {
		return listaGarcom;
	}

	public ArrayList<Gerente> getListaGerente() {
		return listaGerente;
	}
}