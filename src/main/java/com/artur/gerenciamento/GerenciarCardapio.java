package com.artur.gerenciamento;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.artur.controle.ItemCardapio;
import com.artur.interfaces.Listagem;

import java.util.List;

public class GerenciarCardapio implements Listagem {

    private final Map<String, List<ItemCardapio>> cardapio;
    private int IdGlobal = 1;

    public GerenciarCardapio() {
        this.cardapio = new LinkedHashMap<>();
        gerarItems();
    }

    protected void gerarItems() {

        cardapio.put("Pratos Principais", new ArrayList<>());
        cardapio.put("Acompanhamentos", new ArrayList<>());
        cardapio.put("Bebidas", new ArrayList<>());
        cardapio.put("Sobremesas", new ArrayList<>());
        cardapio.put("Outros", new ArrayList<>());

        // Pratos Principais
        adicionarItem("Pratos Principais", new ItemCardapio("Bife a Parmegiana", "Unico", "Bife de carne bovina empanado e coberto com molho de tomate e queijo derretido. Acompanha arroz branco e batatas fritas.", 25.00));
        adicionarItem("Pratos Principais", new ItemCardapio("Frango Grelhado", "Unico", "Peito de frango grelhado suculento, temperado com ervas finas. Servido com arroz branco e salada verde.", 20.00));
        adicionarItem("Pratos Principais", new ItemCardapio("Spaghetti a Bolonhesa", "Unico", "Massa spaghetti cozida al dente, coberta com um delicioso molho de carne moida e tomate, finalizado com queijo parmesao ralado.", 18.00));

        // Acompanhamentos
        adicionarItem("Acompanhamentos", new ItemCardapio("Arroz Branco", "Unico", "Porcao de arroz branco cozido no ponto perfeito.", 5.00));
        adicionarItem("Acompanhamentos", new ItemCardapio("Batata Frita - Pequena", "Pequena", "Porção de batatas fritas crocantes.", 8.00));
        adicionarItem("Acompanhamentos", new ItemCardapio("Batata Frita - Media", "Media", "Porcao de batatas fritas crocantes.", 10.00));
        adicionarItem("Acompanhamentos", new ItemCardapio("Batata Frita - Grande", "Grande", "Porcao de batatas fritas crocantes.", 12.00));
        adicionarItem("Acompanhamentos", new ItemCardapio("Salada Verde", "Unico", "Mix de folhas verdes frescas, tomate, pepino e cenoura, servido com molho vinagrete.", 7.00));

        // Bebidas
        adicionarItem("Bebidas", new ItemCardapio("Refrigerante (lata)", "Lata", "Lata de refrigerante de sua escolha (Coca-Cola, Pepsi, Sprite, etc.).", 5.00));
        adicionarItem("Bebidas", new ItemCardapio("Suco Natural", "300ml", "Suco fresco de frutas naturais da estacao (laranja, limao, morango, etc.).", 6.00));
        adicionarItem("Bebidas", new ItemCardapio("Agua Mineral", "500ml", "Garrafa de agua mineral.", 3.00));

        // Sobremesas
        adicionarItem("Sobremesas", new ItemCardapio("Mousse de Chocolate", "Unico", "Deliciosa sobremesa feita com chocolate cremoso e leve.", 8.00));
        adicionarItem("Sobremesas", new ItemCardapio("Pudim de Leite", "Unico", "Sobremesa tradicional a base de leite condensado, ovos e acucar caramelizado.", 7.00));
        adicionarItem("Sobremesas", new ItemCardapio("Sorvete - 1 bola", "1 bola", "Sorvete cremoso de sua escolha.", 4.00));
        adicionarItem("Sobremesas", new ItemCardapio("Sorvete - 2 bolas", "2 bolas", "Sorvete cremoso de sua escolha.", 7.00));
        adicionarItem("Sobremesas", new ItemCardapio("Sorvete - 3 bolas", "3 bolas", "Sorvete cremoso de sua escolha.", 10.00));

    }

    private String Categoria(String categoria) {

        return switch (categoria) {
            case "Pratos Principais", "Acompanhamentos" -> "Pratos Principais";
            case "Bebidas" -> "Acompanhamentos";
            case "Sobremesas" -> "Bebidas";
            case "Outros" -> "Sobremesas";
            default -> null;
        };

    }

    private int obterIdMaisAltoCategoria(String categoria, List<ItemCardapio> itensCategoria) {
        int idMaisAlto = 0;

        // Verifica se a categoria existe no mapa
        if (itensCategoria != null) {
            // Percorre os itens da categoria para encontrar o ID mais alto
            for (ItemCardapio item : itensCategoria) {
                if (item.getCategoria().equals(categoria)) {
                    if (item.getId() > idMaisAlto) {
                        idMaisAlto = item.getId();
                    }
                }

            }
        }

        return idMaisAlto;
    }

    public void adicionarItem(String categoria, ItemCardapio item) {

        int idAlto = 1;

        String catAnterior = Categoria(categoria);
        List<ItemCardapio> itensCatAnterior = cardapio.get(catAnterior);
        List<ItemCardapio> itens = cardapio.get(categoria);

        if (categoria.equals("Pratos Principais")) {
            item.setIdItem(this.IdGlobal++);
        } else {
            idAlto = obterIdMaisAltoCategoria(catAnterior, itensCatAnterior);
            item.setIdItem(idAlto + 1);
        }

        if (itens != null) {
            itens.add(item);
        }

        int novoId = 1;
        for (Map.Entry<String, List<ItemCardapio>> entry : cardapio.entrySet()) {
            for (ItemCardapio itemCategoria : entry.getValue()) {
                itemCategoria.setIdItem(novoId++);
            }
        }

    }

    public void removerItem(String categoria, int id) {

        if (cardapio.containsKey(categoria)) {
            List<ItemCardapio> itensCategoria = cardapio.get(categoria);
            ItemCardapio itemRemovido = null;

            for (ItemCardapio item : itensCategoria) {
                if (item.getId() == id) {
                    itemRemovido = item;
                    break;
                }
            }

            if (itemRemovido != null) {
                itensCategoria.remove(itemRemovido);
                System.out.println("Item removido com sucesso.");

                int novoId = 1;
                for (Map.Entry<String, List<ItemCardapio>> entry : cardapio.entrySet()) {
                    for (ItemCardapio itemCategoria : entry.getValue()) {
                        itemCategoria.setIdItem(novoId++);
                    }
                }

            } else {
                System.out.println("ID do Item não encontrado na categoria: " + categoria);
            }
        } else {
            System.out.println("Categoria não encontrada: " + categoria);
        }
    }

    @Override
    public void listar() {

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", symbols);

        System.out.println("==================== CARDAPIO ====================");

        for (Map.Entry<String, List<ItemCardapio>> entry : getCardapio().entrySet()) {
            String categoria = entry.getKey();
            List<ItemCardapio> itensCategoria = entry.getValue();

            System.out.println(categoria + "\n");

            for (ItemCardapio item : itensCategoria) {
                System.out.println("ID: " + item.getId() + " | " + item.getNome() + ": " + item.getDescricao());
                System.out.println("Tamanho: " + item.getTamanho());
                System.out.println("Preço: R$ " + df.format(item.getPreco()) + "\n");

            }

        }

    }

    public void imprimirItensCategoria(String categoria, Map<String, List<ItemCardapio>> cardapio) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", symbols);

        if (cardapio.containsKey(categoria)) {
            List<ItemCardapio> itensCategoria = cardapio.get(categoria);
            for (ItemCardapio item : itensCategoria) {
                System.out.println("ID: " + item.getId() + " | " + item.getNome() + ": " + item.getDescricao());
                System.out.println("Tamanho: " + item.getTamanho());
                System.out.println("Preço: R$ " + df.format(item.getPreco()) + "\n");
            }
        } else {
            System.out.println("Categoria não encontrada.");
        }
    }

    public Map<String, List<ItemCardapio>> getCardapio() {
        return cardapio;
    }


}