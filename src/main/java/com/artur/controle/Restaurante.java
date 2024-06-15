package com.artur.controle;

import com.artur.gerenciamento.GerenciadorMesas; // Importação da classe GerenciadorMesas
import com.artur.pessoas.Gerente; // Importação da classe Gerente
 

// Declaração da classe Restaurante
public class Restaurante {

     // Declaração de constantes
    private final String NOME_RESTAURANTE = ""; // Nome do restaurante (vazio por padrão)
    private static final String ENDERECO = "UNASP SP - Estr. de Itapecerica, 5859 - Capao Redondo, São Paulo - SP, 05890-020"; // Endereço do restaurante
    private static final String TELEFONE = "(11) 1234-5678"; // Telefone do restaurante
    private static final String CNPJ = "12.345.678/0001-90"; // CNPJ do restaurante 

    // Declaração de variáveis
    GerenciadorMesas mesa = new GerenciadorMesas(); // Instância de GerenciadorMesas
    Gerente gerente;  // Declaração de um objeto Gerente


    // Método privado para contar o número de mesas disponíveis
    private int contMesaDisponiveis(){
        int cont = 0; // Inicializa o contador de mesas disponíveis

        // Loop através da lista de mesas
        for(Mesa m : mesa.getListaMesas()){
            if(!m.isStatusMesa()){
                cont++; // Incrementa o contador se a mesa não estiver reservada
            }
        }

        return cont; // Retorna o número de mesas disponíveis
    }

    // Método público para iniciar o restaurante e exibir suas informações
    public void iniciar() {
        // Exibe informações do restaurante
        System.out.println("========== Informações do Restaurante ==========");
        System.out.println("Nome: " + NOME_RESTAURANTE);
        System.out.println("Endereço: " + ENDERECO);
        System.out.println("Telefone: " + TELEFONE);
        System.out.println("CNPJ: " + CNPJ);
        System.out.println("========== Detalhes do Restaurante ==========");
        System.out.println("Quantidade de Mesas: " + (mesa.getNumGlobal()-1)); // Exibe a quantidade total de mesas, menos 1
        System.out.println("Quantidade de Mesas Disponiveis: " + contMesaDisponiveis()); // Exibe a quantidade de mesas disponíveis
        System.out.println("=============================================");

         // Exibe o nome do gerente, se houver
        if(gerente != null){
            System.out.println("Gerente: " + gerente.getNome());
        }

    }

    
    // Método getter para obter o nome do restaurante
    public String getNOME_RESTAURANTE() {
        return NOME_RESTAURANTE;
    }
}
