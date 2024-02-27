package loja;
import java.math.BigDecimal;

public class Produto {
    private int codigo;
    private String nome;
    private BigDecimal valor;
    
    public Produto( int codigo, String nome, String valor ){
        this.codigo = codigo;
        this.nome   = nome;
        this.valor  = new BigDecimal( valor );
    }
    public BigDecimal getValor(){
        return this.valor;
    }
    public String getDados(){
        return "\nCódigo: " + this.codigo +
               "\nNome: "   + this.nome +
               "\nPreço: "  + this.valor.toString();
    }
}