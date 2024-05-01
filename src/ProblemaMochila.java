import java.util.Scanner;

class Objeto {
    String nombre;
    String forma;
    int peso;
    int precio;

    public Objeto(String nombre, String forma, int peso, int precio) {
        this.nombre = nombre;
        this.forma = forma;
        this.peso = peso;
        this.precio = precio;
    }
}

public class ProblemaMochila {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese la capacidad de peso de la mochila: ");
        int capacidadMochila = entrada.nextInt();

        Objeto[] objetos = {
            new Objeto("Libro", "Rectangular", 2, 10),
            new Objeto("Laptop", "Rectangular", 3, 15),
            new Objeto("Botella de agua", "Cilíndrica", 1, 8),
            new Objeto("Camisa", "Plana", 1, 5),
            new Objeto("Zapatillas", "Irregular", 2, 12),
            new Objeto("Cámara", "Rectangular", 3, 20),
            new Objeto("Sunglasses", "Irregular", 1, 7),
            new Objeto("Bolsa", "Irregular", 2, 6),
            new Objeto("Teléfono", "Rectangular", 1, 10),
            new Objeto("Tablet", "Rectangular", 2, 14),
            new Objeto("Cargador", "Irregular", 1, 5),
            new Objeto("Cartera", "Plana", 1, 8),
            new Objeto("Llaves", "Irregular", 1, 3),
            new Objeto("Paraguas", "Irregular", 2, 9),
            new Objeto("Botiquín", "Rectangular", 3, 11)
        };

        int valorMaximo = maximizarValor(objetos, capacidadMochila);

        System.out.println("El valor máximo de la mochila es: " + valorMaximo);
    }

    public static int maximizarValor(Objeto[] objetos, int capacidadMochila) {
        int n = objetos.length;
        int[][] dp = new int[n + 1][capacidadMochila + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacidadMochila; j++) {
                if (objetos[i - 1].peso <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - objetos[i - 1].peso] + objetos[i - 1].precio);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacidadMochila];
    }
}
