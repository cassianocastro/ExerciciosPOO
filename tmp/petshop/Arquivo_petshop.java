package petshop;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 */
public class Arquivo_petshop
{

    public static void main(String[] args)
    {
        File file = new File("racoes.dat");
        List<Racao> lista = new ArrayList<>();

        lista.add(new Racao("Pedigree", 5.0));
        lista.add(new Racao("Dog Chow", 3.0));
        lista.add(new Racao("Royal Canin", 2.0));
        lista.add(new Racao("Royal Canin", 10.0));

        // escreve
        try (ObjectOutputStream output
            = new ObjectOutputStream(
                new FileOutputStream(file)))
        {
            output.writeObject(lista);
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        Object object;
        List<Racao> lista2 = new ArrayList<>();

        // lê
        try (ObjectInputStream input
            = new ObjectInputStream(
                new FileInputStream(file)))
        {
            object = input.readObject();
            lista2 = (List<Racao>) object;
        } catch (IOException | ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        StringBuilder msg = new StringBuilder();

        for ( Racao i : lista2 )
        {
            msg.append(i.getDados());
        }
        JOptionPane.showMessageDialog(null, msg);
    }
}
