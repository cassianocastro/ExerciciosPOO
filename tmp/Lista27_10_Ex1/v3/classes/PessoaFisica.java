package v3.classes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 */
public class PessoaFisica extends Pessoa
{

    private float altura;
    private String data_nasc;
    private int idade;
    private String CPF;

    public PessoaFisica(String nome, String endereco, String fone, float altura, String data_nasc, String CPF)
    {
        super(nome, endereco, fone);

        this.altura    = altura;
        this.data_nasc = data_nasc;
        this.CPF       = CPF;

        this.calculaIdade();
    }

    public PessoaFisica()
    {
        super();
    }

    public double getAltura()
    {
        return altura;
    }

    public void setAltura(float altura)
    {
        this.altura = altura;
    }

    public String getData_nasc()
    {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc)
    {
        this.data_nasc = data_nasc;

        calculaIdade();
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

        msg += "Altura: " + this.altura;
        msg += "\nCPF: "  + this.CPF;
        msg += "\nData de Nascimento: " + this.data_nasc;
        msg += "\nIdade: " + this.idade + "\n";

        return msg;
    }

    private void calculaIdade()
    {
        int dia = Integer.parseInt(this.data_nasc.substring(0, 2));
        int mes = Integer.parseInt(this.data_nasc.substring(3, 5));
        int ano = Integer.parseInt(this.data_nasc.substring(6));

        Calendar data = new GregorianCalendar();

        if ( mes <= data.get(Calendar.MONTH) )
            this.idade = 2020 - ano;
        else if ( dia <= data.get(Calendar.DAY_OF_MONTH) )
            this.idade = 2020 - ano;
        else
            this.idade = 2020 - ano - 1;
    }
}