package technicalAssistance;

import java.util.*;
import java.io.*;

/**
 *
 */
public class ClientRepository implements Serializable
{

    private final Set<Client> clients;

    public ClientRepository()
    {
        this.clients = new TreeSet<>();
    }

    public void add(final Client client)
    {
        this.clients.add(client);
    }

    public boolean exists(final String cpf)
    {
        for ( final Client client : this.clients )
        {
            if ( client.getCPF().equals(cpf) )
            {
                return true;
            }
        }

        return false;
    }

    public void remove(final Client client)
    {
        this.clients.remove(client);
    }

    public String show()
    {
        if ( ! this.clients.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();

            for ( final Client client : this.clients )
            {
                msg.append(client.toString()).append("\n----");
            }

            return msg.toString();
        }

        return "Fila Vazia";
    }
}