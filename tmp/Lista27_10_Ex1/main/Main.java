package main;

/**
 *
 */
public class Main
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Person pessoa1 = new Person("João", "01/11/1970", 1.80f);
        Person pessoa2 = new Person();
        pessoa1.imprimeDados();

        pessoa2.setAltura(1.75f);
        pessoa2.setData_nasc("03/09/1995");
        pessoa2.setNome("Maria");

        pessoa2.imprimeDados();
    }

}
