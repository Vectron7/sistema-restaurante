package com.artur.controle;

import com.artur.interfaces.Identificacao;

public class ItemCardapio implements Identificacao {

    private String nome;
    private final String tamanho;
    private final String descricao;
    private final String categoria;
    private final double preco;
    private int idItem;

    public ItemCardapio(String nome, String tamanho, String descricao, double preco) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = definirCategoria(nome);
    }

    private String definirCategoria(String nome) {

        if (nome.contains("Bife") || nome.contains("Frango") || nome.contains("Spaghetti")) {
            return "Pratos Principais";
        } else if (nome.contains("Arroz") || nome.contains("Batata") || nome.contains("Salada")) {
            return "Acompanhamentos";
        } else if (nome.contains("Refrigerante") || nome.contains("Suco") || nome.contains("Agua")) {
            return "Bebidas";
        } else if (nome.contains("Mousse") || nome.contains("Pudim") || nome.contains("Sorvete")) {
            return "Sobremesas";
        } else {
            return "Outros/Adicionados";
        }

    }

    @Override
    public String toString() {
        return nome + ": " + descricao + "\nTamanho: " + tamanho + "\nPreço: R$ " + preco + "\n";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public int getId() {
        return idItem;
    }

    public void setIdItem(int idItem) {

        this.idItem = idItem;
    }

}