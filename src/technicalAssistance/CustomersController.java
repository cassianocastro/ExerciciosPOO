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
                "Selecione uma opção:",
                "Opções",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[] { "Inserir", "Alterar", "Remover", "Listar", "Voltar" },
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
        String name      = JOptionPane.showInputDialog("Nome do cliente:");
        String cpf       = JOptionPane.showInputDialog("CPF:");
        String birthdate = JOptionPane.showInputDialog("Data de Nascimento:");
        String email     = JOptionPane.showInputDialog("E-mail:");
        String phone     = JOptionPane.showInputDialog("Telefone:");

        // new CustomersRepository().add(new Customer(name, cpf, email, phone, birthdate));

        JOptionPane.showMessageDialog(null, "Cadastro realizado.");
    }
    
    private void updateCustomer()
    {

    }

    private void deleteCustomer()
    {
        String cpf = JOptionPane.showInputDialog("Informe o CPF do cliente:");

        if ( ! new CustomersRepository().exists(cpf) )
        {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");

            return;
        }

        // new CustomersRepository().remover(customer);

        JOptionPane.showMessageDialog(null, "Cliente removido.");
    }

    private void showCustomers()
    {
        String msg = new CustomersRepository().show();
        
        JOptionPane.showMessageDialog(null, msg, "Clientes", JOptionPane.INFORMATION_MESSAGE);
    }
}