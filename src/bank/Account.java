package bank;

import java.math.BigDecimal;

/**
 *
 */
abstract public class Account
{

    private final int num_account;
    private final int num_agency;
    private final String password;
    private final BigDecimal taxa_juros;
    private BigDecimal saldo;

    public Account(int num_account, int num_agency, String password, String saldo, String taxa_juros)
    {
        this.num_account = num_account;
        this.num_agency  = num_agency;
        this.password    = password;
        this.saldo       = new BigDecimal(saldo);
        this.taxa_juros  = new BigDecimal(taxa_juros);
    }

    public String getPassword()
    {
        return this.password;
    }

    @Override
    public String toString()
    {
        return "\nTipo: "      + getClass().getSimpleName()
            + "\nNº Conta: "   + this.num_account
            + "\nNº Agência: " + this.num_agency
            + "\nSaldo: R$ "   + this.saldo.toString();
    }

    public void sacar(String value)
    {
        this.saldo = this.saldo.subtract(new BigDecimal(value));
    }

    public void deposit(String value)
    {
        this.saldo = this.saldo.add(new BigDecimal(value));
    }

    public void applyCorrection()
    {
        BigDecimal juro = this.saldo.multiply(this.taxa_juros);
        this.saldo      = this.saldo.add(juro);
    }
}