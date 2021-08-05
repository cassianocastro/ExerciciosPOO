package banco;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(int num_conta, int num_agencia, String senha, String saldo, String taxa){
        super (num_conta, num_agencia, senha, saldo, taxa);
    }
}