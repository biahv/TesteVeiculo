package br.edu.iff.pooa20162.testeveiculo.model;

import com.orm.SugarRecord;

/**
 * Created by bia on 18/03/17.
 */

public class Veiculos extends SugarRecord {

    private String placa;
    private String modelo;
    private String ano;


    public Veiculos(String placa, String modelo, String ano) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;

    }

    public Veiculos(){

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
