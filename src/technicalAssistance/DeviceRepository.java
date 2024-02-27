package technicalAssistance;

import java.io.*;
import java.util.*;

/**
 *
 *
 */
public class DeviceRepository implements Serializable
{

    private final Map<Integer, Device> defectives;

    public DeviceRepository()
    {
        this.defectives = new HashMap<>();
    }

    public void addDevice(int id, Device device)
    {
        this.defectives.put(id, device);
    }

    public Device edicao(int id)
    {
        return this.defectives.get(id);
    }

    public boolean existe(int id)
    {
        return this.defectives.containsKey(id);
    }

    public void remover(int id)
    {
        this.defectives.remove(id);
    }

    public String exibir()
    {
        if ( ! this.defectives.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();
            
            this.defectives.keySet().forEach((ID) ->
            {
                msg.append(this.defectives.get(ID).getEspecificacoes());
            });
            return msg.toString();
        }
        return "Manutenção Vazia";
    }
}