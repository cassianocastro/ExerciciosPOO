package agenda;

import javax.swing.JOptionPane;

/**
 *
 */
public class PrimeiraAgenda
{

    static Agenda agenda = new Agenda();

    public static void main(String[] args)
    {
        int retorno;
        while ( true )
        {
            retorno = JOptionPane.showOptionDialog(
                null,
                "Selecione a opção...",
                "Olá",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]
                {
                    "Add", "Exibir", "Remover", "Sair"
                },
                null
            );
            switch ( retorno )
            {
                case 0:
                    escolher();
                    break;
                case 1:
                    JOptionPane.showMessageDialog(
                        null,
                        agenda.exibir(),
                        "Registros",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    break;
                case 2:
                    String nome = JOptionPane.showInputDialog("Informe o nome da pessoa:");
                    JOptionPane.showMessageDialog(
                        null,
                        ( agenda.remove(nome) ) ? "Registro removido." : "Registro não encontrado.",
                        null, JOptionPane.INFORMATION_MESSAGE
                    );
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private static void escolher()
    {
        String nome, endereco, telefone;
        int retorno;

        while ( true )
        {
            retorno = JOptionPane.showOptionDialog(
                null,
                "Tipo de Pessoa?",
                "Opção",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]
                {
                    "Física", "Jurídica", "Voltar"
                },
                null
            );
            switch ( retorno )
            {
                case 0:
                    nome             = JOptionPane.showInputDialog("Nome:");
                    telefone         = JOptionPane.showInputDialog("Nº de telefone:", "()");
                    endereco         = JOptionPane.showInputDialog("Endereço:");
                    String CPF       = JOptionPane.showInputDialog("CPF:");
                    String data_nasc = JOptionPane.showInputDialog("Data de nascimento:");
                    float altura     = ( Float.parseFloat(JOptionPane.showInputDialog("Altura:")) );

                    agenda.add(new Pessoa_Fisica(nome, endereco, telefone, CPF, data_nasc, altura));
                    break;
                case 1:
                    nome              = JOptionPane.showInputDialog("Nome:");
                    telefone          = JOptionPane.showInputDialog("Nº de telefone:", "()");
                    endereco          = JOptionPane.showInputDialog("Endereço:");
                    String CNPJ       = JOptionPane.showInputDialog("CNPJ:");
                    String data_Found = JOptionPane.showInputDialog("Data de fundação:");

                    agenda.add(new Pessoa_Juridica(nome, endereco, telefone, CNPJ, data_Found));
                    break;
                default:
                    return;
            }
        }
    }
}
