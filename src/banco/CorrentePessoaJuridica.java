package banco;

public class CorrentePessoaJuridica extends Conta{
    public CorrentePessoaJuridica(int num_conta, int num_agencia, String senha, String saldo, String taxa){
        super (num_conta, num_agencia, senha, saldo, taxa);
    }
}