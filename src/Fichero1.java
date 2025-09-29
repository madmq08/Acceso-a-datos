import java.io.File;

public class Fichero1 {
    public static void main(String[] args) {

        // Directorio padre que acabamos de crear
        File dirPadre = new File("C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java");

        //Nombre o ruta relativa al fichero que acabamos de crear
        String nomHijo = "hijo.txt";

        //Creo una instancia File utilizando el constructor y la variable de arriba
        File archivo = new File(dirPadre, nomHijo);

    //Verificar si el archivo existe
    if (archivo.exists()) {
        // Si el archivo existe se muestra un mensaje en pantalla de que existe
        // mostrando la ruta completa especificada
        System.out.println("El archivo existe en la ruta: " + archivo.getAbsolutePath());
    } else  {
        // Si el archivo NO existe se muestra un mensaje de que no existe
        // mostrando la ruta completa especificada
        System.out.println("El archivo no existe en la ruta");
    }
    }
}
