package petshop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * 
 */
public class FileManipulator
{
    
    public void writeToFile(List list, File file)
    {
        try ( ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file)) )
        {
            output.writeObject(list);
        }
        catch ( IOException e )
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public List readFromFile(File file)
    {
        try ( ObjectInputStream input = new ObjectInputStream(new FileInputStream(file)) )
        {
            Object obj = input.readObject();

            return (List<DogFood>) obj;
        }
        catch ( ClassNotFoundException | IOException e )
        {
            return Collections.emptyList();
        }
    }
}