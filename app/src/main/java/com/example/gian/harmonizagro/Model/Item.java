package com.example.gian.harmonizagro.Model;

import java.io.Serializable;

public class Item implements Serializable{
    private String codigo;
    private String codigoPai;
    private String descricao;
    private Boolean ehFolha;
    private Long nivel;

    public Item(){
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoPai() {
        return codigoPai;
    }

    public void setCodigoPai(String codigoPai) {
        this.codigoPai = codigoPai;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEhFolha() {
        return ehFolha;
    }

    public void setEhFolha(boolean ehFolha) {
        this.ehFolha = ehFolha;
    }

    public long getNivel() {
        return nivel;
    }

    public void setNivel(long nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return ""+codigo+"\n"+descricao;
    }
}
