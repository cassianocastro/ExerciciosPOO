package v3.classes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 */
public class Agenda
{

    private final List<Pessoa> pessoas;

    public Agenda()
    {
        this.pessoas = new ArrayList<>();
    }

    public void armazenaPessoaFisica(String nome, String endereco, String telefone, String data_nasc, float altura, String CPF)
    {
        this.pessoas.add(new PessoaFisica(nome, endereco, telefone, altura, data_nasc, CPF));
    }

    public void armazenaPessoaJuridica(String nome, String endereco, String telefone, String CNPJ, String data_fund)
    {
        this.pessoas.add(new PessoaJuridica(nome, endereco, telefone, CNPJ, data_fund));
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

        for ( final Pessoa p : this.pessoas )
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
            for ( final Pessoa p : this.pessoas )
            {
                msg += p.getDados() + "\n";
            }

            JOptionPane.showMessageDialog(null, "Agenda: \n" + msg);
        }
		else
        {
            JOptionPane.showMessageDialog(null, "Agenda vazia!");
        }
    }

    public void imprimePessoa(int index)
    {
        if ( ! this.pessoas.isEmpty() )
        {
            if ( index < this.pessoas.size() )
                this.pessoas.get(index).imprimeDados();
            else
                JOptionPane.showMessageDialog(null, "Index inválido");
        }
		else
        {
            JOptionPane.showMessageDialog(null, "Agenda vazia!");
        }
    }
}