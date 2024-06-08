// Faltam fazer: Pedidos, Cozinha, Caixa, "Garçom?", "Gerente?" (Colocar mais coisas que faltam ou dar/adicionar mais sugestões)
// Herança (ja usado), Polimorfismo (Ja usado), abstração (Ja Usado), interface (Ja usado)

// Criar logica para quantidade de items do cardapio que vai ser pedido (algo como quantidade * preço) e criar uma lista separada
// para os itens que foram pedidos/comprados (como uma comanda) com o preço total.
// Fazer a parte de modificar uma reserva

// Comentar o codigo inteiro explicando oque cada coisa faz

package com.artur.controle;

import java.util.Scanner;

import com.artur.gerenciamento.GerenciarCardapio;
import com.artur.gerenciamento.GerenciarMenu;
import com.artur.gerenciamento.GerenciarMesas;
import com.artur.gerenciamento.GerenciarPessoa;
import com.artur.pessoas.Cliente;


public class Principal {

    public static void main(String[] args) {

        GerenciarMenu menu = new GerenciarMenu();

        int opcao;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("========== RESTAURANTE ==========");
            System.out.println("1 - Recepcao (Reservas, Mesas)");
            System.out.println("2 - Cadastros (Cliente, Garcom, Gerente)");
            System.out.println("3 - Cardapio (Mostrar, Adicionar e Remover item)");
            System.out.println("4 - Pedido (Mostrar, Fazer e Cancelar Pedido)");
            System.out.println("5 - Cozinha");
            System.out.println("0 - SAIR");
            System.out.println("==========================");

            opcao = menu.inserirInt(sc);

            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }

            switch (opcao) {
                case 1:
                    menu.menuRecepcao(sc);
                    break;
                case 2:
                    menu.menuCadastros(sc);
                    break;
                case 3:
                    menu.menuCardapio(sc);
                    break;
                case 4:
                    menu.menuPedido(sc);
                    break;
                case 5:
                    menu.menuCozinha(sc);
                    break;
                default:
                    System.out.println("Opcao inserida invalida. Tente Novamente.");
            }
        } while (opcao != 0);

        sc.close();
    }
}