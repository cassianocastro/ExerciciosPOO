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

    public void escolher()
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
                    inserir();
                    break;
                case 1:
                    listar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    alterar();
                    break;
                default:
                    return;
            }
        }
    }

    private void inserir()
    {
        String name      = JOptionPane.showInputDialog("Nome do cliente:");
        String cpf       = JOptionPane.showInputDialog("CPF:");
        String birthdate = JOptionPane.showInputDialog("Data de Nascimento:");
        String email     = JOptionPane.showInputDialog("E-mail:");
        String phone     = JOptionPane.showInputDialog("Telefone:");

        // this.repository.add(new Customer(name, cpf, email, phone, birthdate));

        JOptionPane.showMessageDialog(null, "Cadastro realizado.");
    }

    private void remover()
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

    private void listar()
    {
        JOptionPane.showMessageDialog(
            null,
            this.repository.show(),
            "Clientes",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void alterar()
    {

    }

    private void salvar()
    {

    }

    private void abrir()
    {

    }
}