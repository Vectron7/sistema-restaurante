package com.artur.interfaces;

import com.artur.pessoas.Cliente;
import com.artur.pessoas.Garcom;
import com.artur.pessoas.Gerente;

public interface Pessoa {

    void adicionarCliente(Cliente cliente);

    void adicionarGarcom(Garcom garcom);

    void adicionarGerente(Gerente gerente);

    void removerCliente(int IdCliente);

    void removerGarcom(int IdCarcom);

    void removerGerente(int IdGerente);
    
    void listarCliente();

    void listarGarcom();

    void listarGerente();

}