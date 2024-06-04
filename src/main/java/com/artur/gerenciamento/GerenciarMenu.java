package com.artur.gerenciamento;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.artur.controle.ItemCardapio;
import com.artur.controle.Reserva;
import com.artur.estabelecimento.Mesa;
import com.artur.pessoas.Cliente;

//OBS: as funções inserirInt e inserirDouble, são funções que pega a entrada do usuario verifica se é um int ou double e retorna ela, se n for ele pede
//que o usuario insira denovo até acertar (essas funções evitam que o codigo pare se um valor diferente do que é requisitado seja inserido.

		public class GerenciarMenu {

	GerenciarCardapio cardapio = new GerenciarCardapio();
	GerenciarMesas mesa = new GerenciarMesas();
	GerenciarReservas reserva = new GerenciarReservas();
	GerenciarPessoa pessoa = new GerenciarPessoa();
	Cliente cliente = new Cliente("", "", "", "");

	public int inserirInt(Scanner scanner) {
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

	public double inserirDouble(Scanner scanner) {
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

	// Menu da Recepção

	public void menuRecepcao(Scanner sc) {
		boolean recepcao = true;

		do {
			System.out.println("========== RECEPÇÃO ==========");
			System.out.println("1 - Reservas");
			System.out.println("2 - Mesas");
			System.out.println("0 - VOLTAR");
			System.out.println("==============================");

			int opcaoRecepcao = inserirInt(sc);

			if (opcaoRecepcao == 0) {
				recepcao = false;
				System.out.println("Voltando...");
				break;
			}

			switch (opcaoRecepcao) {
			case 1:
				menuReservas(sc);
				break;
			case 2:
				menuMesas(sc);
				break;
			default:
				System.out.println("Opção inserida inválida. Tente novamente.");
			}
		} while (recepcao);
	}

	// Menu de Reservas

	public void menuReservas(Scanner sc) {
		boolean reservas = true;
		int temp = 0;

		do {
			System.out.println("========== RESERVAS ==========");
			System.out.println("1 - Listar Reservas");
			System.out.println("2 - Fazer Reserva");
			System.out.println("3 - Cancelar Reserva");
			System.out.println("4 - Modificar Reserva");
			System.out.println("0 - VOLTAR");
			System.out.println("==============================");

			int opcaoReserva = inserirInt(sc);

			if (opcaoReserva == 0) {
				reservas = false;
				System.out.println("Voltando...");
				break;
			}

			switch (opcaoReserva) {
			case 1:
				if (reserva.getListaReservas().isEmpty()) {
					System.out.println("Nenhuma reserva registrada.");
				} else {
					reserva.listar();
				}
				break;
			case 2:
				// Fazer Reserva

				if (pessoa.getListaClientes().isEmpty()) {
					System.out.println("Nenhum Cliente Encontrado. Deseja cadastrar um Cliente? (1)Sim/(2)Nao");
					int opcaoCliRe = inserirInt(sc);

					if (opcaoCliRe == 1) {
						menuClientes(sc);
						break;
					} else if (opcaoCliRe == 2) {
						break;
					} else {
						System.out.println("Opcao invalida. Voltando para o menu anterior...");
						break;
					}

				}

				System.out.println("========== Clientes e Mesas ==========\n");
				cliente.listar(pessoa.getListaClientes());
				;
				System.out.print("\n");
				mesa.listar();

				System.out.println("\n========== Fazer Reserva ==========");
				System.out.println("Digite o id do cliente ou digite (0) para voltar: ");
				int idCliente = inserirInt(sc);

				if (idCliente == 0) {
					System.out.println("Voltando...");
					break;
				}

				Cliente clienteSelec = null;
				for (Cliente id : pessoa.getListaClientes()) {
					if (id.getId() == idCliente) {
						clienteSelec = id;
					}
				}

				if (clienteSelec == null) {
					System.out.println("ID DE CLIENTE INVALIDO.");
					break;
				}

				System.out.println("Digite o numero da mesa: ");
				int numMesa = inserirInt(sc);
				sc.nextLine();

				Mesa mesaSelec = null;
				for (Mesa mesinha : mesa.getListaMesas()) {
					if (numMesa == mesinha.getId() && !mesinha.isStatusMesa()) {
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

				reserva.adicionarReserva(new Reserva(dataReserva, horaReserva, clienteSelec.getNome(),
						clienteSelec.getTelefone(), mesaSelec.getId()));
				mesaSelec.reservar();

				break;
			case 3:
				if (reserva.getListaReservas().isEmpty()) {
					System.out.println("Nenhuma Reserva Registrada");
					break;
				}

				System.out.println("========== Cancelar Reserva ==========");
				reserva.listar();

				System.out.println("\nInsira o ID da reserva ou digite (0) para voltar: ");
				int canIdReserva = inserirInt(sc);

				if (canIdReserva == 0) {
					System.out.println("Voltando...");
					break;
				}

				reserva.cancelarReserva(canIdReserva, mesa.getListaMesas());
				break;
			case 4:
				temp = 0;

				if (reserva.getListaReservas().isEmpty()) {
					System.out.println("Nenhuma Reserva Registrada");
					break;
				}

				System.out.println("========== Modificar Reseva ==========");
				reserva.listar();

				System.out.println("\nInsira o ID da Reserva ou digite (0) para voltar: ");
				int modIdReserva = inserirInt(sc);

				if (modIdReserva == 0) {
					System.out.println("Voltando...");
					break;
				}

				Reserva novaReserva = null;
				for (Reserva r : reserva.getListaReservas()) {
					if (modIdReserva == r.getId()) {
						temp = temp + 1;
						novaReserva = r;
					}
				}

				if (temp == 0) {
					System.out.println("ID INVALIDO OU NAO ENCONTRADO.");
					break;
				}

				System.out.println("O Que deseja modificar?");
				System.out.println("1 - Mesa\n2 - Nome do Cliente\n3 - Telefone do Cliente\n4 - Data\n5 - Hora");

				int modOpcao = inserirInt(sc);
				sc.nextLine();

				switch (modOpcao) {
				case 1:
					mesa.listar();
					int mesaTemp = 0;

					System.out.print("Insira o numero da nova mesa: ");
					int novaMesa = inserirInt(sc);

					// Liberar a mesa anterior
					Mesa mesaAtual = null;
					for (Mesa mesinha : mesa.getListaMesas()) {
						if (mesinha.getId() == novaReserva.getNumMesa()) {
							mesaTemp = mesinha.getId();
							mesaAtual = mesinha;
							break;
						}
					}

					if (mesaAtual != null) {
						mesaAtual.setStatusMesa(false);
					}

					// Verificar se a nova mesa está disponível
					Mesa mesaNova = null;
					for (Mesa mesinha : mesa.getListaMesas()) {
						if (mesinha.getId() == novaMesa) {
							if (mesinha.isStatusMesa()) {
								System.out.println("A nova mesa está ocupada. Tente novamente.");
								if (mesaAtual != null) {
									mesaAtual.setStatusMesa(true);
								}
								break;
							} else {
								mesaNova = mesinha;
								break;
							}
						}
					}

					if (mesaNova != null) {

						novaReserva.setNumMesa(mesaNova.getId());
						mesaNova.setStatusMesa(true);
						System.out.println("Mesa " + mesaTemp + " alterada com sucesso para mesa " + mesaNova.getId());
					} else {
						mesaAtual.setStatusMesa(true);
						System.out.println("ID da nova mesa inválido ou a mesa está ocupada.");
					}

					break;
				case 2:
					String nomeTemp = novaReserva.getNomeCliente();

					System.out.print("Insira o novo nome do cliente: ");
					String novoNome = sc.nextLine();

					novaReserva.setNomeCliente(novoNome);

					System.out
					.println("Alterando nome do cliente " + nomeTemp + " para " + novaReserva.getNomeCliente());

					break;
				case 3:
					String telefoneTemp = novaReserva.getTelefoneCliente();

					System.out.print("Insira o novo telefone do cliente: ");
					String novoTelefone = sc.nextLine();

					novaReserva.setTelefoneCliente(novoTelefone);

					System.out.println("Alterando telefone do cliente " + telefoneTemp + " para "
							+ novaReserva.getTelefoneCliente());

					break;
				case 4:
					String dataTemp = novaReserva.getDataReserva();

					System.out.print("Insira a nova data: ");
					String novaData = sc.nextLine();

					novaReserva.setDataReserva(novaData);

					System.out.println("Alterando a data " + dataTemp + " para " + novaReserva.getDataReserva());

					break;
				case 5:
					String horaTemp = novaReserva.getHoraReserva();

					System.out.print("Insira a nova hora: ");
					String novaHora = sc.nextLine();

					novaReserva.setHoraReserva(novaHora);

					System.out.println("Alterando a hora " + horaTemp + " para " + novaReserva.getHoraReserva());

					break;
				default:
					System.out.println("Opção inserida inválida. Tente novamente.");
				}
			}
		} while (reservas);
	}

	// Menu de Mesas

	public void menuMesas(Scanner sc) {
		boolean mesas = true;

		do {
			System.out.println("========== MESAS ==========");
			System.out.println("1 - Listar Mesas");
			System.out.println("2 - Adicionar Mesas");
			System.out.println("3 - Remover Mesas");
			System.out.println("0 - VOLTAR");
			System.out.println("===========================");

			int opcaoMesa = inserirInt(sc);

			if (opcaoMesa == 0) {
				mesas = false;
				System.out.println("Voltando...");
				break;
			}

			switch (opcaoMesa) {
			case 1:
				if (mesa.getListaMesas().isEmpty()) {
					System.out.println("Nenhuma Mesa Encontrada");
					break;
				} else {
					mesa.listar();
				}
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.println("Opção inserida inválida. Tente novamente.");
			}
		} while (mesas);
	}

	// Menu de Cadastros

	public void menuCadastros(Scanner sc) {
		boolean cadastros = true;

		do {
			System.out.println("========== Cadastros ==========");
			System.out.println("1 - Clientes");
			System.out.println("2 - Garcom");
			System.out.println("3 - Gerente");
			System.out.println("0 - Voltar");
			System.out.println("===============================");

			int opcaoCadastros = inserirInt(sc);

			if (opcaoCadastros == 0) {
				cadastros = false;
				System.out.println("Voltando...");
				break;
			}

			switch (opcaoCadastros) {
			case 1:
				menuClientes(sc);
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.println("Opção inserida inválida. Tente novamente.");
			}

		} while (cadastros);
	}

	// Menu de Clientes

	public void menuClientes(Scanner sc) {
		boolean clientes = true;
		int temp = 0;

		do {
			System.out.println("========== CLIENTES ==========");
			System.out.println("1 - Cadastrar Cliente");
			System.out.println("2 - Remover Cliente");
			System.out.println("3 - Listar Clientes");
			System.out.println("4 - Modificar Cliente");
			System.out.println("0 - VOLTAR");
			System.out.println("==============================");

			int opcaoCliente = inserirInt(sc);
			sc.nextLine();

			if (opcaoCliente == 0) {
				clientes = false;
				System.out.println("Voltando...");
				break;
			}

			switch (opcaoCliente) {
			case 1:
				System.out.println("========== Cadastrar Cliente ==========");
				System.out.println("Insira o nome do cliente: ");
				String cadNomeCliente = sc.nextLine();
				System.out.println("Insira o Endereco: ");
				String enderecoCliente = sc.nextLine();
				System.out.println("Insira o Telefone");
				String cadTelefoneCliente = sc.nextLine();
				System.out.println("Insira a Data de Nascimento");
				String nascCliente = sc.nextLine();

				pessoa.adicionarCliente(new Cliente(cadNomeCliente, enderecoCliente, cadTelefoneCliente, nascCliente));

				break;
			case 2:
				temp = 0;

				if (pessoa.getListaClientes().isEmpty()) {
					System.out.println("Nenhum Cliente Registrado");
					break;
				}

				System.out.println("========== Cancelar Cliente ==========");
				cliente.listar(pessoa.getListaClientes());

				System.out.println("\nInsira o ID do Cliente ou digite (0) para voltar: ");
				int canIdCliente = inserirInt(sc);

				if (canIdCliente == 0) {
					System.out.println("Voltando...");
					break;
				}

				for (Cliente c : pessoa.getListaClientes()) {
					if (canIdCliente == c.getId()) {
						temp = temp + 1;
					}
				}

				if (temp == 0) {
					System.out.println("ID INVALIDO OU NAO ENCONTRADO.");
					break;
				}

				pessoa.removerCliente(canIdCliente);
				break;
			case 3:
				if (pessoa.getListaClientes().isEmpty()) {
					System.out.println("Nenhum cliente registrado.");
				} else {
					cliente.listar(pessoa.getListaClientes());
				}
				break;
			case 4:
				temp = 0;

				if (pessoa.getListaClientes().isEmpty()) {
					System.out.println("Nenhum Cliente Registrado");
					break;
				}

				System.out.println("========== Modificar Cliente ==========");
				cliente.listar(pessoa.getListaClientes());

				System.out.println("\nInsira o ID do Cliente ou digite (0) para voltar: ");
				int modIdCliente = inserirInt(sc);

				if (modIdCliente == 0) {
					System.out.println("Voltando...");
					break;
				}

				for (Cliente c : pessoa.getListaClientes()) {
					if (modIdCliente == c.getId()) {
						temp = temp + 1;
					}
				}

				if (temp == 0) {
					System.out.println("ID INVALIDO OU NAO ENCONTRADO.");
					break;
				}

				System.out.println("O Que deseja modificar?");
				System.out.println("1 - Nome\n2 - Endereco\n3 - Telefone\n4 - Data de Nascimento");

				int modOpcao = inserirInt(sc);
				sc.nextLine();

				switch (modOpcao) {
				case 1:
					System.out.print("Insira o novo nome: ");
					String novoNome = sc.nextLine();

					for (Cliente c : pessoa.getListaClientes()) {
						if (modIdCliente == c.getId()) {
							String nomeTemp = c.getNome();
							c.setNome(novoNome);
							System.out.println("Nome: " + nomeTemp + " Modificado para: " + c.getNome());
							break;
						}
					}

					break;
				case 2:
					System.out.print("Insira o novo endereco: ");
					String novoEndereco = sc.nextLine();

					for (Cliente c : pessoa.getListaClientes()) {
						if (modIdCliente == c.getId()) {
							String enderecoTemp = c.getEndereco();
							c.setEndereco(novoEndereco);
							System.out.println("Nome: " + enderecoTemp + " Modificado para: " + c.getEndereco());
							break;
						}
					}

					break;
				case 3:
					System.out.print("Insira o novo telefone: ");
					String novoTelefone = sc.nextLine();

					for (Cliente c : pessoa.getListaClientes()) {
						if (modIdCliente == c.getId()) {
							String telefoneTemp = c.getTelefone();
							c.setTelefone(novoTelefone);
							System.out.println("Nome: " + telefoneTemp + " Modificado para: " + c.getTelefone());
							break;
						}
					}

					break;
				case 4:
					System.out.print("Insira a nova data de nascimento: ");
					String novaDataNasc = sc.nextLine();

					for (Cliente c : pessoa.getListaClientes()) {
						if (modIdCliente == c.getId()) {
							String dataNascTemp = c.getDataNasc();
							c.setDataNasc(novaDataNasc);
							System.out.println("Nome: " + dataNascTemp + " Modificado para: " + c.getDataNasc());
							break;
						}
					}

					break;
				default:
					System.out.println("Opção inserida inválida.");
				}
				break;
			default:
				System.out.println("Opção inserida inválida. Tente novamente.");
			}
		} while (clientes);
	}

	// Menu do Garçom

	public void menuGarcom(Scanner sc) {
		boolean garcom = true;

		do {
			System.out.println("========== GARCOM ==========");
			System.out.println("1 - Cadastrar Garcom");
			System.out.println("2 - Remover Garcom");
			System.out.println("3 - Listar Garcons");
			System.out.println("4 - Modificar Garcom");
			System.out.println("0 - VOLTAR");
			System.out.println("==============================");

			int opcaoGarcom = inserirInt(sc);
			sc.nextLine();

			if (opcaoGarcom == 0) {
				garcom = false;
				System.out.println("Voltando...");
			}

			switch (opcaoGarcom) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("Opção inserida inválida. Tente novamente.");
			}

		} while (garcom);
	}

	// Menu do Gerente

	public void menuGerente(Scanner sc) {
		boolean gerente = true;

		do {
			System.out.println("========== GERENTE ==========");
			System.out.println("1 - Cadastrar Gerente");
			System.out.println("2 - Remover Gerente");
			System.out.println("3 - Listar Gerente");
			System.out.println("4 - Modificar Gerente");
			System.out.println("0 - VOLTAR");
			System.out.println("==============================");

			int opcaoGerente = inserirInt(sc);
			sc.nextLine();

			if (opcaoGerente == 0) {
				gerente = false;
				System.out.println("Voltando...");
			}

			switch (opcaoGerente) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("Opção inserida inválida. Tente novamente.");
			}

		} while (gerente);
	}

	// Menu do Cardapio

	public void menuCardapio(Scanner sc) {
		boolean card = true;

		do {
			System.out.println("========== CARDÁPIO ==========");
			System.out.println("1 - Mostrar Cardápio");
			System.out.println("2 - Adicionar Item");
			System.out.println("3 - Remover Item");
			System.out.println("0 - VOLTAR");
			System.out.println("==============================");

			int opcaoCardapio = inserirInt(sc);

			if (opcaoCardapio == 0) {
				card = false;
				System.out.println("Voltando...");
				break;
			}

			switch (opcaoCardapio) {
			case 1:
				if (cardapio.getCardapio().isEmpty()) {
					System.out.println("Cardapio vazio.");
				} else {
					cardapio.listar();
				}
				break;
			case 2:
				System.out.println("\n========== Adicionar Item ==========");
				System.out.println("Escolha a categoria do item.");
				System.out.println("1 - Pratos Principais");
				System.out.println("2 - Acompanhamentos");
				System.out.println("3 - Bebidas");
				System.out.println("4 - Sobremesas");
				System.out.println("5 - Outros");
				System.out.println("0 - VOLTAR");
				System.out.println("====================================");

				int opAdicionarItem = inserirInt(sc);
				sc.nextLine();

				if (opAdicionarItem == 0) {
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

				if (opAdicionarItem == 1) {
					cardapio.adicionarItem("Pratos Principais", new ItemCardapio(nome, tamanho, descricao, preco));
					System.out.println("Item adicionado ao cardapio com sucesso.");
				} else if (opAdicionarItem == 2) {
					cardapio.adicionarItem("Acompanhamentos", new ItemCardapio(nome, tamanho, descricao, preco));
					System.out.println("Item adicionado ao cardapio com sucesso.");
				} else if (opAdicionarItem == 3) {
					cardapio.adicionarItem("Bebidas", new ItemCardapio(nome, tamanho, descricao, preco));
					System.out.println("Item adicionado ao cardapio com sucesso.");
				} else if (opAdicionarItem == 4) {
					cardapio.adicionarItem("Sobremesas", new ItemCardapio(nome, tamanho, descricao, preco));
					System.out.println("Item adicionado ao cardapio com sucesso.");
				} else if (opAdicionarItem == 5) {
					cardapio.adicionarItem("Outros", new ItemCardapio(nome, tamanho, descricao, preco));
					System.out.println("Item adicionado ao cardapio com sucesso.");
				} else {
					System.out.println("Opcao inserida invalida. Tente Novamente.");
				}
				break;
			case 3:
				System.out.println("========== Remover Item ==========");
				System.out.println("Escolha a categoria do item.");
				System.out.println("1 - Pratos Principais");
				System.out.println("2 - Acompanhamentos");
				System.out.println("3 - Bebidas");
				System.out.println("4 - Sobremesas");
				System.out.println("5 - Outros");
				System.out.println("0 - VOLTAR");
				System.out.println("===================================");

				int opRemoverItem = inserirInt(sc);

				if (opRemoverItem == 0) {
					System.out.println("Voltando...");
					break;
				}

				if (opRemoverItem == 1) {
					cardapio.imprimirItensCategoria("Pratos Principais", cardapio.getCardapio());
					System.out.println("\nInsira o ID do Item");
					int canIdItem = inserirInt(sc);
					cardapio.removerItem("Pratos Principais", canIdItem);
				} else if (opRemoverItem == 2) {
					cardapio.imprimirItensCategoria("Acompanhamentos", cardapio.getCardapio());
					System.out.println("\nInsira o ID do Item");
					int canIdItem = inserirInt(sc);
					cardapio.removerItem("Acompanhamentos", canIdItem);
				} else if (opRemoverItem == 3) {
					cardapio.imprimirItensCategoria("Bebidas", cardapio.getCardapio());
					System.out.println("\nInsira o ID do Item");
					int canIdItem = inserirInt(sc);
					cardapio.removerItem("Bebidas", canIdItem);
				} else if (opRemoverItem == 4) {
					cardapio.imprimirItensCategoria("Sobremesas", cardapio.getCardapio());
					System.out.println("\nInsira o ID do Item");
					int canIdItem = inserirInt(sc);
					cardapio.removerItem("Sobremesas", canIdItem);
				} else if (opRemoverItem == 5) {
					cardapio.imprimirItensCategoria("Outros", cardapio.getCardapio());
					System.out.println("\nInsira o ID do Item");
					int canIdItem = inserirInt(sc);
					cardapio.removerItem("Outros", canIdItem);
				} else {
					System.out.println("Opcao inserida invalida. Tente Novamente.");
				}
				break;
			default:
				System.out.println("Opção inserida inválida. Tente novamente.");
			}
		} while (card);
	}

	// Menu de Pedidos

	public void menuPedido(Scanner sc) {
		boolean pedido = true;

		do {
			System.out.println("========== PEDIDO ==========");
			System.out.println("0 - Voltar");
			System.out.println("============================");

			int opcaoPedido = inserirInt(sc);

			if (opcaoPedido == 0) {
				pedido = false;
				System.out.println("Voltando...");
				break;
			}

		} while (pedido);
	}

	// Menu da Cozinha

	public void menuCozinha(Scanner sc) {
		boolean cozinha = true;

		do {
			System.out.println("========== COZINHA ==========");
			System.out.println("0 - VOLTAR");
			System.out.println("=============================");

			int opcaoCozinha = inserirInt(sc);

			if (opcaoCozinha == 0) {
				cozinha = false;
				System.out.println("Voltando...");
				break;
			}
		} while (cozinha);
	}

}