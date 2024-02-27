package aulaOO;

import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 */
public class Principal
{

    public static void main(String args[])
    {
        int opcao;
        Metodos metodo = new Metodos();
        
        while ( true )
        {
            try
            {
                opcao = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Olá",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[]
                    {
                        "Inserir", "Remover", "Listar",
                        "Alterar", "Abrir", "Salvar", "Sair"
                    },
                    null
                );
                switch ( opcao )
                {
                    case 0:
                        metodo.inserir();
                        break;
                    case 1:
                        metodo.remover();
                        break;
                    case 2:
                        metodo.listar();
                        break;
                    case 3:
                        metodo.alterar();
                        break;
                    case 4:
                        metodo.abrir();
                        break;
                    case 5:
                        metodo.salvar();
                        break;
                    default:
                        System.exit(0);
                }
            } catch (ParseException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
