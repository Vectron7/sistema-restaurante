package com.artur.gerenciamento;

import java.util.ArrayList;

import com.artur.controle.Reserva;
import com.artur.interfaces.Listagem;
import com.artur.estabelecimento.Mesa;

public class GerenciarReservas implements Listagem {

	private ArrayList<Reserva> listaReservas;
	private int ultimoIdReserva = 1;

	public GerenciarReservas() {
		this.listaReservas = new ArrayList<>();
	}

	public void adicionarReserva(Reserva reserva) {

		reserva.setIdReserva(this.ultimoIdReserva++);
		listaReservas.add(reserva);

	}

	public void cancelarReserva(int canIdReserva, ArrayList<Mesa> listaMesas) {

		// Procurar pela reserva com o ID especificado
		Reserva reservaRemover = null;
		for (Reserva r : listaReservas) {
			if (r.getId() == canIdReserva) {
				reservaRemover = r;
				break;
			}
		}

		if (reservaRemover != null) {
			// Atualizar o status da mesa correspondente
			for (Mesa m : listaMesas) {
				if (m.getId() == reservaRemover.getNumMesa()) {
					m.setStatusMesa(false);
					break;
				}
			}

			// Remover a reserva da lista de reservas
			listaReservas.remove(reservaRemover);
			System.out.println("Reserva removida com sucesso.");

			// Atualizar os IDs das reservas restantes
			for (int j = 0; j < listaReservas.size(); j++) {
				listaReservas.get(j).setIdReserva(j + 1);
			}
		} else {
			System.out.println("Reserva não encontrada.");
		}
	}

	@Override
	public void listar() {

		for (Reserva reserva : listaReservas) {
			System.out.println("ID: " + reserva.getId() + " | Num. Mesa: " + reserva.getNumMesa() + " | Nome: "
					+ reserva.getNomeCliente() + " | Telefone: " + reserva.getTelefoneCliente() + " | Data e Hora: "
					+ reserva.getDataReserva() + " " + reserva.getHoraReserva());

		}

	}

	public ArrayList<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

}