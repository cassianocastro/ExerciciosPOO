package assistenciatecnica;

import java.io.*;
import java.util.*;

/**
 *
 */
public class RepositorioAparelhos implements Serializable
{

    private final Map<Integer, Aparelho> defeituosos;

    public RepositorioAparelhos()
    {
        this.defeituosos = new HashMap<>();
    }

    public void addAparelho(int ID_informado, Aparelho aparelho)
    {
        this.defeituosos.put(ID_informado, aparelho);
    }

    public Aparelho edicao(int ID)
    {
        return this.defeituosos.get(ID);
    }

    public boolean existe(int ID)
    {
        return this.defeituosos.containsKey(ID);
    }

    public void remover(int ID)
    {
        this.defeituosos.remove(ID);
    }

    public StringBuilder exibir()
    {
        if ( !this.defeituosos.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();
            this.defeituosos.keySet().forEach((ID) ->
            {
                msg.append(this.defeituosos.get(ID).getEspecificacoes());
            });
            return msg;
        }
        return new StringBuilder("Manutenção Vazia");
    }
}
