package loja;
import java.math.BigDecimal;
import java.util.*;

public class Pedido {
    private BigDecimal valor_total;
    private List<ItemPedido> carrinho;

    public Pedido() {
        this.carrinho    = new ArrayList<>();
        this.valor_total = new BigDecimal("0");
    }
    //------------
    public void add(ItemPedido item) {
        this.carrinho.add(item);
    }
    public BigDecimal getValor_total() {
        for (ItemPedido itemPedido : this.carrinho) {
            this.valor_total
                    = this.valor_total
                            .add(itemPedido.getPreco()
                                    .multiply( new BigDecimal(itemPedido.getQuantidade() )));
        }
        return this.valor_total;
    }
    public StringBuilder getItemPedido() {
        StringBuilder msg = new StringBuilder();
        for (ItemPedido itemPedido : this.carrinho) {
            msg.append(itemPedido.getDados());
        }
        return msg;
    }
}