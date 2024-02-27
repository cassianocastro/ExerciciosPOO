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

    public void add(Account conta)
    {
        this.accounts.add(conta);
    }

    public boolean remove(String senha)
    {
        Account conta = this.existe(senha);

        if ( conta != null )
        {
            this.accounts.remove(conta);

			return true;
        }

        return false;
    }

    public String exibir()
    {
        if ( ! this.accounts.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();

            for ( Account conta : this.accounts )
            {
                msg.append(conta.getDados()).append("\n***\n");
            }

            return msg.toString();
        }

        return "No accounts!";
    }

    public Account existe(String senha)
    {
        for ( Account conta : this.accounts )
        {
            if ( conta.getSenha().equals(senha) )
            {
                return conta;
            }
        }

        return null;
    }

    public void corrigir()
    {
        for ( Account conta : this.accounts )
        {
            conta.aplicarCorrecao();
        }
    }
}