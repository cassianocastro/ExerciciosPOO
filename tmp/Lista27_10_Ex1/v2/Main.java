package v2;

import javax.swing.JOptionPane;

/**
 *
 */
public class Main
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Agenda ag = new Agenda();
        String nome, data_nasc;
        float altura; char opt = ' ';

        while ( opt != 's' )
        {
            opt = JOptionPane.showInputDialog(
                "Digite:"
                + "\n'a' - para adicionar uma pessoa\n"
                + "'r' - para remover uma pessoa\n'l' - para listar toda a agenda\n"
                + "'p' - para listar uma pessoa\n's' - para sair"
            ).charAt(0);
            switch ( opt )
            {
                case 's':
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                case 'a':
                    nome      = JOptionPane.showInputDialog("Digite o nome da pessoa");
                    data_nasc = JOptionPane.showInputDialog("Digite a data de nascimento da pessoa (dd/mm/aaaa)");
                    altura    = Float.parseFloat(JOptionPane.showInputDialog("Digite a altura da pessoa"));

                    ag.armazenaPessoa(nome, data_nasc, altura);
                    break;
                case 'r':
                    nome = JOptionPane.showInputDialog("Digite o nome da pessoa");
                    ag.removePessoa(nome);
                    break;
                case 'l':
                    ag.imprimeAgenda();
                    break;
                case 'p':
                    int index = Integer.parseInt(JOptionPane.showInputDialog("Digite o index da pessoa"));
                    ag.imprimePessoa(index);
            }

        }
    }

}
