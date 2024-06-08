package com.artur.estabelecimento;

import com.artur.gerenciamento.GerenciarCardapio;
import com.artur.gerenciamento.GerenciarMesas;
import com.artur.gerenciamento.GerenciarPessoa;
import com.artur.pessoas.Gerente;

import java.util.Scanner;

public class Restaurante {

    private final String NOME_RESTAURANTE = "";
    private static final String ENDERECO = "UNASP SP - Estr. de Itapecerica, 5859 - Capao Redondo, São Paulo - SP, 05890-020";
    private static final String TELEFONE = "(11) 1234-5678";
    private static final String CNPJ = "12.345.678/0001-90";

    GerenciarPessoa pessoa = new GerenciarPessoa();
    GerenciarCardapio cardapio = new GerenciarCardapio();
    GerenciarMesas mesa = new GerenciarMesas();
    Gerente gerente;

    private void selecionarPedido(int idPedido){

    }

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