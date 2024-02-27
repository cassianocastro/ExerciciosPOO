package v2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 */
public class Agenda
{

    private final ArrayList<Person> pessoas;

    public Agenda()
    {
        this.pessoas = new ArrayList<>();
    }

    public void armazenaPessoa(String nome, String data_nasc, float altura)
    {
        this.pessoas.add(new Person(nome, data_nasc, altura));
    }

    public void removePessoa(String nome)
    {
        int index = this.buscaPessoa(nome);

        if ( index >= 0 )
        {
            this.pessoas.remove(index);
        }
    }

    public int buscaPessoa(String nome)
    {
        int pos = -1;

        for ( final Person p : this.pessoas )
        {
            if ( p.getNome().equals(nome) )
            {
                pos = this.pessoas.indexOf(p);
            }
        }

        if ( pos < 0 )
        {
            JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
        }
        return pos;
    }

    public void imprimeAgenda()
    {
        String msg = "";

        if ( ! this.pessoas.isEmpty() )
        {
            for ( final Person p : this.pessoas )
            {
                msg += p.imprimeDados()+ "\n";
            }
            JOptionPane.showMessageDialog(null, "Agenda: \n" + msg);
        } else
            JOptionPane.showMessageDialog(null, "Agenda vazia!");
    }

    public void imprimePessoa(int index)
    {
        if ( ! this.pessoas.isEmpty() )
        {
            if ( index < pessoas.size() )
                this.pessoas.get(index).imprimeDados();
            else
                JOptionPane.showMessageDialog(null, "Index inválido");
        } else
            JOptionPane.showMessageDialog(null, "Agenda vazia!");
    }
}
