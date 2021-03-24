package java8;

import java8.method.Operation;
import java8.method.OperationImpl;
import java8.stream.Cliente;
import java8.stream.NumberStream;

import java.util.List;

public class ExecutorJava8 {

    public static void execute() {

        //Implementação de métodos dentro de interfaces
        System.out.println("[Método implementado na interface] - Soma de 2 + 5 é: " + Operation.somar(2,5));
        System.out.println("[Método implementado na interface] - Multiplicação de 5x9 é: " + Operation.multiplicar(5, 9));
        System.out.println("[Default Method] - Subtração de 8-6 é: " + new OperationImpl().subtrair(8, 6));
        System.out.println("[Método implementado pela classe] - Divisão de 21/3 é: " + new OperationImpl().dividir(21, 3));

        Cliente eduardo = new Cliente("Eduardo", 38);
        Cliente roberto = new Cliente("Roberto", 62);

        //Stream
        NumberStream.filter(List.of("abc", "defgh", "pqrstuv"));
        NumberStream.map(List.of(eduardo, roberto));
        NumberStream.reduce(List.of(eduardo, roberto));
        NumberStream.anyMatch(List.of(eduardo, roberto));
        NumberStream.average(List.of(eduardo, roberto));
    }
}
