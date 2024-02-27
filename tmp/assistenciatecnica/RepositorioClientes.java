package assistenciatecnica;

import java.util.*;
import java.io.*;

/**
 *
 */
public class RepositorioClientes implements Serializable
{

    private final Set<Cliente> clientes;

    public RepositorioClientes()
    {
        this.clientes = new TreeSet<>();
    }

    public void add(Cliente cliente)
    {
        this.clientes.add(cliente);
    }

    public boolean existe(String CPF)
    {
        for ( Cliente cliente : this.clientes )
        {
            if ( cliente.getCPF().equals(CPF) )
            {
                return true;
            }
        }

        return false;
    }

    public void remover(Cliente cliente)
    {
        this.clientes.remove(cliente);
    }

    public StringBuilder exibir()
    {
        if ( ! this.clientes.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();

		    for ( Cliente cliente : this.clientes )
            {
                msg.append(cliente.exibir());
                msg.append("\n-----------");
            }

            return msg;
        }

        return new StringBuilder("Fila Vazia");
    }
}