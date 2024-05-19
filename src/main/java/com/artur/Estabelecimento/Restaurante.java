package com.artur.Estabelecimento;

public class Restaurante {

    private String nomeRestaurante;
    private String endereco;
    private String telefone;
    private String CNPJ;

    public Restaurante(String nomeRestaurante, String endereco, String telefone, String CNPJ) {
        this.nomeRestaurante = nomeRestaurante;
        this.endereco = endereco;
        this.telefone = telefone;
        this.CNPJ = CNPJ;
    }

    public String getNomeRest() {
        return nomeRestaurante;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setNomeRest(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCNPJ(String cNPJ) {
        CNPJ = cNPJ;
    }

}
