package technicalAssistance;

import javax.swing.JOptionPane;

/**
 *
 */
public class App
{

    public void start()
    {
        int option;

        while ( true )
        {
            option = JOptionPane.showOptionDialog(
                null,
                "Você deseja ver...?",
                "Olá",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[] { "Clientes", "Aparelhos", "Sair" },
                null
            );

            switch ( option )
            {
                case 0:
                    new Queue().showIndexMenu();
                    break;
                case 1:
                    new Maintenance().showIndexMenu();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}