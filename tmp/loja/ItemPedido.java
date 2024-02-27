package loja;

import java.math.BigDecimal;

/**
 *
 */
public class ItemPedido
{

    private final Produto produto;
    private final int qtde;

    public ItemPedido(Produto produto, int qtde)
    {
        this.produto = produto;
        this.qtde    = qtde;
    }

    public int getQuantidade()
    {
        return this.qtde;
    }

    public BigDecimal getPreco()
    {
        return this.produto.getValor();
    }

    public String getDados()
    {
        return this.produto.getDados();
    }
}
