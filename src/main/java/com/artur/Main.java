// Faltam fazer:  (Colocar mais coisas que faltam ou dar/adicionar mais sugestões)
// Herança (ja usado), Polimorfismo (Ja usado), abstração (Ja Usado), interface (Ja usado)

// Corrigir: quando cancelo depois de fazer a reserva no atendimento, a reserva ainda continua la e a mesa e garçom continuam ocupados
//e se tentar continuar da erro de cliente null
// Corrigir: erro de duplicação na qnt de item na hora de fazer pedido repetido na cozinha
// Fazer o modificar Cardapio
// Comentar o codigo inteiro explicando oque cada coisa faz

package com.artur;

import java.util.Scanner;

import com.artur.controle.Restaurante;
import com.artur.gerenciamento.GerenciadorMenu;


public class Main {

    public static void main(String[] args) {


        GerenciadorMenu menu = new GerenciadorMenu();
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