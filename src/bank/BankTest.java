package bank;

import javax.swing.JOptionPane;

/**
 *
 */
public class BankTest
{

    private static final Bank banco = new Bank();

    private void testAddAccount()
    {
        Account conta;
        int num_conta   = Integer.parseInt(JOptionPane.showInputDialog("Nº da conta:"));
        int num_agencia = Integer.parseInt(JOptionPane.showInputDialog("Nº da agência:"));
        String senha    = JOptionPane.showInputDialog("Senha:");
        String saldo    = JOptionPane.showInputDialog("Saldo inicial:");

        int retorno = JOptionPane.showOptionDialog(
            null,
            "Escolha uma opção:",
            "Tipo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[]
            {
                "Poupança", "Salário", "Corrente Jurídica", "Corrente Física"
            },
            null
        );

        switch ( retorno )
        {
            case 0:
                conta = new SavingsAccount(num_conta, num_agencia, senha, saldo, "0.09");
                break;
            case 1:
                conta = new SalaryAccount(num_conta, num_agencia, senha, saldo, "0.0");
                break;
            case 2:
                conta = new CurrentJuridicalPerson(num_conta, num_agencia, senha, saldo, "0.035");
                break;
            default:
                conta = new CurrentPhysicalPerson(num_conta, num_agencia, senha, saldo, "0.05");
        }

        banco.add(conta);

        JOptionPane.showMessageDialog(null, "Conta criada.");
    }

    private void testShowMenu(Account conta)
    {
        int retorno;
        String valor;

        while ( true )
        {
            retorno = JOptionPane.showOptionDialog(
                null,
                "Escolha a opção:",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]
                {
                    "Saque", "Depósito", "Informações", "Voltar"
                },
                null
            );

            switch ( retorno )
            {
                case 0:
                    valor = JOptionPane.showInputDialog("Informe o Valor:");
                    conta.sacar(valor);
                    break;
                case 1:
                    valor = JOptionPane.showInputDialog("Informe o Valor:");
                    conta.depositar(valor);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, conta.getDados());
                    break;
                default:
                    return;
            }

            JOptionPane.showMessageDialog(null, "Operação realizada.");
        }
    }

    public void test()
    {
        int retorno;
        String senha;

        while ( true )
        {
            retorno = JOptionPane.showOptionDialog(
                null,
                "Seja bem-vindo.",
                "Olá",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]
                {
                    "Nova conta", "Já sou cliente", "Exibir Contas",
                    "Encerrar Conta", "Aplicar Correções", "Sair"
                },
                null
            );

            switch ( retorno )
            {
                case 0:
                    testAddAccount();
                    break;
                case 1:
                    senha = JOptionPane.showInputDialog("Senha da conta:");
                    Account conta = banco.existe(senha);

                    if ( conta != null )
                    {
                        testShowMenu(conta);
                    }
					else
                    {
                        JOptionPane.showMessageDialog(
                            null,
                            "Conta não encontrada.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                    break;
                case 2:
                    String msg = banco.exibir();

                    JOptionPane.showMessageDialog(
                        null,
                        msg != null ? msg : "Sem contas cadastradas."
                    );
                    break;
                case 3:
                    senha = JOptionPane.showInputDialog("Senha da conta:");

                    JOptionPane.showMessageDialog(
                        null,
                        banco.remove(senha) ? "Conta encerrada." : "Conta não encontrada."
                    );
                    break;
                case 4:
                    banco.corrigir();

                    JOptionPane.showMessageDialog(null, "Correções aplicadas.");
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}