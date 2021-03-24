package java8.method;

public interface Operation {

    public static int somar(int x, int y) {
        return x + y;
    }

    public static int multiplicar(int x, int y) {
        return x * y;
    }

    float dividir(int x, int y);

    default int subtrair(int x, int y) {
        return x - y;
    }

}
