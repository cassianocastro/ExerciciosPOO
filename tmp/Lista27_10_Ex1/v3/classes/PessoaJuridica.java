package v3.classes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 */
public class PessoaJuridica extends Pessoa
{

    private String CNPJ;
    private String data_fund;
    private int idade;

    public PessoaJuridica()
    {
        super();
    }

    public PessoaJuridica(String nome, String endereco, String telefone, String CNPJ, String data_fund)
    {
        super(nome, endereco, telefone);

        this.CNPJ      = CNPJ;
        this.data_fund = data_fund;

        this.calculaIdade();
    }

    @Override
    public void imprimeDados()
    {
        String msg = getDados();
        JOptionPane.showMessageDialog(null, msg);
    }

    @Override
    public String getDados()
    {
        String msg = super.getDados();

        msg += "CNPJ: "    + this.CNPJ;
        msg += "\nData de Fundação: "   + this.data_fund;
        msg += "\nIdade: " + this.idade + "\n";

        return msg;
    }

    private void calculaIdade()
    {
        int dia = Integer.parseInt(this.data_fund.substring(0, 2));
        int mes = Integer.parseInt(this.data_fund.substring(3, 5));
        int ano = Integer.parseInt(this.data_fund.substring(6));

        Calendar data = new GregorianCalendar();

        if ( mes <= data.get(Calendar.MONTH) )
            this.idade = 2020 - ano;
        else if ( dia <= data.get(Calendar.DAY_OF_MONTH) )
            this.idade = 2020 - ano;
        else
            this.idade = 2020 - ano - 1;
    }
}