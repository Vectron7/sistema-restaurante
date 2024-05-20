package com.artur.Main;

import java.util.ArrayList;

public class Cardapio {

	private ArrayList<ItemCardapio> itens;

	public Cardapio() {
		this.itens = new ArrayList<>();
		gerarItems();
	}

	private void gerarItems() {

		// Pratos Principais
		adicionarItem(new ItemCardapio("Bife a Parmegiana", "Unico", "Bife de carne bovina empanado e coberto com molho de tomate e queijo derretido. Acompanha arroz branco e batatas fritas.", 25.00));
		adicionarItem(new ItemCardapio("Frango Grelhado", "Unico", "Peito de frango grelhado suculento, temperado com ervas finas. Servido com arroz branco e salada verde.", 20.00));
		adicionarItem(new ItemCardapio("Spaghetti a Bolonhesa", "Unico", "Massa spaghetti cozida al dente, coberta com um delicioso molho de carne moida e tomate, finalizado com queijo parmesao ralado.", 18.00));

		// Acompanhamentos
		adicionarItem(new ItemCardapio("Arroz Branco", "Unico", "Porcao de arroz branco cozido no ponto perfeito.", 5.00));
		adicionarItem(new ItemCardapio("Batata Frita - Pequena", "Pequena", "Porção de batatas fritas crocantes.", 8.00));
		adicionarItem(new ItemCardapio("Batata Frita - Media", "Media", "Porcao de batatas fritas crocantes.", 10.00));
		adicionarItem(new ItemCardapio("Batata Frita - Grande", "Grande", "Porcao de batatas fritas crocantes.", 12.00));
		adicionarItem(new ItemCardapio("Salada Verde", "Unico", "Mix de folhas verdes frescas, tomate, pepino e cenoura, servido com molho vinagrete.", 7.00));

		// Bebidas
		adicionarItem(new ItemCardapio("Refrigerante (lata)", "Lata", "Lata de refrigerante de sua escolha (Coca-Cola, Pepsi, Sprite, etc.).", 5.00));
		adicionarItem(new ItemCardapio("Suco Natural", "300ml", "Suco fresco de frutas naturais da estacao (laranja, limao, morango, etc.).", 6.00));
		adicionarItem(new ItemCardapio("Agua Mineral", "500ml", "Garrafa de agua mineral.", 3.00));

		// Sobremesas
		adicionarItem(new ItemCardapio("Mousse de Chocolate", "Unico", "Deliciosa sobremesa feita com chocolate cremoso e leve.", 8.00));
		adicionarItem(new ItemCardapio("Pudim de Leite", "Unico", "Sobremesa tradicional a base de leite condensado, ovos e acucar caramelizado.", 7.00));
		adicionarItem(new ItemCardapio("Sorvete - 1 bola", "1 bola", "Sorvete cremoso de sua escolha.", 4.00));
		adicionarItem(new ItemCardapio("Sorvete - 2 bolas", "2 bolas", "Sorvete cremoso de sua escolha.", 7.00));
		adicionarItem(new ItemCardapio("Sorvete - 3 bolas", "3 bolas", "Sorvete cremoso de sua escolha.", 10.00));

	}

	private void adicionarItem(ItemCardapio item) {
		itens.add(item);
	}

	public void imprimirCardapio() {
		
		String[] categorias = {"Pratos Principais", "Acompanhamentos", "Bebidas", "Sobremesas"};
		
		System.out.println("==================== CARDAPIO ====================");
		
		for(String categoria : categorias) {
			System.out.println(categoria + "\n");
			
			for (ItemCardapio item : itens) {
                if (item.getCategoria().equals(categoria)) {
                    System.out.println(item);
                }
            }
			
			System.out.print("\n");
		}

	}


}

//Cardápio do Restaurante
//
//Pratos Principais:
//
//Bife à Parmegiana: Bife de carne bovina empanado e coberto com molho de tomate e queijo derretido. Acompanha arroz branco e batatas fritas.
//Tamanho: Único
//Preço: R$ 25,00
//
//Frango Grelhado: Peito de frango grelhado suculento, temperado com ervas finas. Servido com arroz branco e salada verde.
//Tamanho: Único
//Preço: R$ 20,00
//
//Spaghetti à Bolonhesa: Massa spaghetti cozida al dente, coberta com um delicioso molho de carne moída e tomate, finalizado com queijo parmesão ralado.
//Tamanho: Único
//Preço: R$ 18,00


//Acompanhamentos:
//
//Arroz Branco: Porção de arroz branco cozido no ponto perfeito.
//Tamanho: Único
//Preço: R$ 5,00
//
//Batata Frita: Porção de batatas fritas crocantes.
//Tamanho: Pequena (R$ 8,00), Média (R$ 10,00), Grande (R$ 12,00)
//
//Salada Verde: Mix de folhas verdes frescas, tomate, pepino e cenoura, servido com molho vinagrete.
//Tamanho: Único
//Preço: R$ 7,00


//Bebidas:
//
//Refrigerante (lata): Lata de refrigerante de sua escolha (Coca-Cola, Pepsi, Sprite, etc.).
//Preço: R$ 5,00
//
//Suco Natural: Suco fresco de frutas naturais da estação (laranja, limão, morango, etc.).
//Tamanho: 300ml
//Preço: R$ 6,00
//
//Água Mineral: Garrafa de água mineral.
//Tamanho: 500ml
//Preço: R$ 3,00


//Sobremesas:
//
//Mousse de Chocolate: Deliciosa sobremesa feita com chocolate cremoso e leve.
//Tamanho: Único
//Preço: R$ 8,00
//
//Pudim de Leite: Sobremesa tradicional à base de leite condensado, ovos e açúcar caramelizado.
//Tamanho: Único
//Preço: R$ 7,00
//
//Sorvete: Sorvete cremoso de sua escolha.
//Opções: 1 bola (R$ 4,00), 2 bolas (R$ 7,00), 3 bolas (R$ 10,00)
