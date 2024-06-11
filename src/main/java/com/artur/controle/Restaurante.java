package com.artur.controle;

import com.artur.gerenciamento.GerenciadorMesas;
import com.artur.pessoas.Gerente;

public class Restaurante {

    private final String NOME_RESTAURANTE = "";
    private static final String ENDERECO = "UNASP SP - Estr. de Itapecerica, 5859 - Capao Redondo, São Paulo - SP, 05890-020";
    private static final String TELEFONE = "(11) 1234-5678";
    private static final String CNPJ = "12.345.678/0001-90";

    GerenciadorMesas mesa = new GerenciadorMesas();
    Gerente gerente;

    private int contMesaDisponiveis(){
        int cont = 0;

        for(Mesa m : mesa.getListaMesas()){
            if(!m.isStatusMesa()){
                cont++;
            }
        }

        return cont;
    }

    public void iniciar() {
        System.out.println("========== Informações do Restaurante ==========");
        System.out.println("Nome: " + NOME_RESTAURANTE);
        System.out.println("Endereço: " + ENDERECO);
        System.out.println("Telefone: " + TELEFONE);
        System.out.println("CNPJ: " + CNPJ);
        System.out.println("========== Detalhes do Restaurante ==========");
        System.out.println("Quantidade de Mesas: " + (mesa.getNumGlobal()-1));
        System.out.println("Quantidade de Mesas Disponiveis: " + contMesaDisponiveis());
        System.out.println("=============================================");

        if(gerente != null){
            System.out.println("Gerente: " + gerente.getNome());
        }

    }

    public String getNOME_RESTAURANTE() {
        return NOME_RESTAURANTE;
    }
}