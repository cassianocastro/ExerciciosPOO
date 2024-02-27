package aulaOO;
import java.io.*;
import javax.swing.*;

public class Arquivo {

    public Arquivo() {
        //
    }

    public boolean gravar( File file, Object object ) {
        try ( ObjectOutputStream output
                = new ObjectOutputStream(
                        new FileOutputStream( file ))) {
            output.writeObject( object );
        } catch (IOException e) {
            JOptionPane.showMessageDialog( null, e.getMessage() );
            return false;
        }
        return true;
    }

    public Object ler( File file ) {
        Object object = null;
        try ( ObjectInputStream input 
                = new ObjectInputStream(
                        new FileInputStream( file ))){
            object = input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return object;
    }
}