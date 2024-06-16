// Herança (ja usado), Polimorfismo (Ja usado), abstração (Ja Usado), interface (Ja usado)

// Corrigir: erro de duplicação na qnt de item na hora de fazer pedido repetido na cozinha

// Comentar o codigo inteiro explicando oque cada coisa faz

package com.artur;

import java.util.Scanner;

import com.artur.controle.Restaurante;
import com.artur.gerenciamento.GerenciadorMenu;


public class Main {

    public static void main(String[] args) {

        // Criação dos objetos necessários
        GerenciadorMenu menu = new GerenciadorMenu();
        Scanner sc = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        
        int opcao;

        // Loop principal do programa
        do {
            // Exibe o menu principal
            System.out.println("========== RESTAURANTE ==========");
            System.out.println("1 - Inciar Atendimento");
            System.out.println("2 - Administração");
            System.out.println("0 - SAIR");
            System.out.println("==========================");

            // Obtém a opção do usuário
            opcao = menu.inserirInt(sc); // Método do objeto GerenciadorMenu para ler um número inteiro

            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }

            // Verifica a opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    // Inicia o atendimento no restaurante
                    restaurante.iniciar();
                    // Exibe o menu de atendimento e aguarda a interação do usuário
                    menu.menuAtendimento(sc);
                    break;
                case 2:
                    // Exibe o menu de administração e aguarda a interação do usuário
                    menu.menuAdministracao(sc);
                    break;
                default:
                    // Caso a opção inserida seja inválida, exibe uma mensagem de erro
                    System.out.println("Opcao inserida invalida. Tente Novamente.");
            }
        } while (opcao != 0); // O loop continua enquanto a opção inserida for diferente de zero

        // Fecha o scanner para liberar recursos
        sc.close();
    }
}
