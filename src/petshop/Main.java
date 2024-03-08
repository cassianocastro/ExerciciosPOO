package petshop;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    static public void main(String[] args)
    {
        List<DogFood> list = new ArrayList<>();
        
        String name   = JOptionPane.showInputDialog(null, "Name: ");
        String weight = JOptionPane.showInputDialog(null, "Weight: ");

        list.add(new DogFood(name, Double.parseDouble(weight)));
        
        var dialog = new FileDialog();
        
        dialog.save(list);
        
        list = dialog.recovery();
        
        for ( final DogFood food : list )
        {
            JOptionPane.showMessageDialog(null, food.toString());
        }
    }
}