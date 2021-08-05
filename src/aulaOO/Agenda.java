package aulaOO;

import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

public class Agenda implements Serializable{
    private Map<Integer, Pessoa> agenda;
    
    public Agenda(){
        this.agenda = new HashMap<>();
    }
    
    public Map<Integer, Pessoa> getMap(){
        return this.agenda;
    }
    
    public void setMap(Map novoMap){
        this.agenda = ( novoMap != null ) ? novoMap : new HashMap<>();
    }
    
    public void add(int ID_informado, Pessoa pessoa){
        this.agenda.put(ID_informado, pessoa);
    }
    
    public boolean existe(int ID){
        return this.agenda.containsKey( ID );
    }
    
    public void remove(int ID_informado){
        this.agenda.remove( ID_informado );
    }
    
    public StringBuilder listar(){
        if ( ! this.agenda.isEmpty() ){
            StringBuilder mensagem = new StringBuilder("Pessoas cadastradas:\n");
            for (Pessoa pessoa : this.agenda.values()) {
                mensagem.append( pessoa.getDados() );
                mensagem.append( "\n***\n" );
            }
            return mensagem;
        }
        return new StringBuilder("Agenda Vazia.");
    }
    
    public void alterar(int ID, Object dado, String opcao_escolhida) throws ParseException{
        switch ( opcao_escolhida ){
            case "Nome":
                this.agenda.get(ID).setNome( String.valueOf(dado) );
                break;
            case "Sexo":
                this.agenda.get(ID).setSexo( String.valueOf(dado).charAt(0) );
                break;
            case "Nacionalidade":
                this.agenda.get(ID).setNacionalidade( String.valueOf(dado) );
                break;
            case "Data de Nascimento":
                this.agenda.get(ID).setDataNasc( String.valueOf(dado) );
        }
    }
}