// Faltam fazer: Pedidos, Cozinha, Caixa, "Garçom?" (Colocar mais coisas que faltam ou dar/adicionar mais sugestões)
// Tem que Usar Herança (ja usado), Polimorfismo (Ja usado), abstração (Ja Usado), interface (falta)

// Criar logica para quantidade de items do cardapio que vai ser pedido (algo como quantidade * preço) e criar uma lista separada
// para os itens que foram pedidos/comprados (como uma comanda) com o preço total.
// Fazer a parte de modificar uma reserva
// Criar comentarios explicando cada parte do codigo

// OBS: as funções inserirInt e inserirDouble, são funções que pega a entrada do usuario verifica se é um int ou double e retorna ela, se n for ele pede
// que o usuario insira denovo até acertar (essas funções evitam que o codigo pare se um valor diferente do que é requisitado seja inserido.

package com.artur.Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.artur.Pessoas.Cliente;
import com.artur.Estabelecimento.Mesa;


public class Main {
	
	public static int inserirInt(Scanner scanner) {
        int num = 0;
        boolean valido = false;

        while (!valido) {
            try {
                num = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Por favor, digite um numero valido");
                scanner.next();
            }
        }

        return num;
    }
	
	public static double inserirDouble(Scanner scanner) {
        double num = 0;
        boolean valido = false;

        while (!valido) {
            try {
                num = scanner.nextDouble();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Por favor, digite um numero valido");
                scanner.next();
            }
        }

        return num;
    }
	
	public static void main(String[] args) {

		int op1, op2, op3, op4, op5, op6, op7, op8, op9, op10;
		int ultimoIdCliente = 0;
		int ultimoIdReserva = 0;
		
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		ArrayList<Reservas> listaReservas = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		GerenciarMesas mesa = new GerenciarMesas();
		Cardapio cardapio = new Cardapio();
		Cliente cliente = null;
		Reservas reserva = null;

		do {
			System.out.println("========== RESTAURANTE ==========");
			System.out.println("1 - Recepcao");
			System.out.println("2 - Cozinha");
			System.out.println("3 - Cardapio");
			System.out.println("4 - Pedido");
			System.out.println("0 - SAIR");
			System.out.println("==========================");

			op1 = inserirInt(sc);

			switch (op1) {

			case 1: {
				do {
					System.out.println("========== RECEPCAO ==========");
					System.out.println("1 - Reservas");
					System.out.println("2 - Clientes");
					System.out.println("3 - Mesas");
					System.out.println("0 - VOLTAR");
					System.out.println("==============================");

					op2 = inserirInt(sc);

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

							op3 = inserirInt(sc);

							switch (op3) {
							case 1: {
								if (reserva == null || listaReservas.isEmpty()) {
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
								int idCliente = inserirInt(sc);

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
								int numMesa = inserirInt(sc);

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
								if (reserva == null || listaReservas.isEmpty()) {
									System.out.println("Nenhuma Reserva Registrada");
									break;
								}
								
								System.out.println("========== Cancelar Reserva ==========");
								reserva.listarReservas(listaReservas);

								System.out.println("\nInsira o ID da Reserva");
								int canIdReserva = inserirInt(sc);

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
								if (reserva == null || listaReservas.isEmpty()) {
									System.out.println("Nenhuma Reserva Registrada");
									break;
								}
								
								System.out.println("========== Modificar Reserva ==========");
								break;
							}
							case 0:
								System.out.println("Voltando...");
								break;
							default:
								System.out.println("Opcao inserida invalida. Tente Novamente.");
							}
						} while (op3 != 0);
						break;
					}
					case 2: {
						do {
							System.out.println("========== Clientes ==========");
							System.out.println("1 - Cadastrar Cliente");
							System.out.println("2 - Listar Clientes");
							System.out.println("0 - VOLTAR");
							System.out.println("==============================");

							op4 = inserirInt(sc);
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
						} while (op4 != 0);
						break;
					}
					case 3: {
						do {
							System.out.println("========== Mesas ==========");
							System.out.println("1 - Listar Mesas");
							System.out.println("0 - VOLTAR");
							System.out.println("===========================");

							op5 = inserirInt(sc);

							switch (op5) {
							case 1: {
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
						} while (op5 != 0);
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
			case 2: {
				System.out.println("========== Cozinha ==========");

				op6 = inserirInt(sc);
				
				switch(op6) {
				
				}
				break;
			}
			case 3: {
				do {
					System.out.println("========== Cardapio ==========");
					System.out.println("1 - Mostrar Cardapio");
					System.out.println("2 - Adicionar Item");
					System.out.println("3 - Remover Item");
					System.out.println("0 - VOLTAR");
					System.out.println("==============================");
					
					op7 = inserirInt(sc);
					
					switch (op7) {
					case 1: {
						cardapio.imprimirCardapio();
						break;
					}
					case 2: {
							System.out.println("\n========== Adicionar Item ==========");
							System.out.println("Escolha a categoria do item.");
							System.out.println("1 - Pratos Principais");
							System.out.println("2 - Acompanhamentos");
							System.out.println("3 - Bebidas");
							System.out.println("4 - Sobremesas");
							System.out.println("5 - Outros");
							System.out.println("0 - VOLTAR");
							System.out.println("====================================");
							
							op8 = inserirInt(sc);
							sc.nextLine();
							
							if(op8 == 0) {
								System.out.println("Voltando...");
								break;
							}
							
							System.out.println("Insira um nome para o item.");
							String nome = sc.nextLine();
							System.out.println("Insira um tamanho para o item");
							String tamanho = sc.nextLine();
							System.out.println("Insira uma descricao para o item");
							String descricao = sc.nextLine();
							System.out.println("Insira um preco para o item");
							double preco = inserirDouble(sc);
							
							if(op8 == 1) {
								cardapio.adicionarItem("Pratos Principais", new ItemCardapio(nome, tamanho, descricao, preco));
								System.out.println("Item adicionado ao cardapio com sucesso.");
							} else if(op8 == 2) {
								cardapio.adicionarItem("Acompanhamentos", new ItemCardapio(nome, tamanho, descricao, preco));
								System.out.println("Item adicionado ao cardapio com sucesso.");
							} else if(op8 == 3) {
								cardapio.adicionarItem("Bebidas", new ItemCardapio(nome, tamanho, descricao, preco));
								System.out.println("Item adicionado ao cardapio com sucesso.");
							} else if(op8 == 4) {
								cardapio.adicionarItem("Sobremesas", new ItemCardapio(nome, tamanho, descricao, preco));
								System.out.println("Item adicionado ao cardapio com sucesso.");
							} else if(op8 == 5) {
								cardapio.adicionarItem("Outros", new ItemCardapio(nome, tamanho, descricao, preco));
								System.out.println("Item adicionado ao cardapio com sucesso.");
							} else {
								System.out.println("Opcao inserida invalida. Tente Novamente.");
							}
						break;
					}
					case 3: {
						System.out.println("========== Remover Item ==========");
						System.out.println("Escolha a categoria do item.");
						System.out.println("1 - Pratos Principais");
						System.out.println("2 - Acompanhamentos");
						System.out.println("3 - Bebidas");
						System.out.println("4 - Sobremesas");
						System.out.println("5 - Outros");
						System.out.println("0 - VOLTAR");
						System.out.println("===================================");

						op9 = inserirInt(sc);
						
						if(op9 == 0) {
							System.out.println("Voltando...");
							break;
						}
						
						if(op9 == 1) {
							cardapio.imprimirItensCategoria("Pratos Principais", cardapio.getCategorias());
							System.out.println("\nInsira o ID do Item");
			                int canIdItem = inserirInt(sc);
				            cardapio.removerItem("Pratos Principais", canIdItem);
						} else if(op9 == 2) {
							cardapio.imprimirItensCategoria("Acompanhamentos", cardapio.getCategorias());
							System.out.println("\nInsira o ID do Item");
			                int canIdItem = inserirInt(sc);
				            cardapio.removerItem("Acompanhamentos", canIdItem);
						} else if(op9 == 3) {
							cardapio.imprimirItensCategoria("Bebidas", cardapio.getCategorias());
							System.out.println("\nInsira o ID do Item");
			                int canIdItem = inserirInt(sc);
				            cardapio.removerItem("Bebidas", canIdItem);
						} else if(op9 == 4) {
							cardapio.imprimirItensCategoria("Sobremesas", cardapio.getCategorias());
							System.out.println("\nInsira o ID do Item");
			                int canIdItem = inserirInt(sc);
				            cardapio.removerItem("Sobremesas", canIdItem);
						} else if(op9 == 5) {
							cardapio.imprimirItensCategoria("Outros", cardapio.getCategorias());
							System.out.println("\nInsira o ID do Item");
			                int canIdItem = inserirInt(sc);
				            cardapio.removerItem("Outros", canIdItem);
						} else {
							System.out.println("Opcao inserida invalida. Tente Novamente.");
						}

						break;
					}
					case 0:
						System.out.println("Voltando...");
						break;
					default:
						System.out.println("Opcao inserida invalida. Tente Novamente.");
					}
				} while (op7 != 0);
				break;
			}
			case 4: {
				do {
					System.out.println("========== Pedidos ==========");
					System.out.println("1 - Pedidos Realizados");
					System.out.println("2 - Fazer Pedido");
					System.out.println("3 - Cancelar Pedido");
					System.out.println("0 - VOLTAR");
					System.out.println("=============================");
					
					op10 = inserirInt(sc);
					
					switch (op10) {
					case 1: {
						break;
					}
					case 2: {
						break;
					}
					case 3: {
						break;
					}
					case 0:
						System.out.println("Voltando...");
						break;
					default:
						System.out.println("Opcao inserida invalida. Tente Novamente.");
					}
				} while (op10 != 0);
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
