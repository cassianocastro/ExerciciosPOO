package technicalAssistance;

import javax.swing.*;

/**
 *
 */
public class CustomersController
{

    public void showIndexMenu()
    {
        int option;

        while ( true )
        {
            option = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[] { "Add", "Update", "Delete", "Show", "Back" },
                null
            );

            switch ( option )
            {
                case 0:
                    this.addCustomer();
                    break;
                case 1:
                    this.updateCustomer();
                    break;
                case 2:
                    this.deleteCustomer();
                    break;
                case 3:
                    this.showCustomers();
                    break;
                default:
                    return;
            }
        }
    }

    private void addCustomer()
    {
        String name      = JOptionPane.showInputDialog("Name:");
        String cpf       = JOptionPane.showInputDialog("CPF:");
        String birthdate = JOptionPane.showInputDialog("Birthdate:");
        String email     = JOptionPane.showInputDialog("E-mail:");
        String phone     = JOptionPane.showInputDialog("Phone:");

        // new CustomersRepository().add(new Customer(name, cpf, email, phone, birthdate));

        JOptionPane.showMessageDialog(null, "Customer registered.");
    }
    
    private void updateCustomer()
    {

    }

    private void deleteCustomer()
    {
        String cpf = JOptionPane.showInputDialog("Customer\'s CPF:");

        if ( ! new CustomersRepository().exists(cpf) )
        {
            JOptionPane.showMessageDialog(null, "Customer not found.");

            return;
        }

        // new CustomersRepository().remove(customer);

        JOptionPane.showMessageDialog(null, "Customer removed.");
    }

    private void showCustomers()
    {
        String msg = new CustomersRepository().toString();
        
        JOptionPane.showMessageDialog(null, msg, "Customers", JOptionPane.INFORMATION_MESSAGE);
    }
}