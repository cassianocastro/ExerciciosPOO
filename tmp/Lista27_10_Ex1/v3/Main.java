package v3;

import v3.classes.Agenda;
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
        char opt = ' ';
        String nome;

        while ( opt != 's' )
        {
            opt = JOptionPane.showInputDialog(
                "Digite:\n'a' - para adicionar uma pessoa\n"
                + "'r' - para remover uma pessoa\n'l' - para listar toda a agenda\n"
                + "'p' - para listar uma pessoa\n's' - para sair"
            ).charAt(0);

            switch ( opt )
            {
                case 's':
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                case 'a':
                    adicionaPessoa(ag);
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

    public static void adicionaPessoa(Agenda ag)
    {
        String nome, data_nasc, CPF, CNPJ, endereco, telefone, data_fund;

        char opt = JOptionPane.showInputDialog(
            "Digite:\n'f' - para pessoa física\n'j' para pessoa jurídica"
        ).charAt(0);

        switch ( opt )
        {
            case 'f':
                nome         = JOptionPane.showInputDialog("Digite o nome da pessoa");
                data_nasc    = JOptionPane.showInputDialog("Digite a data de nascimento da pessoa (dd/mm/aaaa)");
                float altura = Float.parseFloat(JOptionPane.showInputDialog("Digite a altura da pessoa"));
                CPF          = JOptionPane.showInputDialog("Digite o CPF da pessoa");
                endereco     = JOptionPane.showInputDialog("Digite o endereco da pessoa");
                telefone     = JOptionPane.showInputDialog("Digite o telefone da pessoa");

                ag.armazenaPessoaFisica(nome, endereco, telefone, data_nasc, altura, CPF);
                break;
            case 'j':
                nome      = JOptionPane.showInputDialog("Digite o nome da empresa");
                CNPJ      = JOptionPane.showInputDialog("Digite o CNPJ da empresa");
                endereco  = JOptionPane.showInputDialog("Digite o endereco da empresa");
                telefone  = JOptionPane.showInputDialog("Digite o telefone da empresa");
                data_fund = JOptionPane.showInputDialog("Digite a data de fundação da empresa (dd/mm/aaaa)");

                ag.armazenaPessoaJuridica(nome, endereco, telefone, CNPJ, data_fund);
        }
    }
}