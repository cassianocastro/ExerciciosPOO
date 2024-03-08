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
                "Welcome...",
                "Hello",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[] { "New account", "I\'m a client", "Show accounts", "End account", "Apply corrections", "Exit" },
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
        int num_account = Integer.parseInt(JOptionPane.showInputDialog("Account number:"));
        int num_agency  = Integer.parseInt(JOptionPane.showInputDialog("Agency number:"));
        String password = JOptionPane.showInputDialog("Password:");
        String saldo    = JOptionPane.showInputDialog("Saldo inicial:");

        int option = JOptionPane.showOptionDialog(
            null,
            "Choose a option:",
            "Type",
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
                account = new SavingsAccount(num_account, num_agency, password, saldo, "0.09");
                break;
            case 1:
                account = new SalaryAccount(num_account, num_agency, password, saldo, "0.0");
                break;
            case 2:
                account = new CurrentJuridicalPerson(num_account, num_agency, password, saldo, "0.035");
                break;
            default:
                account = new CurrentPhysicalPerson(num_account, num_agency, password, saldo, "0.05");
        }

        bank.add(account);

        JOptionPane.showMessageDialog(null, "Created account.");
    }
    
    /**
     * @test
     */
    private void canShowClientMenu()
    {
        String password = JOptionPane.showInputDialog("Account\'s password:");
        Account account = bank.exists(password);

        if ( account != null )
        {
            this.canShowMenu(account);

            return;
        }

        JOptionPane.showMessageDialog(
            null,
            "Account not found!",
            "Error",
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
                "Choose a option:",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[] { "Saque", "Depósito", "Info", "Back" },
                null
            );

            switch ( option )
            {
                case 0:
                    value = JOptionPane.showInputDialog("Enter the value:");
                    account.sacar(value);
                    break;
                case 1:
                    value = JOptionPane.showInputDialog("Enter the value:");
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

        JOptionPane.showMessageDialog(null, msg != null ? msg : "No accounts registered.");
    }
    
    /**
     * @test
     */
    private void canDeleteAccount()
    {
        String password = JOptionPane.showInputDialog("Account\'s password:");
        
        boolean removed = bank.remove(password);

        JOptionPane.showMessageDialog(null, "Account " + (removed ? "ended." : "not found."));
    }
    
    /**
     * @test
     */
    private void canApplyChanges()
    {
        bank.corrigir();

        JOptionPane.showMessageDialog(null, "Corrections applied.");
    }
}