package v2;

import javax.swing.JOptionPane;

/**
 *
 */
public class Person
{

    private String nome;
    private String data_nasc;
    private float altura;
    private int idade;

    public Person(String nome, String data_nasc, float altura)
    {
        this.nome      = nome;
        this.data_nasc = data_nasc;
        this.altura    = altura;

        this.calculaIdade();
    }

    public Person() {}

    public double getAltura()
    {
        return this.altura;
    }

    public void setAltura(float altura)
    {
        this.altura = altura;
    }

    public String getData_nasc()
    {
        return this.data_nasc;
    }

    public void setData_nasc(String data_nasc)
    {
        this.data_nasc = data_nasc;

        calculaIdade();
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public StringBuilder imprimeDados()
    {
        StringBuilder msg = new StringBuilder(200);

        msg.append("Nome: ")
           .append(this.nome);
        msg.append("\nAltura: ")
           .append(this.altura);
        msg.append("\nData de Nascimento: ")
           .append(this.data_nasc);
        msg.append("\nIdade: ")
           .append(this.idade)
           .append("\n");

        return msg;
    }

    private void calculaIdade()
    {
        final int CURRENT_YEAR = 2022;

        int dia = Integer.parseInt(this.data_nasc.substring(0, 2));
        int mes = Integer.parseInt(this.data_nasc.substring(3, 5));
        int ano = Integer.parseInt(this.data_nasc.substring(6));

        if ( mes <= 10 )
            this.idade = CURRENT_YEAR - ano;
        else if ( dia <= 27 )
            this.idade = CURRENT_YEAR - ano;
        else
            this.idade = CURRENT_YEAR - ano - 1;
    }
}