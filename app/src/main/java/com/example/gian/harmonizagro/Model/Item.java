package com.example.gian.harmonizagro.Model;

public class Item {
    private String codigo;
    private String codPai;
    private String desc;
    private boolean folha;
    private int nivel;

    public Item() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodPai() {
        return codPai;
    }

    public void setCodPai(String codPai) {
        this.codPai = codPai;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isFolha() {
        return folha;
    }

    public void setFolha(boolean folha) {
        this.folha = folha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return codigo;
    }
}
