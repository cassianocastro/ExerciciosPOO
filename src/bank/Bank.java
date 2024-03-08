package bank;

import java.util.*;

/**
 *
 */
public class Bank
{

    private final List<Account> accounts;

    public Bank()
    {
        this.accounts = new ArrayList<>();
    }

    public void add(Account account)
    {
        this.accounts.add(account);
    }

    public boolean remove(String password)
    {
        Account account = this.existe(password);

        if ( account != null )
        {
            this.accounts.remove(account);

            return true;
        }

        return false;
    }

    public String exibir()
    {
        if ( ! this.accounts.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();

            for ( Account account : this.accounts )
            {
                msg.append(account.toString()).append("\n***\n");
            }

            return msg.toString();
        }

        return "No accounts!";
    }

    public Account existe(String senha)
    {
        for ( Account account : this.accounts )
        {
            if ( account.getPassword().equals(senha) )
            {
                return account;
            }
        }

        return null;
    }

    public void corrigir()
    {
        for ( Account account : this.accounts )
        {
            account.applyCorrection();
        }
    }
}