package v3.classes;

/**
 *
 */
public class Pessoa
{

    protected String nome;
    protected String endereco;
    protected String telefone;

    public Pessoa(String nome, String endereco, String telefone)
    {
        this.nome     = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Pessoa() {}

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDados()
    {
        String msg = "";

        msg += "Nome: "       + this.nome;
        msg += "\nTelefone: " + this.telefone;
        msg += "\nEndereço: " + this.endereco + "\n";

        return msg;
    }

    public void imprimeDados() {}
}