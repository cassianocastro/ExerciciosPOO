package technicalAssistance;

import java.io.Serializable;
import java.text.*;
import java.util.*;

/**
 *
 */
public class Client implements Serializable, Comparable<Client>
{

    private final String name;
    private final String cpf;
    private final String email;
    private final String phone;
    private final Date birthdate;
    private Device device;

    public Client(String name, String cpf, String email, String phone, String birthdate) throws ParseException
    {
        this.name      = name;
        this.cpf       = cpf;
        this.email     = email;
        this.phone     = phone;
        this.birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);
    }

    public Device getDevice()
    {
        return this.device;
    }

    public void setDevice(Device device)
    {
        this.device = device;
    }

    public String getCPF()
    {
        return this.cpf;
    }
    
    @Override
    public int compareTo(Client other)
    {
        return this.cpf.compareTo(other.cpf);
    }
    
    @Override
    public String toString()
    {
        return "\nNome: "              + this.name
            + "\nCPF: "                + this.cpf
            + "\nData de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy").format(this.birthdate)
            + "\nE-mail: "             + this.email
            + "\nTelefone: "           + this.phone
            + "\nID do Aparelho: "     + this.device.getID();
    }
}