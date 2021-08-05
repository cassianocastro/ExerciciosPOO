package agenda;

public abstract class Pessoa {
    private String nome, endereco, telefone;

    public Pessoa(String nome, String endereco, String telefone){
        this.nome     = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    //--------------------------------------
    public String getNome(){
        return this.nome;
    }
    public String getDados(){
        return  "\nNome: "     + this.nome +
                "\nTelefone: " + this.telefone +
                "\nEndereço: " + this.endereco;
    }
}