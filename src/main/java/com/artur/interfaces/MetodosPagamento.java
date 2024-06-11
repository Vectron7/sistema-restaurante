package com.artur.interfaces;

import com.artur.gerenciamento.GerenciadorMenu;

import java.util.Scanner;

public interface MetodosPagamento {

    void pagarComDinheiro(GerenciadorMenu menu, Scanner sc);

    void pagarComCartao(GerenciadorMenu menu, Scanner sc);

    void pagarComCarteiraDigital(GerenciadorMenu menu, Scanner sc);

    void pagarComPix(GerenciadorMenu menu, Scanner sc);


}
