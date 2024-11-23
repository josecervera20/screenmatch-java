import modelo.Pelicula;
import modelo.Serie;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private Pelicula peliculaUsuario = new Pelicula();
    private Serie serieUsuario = new Serie();

    public void muestraElMenu() {
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);

        while (opcion != 9) {
            System.out.println("""
                    ===================================
                    ¡Bienvenido(a) a Screenmatch!
                    Selecciona una opción del menú:
                    1) Registrar nueva película
                    2) Registrar nueva serie
                    9) Salir del programa
                    ===================================
                    """);

            System.out.print("Tu opción: ");
            try {
                opcion = teclado.nextInt();
                teclado.nextLine(); // Limpieza de buffer

                switch (opcion) {
                    case 1 -> registrarPelicula(teclado);
                    case 2 -> registrarSerie(teclado);
                    case 9 -> System.out.println("Gracias por usar Screenmatch. ¡Hasta la próxima!");
                    default -> System.out.println("⚠️ Opción no válida. Por favor selecciona una opción del menú.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida. Por favor, ingresa un número del menú.");
                teclado.nextLine(); // Limpieza de buffer tras error
            }
        }
    }

    private void registrarPelicula(Scanner teclado) {
        System.out.println("\n---- Registro de Nueva Película ----");

        System.out.print("Ingrese el nombre de la película: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingrese el año de lanzamiento de la película: ");
        int fechaDeLanzamiento = obtenerEntradaNumerica(teclado);

        System.out.print("Ingrese la duración en minutos de la película: ");
        int duracionEnMinutos = obtenerEntradaNumerica(teclado);

        peliculaUsuario.setNombre(nombre);
        peliculaUsuario.setFechaDeLanzamiento(fechaDeLanzamiento);
        peliculaUsuario.setTiempoDeDuracionEnMinutos(duracionEnMinutos);

        System.out.println("\n✅ Película registrada con éxito:");
        peliculaUsuario.muestraFichaTecnica();
    }

    private void registrarSerie(Scanner teclado) {
        System.out.println("\n---- Registro de Nueva Serie ----");

        System.out.print("Ingrese el nombre de la serie: ");
        String nombreSerie = teclado.nextLine();

        System.out.print("Ingrese el año de lanzamiento de la serie: ");
        int fechaDeLanzamientoSerie = obtenerEntradaNumerica(teclado);

        System.out.print("Por favor, ingresa el número de temporadas para esta serie: ");
        int temporadas = obtenerEntradaNumerica(teclado);

        System.out.print("Por favor, ingresa la cantidad de episodios por temporada: ");
        int episodiosPorTemporada = obtenerEntradaNumerica(teclado);

        System.out.print("Por favor, ingresa la duración en minutos de cada episodio: ");
        int minutosPorEpisodio = obtenerEntradaNumerica(teclado);

        serieUsuario.setNombre(nombreSerie);
        serieUsuario.setFechaDeLanzamiento(fechaDeLanzamientoSerie);
        serieUsuario.setTemporadas(temporadas);
        serieUsuario.setEpisodiosPorTemporada(episodiosPorTemporada);
        serieUsuario.setDuracionEnMinutosPorEpisodio(minutosPorEpisodio);

        System.out.println("\n✅ Serie registrada con éxito:");
        serieUsuario.muestraFichaTecnica();
    }

    private int obtenerEntradaNumerica(Scanner teclado) {
        while (true) {
            try {
                return teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("❌ Entrada inválida. Por favor, ingresa un número válido: ");
                teclado.nextLine(); // Limpieza de buffer
            }
        }
    }

    public static void main(String[] args) {
        new Principal().muestraElMenu();
    }
}
