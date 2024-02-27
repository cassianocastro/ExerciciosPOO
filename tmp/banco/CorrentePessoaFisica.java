package banco;

/**
 *
 */
public class CorrentePessoaFisica extends Conta
{

    public CorrentePessoaFisica(int num_conta, int num_agencia, String senha, String saldo, String taxa)
    {
        super(num_conta, num_agencia, senha, saldo, taxa);
    }
}
