package model.interfaces;

import model.entities.Conta;

public interface InterfaceConta {

    void depositar(double valor);

    void sacar(double valor);

    void transferencia(double valor, Conta contaDestino);

}
