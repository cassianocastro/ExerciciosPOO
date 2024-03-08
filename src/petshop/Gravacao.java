package petshop;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Gravacao
{

    /**
     * @param args the command line arguments
     */
    static public void main(String[] args)
    {
        List<Racao> list = new ArrayList<>();
        
        String name   = JOptionPane.showInputDialog(null, "Name: ");
        String weight = JOptionPane.showInputDialog(null, "Weight: ");

        list.add(new Racao(name, Double.parseDouble(weight)));
        
        var dialog = new FileDialog();
        
        dialog.save(list);
        
        list = dialog.recovery();
        
        for ( final Racao r : list )
        {
            JOptionPane.showMessageDialog(null, r.toString());
        }
    }
}