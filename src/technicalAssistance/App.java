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
                "Choose an option",
                "Hello",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[] { "Customers", "Devices", "Exit" },
                null
            );

            switch ( option )
            {
                case 0:
                    new CustomersController().showIndexMenu();
                    break;
                case 1:
                    new DevicesController().showIndexMenu();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}