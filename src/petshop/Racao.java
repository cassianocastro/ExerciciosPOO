package petshop;

import java.io.Serializable;

/**
 *
 */
public class Racao implements Serializable
{

    private final String name;
    private final double weight;

    public Racao(String name, double weight)
    {
        this.name   = name;
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "\nName: " + this.name + "\nWeight: " + this.weight;
    }
}