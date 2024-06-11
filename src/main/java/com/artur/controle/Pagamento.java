package com.artur.controle;

import com.artur.gerenciamento.GerenciadorMenu;

import java.util.Scanner;

public class Pagamento extends Caixa {

    private void confirmarPagamento(GerenciadorMenu menu, Scanner sc) {
        System.out.println("Deseja continuar com esse metodo de pagamento? (1)Sim / (2)Não");
        int confirmacao = menu.inserirInt(sc);
        sc.nextLine();
        if (confirmacao == 1) {
            System.out.println("Continuando...");
        } else {
            System.out.println("Pagamento cancelado.");
        }
    }

    @Override
    public void pagarComDinheiro(GerenciadorMenu menu, Scanner sc) {
        confirmarPagamento(menu, sc);
        System.out.println("Pagamento com Dinheiro Realizado.");
    }

    @Override
    public void pagarComCartao(GerenciadorMenu menu, Scanner sc) {
        confirmarPagamento(menu, sc);
        boolean certo = true;
        System.out.println("(1) Credito\n(2) Debito");
        do{
            int opcaoCartao = menu.inserirInt(sc);
            if(opcaoCartao == 1){
                System.out.println("Pagamento com Cartão de Credito Realizado.");
                certo = false;
            } else if (opcaoCartao == 2) {
                System.out.println("Pagamento com Cartão de Debito Realizado.");
                certo = false;
            } else{
                System.out.println("Opcao Incorreta, Insira novamente.");
            }
        }while(certo);
    }

    @Override
    public void pagarComCarteiraDigital(GerenciadorMenu menu, Scanner sc) {
        confirmarPagamento(menu, sc);
        System.out.println("Pagamento com Carteira Digital Realizado.");
    }

    @Override
    public void pagarComPix(GerenciadorMenu menu, Scanner sc){
        confirmarPagamento(menu, sc);
        System.out.println("Pagamento com Pix Realizado.");
    }

    @Override
    public void fazerPagamento(Scanner sc) {
        GerenciadorMenu menu = new GerenciadorMenu();

        System.out.println("Escolha o metodo de pagamento.");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão");
        System.out.println("3 - Carteira Digital");
        System.out.println("4 - PIX");

        int opcao = menu.inserirInt(sc);

        switch (opcao){
            case 1:
                pagarComDinheiro(menu, sc);
                break;
            case 2:
                pagarComCartao(menu, sc);
                break;
            case 3:
                pagarComCarteiraDigital(menu, sc);
                break;
            case 4:
                pagarComPix(menu, sc);
                break;
            default:
                System.out.println("Opção inserida inválida. Tente novamente.");
        }

    }

}
