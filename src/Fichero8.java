import java.io.File;
import java.net.URI;
import java.util.Scanner;

/* Función explorarCarpeta(String ruta): lista contenido.
Función analizarElemento(String ruta): muestra si es archivo (con tamaño) o carpeta (con número de elementos).
Función convertirAURI(String ruta): convierte ruta a URI.
Practica: list(), isFile(), isDirectory(), toURI().*/

public class Fichero8 {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    explorarCarpeta(sc);

    }

    public static void explorarCarpeta(Scanner sc){
        System.out.print("Introduzca una ruta valida a explorar: ");
        String ruta = sc.nextLine();

        // Convertimos de string a File, porque para exists y mas cosas necesitamos file
        File rutaExplora = new File(ruta);
        // If para comprobar si existe
        if (rutaExplora.exists()) {
            System.out.println("Explorando: " + ruta);
            // Hacemos un bucle tipo for each, .list() nos creará una lista con el nombre de archivos y carpetas del directorio ruta.Explora, guardaremos el valor de
            //cada línea en una variable, ese valor cambiará según se recorra el bucle, cada vez que se recorre el valor será la siguiente línea de la lista
            for (String valorDentroLista : rutaExplora.list()) {
                File fileDentroLista = new File (rutaExplora, valorDentroLista);
                analizarElemento(fileDentroLista);
            }
        } else {
            System.out.println("La ruta no existe: " + ruta);
        }
        convertirAUri(rutaExplora);
    }

    public static void analizarElemento(File fileDentroLista){
        if (fileDentroLista.isFile()) {
            // Transforma archivo a tipo long para decir cuanto pesa
            long size = fileDentroLista.length();
            System.out.println("Es un archivo: " + fileDentroLista + " y ocupa " + size + " bytes");

        } else if(fileDentroLista.isDirectory()) {
            String[] lista = fileDentroLista.list();
            System.out.println("Es un directorio: " + fileDentroLista + ", numero de elementos: " + lista.length);
        } else {
            System.out.println("ERROR, la ruta no contiene ni archivos ni directorios");
        }

    }

    public static void convertirAUri(File rutaExplora){
        URI uri = rutaExplora.toURI();
        System.out.println("El URI de " + rutaExplora + " es: " + uri);


    }
}
