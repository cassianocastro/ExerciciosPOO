package agenda;

/**
 *
 */
final public class Pessoa_Fisica extends Pessoa
{

    private final String CPF;
    private final String data_nasc;
    private final float altura;

    public Pessoa_Fisica(String nome, String endereco, String fone, String CPF, String data_nasc, float altura)
    {
        super(nome, endereco, fone);

        this.CPF       = CPF;
        this.altura    = altura;
        this.data_nasc = data_nasc;
    }

    @Override
    public String getDados()
    {
        return super.getDados()
            + "\nCPF: " + this.CPF
            + "\nData Nascimento: " + this.data_nasc
            + "\nAltura: " + this.altura;
    }
}