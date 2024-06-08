package com.artur.estabelecimento;

import com.artur.gerenciamento.GerenciarCardapio;

public class Restaurante {

    private static final String NOME_RESTAURANTE = "";
    private static final String ENDERECO = "";
    private static final String TELEFONE = "";
    private static final String CNPJ = "";

    Mesa mesa;
    GerenciarCardapio gerenciarCardapio;

    public Restaurante() {

    }

    public void imprimirInformacoesRestaurante(Restaurante restaurante) {
        System.out.println("\n===== Apresentação do Restaurante =====");
        System.out.println("Nome: " + NOME_RESTAURANTE);
        System.out.println("Endereço: " + ENDERECO);
        System.out.println("Telefone: " + TELEFONE);
        System.out.println("CNPJ: " + CNPJ);

        System.out.println("\n===== Detalhes do Restaurante =====");
        System.out.println("Quantidade de Mesas: " + mesa.getId());

        gerenciarCardapio.listar();
    }

}