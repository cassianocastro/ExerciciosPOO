package technicalAssistance;

import java.io.Serializable;
import java.text.*;
import java.util.*;

/**
 *
 *
 */
public class Client implements Serializable, Comparable<Client>
{

    private final String name;
    private final String cpf;
    private final String email;
    private final String phone;
    private final Date birthDate;
    private Device device;

    public Client(String name, String cpf, String email, String phone, String birthDate) throws ParseException
    {
        this.name      = name;
        this.cpf       = cpf;
        this.email     = email;
        this.phone     = phone;
        this.birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
    }

    @Override
    public int compareTo(Client other)
    {
        return this.cpf.compareTo(other.cpf);
    }

    public String exibir()
    {
        return "\nNome: " + this.name
            + "\nCPF: " + this.cpf
            + "\nData de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy").format(this.birthDate)
            + "\nE-mail: " + this.email
            + "\nTelefone: " + this.phone
            + "\nID do Aparelho: " + this.device.getID();
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
}