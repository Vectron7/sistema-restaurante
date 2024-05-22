package com.artur.Main;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Cardapio {

	private ArrayList<ItemCardapio> itensPP;
	private ArrayList<ItemCardapio> itensA;
	private ArrayList<ItemCardapio> itensB;
	private ArrayList<ItemCardapio> itensS;
	private ArrayList<ItemCardapio> itensO;
	

	public Cardapio() {
		this.itensPP = new ArrayList<>();
		this.itensA = new ArrayList<>();
		this.itensB = new ArrayList<>();
		this.itensS = new ArrayList<>();
		this.itensO = new ArrayList<>();
		gerarItems();
	}

	private void gerarItems() {

		// Pratos Principais
		adicionarItemPP(new ItemCardapio("Bife a Parmegiana", "Unico", "Bife de carne bovina empanado e coberto com molho de tomate e queijo derretido. Acompanha arroz branco e batatas fritas.", 25.00));
		adicionarItemPP(new ItemCardapio("Frango Grelhado", "Unico", "Peito de frango grelhado suculento, temperado com ervas finas. Servido com arroz branco e salada verde.", 20.00));
		adicionarItemPP(new ItemCardapio("Spaghetti a Bolonhesa", "Unico", "Massa spaghetti cozida al dente, coberta com um delicioso molho de carne moida e tomate, finalizado com queijo parmesao ralado.", 18.00));

		// Acompanhamentos
		adicionarItemA(new ItemCardapio("Arroz Branco", "Unico", "Porcao de arroz branco cozido no ponto perfeito.", 5.00));
		adicionarItemA(new ItemCardapio("Batata Frita - Pequena", "Pequena", "Porção de batatas fritas crocantes.", 8.00));
		adicionarItemA(new ItemCardapio("Batata Frita - Media", "Media", "Porcao de batatas fritas crocantes.", 10.00));
		adicionarItemA(new ItemCardapio("Batata Frita - Grande", "Grande", "Porcao de batatas fritas crocantes.", 12.00));
		adicionarItemA(new ItemCardapio("Salada Verde", "Unico", "Mix de folhas verdes frescas, tomate, pepino e cenoura, servido com molho vinagrete.", 7.00));

		// Bebidas
		adicionarItemB(new ItemCardapio("Refrigerante (lata)", "Lata", "Lata de refrigerante de sua escolha (Coca-Cola, Pepsi, Sprite, etc.).", 5.00));
		adicionarItemB(new ItemCardapio("Suco Natural", "300ml", "Suco fresco de frutas naturais da estacao (laranja, limao, morango, etc.).", 6.00));
		adicionarItemB(new ItemCardapio("Agua Mineral", "500ml", "Garrafa de agua mineral.", 3.00));

		// Sobremesas
		adicionarItemS(new ItemCardapio("Mousse de Chocolate", "Unico", "Deliciosa sobremesa feita com chocolate cremoso e leve.", 8.00));
		adicionarItemS(new ItemCardapio("Pudim de Leite", "Unico", "Sobremesa tradicional a base de leite condensado, ovos e acucar caramelizado.", 7.00));
		adicionarItemS(new ItemCardapio("Sorvete - 1 bola", "1 bola", "Sorvete cremoso de sua escolha.", 4.00));
		adicionarItemS(new ItemCardapio("Sorvete - 2 bolas", "2 bolas", "Sorvete cremoso de sua escolha.", 7.00));
		adicionarItemS(new ItemCardapio("Sorvete - 3 bolas", "3 bolas", "Sorvete cremoso de sua escolha.", 10.00));

	}
	
	
	
	private int ultimoIdCategoria(ArrayList<ItemCardapio> lista, String categoria) {
	    int ultimoId = 0;
	    
	    for (ItemCardapio item : lista) {
	        if (item.getCategoria().equals(categoria)) {
	            if (item.getIdItem() > ultimoId) {
	                ultimoId = item.getIdItem();
	            }
	        }

	    }
	    	    
	    return ultimoId;
	}
	


	public void adicionarItemPP(ItemCardapio itemPP) {
		
		int ultimoIdPP = ultimoIdCategoria(itensPP, "Pratos Principais");
		
		itemPP.setIdItem(ultimoIdPP + 1);
		
		itemPP.setCategoria("Pratos Principais");
		itensPP.add(itemPP);
		
		
		

	}
	
	public void adicionarItemA(ItemCardapio itemA) {
		
		int ultimoIdA = ultimoIdCategoria(itensA, "Acompanhamentos");
		
		itemA.setIdItem(ultimoIdA + 1);
		
		itemA.setCategoria("Acompanhamentos");
		itensA.add(itemA);
		
		
		
	}
	
	public void adicionarItemB(ItemCardapio itemB) {
		
		int ultimoIdB = ultimoIdCategoria(itensB, "Bebidas");
		
		itemB.setIdItem(ultimoIdB + 1);
		
		itemB.setCategoria("Bebidas");
		itensB.add(itemB);
		
		
		

	}
	
    public void adicionarItemO(ItemCardapio itemO) {
		
		int ultimoIdO = ultimoIdCategoria(itensB, "Outros");
		
		itemO.setIdItem(ultimoIdO + 1);
		
		itemO.setCategoria("Outros");
		itensO.add(itemO);
		
		
		

	}
	
	public void adicionarItemS(ItemCardapio itemS) {
		
		int ultimoIdS = ultimoIdCategoria(itensS, "Sobremesas");
		
		itemS.setIdItem(ultimoIdS + 1);
		
		itemS.setCategoria("Sobremesas");
		itensS.add(itemS);
	}

	public void imprimirCardapio() {
		
		ArrayList<ItemCardapio> listaUnificada = new ArrayList<>();
		
		if (!itensPP.isEmpty()) listaUnificada.addAll(itensPP);
	    if (!itensA.isEmpty()) listaUnificada.addAll(itensA);
	    if (!itensB.isEmpty()) listaUnificada.addAll(itensB);
	    if (!itensS.isEmpty()) listaUnificada.addAll(itensS);
	    if (!itensO.isEmpty()) listaUnificada.addAll(itensO);
		
		
		String[] categorias = {"Pratos Principais", "Acompanhamentos", "Bebidas", "Sobremesas", "Outros"};
		
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
	    symbols.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.00", symbols);
		
		System.out.println("==================== CARDAPIO ====================");
		
		
		for (int i = 0; i < categorias.length ; i++) {
		    String categoria = categorias[i];
		    System.out.println(categoria + "\n");
		    
		    for (ItemCardapio item : listaUnificada) {
                if (item.getCategoria().equals(categoria)) {
                	System.out.println("ID: "+item.getIdItem()+" | "+item.getNome() + ": " + item.getDescricao());
                    System.out.println("Tamanho: " + item.getTamanho());
                    System.out.println("Preço: R$ " + df.format(item.getPreco()) + "\n");
                }
            }
		    
		    
		    
		    System.out.print("\n");
		}


	}

	public ArrayList<ItemCardapio> getItensPP() {
		return itensPP;
	}

	public ArrayList<ItemCardapio> getItensA() {
		return itensA;
	}

	public ArrayList<ItemCardapio> getItensB() {
		return itensB;
	}

	public ArrayList<ItemCardapio> getItensS() {
		return itensS;
	}

	public ArrayList<ItemCardapio> getItensO() {
		return itensO;
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
