package technicalAssistance;

import javax.swing.*;

/**
 *
 */
public class DevicesController
{

    public void showIndexMenu()
    {
        int option;

        while ( true )
        {
            option = JOptionPane.showOptionDialog(
                null,
                "Selecione uma opção:",
                "Opções",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[] { "Inserir", "Alterar", "Remover", "Listar", "Voltar" },
                null
            );

            switch ( option )
            {
                case 0:
                    this.addDevice();
                    break;
                case 1:
                    this.updateDevice();
                    break;
                case 2:
                    this.deleteDevice();
                    break;
                case 3:
                    this.showDevices();
                    break;
                default:
                    return;
            }
        }
    }

    private void addDevice()
    {
        String mark   = JOptionPane.showInputDialog("Marca:");
        String model  = JOptionPane.showInputDialog("Modelo:");
        String system = JOptionPane.showInputDialog("S.O.:");
        double screen = Double.parseDouble(
            JOptionPane.showInputDialog("Tam. da tela:")
        );

        int ram = Integer.parseInt(JOptionPane.showInputDialog("RAM(GB):"));
        int rom = Integer.parseInt(JOptionPane.showInputDialog("ROM(GB):"));

        Object defect = JOptionPane.showInputDialog(
            null,
            "Tipo de Problema:",
            "Descrição",
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] { "Hardware", "Software" },
            null
        );

        Object type = JOptionPane.showInputDialog(
            null,
            "Tipo de Aparelho:",
            null,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] { "Celular", "Notebook" },
            null
        );
    }
    
    private void updateDevice()
    {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do aparelho:"));

        if ( ! new DevicesRepository().exists(id) )
        {
            JOptionPane.showMessageDialog(null, "ID não encontrado.");

            return;
        }

        Device tmp = new DevicesRepository().findByID(id);
        
        Object input = JOptionPane.showInputDialog(
            null,
            "Escolha o tipo de dado:",
            "Opções",
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] { "Marca", "Modelo", "S.O.", "RAM", "ROM", "Tela", "Defeito" },
            null
        );

        switch ( input.toString() )
        {
            case "Marca":
                tmp.setMark(JOptionPane.showInputDialog("Nova Marca:"));
                break;
            case "Modelo":
                tmp.setModel(JOptionPane.showInputDialog("Novo Modelo:"));
                break;
            case "S.O.":
                tmp.setSO(JOptionPane.showInputDialog("Novo S.O.:"));
                break;
            case "RAM":
                tmp.setRAM(Integer.parseInt(JOptionPane.showInputDialog("Nova RAM:")));
                break;
            case "ROM":
                tmp.setROM(Integer.parseInt(JOptionPane.showInputDialog("Nova ROM:")));
                break;
            case "Tela":
                tmp.setScreenSize(Float.parseFloat(JOptionPane.showInputDialog("Novo tam. de tela:")));
                break;
            case "Defeito":
                Object defect = JOptionPane.showInputDialog(
                    null,
                    "Novo defeito:",
                    "Tipo de Problema",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[] { "Hardware", "Software" },
                    null
                );
                
                tmp.setDefect(defect.toString());
        }
    }

    private void deleteDevice()
    {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do aparelho:"));

        if ( ! new DevicesRepository().exists(id) )
        {
            JOptionPane.showMessageDialog(null, "Aparelho não encontrado.");

            return;
        }

        new DevicesRepository().remove(id);

        JOptionPane.showMessageDialog(null, "Aparelho removido.");
    }

    private void showDevices()
    {
        String msg = new DevicesRepository().toString();
        
        JOptionPane.showMessageDialog(null, msg, "Aparelhos cadastrados", JOptionPane.INFORMATION_MESSAGE);
    }
}