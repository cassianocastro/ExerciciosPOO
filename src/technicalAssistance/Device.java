package technicalAssistance;

import java.io.Serializable;

/**
 *
 */
abstract public class Device implements Serializable, Comparable<Device>
{

    private final int id;
    private String mark;
    private String model;
    private String so;
    private String defect;
    private int ram;
    private int rom;
    private float screenSize;

    public Device(String mark, String model, String so, String defect,
                    int id, int ram, int rom, float screenSize)
    {
        this.id      = id;
        this.mark    = mark;
        this.model   = model;
        this.so      = so;
        this.defect  = defect;
        this.ram     = ram;
        this.rom     = rom;
        this.screenSize = screenSize;
    }
    
    public int getID()
    {
        return this.id;
    }

    public void setMark(String mark)
    {
        this.mark = mark;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public void setSO(String so)
    {
        this.so = so;
    }

    public void setDefect(String defect)
    {
        this.defect = defect;
    }

    public void setRAM(int ram)
    {
        this.ram = ram;
    }

    public void setROM(int rom)
    {
        this.rom = rom;
    }

    public void setScreenSize(float screenSize)
    {
        this.screenSize = screenSize;
    }

    @Override
    public int compareTo(Device other)
    {
        if ( this.id < other.getID() )
        {
            return -1;
        }

        if ( this.id > other.getID() )
        {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString()
    {
        return "\nID do aparelho: " + this.id
            + "\nTipo: " + getClass().getSimpleName()
            + "\nMarca: " + this.mark
            + "\nModelo: " + this.model
            + "\nSistema Operacional: " + this.so
            + "\nDefeito: " + this.defect
            + "\nRAM: " + this.ram + " GB"
            + "\nROM: " + this.rom + " GB"
            + "\nTamanho de tela: " + this.screenSize + "\"";
    }
}