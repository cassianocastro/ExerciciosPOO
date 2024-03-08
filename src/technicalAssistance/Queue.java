package technicalAssistance;

import javax.swing.*;

/**
 *
 */
public class Queue
{

    private final CustomersRepository repository;

    public Queue()
    {
        this.repository = new CustomersRepository();
    }

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
                new String[] { "Inserir", "Listar", "Remover", "Alterar", "Voltar" },
                null
            );

            switch ( option )
            {
                case 0:
                    this.addCustomer();
                    break;
                case 1:
                    this.showCustomers();
                    break;
                case 2:
                    this.deleteCustomer();
                    break;
                case 3:
                    this.updateCustomer();
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

        // this.repository.add(new Customer(name, cpf, email, phone, birthdate));

        JOptionPane.showMessageDialog(null, "Cadastro realizado.");
    }

    private void deleteCustomer()
    {
        String cpf = JOptionPane.showInputDialog("Informe o CPF do cliente:");

        if ( ! this.repository.exists(cpf) )
        {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");

            return;
        }

        // this.repository.remover(customer);

        JOptionPane.showMessageDialog(null, "Cliente removido.");
    }

    private void showCustomers()
    {
        JOptionPane.showMessageDialog(
            null,
            this.repository.show(),
            "Clientes",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void updateCustomer()
    {

    }
}