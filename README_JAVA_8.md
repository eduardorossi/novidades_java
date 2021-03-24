#Java 8

##Principais novidades

###Criação de métodos estáticos dentro de Interface
Podemos criar métodos estáticos em interfaces sem que haja necessidade de implementação dos mesmos por uma classe

Para acessar esse tipo de método é preciso apenas chamar eles pela interface.

###Default Method
Agora é possível criar métodos dentro da interface sem que a classe que a implementa quebre.

Isso é feito usando Default Method

Para acessar esse tipo de método é preciso que a classe que implementa essa interface faça essa chamada.

**Consultar a interface Service**

###Functional Interface
O conceito de interface funcional, é uma interface que declara apenas um método abstrato dentro dela.

A vantagem de usar esse conceito se dá apenas na escrita de código usando lambda, pelo fato do compilador já entender que o lambda irá implementar o único método que essa interface possui.

As interfaces funcionais são anotadas com @FunctionalInterface, contudo, toda interface que contém apenas 1 método abstrato e não tenha essa anotação, o compilador trata como se ela estivesse com essa anotação.

###Lambda
As expressões lambdas permitem tratar funcionalidades como argumento de método, ou código como dados. Os tipos de entrada podem ser inferidos e são opcionais, exemplos:

```java
(int x, int y) -> { return x + y; }

  (x, y) -> x + y

  x -> x * x

  () -> x

  x -> { System.out.println(x); }
```
  
  Runnable r = () -> { System.out.println("Running!"); }

###Referências de métodos
As referências de métodos são expressões lambdas compactas para métodos que já possuem um nome. Aqui estão alguns exemplos de referências de métodos, com o seu equivalente em expressão lambda à direita:

|  Referência de método |Lambda   |
| ------------ | ------------ |
| String::valueOf  | x -> String.valueOf(x)  |
| Object::toString | x -> x.toString()  |
| x::toString  | () -> x.toString()  |
| ArrayList::new  | () -> new ArrayList<>() |

###Stream

As coleções agora possui a funcionalidade de Stream que permite trabalhar de diversas formas com os dados, conforme algumas funções descritas abaixo

####Filter
Com a função filter do stream, é possível filtrar os dados de uma determinada coleção, exemplo:

```java
palavras.stream().filter(s -> s.length() < 6).forEach(System.out::println);
```

No exemplo acima, é realizado um filtro na coleção para retornar apenas as Strings que possuem tamanho inferior a 6 e após isso é feito um forEach imprimindo cada item

####Map
A ideia da função map é realizar um mapeamento de itens, é similar ao filter, porém não é preciso aplicar alguma regra para tal, conforme abaixo:

```java
clientes.stream().map(Cliente::getNome);
```

O map acima varrer a lista de clientes e retorna apenas o nome deles


####Reduce
O reduce combina os elementos de um stream e retorna um único valor

```java
int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int sum = Arrays.stream(numbers).reduce(0, Integer::sum);
```

Aqui, ele realizou a soma de todos os itens do array. Caso o array estivesse vazio, ele retornaria 0, conforme definido no primeiro parâmetro

####AnyMatch
Esta função retorna true se qualquer um dos elementos da stream corresponde ao predicado fornecido.

```java
clientes.stream().anyMatch(c -> c.getNome().equals("Eduardo"));
```

####Average
A função average retorna a média de um conjunto de valores.

```java
clientes.stream().mapToDouble(cliente -> cliente.getLimite().doubleValue()).average().getAsDouble();
```
