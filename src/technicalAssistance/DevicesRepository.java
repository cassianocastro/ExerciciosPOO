package technicalAssistance;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class DevicesRepository implements Serializable
{

    private final Map<Integer, Device> devices;

    public DevicesRepository()
    {
        this.devices = new HashMap<>();
    }

    public void add(int id, Device device)
    {
        this.devices.put(id, device);
    }
    
    public void remove(int id)
    {
        this.devices.remove(id);
    }
    
    public boolean exists(int id)
    {
        return this.devices.containsKey(id);
    }

    public Device findByID(int id)
    {
        return this.devices.get(id);
    }

    @Override
    public String toString()
    {
        if ( ! this.devices.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();

            this.devices.keySet().forEach((ID) ->
            {
                msg.append(this.devices.get(ID).toString());
            });

            return msg.toString();
        }

        return "Manutenção Vazia";
    }
}