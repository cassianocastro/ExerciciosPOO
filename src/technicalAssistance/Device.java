package assistenciatecnica;
import java.io.Serializable;

public abstract class Aparelho implements Serializable, Comparable<Aparelho>{
    private String Marca, Modelo, SO, defeito;
    private int ID, RAM, ROM; 
    private double tamanho_tela;
    
    public Aparelho (String Marca, String Modelo, String SO, String defeito,
            int ID, int RAM, int ROM, double tamanho_tela){
        this.Marca          = Marca;
        this.Modelo         = Modelo;
        this.SO             = SO;
        this.defeito        = defeito;
        this.ID             = ID;
        this.RAM            = RAM;
        this.ROM            = ROM;
        this.tamanho_tela   = tamanho_tela;
    }
    
    @Override
    public int compareTo(Aparelho outro_aparelho){
        if (this.ID < outro_aparelho.getID())
            return -1;
        if (this.ID > outro_aparelho.getID())
            return 1;
        return 0;
    }
    public String getEspecificacoes(){
        return    "\nID do aparelho: "      + this.ID
                + "\nTipo: "                + getClass().getSimpleName()
                + "\nMarca: "               + this.Marca
                + "\nModelo: "              + this.Modelo
                + "\nSistema Operacional: " + this.SO
                + "\nDefeito: "             + this.defeito
                + "\nRAM: "                 + this.RAM + " GB"
                + "\nROM: "                 + this.ROM + " GB"
                + "\nTamanho de tela: "     + this.tamanho_tela + "\"";
    }
    public int getID(){
        return this.ID;
    }
    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }
    public void setSO(String SO) {
        this.SO = SO;
    }
    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }
    public void setRAM(int RAM) {
        this.RAM = RAM;
    }
    public void setROM(int ROM) {
        this.ROM = ROM;
    }
    public void setTamanho_tela(double tamanho_tela) {
        this.tamanho_tela = tamanho_tela;
    }
}