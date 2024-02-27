package loja;

import javax.swing.*;

/**
 *
 */
public class Loja
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String nome  = JOptionPane.showInputDialog("Nome do produto:");
        String valor = JOptionPane.showInputDialog("Valor:");
        int codigo   = Integer.parseInt(JOptionPane.showInputDialog("Código:"));

        Produto produto = new Produto(codigo, nome, valor);

        int retorno = JOptionPane.showConfirmDialog(
            null,
            "Adicionar à lista de compras?",
            "Opção",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if ( retorno == JOptionPane.YES_OPTION )
        {
            int qtde = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Informe a quantidade do produto:"
            ));

            ItemPedido item = new ItemPedido(produto, qtde);
            Pedido pedido   = new Pedido();

			pedido.add(item);

            JOptionPane.showMessageDialog(
                null,
                "Item adicionado: "            + pedido.getItemPedido() +
                "\nValor Total da compra: R$ " + pedido.getValor_total().toString()
            );
        }
    }
}