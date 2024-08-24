package model.entities;

import model.exceptions.ValorNegativoException;
import model.exceptions.ValorSaqueExcedeSaldoException;
import model.exceptions.ValorTransferenciaExcedeSaldoException;
import model.interfaces.InterfaceConta;

public abstract class Conta implements InterfaceConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = SEQUENCIAL++;
        this.numero = Conta.AGENCIA_PADRAO;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Implementação dos métodos da interface
    @Override
    public void depositar(double valor) {
        try {
            if (valor < 0)
                throw new ValorNegativoException("O valor de depósito não pode ser negativo.");

            this.saldo += valor;
        }
        catch (ValorNegativoException e) {
            System.out.println("Erro ao realizar a operação de depósito: " + e.getMessage());
        }
    }

    @Override
    public void sacar(double valor) {
        try {
            if (valor < 0)
                throw new ValorNegativoException("O valor de saque não pode ser negativo.");

            if (valor > this.saldo)
                throw new ValorSaqueExcedeSaldoException("Saldo insuficiente. O valor do saque excede o saldo disponível na conta.");

            this.saldo -= valor;
        }
        catch (ValorNegativoException | ValorSaqueExcedeSaldoException e) {
            System.out.println("Erro ao realizar a operação de saque: " + e.getMessage());
        }
    }

    @Override
    public void transferencia(double valor, Conta contaDestino) {
        try {
            if (valor < 0)
                throw new ValorNegativoException("O valor de transferência não pode ser negativo.");

            if (valor > this.saldo)
                throw new ValorTransferenciaExcedeSaldoException("Saldo insuficiente. O valor de transferência excede o saldo disponível na conta.");

            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.printf("Transferência realizada com sucesso! Novo saldo da conta de %s: %.2f%n", this.cliente.getNome(), this.getSaldo());

        }
        catch (ValorNegativoException | ValorTransferenciaExcedeSaldoException e) {
            System.out.println("Erro ao realizar a operação de transferência: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("Titular da Conta = %s [Informações Bancárias = Número da conta: %d | Agência: %d | Saldo: %.2f]", cliente, getNumero(), getAgencia(), getSaldo());
    }


    public void imprimirSaldo() {
        System.out.printf("Saldo disponível: %.2f%n", getSaldo());
    }

}
