package agenda;

/**
 *
 */
final public class Pessoa_Juridica extends Pessoa
{

    private final String CNPJ;
    private final String date_foundation;

    public Pessoa_Juridica(String nome, String endereco, String telefone, String CNPJ, String date_foundation)
    {
        super(nome, endereco, telefone);
        this.CNPJ            = CNPJ;
        this.date_foundation = date_foundation;
    }

    @Override
    public String getDados()
    {
        return super.getDados()
            + "\nCNPJ: " + this.CNPJ
            + "\nData Fundação: " + this.date_foundation;
    }
}
