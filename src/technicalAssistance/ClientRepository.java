package technicalAssistance;

import java.util.*;
import java.io.*;

/**
 *
 *
 */
public class ClientRepository implements Serializable
{

    private final Set<Client> clients;

    public ClientRepository()
    {
        this.clients = new TreeSet<>();
    }

    public void add(Client client)
    {
        this.clients.add(client);
    }

    public boolean exists(String cpf)
    {
        for ( Client client : this.clients )
        {
            if ( client.getCPF().equals(cpf) )
            {
                return true;
            }
        }
        return false;
    }

    public void remove(Client client)
    {
        this.clients.remove(client);
    }

    public String show()
    {
        if ( ! this.clients.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();
            
            for ( Client client : this.clients )
            {
                msg.append(client.exibir()).append("\n----");
            }
            return msg.toString();
        }
        return "Fila Vazia";
    }
}