package technicalAssistance;

import java.util.*;
import java.io.*;

/**
 *
 */
public class CustomersRepository implements Serializable
{

    private final Set<Customer> clients;

    public CustomersRepository()
    {
        this.clients = new TreeSet<>();
    }

    public void add(final Customer client)
    {
        this.clients.add(client);
    }

    public boolean exists(final String cpf)
    {
        for ( final Customer client : this.clients )
        {
            if ( client.getCPF().equals(cpf) )
            {
                return true;
            }
        }

        return false;
    }

    public void remove(final Customer client)
    {
        this.clients.remove(client);
    }

    public String show()
    {
        if ( ! this.clients.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();

            for ( final Customer client : this.clients )
            {
                msg.append(client.toString()).append("\n----");
            }

            return msg.toString();
        }

        return "Fila Vazia";
    }
}