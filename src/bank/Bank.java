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

    public void add(final Account account)
    {
        this.accounts.add(account);
    }

    public boolean remove(final String password)
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

            for ( final Account account : this.accounts )
            {
                msg.append(account.toString()).append("\n***\n");
            }

            return msg.toString();
        }

        return "No accounts!";
    }

    public Account existe(final String password)
    {
        for ( final Account account : this.accounts )
        {
            if ( account.getPassword().equals(password) )
            {
                return account;
            }
        }

        return null;
    }

    public void corrigir()
    {
        for ( final Account account : this.accounts )
        {
            account.applyCorrection();
        }
    }
}