package com.artur.gerenciamento;

import java.util.ArrayList;

import com.artur.estabelecimento.Mesa;
import com.artur.interfaces.Listagem;

public class GerenciarMesas implements Listagem {

    private final ArrayList<Mesa> listaMesas;
    private int numGlobal = 1;

    public GerenciarMesas() {
        this.listaMesas = new ArrayList<>();
    }

    public void criarMesa() {

        adicionarMesa(new Mesa(2));
        adicionarMesa(new Mesa(4));
        adicionarMesa(new Mesa(4));
        adicionarMesa(new Mesa(6));
        adicionarMesa(new Mesa(8));

    }

    protected void adicionarMesa(Mesa mesa) {

        mesa.setIdMesa(this.numGlobal++);
        listaMesas.add(mesa);
    }

    protected void removerMesa(int canIdMesa, ArrayList<Mesa> listaMesas){

        // Procurar pela Mesa com o ID especificado
        Mesa mesaRemover = null;
        for (Mesa m : listaMesas) {
            if (m.getId() == canIdMesa) {
                if(m.isStatusMesa()){
                    System.out.println("Mesa ocupada, libere a reserva antes de remover esta mesa.");
                } else{
                    mesaRemover = m;
                }
                break;
            }
        }

        if (mesaRemover != null) {
            // Remover a mesa da lista de mesas
            listaMesas.remove(mesaRemover);
            System.out.println("Mesa removida com sucesso.");

            // Atualizar os IDs das Mesas restantes
            for (int j = 0; j < listaMesas.size(); j++) {
                listaMesas.get(j).setIdMesa(j + 1);
            }

            this.numGlobal = listaMesas.size() + 1;
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }

    public void listar() {

        for (Mesa mesas : listaMesas) {
            System.out.print("Num. Mesa: " + mesas.getId() + " | Capacidade da Mesa: " + mesas.getCapacidade());
            if (mesas.isStatusMesa()) {
                System.out.println(" | (Ocupado)");
            } else {
                System.out.println(" | (Livre)");
            }

        }

    }

    public ArrayList<Mesa> getListaMesas() {
        return listaMesas;
    }

}