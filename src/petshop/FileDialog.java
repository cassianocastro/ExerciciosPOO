package petshop;

import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * 
 */
public class FileDialog
{

    private final JFileChooser chooser;
    private final FileManipulator manipulator;

    public FileDialog()
    {
        this.chooser     = new JFileChooser();
        this.manipulator = new FileManipulator();
    }

    public void save(List list)
    {
        int option = this.chooser.showSaveDialog(null);

        if ( option == JFileChooser.APPROVE_OPTION )
        {
            File file = this.chooser.getSelectedFile();

            this.manipulator.writeToFile(list, file);
        }
        else if ( option == JFileChooser.CANCEL_OPTION )
        {
            JOptionPane.showMessageDialog(null, "Op. cancelada");
        }
    }
    
    public List recovery()
    {
        int option = this.chooser.showOpenDialog(null);

        if ( option == JFileChooser.APPROVE_OPTION )
        {
            File file = this.chooser.getSelectedFile();

            return this.manipulator.readFromFile(file);
        }
        else if ( option == JFileChooser.CANCEL_OPTION )
        {
            JOptionPane.showMessageDialog(null, "Op. cancelada");
        }

        return null;
    }
}