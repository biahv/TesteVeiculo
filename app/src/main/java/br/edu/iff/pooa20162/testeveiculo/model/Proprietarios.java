package br.edu.iff.pooa20162.testeveiculo.model;


import com.orm.SugarRecord;

/**
 * Created by aluno on 06/03/17.
 */

public class Proprietarios extends SugarRecord {

    private String nome;
    private String endereco;
    private String telefone;
    private String dataNasc;

    public Proprietarios(String nome, String endereco, String telefone, String dataNasc) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
    }

    public Proprietarios(){

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
}
