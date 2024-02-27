package agenda;

import java.util.*;

/**
 *
 */
final public class Agenda
{

    private final List<Pessoa> pessoas;

    public Agenda()
    {
        this.pessoas = new ArrayList<>();
    }

    public void add(Pessoa pessoa)
    {
        this.pessoas.add(pessoa);
    }

    public Pessoa existe(String nome)
    {
        for ( Pessoa pessoa : this.pessoas )
        {
            if ( pessoa.getNome().equals(nome) )
            {
                return pessoa;
            }
        }

        return null;
    }

    public boolean remove(String nome)
    {
        Pessoa pessoa = existe(nome);

        if ( pessoa != null )
        {
            this.pessoas.remove(pessoa);

            return true;
        }

        return false;
    }

    public StringBuilder exibir()
    {
        if ( ! this.pessoas.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();

            for ( Pessoa pessoa : this.pessoas )
            {
                msg.append(pessoa.getDados());
                msg.append("\n***\n");
            }

            return msg;
        }

        return new StringBuilder("Agenda Vazia.");
    }
}