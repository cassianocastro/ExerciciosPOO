package petshop;

import java.io.Serializable;

/**
 *
 */
public class Racao implements Serializable
{

    private final String nome;
    private final double peso;

    public Racao(String nome, double peso)
    {
        this.nome = nome;
        this.peso = peso;
    }

    public String getDados()
    {
        return "\nNome: " + this.nome + "\nPeso: " + this.peso;
    }
}
