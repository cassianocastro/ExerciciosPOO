package bank;

import javax.swing.JOptionPane;

/**
 *
 */
public class BankTest
{

    static private final Bank bank = new Bank();

    /**
     * @test
     */
    private void canAddAccount()
    {
        int num_conta   = Integer.parseInt(JOptionPane.showInputDialog("Nº da conta:"));
        int num_agencia = Integer.parseInt(JOptionPane.showInputDialog("Nº da agência:"));
        String senha    = JOptionPane.showInputDialog("Senha:");
        String saldo    = JOptionPane.showInputDialog("Saldo inicial:");

        int option = JOptionPane.showOptionDialog(
            null,
            "Escolha uma opção:",
            "Tipo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] { "Poupança", "Salário", "Corrente Jurídica", "Corrente Física" },
            null
        );

        Account account;
        
        switch ( option )
        {
            case 0:
                account = new SavingsAccount(num_conta, num_agencia, senha, saldo, "0.09");
                break;
            case 1:
                account = new SalaryAccount(num_conta, num_agencia, senha, saldo, "0.0");
                break;
            case 2:
                account = new CurrentJuridicalPerson(num_conta, num_agencia, senha, saldo, "0.035");
                break;
            default:
                account = new CurrentPhysicalPerson(num_conta, num_agencia, senha, saldo, "0.05");
        }

        bank.add(account);

        JOptionPane.showMessageDialog(null, "Conta criada.");
    }

    /**
     * @test
     */
    private void canShowMenu(Account account)
    {
        int option;
        String value;
        
        while ( true )
        {
            option = JOptionPane.showOptionDialog(
                null,
                "Escolha a opção:",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[] { "Saque", "Depósito", "Informações", "Voltar" },
                null
            );

            switch ( option )
            {
                case 0:
                    value = JOptionPane.showInputDialog("Informe o Valor:");
                    account.sacar(value);
                    break;
                case 1:
                    value = JOptionPane.showInputDialog("Informe o Valor:");
                    account.depositar(value);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, account.getDados());
                    break;
                default:
                    return;
            }

            JOptionPane.showMessageDialog(null, "Operação realizada.");
        }
    }

    /**
     * @test
     */
    public void test()
    {
        int option;
        String password;

        while ( true )
        {
            option = JOptionPane.showOptionDialog(
                null,
                "Seja bem-vindo.",
                "Olá",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[] { "Nova conta", "Já sou cliente", "Exibir Contas", "Encerrar Conta", "Aplicar Correções", "Sair" },
                null
            );

            switch ( option )
            {
                case 0:
                    this.canAddAccount();
                    break;
                case 1:
                    password = JOptionPane.showInputDialog("Senha da conta:");
                    
                    Account account = bank.existe(password);

                    if ( account != null )
                    {
                        this.canShowMenu(account);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(
                            null,
                            "Conta não encontrada.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                    break;
                case 2:
                    String msg = bank.exibir();

                    JOptionPane.showMessageDialog(
                        null,
                        msg != null ? msg : "Sem contas cadastradas."
                    );
                    break;
                case 3:
                    password = JOptionPane.showInputDialog("Senha da conta:");

                    JOptionPane.showMessageDialog(
                        null,
                        bank.remove(password) ? "Conta encerrada." : "Conta não encontrada."
                    );
                    break;
                case 4:
                    bank.corrigir();

                    JOptionPane.showMessageDialog(null, "Correções aplicadas.");
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}