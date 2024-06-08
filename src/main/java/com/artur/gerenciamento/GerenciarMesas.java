package com.artur.gerenciamento;

import java.util.ArrayList;

import com.artur.estabelecimento.Mesa;
import com.artur.interfaces.Listagem;

public class GerenciarMesas implements Listagem {

	private final ArrayList<Mesa> listaMesas;
	private int numGlobal = 1;

	public GerenciarMesas() {
		this.listaMesas = new ArrayList<>();
		criarMesa();
	}

	protected void criarMesa() {

		adicionarMesa(new Mesa(2));
		adicionarMesa(new Mesa(4));
		adicionarMesa(new Mesa(4));
		adicionarMesa(new Mesa(6));
		adicionarMesa(new Mesa(8));

	}

	private void adicionarMesa(Mesa mesa) {

		mesa.setIdMesa(this.numGlobal++);
		listaMesas.add(mesa);
	}

	public void listar() {

		for (Mesa mesas : listaMesas) {
			System.out.print("Num. Mesa: " + mesas.getId() + " | Capacidade da Mesa: " + mesas.getCapacidade());
			if (mesas.isStatusMesa()) {
				System.out.println(" | (Ocupado)");
			} else {
				System.out.println(" | (Livre)");
			}

		}

	}

	public ArrayList<Mesa> getListaMesas() {
		return listaMesas;
	}

}