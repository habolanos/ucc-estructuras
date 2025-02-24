import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
 
public class PgmAlgoritmoO1 {
    public static int obtenerPrimerElemento(int[] arr) {
        return arr[0];
    }
 
    public static void encabezadoPgm(){
         // Datos del encabezado
        String nombre = "Harold Adrian"; // Reemplaza con tu nombre
        String campus = "Campus Cali, U. Cooperativa de Colombia"; // Reemplaza con el nombre de tu campus
        String repositorioGit = "https://github.com/habolanos/ucc-estructuras/blob/master/sesion04/ejercicios/1-algoritmo-O1/PgmAlgoritmoO1.java"; // Reemplaza con la URL de tu repositorio Git

        // Obtener la fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHora = ahora.format(formateador);

        // Imprimir el encabezado
        System.out.println("----------------------------------------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Campus: " + campus);
        System.out.println("Fecha y hora: " + fechaHora);
        System.out.println("Repositorio Git: " + repositorioGit);
        System.out.println("----------------------------------------");
        System.out.println(); // Línea en blanco para separar el encabezado de los datos
    }

    public static void main(String[] args) {
        encabezadoPgm();

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño del array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
 
        System.out.println("Ingrese los elementos del array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
 
        System.out.println("El primer elemento del array es: " + obtenerPrimerElemento(arr));
    }
}
