package com.artur.gerenciamento; // Declaração do pacote 
 
import java.util.ArrayList;  // Importação da classe ArrayList


import com.artur.controle.Reserva; // Importação da classe Reserva
import com.artur.interfaces.Listagem; // Importação da interface Listagem
import com.artur.controle.Mesa; // Importação da classe Mesa
import com.artur.pessoas.Garcom; // Importação da classe Garcom


// Classe que gerencia as reservas e implementa a interface Listagem
public class GerenciadorReservas implements Listagem {


    private final ArrayList<Reserva> listaReservas; // Lista de reservas
    private int ultimoIdReserva = 1; // Contador para o ID das reservas

    // Construtor da classe
    public GerenciadorReservas() {

        this.listaReservas = new ArrayList<>(); // Inicializa a lista de reservas
    }

    // Método para escolher um garçom disponível
    public Garcom escolherGarcom(GerenciadorDePessoas pessoa) {

        if (pessoa.getListaGarcom() == null || pessoa.getListaGarcom().isEmpty()) {
            System.out.println("A lista de garcons está vazia.");
            return null;
        }

         // Percorre a lista de garçons e retorna o primeiro disponível
        for (Garcom g : pessoa.getListaGarcom()) {
            if (!g.isOcupado()) {
                g.setOcupado(true);
                System.out.println("Garcom escolhido: ID " + g.getId());
                System.out.println("Nome do Garcom: " + g.getNome());
                return g;
            }
        }

           
        System.out.println("Nao existe garcom disponivel");  
        return null;

    }

    // Método protegido para adicionar uma reserva
    protected void adicionarReserva(Reserva reserva) {

        reserva.setIdReserva(this.ultimoIdReserva++); // Define o ID da reserva e incrementa o contador
        listaReservas.add(reserva); // Adiciona a reserva à lista
    }

    // Método protegido para cancelar uma reserva
    protected void cancelarReserva(int canIdReserva, ArrayList<Mesa> listaMesas, ArrayList<Garcom> listaGarcom) {

        // Procurar pela reserva com o ID especificado
        Reserva reservaRemover = null; // Variável para armazenar a reserva a ser removida
        for (Reserva r : listaReservas) {
            if (r.getId() == canIdReserva) {
                reservaRemover = r;
                break;
            }
        }

         // Procura pela reserva com o ID especificado
        if (reservaRemover != null) {
            // Atualizar o status do garcom correspondente
            for (Garcom g : listaGarcom) {
                if (g.getId() == reservaRemover.getIdGarcom()) {
                    g.setOcupado(false);
                    break;
                }
            }
        }

        if (reservaRemover != null) {
            // Atualizar o status da mesa correspondente
            for (Mesa m : listaMesas) {
                if (m.getId() == reservaRemover.getNumMesa()) {
                    m.setStatusMesa(false);
                    break;
                }
            }

            // Remover a reserva da lista de reservas
            listaReservas.remove(reservaRemover);
            System.out.println("Reserva removida com sucesso.");

            // Atualizar os IDs das reservas restantes
            for (int j = 0; j < listaReservas.size(); j++) {
                listaReservas.get(j).setIdReserva(j + 1);
            }

            this.ultimoIdReserva = listaReservas.size() + 1;
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    @Override
    public void listar() {
         // Lista todas as reservas

        for (Reserva reserva : listaReservas) {
            System.out.println("ID: " + reserva.getId() + " | Num. Mesa: " + reserva.getNumMesa() + " | Nome e ID do Gargom: "
                    + reserva.getIdGarcom() + " - " + reserva.getNomeGarcom() + " | Nome do Cliente: "
                    + reserva.getNomeCliente() + " | Telefone: " + reserva.getTelefoneCliente() + " | Data e Hora: "
                    + reserva.getDataReserva() + " - " + reserva.getHoraReserva());

        }

    }

    // Método para obter a lista de reservas
    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

}
