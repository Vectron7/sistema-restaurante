// Faltam fazer: Pedidos, Cozinha, Caixa, "Garçom?", Cardapio (Colocar mais coisas que faltam ou dar/adicionar mais sugestões)
// Tem que Usar Herança (ja usado), Polimorfismo (falta), abstração (Ja Usado), interface (falta)

// Fazer um menu para o cardapio dentro do menu pedidos (Cardapio ja esta pronto e com uma função para imprimi-lo).
// Colocar IDs em cada item do cardapio para a seleção do item (Verificar os IDs das outras classes para ver como foi implementado).
// Criar logica para quantidade de items do cardapio que vai ser pedido (algo como quantidade * preço) e criar uma lista separada
// para os itens que foram pedidos/comprados (como uma comanda) com o preço total.

package com.artur.Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import com.artur.Pessoas.Cliente;
import com.artur.Estabelecimento.Mesa;


public class Main {

	public static void imprimirArray(ArrayList<?> lista) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.00", symbols);

		for (Object item : lista) {
			if (item instanceof ItemCardapio) {
				ItemCardapio itemCardapio = (ItemCardapio) item;
				System.out.println("ID: " + itemCardapio.getIdItem() + " | " + itemCardapio.getNome() + ": " + itemCardapio.getDescricao());
				System.out.println("Tamanho: " + itemCardapio.getTamanho());
				System.out.println("Preço: R$ " + df.format(itemCardapio.getPreco()) + "\n");
			} else {
				System.out.println(item.toString()); // Se não for um ItemCardapio, apenas imprime o objeto
			}
		}
	}

	public static void main(String[] args) {

		int op1, op2, op3, op4, op5, op6, op7, op8, op9, op10;
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
						} while (op4 != 0);
						break;
					}
					case 3: {
						do {
							System.out.println("========== Mesas ==========");
							System.out.println("1 - Listar Mesas");
							System.out.println("0 - VOLTAR");
							System.out.println("===========================");

							op5 = sc.nextInt();
							sc.nextLine();

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

				op6 = sc.nextInt();
				sc.nextLine();
				
				switch(op6) {
				
				}
				break;
			}
			case 3: {
				do {
					System.out.println("========== Pedidos ==========");
					System.out.println("1 - Cardapio");
					System.out.println("2 - Fazer Pedido");
					System.out.println("3 - Pedidos Realizados");
					System.out.println("0 - VOLTAR");
					System.out.println("=============================");
					op7 = sc.nextInt();
					sc.nextLine();
					switch (op7) {
					case 1: {
						do {
							System.out.println("========== Cardapio ==========");
							System.out.println("1 - Mostrar Cardapio");
							System.out.println("2 - Adicionar Item");
							System.out.println("3 - Remover Item");
							System.out.println("0 - VOLTAR");
							System.out.println("==============================");
							op8 = sc.nextInt();
							sc.nextLine();
							switch (op8) {
							case 1: {
								cardapio.imprimirCardapio();
								break;
							}
							case 2: {
								do {
									System.out.println("========== Adicionar Item ==========\n");
									System.out.println("Escolha a categoria do item.");
									System.out.println("1 - Pratos Principais");
									System.out.println("2 - Acompanhamentos");
									System.out.println("3 - Bebidas");
									System.out.println("4 - Sobremesas");
									System.out.println("5 - Outros");
									System.out.println("0 - VOLTAR");
									System.out.println("====================================");
									op9 = sc.nextInt();
									sc.nextLine();
									switch (op9) {
									case 1: {
										System.out.println("Prato Principal\n");
										System.out.println("Insira um nome para o item.");
										String nomePP = sc.nextLine();
										System.out.println("Insira um tamanho para o item");
										String tamanhoPP = sc.nextLine();
										System.out.println("Insira uma descricao para o item");
										String descricaoPP = sc.nextLine();
										System.out.println("Insira um preco para o item");
										double precoPP = sc.nextDouble();

										cardapio.adicionarItemPP(
												new ItemCardapio(nomePP, tamanhoPP, descricaoPP, precoPP));

										break;
									}
									case 2: {
										System.out.println("Acompanhamento\n");
										System.out.println("Insira um nome para o item.");
										String nomeA = sc.nextLine();
										System.out.println("Insira um tamanho para o item");
										String tamanhoA = sc.nextLine();
										System.out.println("Insira uma descricao para o item");
										String descricaoA = sc.nextLine();
										System.out.println("Insira um preco para o item");
										double precoA = sc.nextDouble();

										cardapio.adicionarItemA(new ItemCardapio(nomeA, tamanhoA, descricaoA, precoA));
										break;
									}
									case 3: {
										System.out.println("Bebida\n");
										System.out.println("Insira um nome para o item.");
										String nomeB = sc.nextLine();
										System.out.println("Insira um tamanho para o item");
										String tamanhoB = sc.nextLine();
										System.out.println("Insira uma descricao para o item");
										String descricaoB = sc.nextLine();
										System.out.println("Insira um preco para o item");
										double precoB = sc.nextDouble();

										cardapio.adicionarItemB(new ItemCardapio(nomeB, tamanhoB, descricaoB, precoB));
										break;
									}
									case 4: {
										System.out.println("Sobremesa\n");
										System.out.println("Insira um nome para o item.");
										String nomeS = sc.nextLine();
										System.out.println("Insira um tamanho para o item");
										String tamanhoS = sc.nextLine();
										System.out.println("Insira uma descricao para o item");
										String descricaoS = sc.nextLine();
										System.out.println("Insira um preco para o item");
										double precoS = sc.nextDouble();

										cardapio.adicionarItemS(new ItemCardapio(nomeS, tamanhoS, descricaoS, precoS));
										break;
									}
									case 5: {
										System.out.println("Sobremesa\n");
										System.out.println("Insira um nome para o item.");
										String nomeO = sc.nextLine();
										System.out.println("Insira um tamanho para o item");
										String tamanhoO = sc.nextLine();
										System.out.println("Insira uma descricao para o item");
										String descricaoO = sc.nextLine();
										System.out.println("Insira um preco para o item");
										double precoO = sc.nextDouble();

										cardapio.adicionarItemO(new ItemCardapio(nomeO, tamanhoO, descricaoO, precoO));
										break;
									}
									case 0:
										System.out.println("Voltando...");
										break;
									default:
										System.out.println("Opcao inserida invalida. Tente Novamente.");
									}
									break;
								} while (op9!=0);
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

								op10 = sc.nextInt();
								sc.nextLine();

								switch (op10) {
								case 1: {
						            System.out.println("Pratos Principais\n");
						            if(cardapio.getItensPP() != null) {
						                imprimirArray(cardapio.getItensPP());
						            } else {
						                System.out.println("Lista Vazia");
						                break;
						            }

						            System.out.println("\nInsira o ID do Item");
						            int canIdItemPP = sc.nextInt();
						            sc.nextLine();

						            ItemCardapio itemRemovido = null;
						            for (ItemCardapio item : cardapio.getItensPP()) {
						                if (item.getIdItem() == canIdItemPP) {
						                    itemRemovido = item;
						                    break;
						                }
						            }

						            if (itemRemovido != null) {
						                cardapio.getItensPP().remove(itemRemovido);
						                System.out.println("Item removido com sucesso.");

						                for (int i = 0; i < cardapio.getItensPP().size(); i++) {
						                    cardapio.getItensPP().get(i).setIdItem(i + 1);
						                }
						            } else {
						                System.out.println("ID do Item não encontrado.");
						            }

						            break;
						        }
								case 2: {
									System.out.println("Acompanhamentos\n");
									if(cardapio.getItensA() != null) {
										imprimirArray(cardapio.getItensA());
									} else {
										System.out.println("Lista Vazia");
										break;
									}
									
									System.out.println("\nInsira o ID do Item");
									int canIdItemA = sc.nextInt();
									sc.nextLine();

									ItemCardapio itemRemovido = null;
						            for (ItemCardapio item : cardapio.getItensA()) {
						                if (item.getIdItem() == canIdItemA) {
						                    itemRemovido = item;
						                    break;
						                }
						            }

						            if (itemRemovido != null) {
						                cardapio.getItensA().remove(itemRemovido);
						                System.out.println("Item removido com sucesso.");

						                for (int i = 0; i < cardapio.getItensA().size(); i++) {
						                    cardapio.getItensA().get(i).setIdItem(i + 1);
						                }
						            } else {
						                System.out.println("ID do Item não encontrado.");
						            }
									
									break;
								}
								case 3: {
									System.out.println("Bebidas\n");
									if(cardapio.getItensB() != null) {
										imprimirArray(cardapio.getItensB());
									} else {
										System.out.println("Lista Vazia");
										break;
									}
									
									System.out.println("\nInsira o ID do Item");
									int canIdItemB = sc.nextInt();
									sc.nextLine();

									ItemCardapio itemRemovido = null;
						            for (ItemCardapio item : cardapio.getItensB()) {
						                if (item.getIdItem() == canIdItemB) {
						                    itemRemovido = item;
						                    break;
						                }
						            }

						            if (itemRemovido != null) {
						                cardapio.getItensB().remove(itemRemovido);
						                System.out.println("Item removido com sucesso.");

						                for (int i = 0; i < cardapio.getItensB().size(); i++) {
						                    cardapio.getItensB().get(i).setIdItem(i + 1);
						                }
						            } else {
						                System.out.println("ID do Item não encontrado.");
						            }
									
									break;
								}
								case 4: {
									System.out.println("Sobremesas\n");
									if(cardapio.getItensS() != null) {
										imprimirArray(cardapio.getItensS());
									} else {
										System.out.println("Lista Vazia");
										break;
									}
									System.out.println("\nInsira o ID do Item");
									int canIdItemS = sc.nextInt();
									sc.nextLine();

									ItemCardapio itemRemovido = null;
						            for (ItemCardapio item : cardapio.getItensS()) {
						                if (item.getIdItem() == canIdItemS) {
						                    itemRemovido = item;
						                    break;
						                }
						            }

						            if (itemRemovido != null) {
						                cardapio.getItensS().remove(itemRemovido);
						                System.out.println("Item removido com sucesso.");

						                for (int i = 0; i < cardapio.getItensS().size(); i++) {
						                    cardapio.getItensS().get(i).setIdItem(i + 1);
						                }
						            } else {
						                System.out.println("ID do Item não encontrado.");
						            }
						            
									break;
								}
								case 5: {
									System.out.println("Outros\n");
									if(cardapio.getItensO() != null) {
										imprimirArray(cardapio.getItensO());
									} else {
										System.out.println("Lista Vazia");
										break;
									}
									System.out.println("\nInsira o ID do Item");
									int canIdItemO = sc.nextInt();
									sc.nextLine();

									ItemCardapio itemRemovido = null;
						            for (ItemCardapio item : cardapio.getItensO()) {
						                if (item.getIdItem() == canIdItemO) {
						                    itemRemovido = item;
						                    break;
						                }
						            }

						            if (itemRemovido != null) {
						                cardapio.getItensO().remove(itemRemovido);
						                System.out.println("Item removido com sucesso.");

						                for (int i = 0; i < cardapio.getItensO().size(); i++) {
						                    cardapio.getItensO().get(i).setIdItem(i + 1);
						                }
						            } else {
						                System.out.println("ID do Item não encontrado.");
						            }
						            
									break;
								}
								case 0:
									System.out.println("Voltando...");
									break;
								default:
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
						} while (op8 != 0);
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
				} while (op7 != 0);
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
