package com.artur.gerenciamento; // Declaração do pacote

import java.util.ArrayList; // Importação da classe ArrayList

import com.artur.controle.Mesa; // Importação da classe Mesa
import com.artur.interfaces.Listagem; // Importação da interface Listagem

// Classe que gerencia as mesas e implementa a interface Listagem
public class GerenciadorMesas implements Listagem {

    private final ArrayList<Mesa> listaMesas; // Lista de mesas
    private int numGlobal = 1;  // Contador global para os IDs das mesas


    // Construtor da classe
    public GerenciadorMesas() {
        this.listaMesas = new ArrayList<>(); // Inicializa a lista de mesas 
        criarMesa(); // Chama o método para criar mesas iniciais
    }

     // Método protegido para criar mesas iniciais
    protected void criarMesa() {

        adicionarMesa(new Mesa(2)); // Adiciona uma mesa com capacidade para 2 pessoas
        adicionarMesa(new Mesa(4)); // Adiciona uma mesa com capacidade para 4 pessoas
        adicionarMesa(new Mesa(4)); // Adiciona outra mesa com capacidade para 4 pessoas
        adicionarMesa(new Mesa(6)); // Adiciona uma mesa com capacidade para 6 pessoas
        adicionarMesa(new Mesa(8)); // Adiciona uma mesa com capacidade para 8 pessoas

    }

    // Método protegido para adicionar uma mesa à lista
    protected void adicionarMesa(Mesa mesa) {

        mesa.setIdMesa(this.numGlobal++); // Define o ID da mesa e incrementa o contador global
        listaMesas.add(mesa);  // Adiciona a mesa à lista de mesas
    }

    // Método protegido para remover uma mesa da lista
    protected void removerMesa(int canIdMesa, ArrayList<Mesa> listaMesas){

        // Procurar pela Mesa com o ID especificado
        Mesa mesaRemover = null;
        for (Mesa m : listaMesas) {
            if (m.getId() == canIdMesa) { // Variável para armazenar a mesa a ser removida
                if(m.isStatusMesa()){ // Verifica se a mesa está ocupada
                    System.out.println("Mesa ocupada, libere a reserva antes de remover esta mesa.");
                } else{
                    mesaRemover = m; // Armazena a mesa a ser removida
                }
                break;
            }
        }

        if (mesaRemover != null) {
            // Remover a mesa da lista de mesas
            listaMesas.remove(mesaRemover); // Remove a mesa da lista de mesas
            System.out.println("Mesa removida com sucesso.");

            // Atualizar os IDs das Mesas restantes
            for (int j = 0; j < listaMesas.size(); j++) { 
                listaMesas.get(j).setIdMesa(j + 1);
            }

            this.numGlobal = listaMesas.size() + 1; // Atualiza o contador global
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }

    public void listar() {

         // Lista todas as mesas
        System.out.println("==================== MESAS ====================\n");
        for (Mesa mesas : listaMesas) {
            System.out.print("Num. Mesa: " + mesas.getId() + " | Capacidade da Mesa: " + mesas.getCapacidade());
            if (mesas.isStatusMesa()) {
                System.out.println(" | (Ocupado)");
            } else {
                System.out.println(" | (Livre)");
            }

        }
        System.out.println();

    }

     // Método para obter a lista de mesas
    public ArrayList<Mesa> getListaMesas() {
        return listaMesas;
    }

    // Método para obter o contador global
    public int getNumGlobal() {
        return numGlobal;
    }
}
