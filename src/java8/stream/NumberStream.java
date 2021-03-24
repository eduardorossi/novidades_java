package java8.stream;

import java.util.List;

public class NumberStream {

    //Filtrando as palavras que contém mais de 6 caracteres e imprimi quais são elas
    public static void filter(List<String> palavras) {
        palavras.stream().filter(palavra -> palavra.length() < 6).forEach(p -> {
            System.out.println("Palavra: " + p);
        });
    }

    //Mapeia a lista de cliente pegando apenas o nome dele e imprimi quais são eles
    public static void map(List<Cliente> clientes) {
        clientes.stream().map(Cliente::getNome).forEach(cliente -> {
            System.out.println("Nome do cliente: " + cliente);
        });
    }

    //Pelo campo idade da lista de cliente é feito a redução dos valores e devolve o valor máximo
    //Foi usado também referece method: Cliente::getIdade
    public static void reduce(List<Cliente> clientes) {
        System.out.println("Valor máximo: " + clientes.stream().map(Cliente::getIdade).reduce(0, Integer::max));
    }

    //O anyMatch verifica se dado uma comparação, ele retorna true ou false
    public static void anyMatch(List<Cliente> clientes) {
        System.out.println("Tem o nome Eduardo? " + clientes.stream().anyMatch(cliente -> cliente.getNome().equals("Eduardo")));
        System.out.println("Tem o nome Roberto? " + clientes.stream().anyMatch(cliente -> cliente.getNome().equals("Rossi")));
    }

    //Pelo campo idade da lista de cliente é feito a média dos valores
    public static void average(List<Cliente> clientes) {
        System.out.println("Média da idade: " + clientes.stream().mapToInt(Cliente::getIdade).average().getAsDouble());
    }
}
