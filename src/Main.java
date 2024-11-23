import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a la inmersión en Java!");

        // Declaración de variables
        int fechaDeLanzamiento = 2016;
        double evaluacion = 4.8;
        boolean incluidoEnElPlanBasico = true;
        String nombre = "Zootopia";
        String sinopsis = """
                Una divertida aventura en la que una conejita policía y un astuto zorro se unen
                para resolver un gran misterio en la ciudad de los animales.
                """;
        double mediaEvaluacionUsuario = 0;

        // Mostrar detalles de la película
        System.out.println("\n--- Detalles de la Película ---");
        System.out.println("Película: " + nombre);
        System.out.println("Año de lanzamiento: " + fechaDeLanzamiento);
        System.out.println("Evaluación promedio: " + evaluacion + " estrellas");
        System.out.println("Disponible en el plan básico: " + (incluidoEnElPlanBasico ? "Sí" : "No"));
        System.out.println("Sinopsis: " + sinopsis);

        // Cálculo de la media de evaluaciones predefinidas
        double mediaEvaluacion = (4.5 + 4.8 + 5.0) / 3;
        System.out.printf("Media de evaluación predefinida: %.2f estrellas%n", mediaEvaluacion);

        // Clasificación según el año de lanzamiento
        if (fechaDeLanzamiento >= 2024) {
            System.out.println("¡Es una película popular en este momento!");
        } else {
            System.out.println("Un clásico moderno que no te puedes perder.");
        }

        // Solicitar evaluaciones al usuario
        System.out.println("\n--- ¡Queremos saber tu opinión! ---");
        Scanner teclado = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.print("Ingresa la calificación #" + i + " para " + nombre + " (de 1 a 5): ");
            double nota = teclado.nextDouble();

            // Validar que la nota esté en el rango correcto
            while (nota < 1 || nota > 5) {
                System.out.print("Por favor, ingresa una calificación válida (de 1 a 5): ");
                nota = teclado.nextDouble();
            }

            mediaEvaluacionUsuario += nota;
        }

        teclado.close();

        // Mostrar media de las evaluaciones del usuario
        System.out.printf("La media de calificaciones para %s según tu opinión es: %.2f estrellas%n",
                nombre, mediaEvaluacionUsuario / 3);
        System.out.println("¡Gracias por participar!");
    }
}
