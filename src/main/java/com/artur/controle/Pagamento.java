package com.artur.controle;

// Importação da classe GerenciadorMenu do pacote com.artur.gerenciamento
import com.artur.gerenciamento.GerenciadorMenu;
// Importação da classe Scanner do pacote java.util
import java.util.Scanner;

// Declaração da classe Pagamento, que estende a classe Caixa
public class Pagamento extends Caixa {

    // Método privado para confirmar o pagamento
    private void confirmarPagamento(GerenciadorMenu menu, Scanner sc) {
         // Exibe uma mensagem para confirmar o pagamento
        System.out.println("Deseja continuar com esse metodo de pagamento? (1)Sim / (2)Não");
        // Solicita ao usuário que insira um número para confirmar o pagamento
        int confirmacao = menu.inserirInt(sc);
        sc.nextLine(); // Limpa o buffer do scanner

        // Verifica se o usuário confirmou o pagamento
        if (confirmacao == 1) {
            try {
                // Inicia um temporizador para simular uma animação de carregamento
                long startTime = System.currentTimeMillis();
                long duration = 2000; // Duração da animação em milissegundos


                // Loop para exibir a animação
                while (System.currentTimeMillis() - startTime < duration) {
                    System.out.print("\rContinuando.  "); // Exibe uma parte da animação
                    Thread.sleep(500); // Aguarda 500 milissegundos
                    System.out.print("\rContinuando.. "); // Exibe outra parte da animação
                    Thread.sleep(500);// Aguarda 500 milissegundos
                    System.out.print("\rContinuando...");// Exibe outra parte da animação
                    Thread.sleep(500);// Aguarda 500 milissegundos
                }
                System.out.println(); // Quebra de linha após a animação
            } catch (InterruptedException e) {
                e.printStackTrace(); // Imprime informações sobre a exceção
            }
        } else {
            // Exibe uma mensagem informando que o pagamento foi cancelado
            System.out.println("Pagamento cancelado.");
        }
    }

    
    // Método para pagar com dinheiro
    @Override
    public void pagarComDinheiro(GerenciadorMenu menu, Scanner sc) {
        confirmarPagamento(menu, sc); // Confirma o pagamento
        System.out.println("Pagamento com Dinheiro Realizado.");
    }

    // Método para pagar com cartão
    @Override
    public void pagarComCartao(GerenciadorMenu menu, Scanner sc) {
        confirmarPagamento(menu, sc); // Confirma o pagamento
        boolean certo = true;// Define uma variável booleana para controlar o loop 
        System.out.println("(1) Credito\n(2) Debito"); // Exibe opções de pagamento com cartão
        do {
        do{
            int opcaoCartao = menu.inserirInt(sc); // Solicita ao usuário que escolha uma opção de pagamento
            if(opcaoCartao == 1){
                // Exibe uma mensagem informando que o pagamento com cartão de crédito foi realizado
                System.out.println("Pagamento com Cartão de Credito Realizado.");
                certo = false; //Sai do loop
            } else if (opcaoCartao == 2) {
                // Exibe uma mensagem informando que o pagamento com cartão de débito foi realizado
                System.out.println("Pagamento com Cartão de Debito Realizado.");
                certo = false;// Sai do loop
            } else{
                // Exibe uma mensagem informando que a opção inserida é inválida
                System.out.println("Opcao Incorreta, Insira novamente.");
            }
            // Loop enquanto a opção inserida for inválida
        }while(certo);
    }

    // Método para pagar com carteira digital
    @Override
    public void pagarComCarteiraDigital(GerenciadorMenu menu, Scanner sc) {
        confirmarPagamento(menu, sc); // Confirma o pagamento
        // Exibe uma mensagem informando que o pagamento com carteira digital foi realizado
        System.out.println("Pagamento com Carteira Digital Realizado.");
    }

    // Método para pagar com PIX
    @Override
    public void pagarComPix(GerenciadorMenu menu, Scanner sc){
        confirmarPagamento(menu, sc); // Confirma o pagamento
        // Exibe uma mensagem informando que o pagamento com PIX foi realizado
        System.out.println("Pagamento com Pix Realizado.");
    }

    // Método para fazer o pagamento
    @Override
    public void fazerPagamento(Scanner sc) {
        
        // Cria uma instância de GerenciadorMenu
        GerenciadorMenu menu = new GerenciadorMenu();
        
         // Exibe opções de pagamento
        System.out.println("Escolha o metodo de pagamento.");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão");
        System.out.println("3 - Carteira Digital");
        System.out.println("4 - PIX");

        // Solicita ao usuário que escolha uma opção de pagamento
        int opcao = menu.inserirInt(sc);

         // Executa uma ação com base na opção escolhida
        switch (opcao){
            case 1:
                pagarComDinheiro(menu, sc); // Paga com dinheiro
                break;
            case 2:
                pagarComCartao(menu, sc); // Pag a com cartão
                break;
            case 3:
                pagarComCarteiraDigital(menu, sc); // Paga com carteira digital 
                break;
            case 4:
                pagarComPix(menu, sc); // Paga com PIX
                break;
            default:
                // Exibe uma mensagem informando que a opção inserida é inválido
                System.out.println("Opção inserida inválida. Tente novamente.");
                
        }

    }

}
