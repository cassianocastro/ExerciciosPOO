package technicalAssistance;

import java.io.Serializable;

/**
 *
 */
public class Notebook extends Device implements Serializable
{

    public Notebook(String mark, String model, String so, String defect,
                    int id, int ram, int rom, float screenSize)
    {
        super(mark, model, so, defect, id, ram, rom, screenSize);
    }
}