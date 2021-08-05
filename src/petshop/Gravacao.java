package petshop;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Gravacao {
    public static void main(String[] args) throws IOException {
        File file; Object object;
        JFileChooser chooser = new JFileChooser();
        
        String nome = JOptionPane.showInputDialog(null, "Nome: ");
        String peso = JOptionPane.showInputDialog(null, "Tipo: ");
        Racao racao = new Racao(nome, Double.parseDouble(peso));
        
        List<Racao> lista = new ArrayList<>();
        lista.add(racao);

        if ( chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ){
            file = chooser.getSelectedFile();
            try ( ObjectOutputStream output
                    = new ObjectOutputStream(
                            new FileOutputStream( file )))
            {
                output.writeObject(lista);
            }catch(IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else if ( chooser.showSaveDialog(null) == JFileChooser.CANCEL_OPTION )
            JOptionPane.showMessageDialog(null, "Op. cancelada");
        
        
        if ( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ){
            file = chooser.getSelectedFile();
            List<Racao> lista2 = new ArrayList();

            try ( ObjectInputStream input 
                    = new ObjectInputStream(
                            new FileInputStream( file ))){
                object = input.readObject();
                lista2 = (ArrayList<Racao>) object;
            }catch(ClassNotFoundException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            for (Racao RaCao : lista2){
                JOptionPane.showMessageDialog(null, RaCao.getDados());
            }
        } else if (  chooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION  )
                JOptionPane.showMessageDialog(null, "Op. cancelada");
    }
}