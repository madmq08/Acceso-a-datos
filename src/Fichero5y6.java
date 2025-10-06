import java.io.File;
import java.io.IOException;

public class Fichero5y6 {
    public static void main(String[] args) throws IOException {
        // Rutas de archivo y directorio como cadena de texto
        String directorio = "C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java\\Padre";
        String archivo = "C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java\\Hijo.txt";

        // Crear instancias file utilizando su constructor
        File directorioPadre = new File(directorio);
        File archivoHijo = new File(archivo);

        // Verificar si el archivo y directorio existen
        boolean fin = false;

        do {
            if (!directorioPadre.exists()) {
                System.out.println("El directorio no existe. ");
                directorioPadre.mkdir();
                System.out.println("El directorio se ha creado correctamente. ");
            } else if (!archivoHijo.exists()) {
                System.out.println("El archivo no existe. ");
                archivoHijo.createNewFile();
                System.out.println("El archivo se ha creado correctamente. ");
            } else {
                System.out.println("El directorio y el archivo ya existen. ");
                fin = true;
            }
        } while (!fin);
    }
}
