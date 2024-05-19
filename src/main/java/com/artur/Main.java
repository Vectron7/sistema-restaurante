// Falta Pedidos, Cozinha, Caixa, "Garçom?" (Colocar mais coisas que faltam ou dar/adicionar mais sugestões)

package com.artur;

import java.util.Scanner;

import com.artur.Estabelecimento.Reservas;
import com.artur.Pessoas.Cliente;
import com.artur.Estabelecimento.Mesa;
import com.artur.Estabelecimento.GerenciarMesas;

public class Main {

    public static void main(String[] args) {

        int op1, op2;
        int ultimoIdCliente = 0;

        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;
        Reservas reserva = null;
        GerenciarMesas mesa = new GerenciarMesas();

        do {
            System.out.println("========== MENU ==========");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Recepcao");
            System.out.println("0 - SAIR");
            System.out.println("==========================");

            op1 = sc.nextInt();
            sc.nextLine();

            switch (op1) {
                case 1: {
                    System.out.println("========== Cadastrar Cliente ==========");
                    System.out.println("Insira o nome do cliente: ");
                    String cadNomeCliente = sc.nextLine();
                    System.out.println("Insira o Endereco: ");
                    String enderecoCliente = sc.nextLine();
                    System.out.println("Insira o Telefone");
                    String cadTelefoneCliente = sc.nextLine();
                    System.out.println("Insira a Data de Nascimento");
                    String nascCliente = sc.nextLine();

                    cliente = new Cliente(cadNomeCliente, enderecoCliente, cadTelefoneCliente, nascCliente);
                    cliente.setIdCliente(++ultimoIdCliente);
                    cliente.cadastrarCliente(cliente);

                    break;
                }
                case 2: {
                    if (cliente == null) {
                        System.out.println("Nenhum Cliente Encontrado");
                        break;
                    } else {
                        System.out.println("========== Lista de Clientes ==========\n");
                        cliente.listarClientes();
                    }
                    break;
                }
                case 3: {
                    do {
                        System.out.println("========== RECEPCAO ==========");
                        System.out.println("1 - Listar Reservas");
                        System.out.println("2 - Listar Mesas");
                        System.out.println("3 - Fazer Reserva");
                        System.out.println("4 - Cancelar Reserva");
                        System.out.println("5 - Modificar Reserva");
                        System.out.println("0 - VOLTAR");
                        System.out.println("==============================");

                        op2 = sc.nextInt();
                        sc.nextLine();

                        switch (op2) {
                            case 1: {
                                if (reserva == null) {
                                    System.out.println("Nenhuma Reserva Registrada");
                                    break;
                                } else {
                                    reserva.listarReservas();
                                }                         
                            break;
                            }
                            case 2:{
                                if (mesa == null) {
                                    System.out.println("Nenhuma Mesa Encontrada");
                                    break;
                                } else {
                                    mesa.listarMesas();
                                }
                                break;
                            }
                            case 3:{
                                if (cliente == null) {
                                    System.out.println("Nenhum Cliente Encontrado. Cadastre um cliente antes de fazer uma reserva.");
                                    break;
                                }

                                System.out.println("========== Clientes e Mesas ==========\n");
                                cliente.listarClientes();
                                System.out.print("\n");
                                mesa.listarMesas();

                                System.out.println("\n========== Fazer Reserva ==========");
                                System.out.println("Digite o id do cliente: ");
                                int idCliente = sc.nextInt();

                                sc.nextLine();

                                Cliente clienteSelec = null;
                                for (Cliente id : cliente.getListaClientes()) {
                                    if (id.getIdCliente() == idCliente) {
                                        clienteSelec = id;
                                    }
                                }

                                if (clienteSelec == null) {
                                    System.out.println("ID DE CLIENTE INVALIDO.");
                                    break;
                                }

                                System.out.println("Digite o numero da mesa: ");
                                int numMesa = sc.nextInt();

                                sc.nextLine();

                                Mesa mesaSelec = null;
                                for (Mesa mesinha : mesa.getListaMesas()) {
                                    if (numMesa == mesinha.getNumero() && !mesinha.isStatusMesa()) {
                                        mesaSelec = mesinha;
                                    }
                                }

                                if (mesaSelec == null) {
                                    System.out.println("ID DA MESA INVALIDA OU OCUPADA");
                                    break;
                                }

                                System.out.println("Insira a Data (DD/MM/AAAA): ");
                                String dataReserva = sc.nextLine();
                                System.out.println("Insira o Horario (HH:MM): ");
                                String horaReserva = sc.nextLine();

                                reserva = new Reservas(dataReserva, horaReserva, clienteSelec.getNome(), clienteSelec.getTelefone(), mesaSelec.getNumero());
                                reserva.fazerReserva(reserva);
                                mesaSelec.reservar();

                                break;
                            }
                            case 4:{
                                break;
                            }
                            case 5:{
                                break;
                            }
                            case 0:
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println("Opcao inserida invalida. Tente Novamente.");
                        }
                    } while (op2 != 0);
                    break;
                }
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao inserida invalida. Tente Novamente.");
            }

        } while (op1 != 0);
        
        sc.close();

    }
}
