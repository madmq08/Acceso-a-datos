import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class Fichero3 {
    public static void main(String[] args) {
        // Utilizamos try catch porque el objeto URI tiende a dar errores al trabajar con este
        try {
            // Crear un objeto URI a partir de una cadena de texto
            String uriString = "C:/Users/AlumnoAfternoon/Documents/Pruebas Java";
            URI uri = new URI(uriString);
            // Crear una instancia en File utilizando el constructor
            File ruta = new File(uri);
            // Verificar si el archivo o directorio existe
            if (ruta.exists()) {
                if (ruta.isDirectory()) {
                    // Si en la ruta el ultimo elemento es un directorio me muestra un mensaje en pantalla
                    // de que la ruta especificada es un directorio
                    System.out.println("La ruta presenta un directorio en: " + uri.toString());
                } else if (ruta.isFile()) { // Verifica si la ruta especificada es un archivo
                    // Si en la ruta el ultimo elemento es un archivo se muestra un menesaje en pantalla
                    // de que las ruta especificada es un archivo
                    System.out.println("La ruta presenta un archivo en: " + uri.toString());
                }
            } else  {
                System.out.println("La URI no existe " + uri.toString());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
