package bank;

import java.math.BigDecimal;

/**
 *
 */
abstract public class Account
{

    private final int num_conta;
    private final int num_agencia;
    private final String senha;
    private final BigDecimal taxa_juros;
    private BigDecimal saldo;

    public Account(int num_conta, int num_agencia, String senha, String saldo, String taxa_juros)
    {
        this.num_conta   = num_conta;
        this.num_agencia = num_agencia;
        this.senha       = senha;
        this.saldo       = new BigDecimal(saldo);
        this.taxa_juros  = new BigDecimal(taxa_juros);
    }

    public String getPassword()
    {
        return this.senha;
    }

    @Override
    public String toString()
    {
        return "\nTipo: "      + getClass().getSimpleName()
            + "\nNº Conta: "   + this.num_conta
            + "\nNº Agência: " + this.num_agencia
            + "\nSaldo: R$ "   + this.saldo.toString();
    }

    public void sacar(String valor)
    {
        this.saldo = this.saldo.subtract(new BigDecimal(valor));
    }

    public void deposit(String valor)
    {
        this.saldo = this.saldo.add(new BigDecimal(valor));
    }

    public void applyCorrection()
    {
        BigDecimal juro = this.saldo.multiply(this.taxa_juros);
        this.saldo      = this.saldo.add(juro);
    }
}