package technicalAssistance;

import java.io.*;
import java.util.*;

/**
 *
 */
public class DevicesRepository implements Serializable
{

    private final Map<Integer, Device> defectives;

    public DevicesRepository()
    {
        this.defectives = new HashMap<>();
    }

    public void add(int id, Device device)
    {
        this.defectives.put(id, device);
    }

    public Device findByID(int id)
    {
        return this.defectives.get(id);
    }

    public boolean exists(int id)
    {
        return this.defectives.containsKey(id);
    }

    public void remove(int id)
    {
        this.defectives.remove(id);
    }

    @Override
    public String toString()
    {
        if ( ! this.defectives.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();

            this.defectives.keySet().forEach((ID) ->
            {
                msg.append(this.defectives.get(ID).toString());
            });

            return msg.toString();
        }

        return "Manutenção Vazia";
    }
}