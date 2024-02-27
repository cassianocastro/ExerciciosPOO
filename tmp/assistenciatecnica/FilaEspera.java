package assistenciatecnica;

import javax.swing.*;

/**
 *
 */
public class FilaEspera implements NewInterface
{

    private final RepositorioClientes fila;

    public FilaEspera()
    {
        this.fila = new RepositorioClientes();
    }

    @Override
    public void escolher()
    {
        int retorno;

        while ( true )
        {
            retorno = JOptionPane.showOptionDialog(
                null,
                "Selecione uma opção:",
                "Opções",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]
                {
                    "Inserir", "Listar", "Remover", "Alterar", "Voltar"
                },
                null
            );

            switch ( retorno )
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

    @Override
    public void inserir()
    {
        String nome     = JOptionPane.showInputDialog("Nome do cliente:");
        String cpf      = JOptionPane.showInputDialog("CPF:");
        String dataNasc = JOptionPane.showInputDialog("Data de Nascimento:");
        String email    = JOptionPane.showInputDialog("E-mail:");
        String telefone = JOptionPane.showInputDialog("Telefone:");

        // Cliente cliente = new Cliente(nome, cpf, email, telefone, dataNasc);
        // this.fila.add(cliente);
        JOptionPane.showMessageDialog(null, "Cadastro realizado.");
    }

    @Override
    public void remover()
    {
        String CPF = JOptionPane.showInputDialog("Informe o CPF do cliente:");

        if ( ! this.fila.existe(CPF) )
        {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");

            return;
        }

        // this.fila.remover(cliente);

        JOptionPane.showMessageDialog(null, "Cliente removido.");
    }

    @Override
    public void listar()
    {
        JOptionPane.showMessageDialog(
            null,
            this.fila.exibir(),
            "Clientes",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public void alterar()
    {

    }

    @Override
    public void salvar()
    {

    }

    @Override
    public void abrir()
    {

    }
}