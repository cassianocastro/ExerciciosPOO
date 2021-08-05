package assistenciatecnica;

import javax.swing.*;

public class Manutencao implements NewInterface{
    private RepositorioAparelhos manutencao;
    
    public Manutencao(){
        this.manutencao = new RepositorioAparelhos();
    }
    
    @Override
    public void escolher(){
        int retorno;
        while ( true ) {
            retorno = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Opções",
                      JOptionPane.DEFAULT_OPTION,
                      JOptionPane.INFORMATION_MESSAGE,
                      null,
                      new String[] {"Inserir", "Listar", "Remover", "Alterar", "Voltar"},
                      null );
            switch ( retorno ){
                case 0:
                    inserir();
                    break;
                case 1:
                    listar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    alterar();
                    break;
                default:
                    return;
            }
        }
    }
    
    @Override
    public void inserir(){
        String Marca        = JOptionPane.showInputDialog("Marca:");
        String Modelo       = JOptionPane.showInputDialog("Modelo:");
        String SO           = JOptionPane.showInputDialog("S.O.:");
        double tamanho_tela = Double.parseDouble(
                              JOptionPane.showInputDialog("Tam. da tela:"));
        
        int RAM = Integer.parseInt(JOptionPane.showInputDialog("RAM(GB):"));
        int ROM = Integer.parseInt(JOptionPane.showInputDialog("ROM(GB):"));
        int ID  = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe um ID para seu aparelho:"));
        while ( this.manutencao.existe(ID) ){
            ID  = Integer.parseInt(JOptionPane.showInputDialog(null, "ID já utilizado!! Escolha outro..."));
        }
        Object defeito = JOptionPane.showInputDialog( null, "Tipo de Problema:", "Descrição",
                         JOptionPane.QUESTION_MESSAGE,
                         null,
                         new String[] {"Hardware", "Software"},
                         null );
        Object tipo =    JOptionPane.showInputDialog(null, "Tipo de Aparelho:", null,
                         JOptionPane.QUESTION_MESSAGE,
                         null,
                         new String[] {"Celular", "Notebook"},
                         null );
    }
    
    @Override
    public void remover(){
        int ID = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do aparelho:"));
        if ( ! this.manutencao.existe(ID) ){
            JOptionPane.showMessageDialog(null, "Aparelho não encontrado.");
            return;
        }
        this.manutencao.remover(ID);
        JOptionPane.showMessageDialog(null, "Aparelho removido.");
    }
    
    @Override
    public void listar(){
        JOptionPane.showMessageDialog(
                null,
                this.manutencao.exibir(),
                "Aparelhos cadastrados",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void alterar(){
        int ID = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do aparelho:"));
        if ( ! this.manutencao.existe(ID) ){
            JOptionPane.showMessageDialog(null, "ID não encontrado.");
            return;
        }
        Aparelho temporario = this.manutencao.edicao(ID);
        Object retorno = JOptionPane.showInputDialog(null, "Escolha o tipo de dado:", "Opções",
                         JOptionPane.QUESTION_MESSAGE,
                         null,
                         new String[] {"Marca", "Modelo", "S.O.", "RAM", "ROM", "Tela", "Defeito"},
                         null );
        switch ( retorno.toString() ){
            case "Marca":
                temporario.setMarca(JOptionPane.showInputDialog("Nova Marca:"));
                break;
            case "Modelo":
                temporario.setModelo(JOptionPane.showInputDialog("Novo Modelo:"));
                break;
            case "S.O.":
                temporario.setSO(JOptionPane.showInputDialog("Novo S.O.:"));
                break;
            case "RAM":
                temporario.setRAM(Integer.parseInt(JOptionPane.showInputDialog("Nova RAM:")));
                break;
            case "ROM":
                temporario.setROM(Integer.parseInt(JOptionPane.showInputDialog("Nova ROM:")));
                break;
            case "Tela":
                temporario.setTamanho_tela(Double.parseDouble(JOptionPane.showInputDialog("Novo tam. de tela:")));
                break;
            case "Defeito":
                Object defeito = JOptionPane.showInputDialog(null, "Novo defeito:","Tipo de Problema", 
                                 JOptionPane.QUESTION_MESSAGE,
                                 null,
                                 new String[] {"Hardware", "Software"},
                                 null);
                temporario.setDefeito( defeito.toString() );
        }
    }

    @Override
    public void salvar() {
        
    }

    @Override
    public void abrir() {
        
    }
}