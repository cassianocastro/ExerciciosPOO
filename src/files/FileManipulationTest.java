package files;

import java.io.*;
import java.util.Scanner;

/**
 *
 */
public class FileManipulationTest
{

    public void testWriteAndReadOf(File file)
    {
        try
        {
            String content = this.read(file);
            String newLine = this.getNewLineAndShowContent(content);

            content += newLine;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
            {
                writer.write(content);
            }
        }
		catch ( IOException e )
        {
            System.out.println(e.getMessage());
        }
    }

    private String read(File file) throws IOException
    {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        try
        {
            while ( true )
            {
                line = reader.readLine();

                if ( line == null ) throw new EOFException("Arquivo lido.");

                builder.append(line).append("\n");
            }
        }
		catch ( EOFException e )
        {
            return builder.toString();
        }
    }

    private String getNewLineAndShowContent(CharSequence msg)
    {
        System.out.print(msg + "\nNew Line: ");

        String line = new Scanner(System.in).nextLine();

        return line == null ? "" : line;
    }
}