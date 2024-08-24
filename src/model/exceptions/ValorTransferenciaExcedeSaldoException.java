package model.exceptions;

public class ValorTransferenciaExcedeSaldoException extends RuntimeException{
    public ValorTransferenciaExcedeSaldoException(String mensagem) {
        super(mensagem);
    }
}
