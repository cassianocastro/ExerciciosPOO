package petshop;

import java.io.Serializable;

public class Racao implements Serializable{
    private String nome;
    private double peso;

    public Racao(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getDados() {
        return  "\nNome: " + this.nome +
                "\nPeso: " + this.peso;
    }
}