package com.artur.Pessoas;

import java.util.ArrayList;

public abstract class Pessoas {

	protected String nome;
    
    public Pessoas(String nome) {
		this.nome = nome;
	}
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public abstract void listar(ArrayList<?> lista);
    
    

}
