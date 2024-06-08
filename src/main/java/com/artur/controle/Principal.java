// Faltam fazer: Pedidos, Cozinha, Caixa, "Garçom?", "Gerente?" (Colocar mais coisas que faltam ou dar/adicionar mais sugestões)
// Herança (ja usado), Polimorfismo (Ja usado), abstração (Ja Usado), interface (Ja usado)

// Criar logica para quantidade de items do cardapio que vai ser pedido (algo como quantidade * preço) e criar uma lista separada
// para os itens que foram pedidos/comprados (como uma comanda) com o preço total.
// Fazer a parte de modificar uma reserva

// Comentar o codigo inteiro explicando oque cada coisa faz

package com.artur.controle;

import java.util.Scanner;

import com.artur.estabelecimento.Restaurante;
import com.artur.gerenciamento.GerenciarCardapio;
import com.artur.gerenciamento.GerenciarMenu;
import com.artur.gerenciamento.GerenciarMesas;
import com.artur.gerenciamento.GerenciarPessoa;
import com.artur.pessoas.Cliente;


public class Principal {

    public static void main(String[] args) {

        GerenciarMenu menu = new GerenciarMenu();
        Scanner sc = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        
        int opcao;

        do {
            System.out.println("========== RESTAURANTE ==========");
            System.out.println("1 - Inciar Atendimento");
            System.out.println("2 - Administração");
            System.out.println("0 - SAIR");
            System.out.println("==========================");

            opcao = menu.inserirInt(sc);

            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }

            switch (opcao) {
                case 1:
                    restaurante.iniciar();
                    menu.menuAtendimento(sc);
                    break;
                case 2:
                    menu.menuAdministracao(sc);
                    break;
                default:
                    System.out.println("Opcao inserida invalida. Tente Novamente.");
            }
        } while (opcao != 0);

        sc.close();
    }
}