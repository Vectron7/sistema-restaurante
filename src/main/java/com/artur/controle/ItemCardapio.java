package com.artur.controle;

import com.artur.interfaces.Identificacao;

// Declaração da classe ItemCardapio que implementa a interface Identificacao
public class ItemCardapio implements Identificacao {

     
    // Declaração dos atributos da classe
    private String nome; // Nome do item
    private final String tamanho; // Tamanho do item (inalterável)
    private final String descricao; // Descrição do item (inalterável)
    private final String categoria; // Categoria do item (inalterável)
    private final double preco; // Preço do item
    private int idItem; // Identificador único do item 

    
    // Construtor da classe
    public ItemCardapio(String nome, String tamanho, String descricao, double preco) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = definirCategoria(nome);
        // Determina a categoria do item
    }

     // Método privado para determinar a categoria do item com base no nome
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

    // Método para representação textual do objeto
    @Override
    public String toString() {
        return nome + ": " + descricao + "\nTamanho: " + tamanho + "\nPreço: R$ " + preco + "\n";
    }

     // Métodos getters e setters para acessar e modificar os atributos
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

    // Implementação do método da interface Identificacao para obter o ID do item
    @Override
    public int getId() {
        return idItem;
    }
    
    // Método para definir o ID do item
    public void setIdItem(int idItem) {

        this.idItem = idItem;
    }

}
