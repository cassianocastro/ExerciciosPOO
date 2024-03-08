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
                "Choose an option:",
                "Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[] { "Add", "Update", "Delete", "Show", "Back" },
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
        String mark   = JOptionPane.showInputDialog("Mark:");
        String model  = JOptionPane.showInputDialog("Model:");
        String system = JOptionPane.showInputDialog("S.O.:");
        double screen = Double.parseDouble(
            JOptionPane.showInputDialog("Screen size:")
        );

        int ram = Integer.parseInt(JOptionPane.showInputDialog("RAM(GB):"));
        int rom = Integer.parseInt(JOptionPane.showInputDialog("ROM(GB):"));

        Object defect = JOptionPane.showInputDialog(
            null,
            "Defect\'s type:",
            "Description",
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] { "Hardware", "Software" },
            null
        );

        Object type = JOptionPane.showInputDialog(
            null,
            "Device\'s type:",
            null,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] { "Celular", "Notebook" },
            null
        );
    }
    
    private void updateDevice()
    {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Device\'s ID:"));

        if ( ! new DevicesRepository().exists(id) )
        {
            JOptionPane.showMessageDialog(null, "ID not found.");

            return;
        }

        Device tmp = new DevicesRepository().findByID(id);
        
        Object input = JOptionPane.showInputDialog(
            null,
            "Choose the data type:",
            "Options",
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] { "Mark", "Model", "S.O.", "RAM", "ROM", "Screen", "Defect" },
            null
        );

        switch ( input.toString() )
        {
            case "Mark":
                tmp.setMark(JOptionPane.showInputDialog("New mark:"));
                break;
            case "Model":
                tmp.setModel(JOptionPane.showInputDialog("New model:"));
                break;
            case "S.O.":
                tmp.setSO(JOptionPane.showInputDialog("New system:"));
                break;
            case "RAM":
                tmp.setRAM(Integer.parseInt(JOptionPane.showInputDialog("New RAM memory:")));
                break;
            case "ROM":
                tmp.setROM(Integer.parseInt(JOptionPane.showInputDialog("New ROM memory:")));
                break;
            case "Screen":
                tmp.setScreenSize(Float.parseFloat(JOptionPane.showInputDialog("New screen size:")));
                break;
            case "Defect":
                Object defect = JOptionPane.showInputDialog(
                    null,
                    "New defect:",
                    "Defect\'s type",
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
        int id = Integer.parseInt(JOptionPane.showInputDialog("Device\'s ID:"));

        if ( ! new DevicesRepository().exists(id) )
        {
            JOptionPane.showMessageDialog(null, "Device not found.");

            return;
        }

        new DevicesRepository().remove(id);

        JOptionPane.showMessageDialog(null, "Device removed.");
    }

    private void showDevices()
    {
        String msg = new DevicesRepository().toString();
        
        JOptionPane.showMessageDialog(null, msg, "Registered devices", JOptionPane.INFORMATION_MESSAGE);
    }
}