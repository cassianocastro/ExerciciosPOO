package files;

import java.io.*;
import javax.swing.JOptionPane;

public class TrabalhandoComArquivos2
{

    public static void main(String[] args)
    {
        File file = new File("..\\..\\..\\Desktop\\teste.txt");

        StringBuilder msg = new StringBuilder("");
        String line;

        try (BufferedReader reader
            = new BufferedReader(
                new FileReader(file)))
        {
            while ( true )
            {
                line = reader.readLine();

                if ( line != null )
                {
                    msg.append(line);
                    msg.append("\n");
                } else
                    throw new EOFException("Arquivo lido.");
            }
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        String novaLinha = JOptionPane.showInputDialog(null, msg + "\n\nDigite a linha nova:");

        if ( novaLinha != null )
        {
            msg.append(novaLinha);

            try (BufferedWriter writer
                = new BufferedWriter(
                    new FileWriter(file)))
            {
                writer.write(msg.toString());
            } catch (IOException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
