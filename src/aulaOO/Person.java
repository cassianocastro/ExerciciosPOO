package aulaOO;
import java.util.*;
import java.io.*;
import java.text.*;

public class Pessoa implements Serializable {
    private String nome, nacionalidade;
    private char sexo;
    private Date dataNasc;
    
    public Pessoa( String nome, String nacionalidade, char sexo, Date dataNasc ) {
        this.nome          = nome;
        this.sexo          = sexo;
        this.dataNasc      = dataNasc;
        this.nacionalidade = nacionalidade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public void setDataNasc(String dataNasc) throws ParseException {
        this.dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(dataNasc);
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public String getDados() {
        return  "\nNome: "               + this.nome +
                "\nSexo: "               + this.sexo +
                "\nData de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy").format(this.dataNasc) +
                "\nNacionalidade: "      + this.nacionalidade;
    }
}