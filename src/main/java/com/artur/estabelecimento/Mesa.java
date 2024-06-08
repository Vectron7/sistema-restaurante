package com.artur.estabelecimento;

import com.artur.interfaces.Identificacao;

public class Mesa implements Identificacao {

	private int idMesa;
	private int capacidade;
	private boolean statusMesa;
	private String nomeGarcom;
	private int idGarcom;

	public Mesa(int capacidade) {
		this.capacidade = capacidade;
		this.statusMesa = false;
	}

	public boolean isStatusMesa() {
		return statusMesa;
	}

	public void reservar() {
		statusMesa = true;
	}

	public void liberar() {
		statusMesa = false;
	}

	@Override
	public int getId() {
		return idMesa;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public void setStatusMesa(boolean statusMesa) {
		this.statusMesa = statusMesa;
	}

	public String getNomeGarcom() {
		return nomeGarcom;
	}

	public void setNomeGarcom(String nomeGarcom) {
		this.nomeGarcom = nomeGarcom;
	}

	public int getIdGarcom() {
		return idGarcom;
	}

	public void setIdGarcom(int idGarcom) {
		this.idGarcom = idGarcom;
	}
}