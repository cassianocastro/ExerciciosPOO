package aulaOO;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class Metodos {
    private Agenda agenda;
    
    public Metodos(){
        this.agenda = new Agenda();
    }
    public void inserir() throws ParseException {
        int ID               = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
        String Nacionalidade = JOptionPane.showInputDialog("Nacionalidade: ");
        String Nome          = JOptionPane.showInputDialog("Nome: ");
        char Sexo            = JOptionPane.showInputDialog("Sexo: ").charAt(0);
        Date DataNasc        = new SimpleDateFormat("dd/MM/yyyy").parse(
                               JOptionPane.showInputDialog("Data de Nascimento: "));

        Pessoa pessoa = new Pessoa(Nome, Nacionalidade, Sexo, DataNasc);
        this.agenda.add(ID, pessoa);
    }

    public void remover() {
        int ID = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da Pessoa:"));
        if ( ! this.agenda.existe(ID)) {
            JOptionPane.showMessageDialog(null, "ID inexistente", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.agenda.remove(ID);
        JOptionPane.showMessageDialog(null, "Pessoa removida", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void listar() {
        JOptionPane.showMessageDialog(null, this.agenda.listar());
    }

    public void alterar() throws ParseException{
        int ID = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da Pessoa:"));
        if ( ! this.agenda.existe(ID)) {
            JOptionPane.showMessageDialog(null, "ID inexistente", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Object dado  = null;
        Object opcao =  JOptionPane.showInputDialog(null, "Escolha o que deseja alterar:", "Alteração",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        new String[] {"Nome", "Sexo", "Nacionalidade", "Data de Nascimento"},
                        null);
        switch ( opcao.toString() ){
            case "Nome":
                dado = JOptionPane.showInputDialog("Novo Nome:");
                break;
            case "Sexo":
                dado = (JOptionPane.showInputDialog("Novo Sexo:")).charAt(0);
                break;
            case "Nacionalidade":
                dado = JOptionPane.showInputDialog("Nova Nacionalidade:");
                break;
            case "Data de Nascimento":
                dado = JOptionPane.showInputDialog("Nova Data de Nascimento:");
        }
        this.agenda.alterar(ID, dado, opcao.toString());
    }
    
    public void salvar(){
        JFileChooser chooser = new JFileChooser();
        Arquivo arquivo      = new Arquivo();
        int opcao            = chooser.showSaveDialog(null);
        
        if ( opcao == JFileChooser.APPROVE_OPTION ){
            boolean isSalvo = arquivo.gravar( chooser.getSelectedFile(), this.agenda.getMap() );
            if ( isSalvo )
                JOptionPane.showMessageDialog(null, "Dados Salvos.");
            else
                JOptionPane.showMessageDialog(null, "Ocorreu um erro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }  
        else if ( opcao == JFileChooser.CANCEL_OPTION )
            JOptionPane.showMessageDialog(null, "Op. cancelada.");
    }
    
    public void abrir(){
        JFileChooser chooser = new JFileChooser();
        Arquivo arquivo      = new Arquivo();
        int opcao            = chooser.showOpenDialog(null);
        
        if ( opcao == JFileChooser.APPROVE_OPTION ){
            Map novoMap = ( Map<Integer, Pessoa> ) arquivo.ler( chooser.getSelectedFile() );
            this.agenda.setMap( novoMap );
            JOptionPane.showMessageDialog(null, "Dados lidos com sucesso.");
        }
        else if ( opcao == JFileChooser.CANCEL_OPTION )
            JOptionPane.showMessageDialog(null, "Op. cancelada.");
    }
}