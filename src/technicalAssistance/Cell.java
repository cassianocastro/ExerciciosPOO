package assistenciatecnica;
import java.io.Serializable;

public class Celular extends Aparelho implements Serializable{
    public Celular(String Marca, String Modelo, String SO, String defeito, 
        int ID, int RAM, int ROM, double tamanho_tela){
        super(Marca, Modelo, SO, defeito, ID, RAM, ROM, tamanho_tela);
    }
}