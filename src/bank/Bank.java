package banco;
import java.util.*;

public class Banco {
    private List<Conta> contas;
    
    public Banco(){
        this.contas = new ArrayList<>();
    }
    //--------------------------------------
    public void add(Conta conta){
        this.contas.add(conta);
    }
    public boolean remove(String senha){
        Conta conta = existe(senha);
        if ( conta != null ) {
            this.contas.remove(conta);
            return true;
        }
        return false;
    }
    public StringBuilder exibir(){
        if ( ! this.contas.isEmpty() ) {
            StringBuilder msg = new StringBuilder();
            for (Conta conta : this.contas) {
                msg.append( conta.getDados() );
                msg.append( "\n***\n" );
            }
            return msg;
        }
        return null;
    }
    public Conta existe(String senha){
        for (Conta conta : this.contas) {
            if ( conta.getSenha().equals(senha) ) return conta;
        }
        return null;
    }
    public void corrigir(){
        for (Conta conta : this.contas) {
            conta.aplicarCorrecao();
        }
    }
}