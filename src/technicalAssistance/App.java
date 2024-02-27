package technicalAssistance;

import javax.swing.JOptionPane;

/**
 *
 *
 */
public class App
{

    public void start()
    {
        Maintenance maintenance = new Maintenance();
        Queue queue = new Queue();
        int retorno;

        while ( true )
        {
            retorno = JOptionPane.showOptionDialog(
                null,
                "Você deseja ver...?",
                "Olá",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]
                {
                    "Clientes", "Aparelhos", "Sair"
                },
                null
            );
            switch ( retorno )
            {
                case 0:
                    queue.escolher();
                    break;
                case 1:
                    maintenance.escolher();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}