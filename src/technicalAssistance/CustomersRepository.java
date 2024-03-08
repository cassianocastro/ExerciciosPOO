package technicalAssistance;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 */
public class CustomersRepository implements Serializable
{

    private final Set<Customer> customers;

    public CustomersRepository()
    {
        this.customers = new TreeSet<>();
    }

    public void add(final Customer customer)
    {
        this.customers.add(customer);
    }
    
    public void remove(final Customer customer)
    {
        this.customers.remove(customer);
    }

    public boolean exists(final String cpf)
    {
        for ( final Customer customer : this.customers )
        {
            if ( customer.getCPF().equals(cpf) )
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString()
    {
        if ( ! this.customers.isEmpty() )
        {
            StringBuilder msg = new StringBuilder();

            for ( final Customer customer : this.customers )
            {
                msg.append(customer.toString()).append("\n----");
            }

            return msg.toString();
        }

        return "Fila Vazia";
    }
}