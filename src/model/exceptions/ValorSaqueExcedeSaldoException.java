package model.exceptions;

public class ValorSaqueExcedeSaldoException extends RuntimeException{
    public ValorSaqueExcedeSaldoException(String mensagem) {
        super(mensagem);
    }
}
