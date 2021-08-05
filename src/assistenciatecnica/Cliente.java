package assistenciatecnica;

import java.io.Serializable;
import java.text.*;
import java.util.*;

public class Cliente implements Serializable, Comparable<Cliente> {

    private String nome, CPF, email, telefone;
    private Date dataNascimento;
    private Aparelho aparelho;

    public Cliente(String nome, String CPF, String email, String telefone, String dataNascimento) throws ParseException {
        this.nome           = nome;
        this.CPF            = CPF;
        this.email          = email;
        this.telefone       = telefone;
        this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
    }

    @Override
    public int compareTo(Cliente outro_cliente) {
        return this.CPF.compareTo(outro_cliente.CPF);
    }

    public String exibir() {
        return "\nNome: "               + this.nome +
               "\nCPF: "                + this.CPF +
               "\nData de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy").format( this.dataNascimento ) +
               "\nE-mail: "             + this.email +
               "\nTelefone: "           + this.telefone +
               "\nID do Aparelho: "     + this.aparelho.getID();
    }

    public Aparelho getAparelho() {
        return this.aparelho;
    }
    
    public void setAparelho(Aparelho novoAparelho){
        this.aparelho = novoAparelho;
    }

    public String getCPF() {
        return this.CPF;
    }
}
