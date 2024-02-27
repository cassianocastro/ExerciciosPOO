package technicalAssistance;

import java.io.Serializable;

/**
 *
 *
 */
public class Cell extends Device implements Serializable
{

    public Cell(String mark, String model, String so, String defect,
                   int id, int ram, int rom, float screenSize)
    {
        super(mark, model, so, defect, id, ram, rom, screenSize);
    }
}