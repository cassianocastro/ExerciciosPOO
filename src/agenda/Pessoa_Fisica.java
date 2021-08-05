package agenda;

public final class Pessoa_Fisica extends Pessoa{
    private String CPF, data_nasc;
    private float altura;

    public Pessoa_Fisica(String nome, String endereco, String telefone, String CPF, String data_nasc, float altura){
        super(nome, endereco, telefone);
        this.CPF        = CPF;
        this.altura     = altura;
        this.data_nasc  = data_nasc;
    }
    //--------------------------------------
    @Override
    public String getDados(){
        return super.getDados()     +
                "\nCPF: "             + this.CPF +
                "\nData Nascimento: " + this.data_nasc +
                "\nAltura: "          + this.altura;
    }
}