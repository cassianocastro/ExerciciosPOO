package agenda;

/**
 *
 */
abstract public class Pessoa
{

    private final String nome;
    private final String endereco;
    private final String telefone;

    public Pessoa(String nome, String endereco, String telefone)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome()
    {
        return this.nome;
    }

    public String getDados()
    {
        return "\nNome: "    + this.nome
            + "\nTelefone: " + this.telefone
            + "\nEndereço: " + this.endereco;
    }
}
