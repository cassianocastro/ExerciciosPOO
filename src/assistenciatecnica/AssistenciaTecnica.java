package assistenciatecnica;
import javax.swing.*;

public class AssistenciaTecnica {
    public static void main(String[] args){
        Manutencao classe   = new Manutencao();
        FilaEspera classe1 = new FilaEspera();
        int retorno;
        while ( true ){
            retorno = JOptionPane.showOptionDialog(null, "Você deseja ver...?", "Olá", 
                      JOptionPane.DEFAULT_OPTION,
                      JOptionPane.QUESTION_MESSAGE,
                      null,
                      new String[] {"Clientes", "Aparelhos", "Sair"},
                      null );
            switch (retorno) {
                case 0:
                    classe1.escolher();
                    break;
                case 1:
                    classe.escolher();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}