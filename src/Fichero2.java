import java.io.File;

public class Fichero2 {
    public static void main(String[] args) {
        // Directorio padre que acabamos de crear
        File ruta = new File("C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java");

        // Verificar si el archivo existe
        if (ruta.exists()) {
            // Verificar si la ruta especificada es un directorio 
            if (ruta.isDirectory()) {
                // Si en la ruta el ultimo elemento es un directorio me muestra un mensaje en pantalla
                // de que la ruta especificada es un directorio
                System.out.println("La ruta presenta un directorio en: " +  ruta.getAbsolutePath());
            } else if(ruta.isFile()) { //verifica si la ruta especificada es un archivo
                // Si en la ruta el ultimo elemento es un archivo se muestra un menesaje en pantalla
                // de que la ruta especificada es un archivo
                System.out.println("La ruta presenta un archivo en: " + ruta.getAbsolutePath());
            }
                
        }
    }
}
