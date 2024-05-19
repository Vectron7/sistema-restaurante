package com.artur.Estabelecimento;

import java.util.ArrayList;

public class GerenciarMesas {

    private final ArrayList<Mesa> listaMesas;

    public GerenciarMesas() {
        this.listaMesas = new ArrayList<>();
        criarMesa();
    }

    private void criarMesa() {

        listaMesas.add(new Mesa(2, 1));
        listaMesas.add(new Mesa(4, 2));
        listaMesas.add(new Mesa(4, 3));
        listaMesas.add(new Mesa(6, 4));
        listaMesas.add(new Mesa(8, 5));

    }

    public void listarMesas() {

        for (Mesa mesas : listaMesas) {
            System.out.print("Num. Mesa: " + mesas.getNumero() + " | Capacidade da Mesa: " + mesas.getCapacidade());
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
