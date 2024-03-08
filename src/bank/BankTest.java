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
    public void index()
    {
        int option;

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
                    this.canShowClientMenu();
                    break;
                case 2:
                    this.canShowAccounts();
                    break;
                case 3:
                    this.canDeleteAccount();
                    break;
                case 4:
                    this.canApplyChanges();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

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
    private void canShowClientMenu()
    {
        String password = JOptionPane.showInputDialog("Senha da conta:");
        Account account = bank.exists(password);

        if ( account != null )
        {
            this.canShowMenu(account);

            return;
        }

        JOptionPane.showMessageDialog(
            null,
            "Conta não encontrada.",
            "Erro",
            JOptionPane.ERROR_MESSAGE
        );
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
                    account.deposit(value);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, account.toString());
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
    private void canShowAccounts()
    {
        String msg = bank.exibir();

        JOptionPane.showMessageDialog(null, msg != null ? msg : "Sem contas cadastradas.");
    }
    
    /**
     * @test
     */
    private void canDeleteAccount()
    {
        String password = JOptionPane.showInputDialog("Senha da conta:");
        
        boolean removed = bank.remove(password);

        JOptionPane.showMessageDialog(null, "Conta " + (removed ? "encerrada." : "não encontrada."));
    }
    
    /**
     * @test
     */
    private void canApplyChanges()
    {
        bank.corrigir();

        JOptionPane.showMessageDialog(null, "Correções aplicadas.");
    }
}