package application;

import model.entities.Cliente;
import model.entities.Conta;
import model.entities.ContaCorrente;
import model.entities.ContaPoupanca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Banco {
    public static void main(String[] args) {
        System.out.println();
        final DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Cliente mateus = new Cliente("Mateus", "000.111.222-33", "Rua Brasil 55", "+55 21 90011-2233", "mateus@gmail.com", LocalDate.from(dataFormatada.parse("01/01/2000")));
        Conta ccMateus = new ContaCorrente(mateus);

        ccMateus.depositar(2000);
        System.out.println(ccMateus.toString());
        ccMateus.depositar(-1);
        ccMateus.sacar(-12);
        ccMateus.sacar(5000);
        System.out.println();

        Cliente julia = new Cliente("Júlia", "111.222.333-44", "Rua Uruguai 11", "+55 21 91122-3344", "julia@gmail.com", LocalDate.from(dataFormatada.parse("02/02/2001")));
        Conta ppJulia = new ContaPoupanca(julia);
        ppJulia.depositar(2500);
        System.out.println(ppJulia.toString());
        ppJulia.depositar(-50);
        ppJulia.sacar(-26);
        ppJulia.sacar(8000);

        ccMateus.transferencia(200, ppJulia);
        System.out.println();

        System.out.println("--- Contas atualizadas ---");
        System.out.println(ccMateus);
        System.out.println(ppJulia);






    }
}
