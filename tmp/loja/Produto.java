package loja;

import java.math.BigDecimal;

/**
 *
 */
public class Produto
{

    private final int codigo;
    private final String nome;
    private final BigDecimal valor;

    public Produto(int codigo, String nome, String valor)
    {
        this.codigo = codigo;
        this.nome   = nome;
        this.valor  = new BigDecimal(valor);
    }

    public BigDecimal getValor()
    {
        return this.valor;
    }

    public String getDados()
    {
        return "\nCódigo: " + this.codigo
            + "\nNome: " + this.nome
            + "\nPreço: " + this.valor.toString();
    }
}
