// Faltam fazer: Pedidos, Cozinha, Caixa, "Garçom?", Cardapio (Colocar mais coisas que faltam ou dar/adicionar mais sugestões)
// Tem que Usar Herança (ja usado), Polimorfismo (falta), abstração (Ja Usado), interface (falta)

// Fazer um menu para o cardapio dentro do menu pedidos (Cardapio ja esta pronto e com uma função para imprimi-lo).
// Colocar IDs em cada item do cardapio para a seleção do item (Verificar os IDs das outras classes para ver como foi implementado).
// Criar logica para quantidade de items do cardapio que vai ser pedido (algo como quantidade * preço) e criar uma lista separada
// para os itens que foram pedidos/comprados (como uma comanda) com o preço total.

package com.artur.Main;

import java.util.ArrayList;
import java.util.Scanner;

import com.artur.Pessoas.Cliente;
import com.artur.Estabelecimento.Mesa;

public class Main {

	public static void main(String[] args) {

		int op1, op2, op3, op4, op5;
		int ultimoIdCliente = 0;
		int ultimoIdReserva = 0;

		ArrayList<Cliente> listaClientes = new ArrayList<>();
		ArrayList<Reservas> listaReservas = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		Cliente cliente = null;
		Reservas reserva = null;
		GerenciarMesas mesa = new GerenciarMesas();
		Cardapio cardapio = new Cardapio();

		do {
			System.out.println("========== RESTAURANTE ==========");
			System.out.println("1 - Recepcao");
			System.out.println("2 - Cozinha");
			System.out.println("3 - Pedido");
			System.out.println("0 - SAIR");
			System.out.println("==========================");

			op1 = sc.nextInt();
			sc.nextLine();

			switch (op1) {

			case 1: {
				do {
					System.out.println("========== RECEPCAO ==========");
					System.out.println("1 - Reservas");
					System.out.println("2 - Clientes");
					System.out.println("3 - Mesas");
					System.out.println("0 - VOLTAR");
					System.out.println("==============================");

					op2 = sc.nextInt();
					sc.nextLine();

					switch (op2) {
					case 1: {
						do {
							System.out.println("========== Reservas ==========");
							System.out.println("1 - Listar Reservas");
							System.out.println("2 - Fazer Reserva");
							System.out.println("3 - Cancelar Reserva");
							System.out.println("4 - Modificar Reserva");
							System.out.println("0 - VOLTAR");
							System.out.println("==============================");

							op3 = sc.nextInt();
							sc.nextLine();

							switch (op3) {
							case 1: {
								if (reserva == null || listaReservas == null || listaReservas.isEmpty()) {
									System.out.println("Nenhuma Reserva Registrada");
									break;
								} else {
									reserva.listarReservas(listaReservas);
								}
								break;
							}
							case 2: {
								if (cliente == null) {
									System.out.println(
											"Nenhum Cliente Encontrado. Cadastre um cliente antes de fazer uma reserva.");
									break;
								}

								System.out.println("========== Clientes e Mesas ==========\n");
								cliente.listar(listaClientes);
								System.out.print("\n");
								mesa.listarMesas();

								System.out.println("\n========== Fazer Reserva ==========");
								System.out.println("Digite o id do cliente: ");
								int idCliente = sc.nextInt();

								sc.nextLine();

								Cliente clienteSelec = null;
								for (Cliente id : listaClientes) {
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

								reserva = new Reservas(dataReserva, horaReserva, clienteSelec.getNome(),
										clienteSelec.getTelefone(), mesaSelec.getNumero());
								reserva.setIdReserva(++ultimoIdReserva);
								listaReservas.add(reserva);
								mesaSelec.reservar();

								break;
							}
							case 3: {
								System.out.println("========== Cancelar Reserva ==========");
								reserva.listarReservas(listaReservas);

								System.out.println("\nInsira o ID da Reserva");
								int canIdReserva = sc.nextInt();
								sc.nextLine();

								for (int i = 0; i < listaReservas.size(); i++) {
									Reservas r = listaReservas.get(i);
									if (r.getIdReserva() == canIdReserva) {
										listaReservas.remove(r);
										System.out.println("Reserva removida com sucesso.");
									}

									for (int j = 0; j < listaReservas.size(); j++) {
										int novoID = listaReservas.get(j).getIdReserva() - 1;
										if (novoID >= 1) {
											listaReservas.get(j).setIdReserva(novoID);
										}
									}
									
									
								}
								
								

								break;
							}
							case 4: {
								System.out.println("========== Modificar Reserva ==========");
								break;
							}
							case 0:
								System.out.println("Voltando...");
								break;
							default:
								System.out.println("Opcao inserida invalida. Tente Novamente.");
							}
						}while(op3!=0);
						break;
					}
					case 2: {
						do {
							System.out.println("========== Clientes ==========");
							System.out.println("1 - Cadastrar Cliente");
							System.out.println("2 - Listar Clientes");
							System.out.println("0 - VOLTAR");
							System.out.println("==============================");

							op4 = sc.nextInt();
							sc.nextLine();

							switch (op4) {
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
								listaClientes.add(cliente);

								break;
							}
							case 2: {
								if (cliente == null) {
									System.out.println("Nenhum Cliente Encontrado");
									break;
								} else {
									System.out.println("========== Lista de Clientes ==========\n");
									cliente.listar(listaClientes);
								}
								break;
							}
							case 0:
								System.out.println("Voltando...");
								break;
							default:
								System.out.println("Opcao inserida invalida. Tente Novamente.");
							}
						}while(op4!=0);
						break;
					}
					case 3:{
						do {
							System.out.println("========== Mesas ==========");
							System.out.println("1 - Listar Mesas");
							System.out.println("0 - VOLTAR");
							System.out.println("===========================");

							op5 = sc.nextInt();
							sc.nextLine();

							switch(op5) {
							case 1:{
								if (mesa == null) {
									System.out.println("Nenhuma Mesa Encontrada");
									break;
								} else {
									mesa.listarMesas();
								}
								break;
							}
							case 0:
								System.out.println("Voltando...");
								break;
							default:
								System.out.println("Opcao inserida invalida. Tente Novamente.");
							}
						}while(op5!=0);
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
			case 2:{
				System.out.println("========== Cozinha ==========");
				break;
			}
			case 3:{
				System.out.println("========== Pedidos ==========");

				break;
			}
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opcao inserida invalida. Tente Novamente.");

			}
		} while(op1!=0);

		sc.close();
	}
}

