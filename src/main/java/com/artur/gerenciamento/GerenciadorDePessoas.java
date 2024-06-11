package com.artur.gerenciamento;

import java.util.ArrayList;
import com.artur.interfaces.GerenciamentoPessoas;
import com.artur.pessoas.*;

// Terminar o resto dos metodos

public class GerenciadorDePessoas implements GerenciamentoPessoas {

    private final ArrayList<Cliente> listaClientes;
    private final ArrayList<Garcom> listaGarcom;
    private final ArrayList<Gerente> listaGerente;

    private int ultimoIdCliente = 0;
    protected int ultimoIdGarcom = 0;
    private int ultimoIdGerente = 0;

    public GerenciadorDePessoas() {
        this.listaClientes = new ArrayList<>();
        this.listaGarcom = new ArrayList<>();
        this.listaGerente = new ArrayList<>();
        gerarGarcom();
    }


    public void gerarGarcom() {
        adicionarGarcom(new Garcom("Thiago", "Capao Redondo", "1234-5678", 1412));
        adicionarGarcom(new Garcom("Ana", "Av. Paulista, 100", "9876-5432", 1413));
        adicionarGarcom(new Garcom("Carlos", "Rua Augusta, 200", "8765-4321", 1414));
        adicionarGarcom(new Garcom("Maria", "Av. Faria Lima, 300", "7654-3210", 1415));
        adicionarGarcom(new Garcom("Pedro", "Rua Oscar Freire, 400", "6543-2109", 1416));
    }

    @Override
    public void adicionarCliente(Cliente cliente) {
        // Define o id do cliente e o adiciona a lista de cliente
        cliente.setIdCliente(++ultimoIdCliente);
        listaClientes.add(cliente);

    }

    @Override
    public void removerCliente(int IdCliente) {
        // Verifica se o id do cliente existe e o remove
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente r = listaClientes.get(i);
            if (r.getId() == IdCliente) {
                listaClientes.remove(r);
                System.out.println("Cliente removido com sucesso.");
            }

            // Atualiza os ids da lista
            for (Cliente listaCliente : listaClientes) {
                int novoID = listaCliente.getId() - 1;
                if (novoID >= 1) {
                    listaCliente.setIdCliente(novoID);
                }
            }

        }

        // Se a lista estiver vazia, garante que o ultimoIdCliente seja 0
        if (listaClientes.isEmpty()) {
            this.ultimoIdCliente = 0;
        }
    }

    @Override
    public void listarCliente() {
        for (Cliente cliente : listaClientes) {
            System.out.println("ID: " + cliente.getId() + " | Nome: " + cliente.getNome() + " | Endereco: " + cliente.getEndereco() + " | Telefone: " + cliente.getTelefone() + " | Data de Nascimento: " + cliente.getDataNasc());

        }
    }

    @Override
    public void adicionarGarcom(Garcom garcom) {
        // Define o id do garçom e o adiciona a lista de garçons
        garcom.setIdGarcom(++ultimoIdGarcom);
        listaGarcom.add(garcom);
    }

    @Override
    public void removerGarcom(int IdGarcom) {
        // Verifica se o id do garçom existe e o remove
        for (int i = 0; i < listaGarcom.size(); i++) {
            Garcom g = listaGarcom.get(i);
            if (g.getId() == IdGarcom) {
                listaGarcom.remove(g);
                System.out.println("Garçom removido com sucesso.");
                break;
            }
        }

        // Atualizar os IDs dos garçons restantes
        for (int i = 0; i < listaGarcom.size(); i++) {
            listaGarcom.get(i).setIdGarcom(i + 1);
        }

        // Ajustar o último ID de garçom
        this.ultimoIdGarcom = listaGarcom.size();
    }

    @Override
    public void listarGarcom() {

        for (Garcom garcom : listaGarcom) {
            System.out.print("ID: " + garcom.getId() + " | Nome: " + garcom.getNome() + " | Endereco: " + garcom.getEndereco() + " | Telefone: " + garcom.getTelefone() + " | Salario: " + garcom.getSalario() + " | Data de Contratacao: " + garcom.getDataContratacao());
            if (garcom.isOcupado()) {
                System.out.println(" | (Ocupado) ");
            } else {
                System.out.println(" | (Livre) ");
            }
        }
    }

    @Override
    public void adicionarGerente(Gerente gerente) {
        if (Gerente.getGerenteAtual() == null) { // Se não houver gerente atual
            gerente.setIdGerente(++ultimoIdGerente); // Define o ID do gerente
            listaGerente.add(gerente); // Adiciona o gerente à lista de gerentes
            Gerente.setGerenteAtual(gerente); // Define o gerente como gerente atual
            System.out.println("Gerente adicionado com sucesso.");
        } else {
            System.out.println("Já existe um gerente no restaurante.");
        }
    }

    @Override
    public void removerGerente(int IdGerente) {
        for (Gerente gerente : listaGerente) {
            if (gerente.getId() == IdGerente) {
                listaGerente.remove(gerente);
                Gerente.setGerenteAtual(null);
                System.out.println("Gerente removido com sucesso.");
                return;
            }
        }
        System.out.println("Gerente não encontrado com o ID fornecido.");
    }

    @Override
    public void listarGerente() {
        if (Gerente.getGerenteAtual() != null) {
            Gerente gerenteAtual = Gerente.getGerenteAtual();
            System.out.println("Gerente atual: " + gerenteAtual.getNome());
        } else {
            System.out.println("Não há gerente no restaurante atualmente.");
        }
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }


    public ArrayList<Garcom> getListaGarcom() {
        return listaGarcom;
    }

    public ArrayList<Gerente> getListaGerente() {
        return listaGerente;
    }


}