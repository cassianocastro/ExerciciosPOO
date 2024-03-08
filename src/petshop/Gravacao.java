package petshop;

import javax.swing.*;
import java.io.*;
import java.util.*;

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
        File file;
        Object object;
        JFileChooser chooser = new JFileChooser();

        String name   = JOptionPane.showInputDialog(null, "Nome: ");
        String weight = JOptionPane.showInputDialog(null, "Tipo: ");

        Racao racao = new Racao(name, Double.parseDouble(weight));

        List<Racao> list = new ArrayList<>();
        list.add(racao);

        if ( chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION )
        {
            file = chooser.getSelectedFile();

            try (ObjectOutputStream output
                = new ObjectOutputStream(
                    new FileOutputStream(file)))
            {
                output.writeObject(list);
            }
            catch ( IOException e )
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
	else if ( chooser.showSaveDialog(null) == JFileChooser.CANCEL_OPTION )
        {
            JOptionPane.showMessageDialog(null, "Op. cancelada");
        }

        if ( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
        {
            file = chooser.getSelectedFile();
            List<Racao> list2 = new ArrayList();

            try (ObjectInputStream input
                = new ObjectInputStream(
                    new FileInputStream(file)))
            {
                object = input.readObject();
                list2  = (List<Racao>) object;
            }
            catch ( ClassNotFoundException | IOException e )
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            for ( final Racao r : list2 )
            {
                JOptionPane.showMessageDialog(null, r.toString());
            }
        }
	else if ( chooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION )
        {
            JOptionPane.showMessageDialog(null, "Op. cancelada");
        }
    }
}