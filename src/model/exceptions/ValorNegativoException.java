package model.exceptions;

public class ValorNegativoException extends RuntimeException {
    public ValorNegativoException(String mensagem) {
        super(mensagem);
    }
}
