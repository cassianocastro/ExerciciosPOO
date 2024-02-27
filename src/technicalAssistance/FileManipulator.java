package technicalAssistance;

import java.io.*;

/**
 *
 */
public class FileManipulator implements Serializable
{

    public Object read(File file) throws IOException, ClassNotFoundException
    {
        try (ObjectInputStream input
            = new ObjectInputStream(new FileInputStream(file)))
        {
            return input.readObject();
        }
    }

    public void write(File file, Object object) throws IOException
    {
        try (ObjectOutputStream output
            = new ObjectOutputStream(new FileOutputStream(file)))
        {
            output.writeObject(object);
        }
    }
}