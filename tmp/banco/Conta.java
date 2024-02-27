package banco;

import java.math.BigDecimal;

/**
 *
 */
abstract public class Conta
{

    private final int num_conta;
    private final int num_agencia;
    private final String senha;
    private final BigDecimal taxa_juros;
    private BigDecimal saldo;

    public Conta(int num_conta, int num_agencia, String senha, String saldo, String taxa_juros)
    {
        this.num_conta   = num_conta;
        this.num_agencia = num_agencia;
        this.senha       = senha;
        this.saldo       = new BigDecimal(saldo);
        this.taxa_juros  = new BigDecimal(taxa_juros);
    }

    public String getSenha()
    {
        return this.senha;
    }

    public String getDados()
    {
        return "\nTipo: " + getClass().getSimpleName()
            + "\nNº Conta: " + this.num_conta
            + "\nNº Agência: " + this.num_agencia
            + "\nSaldo: R$ " + this.saldo.toString();
    }

    public void sacar(String valor)
    {
        this.saldo = this.saldo.subtract(new BigDecimal(valor));
    }

    public void depositar(String valor)
    {
        this.saldo = this.saldo.add(new BigDecimal(valor));
    }

    public void aplicarCorrecao()
    {
        BigDecimal juro = this.saldo.multiply(this.taxa_juros);
        this.saldo      = this.saldo.add(juro);
    }
}
