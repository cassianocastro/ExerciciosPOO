package files;

import java.io.File;

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
        new FileManipulationTest().canWriteAndRead(new File("src/files/test.txt"));
    }
}