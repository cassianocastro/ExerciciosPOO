package assistenciatecnica;

import java.io.*;
import javax.swing.*;

/**
 *
 */
public class Arquivo implements Serializable
{

    public Object ler(File file)
    {
        Object object = null;
        try (ObjectInputStream input
            = new ObjectInputStream(
                new FileInputStream(file)))
        {
            object = input.readObject();
        } catch (IOException | ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return object;
    }

    public boolean gravar(File file, Object object)
    {
        try (ObjectOutputStream output
            = new ObjectOutputStream(
                new FileOutputStream(file)))
        {
            output.writeObject(object);
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
