import java.io.IOException;
import java.util.Scanner;
import java.io.File;

/*
Función organizarBiblioteca(): crea carpeta de categoría y archivo catalogo.txt.
Función verificarLibro(): verifica si existe un libro; si no, pregunta si se crea.
Practica: exists(), mkdir(), createNewFile(), funciones separadas.
 */
public class Fichero7 {
    public static void main(String[] args) throws IOException {
        // Primero declaramos la ruta y el escáner
        Scanner sc = new Scanner(System.in);
        File ruta = new File("C:\\Users\\AlumnoAfternoon\\Documents\\Pruebas Java\\Biblioteca");
        organizarBibilioteca(ruta, sc);

    }
    // Ahora declaro la funcion void porque no va a devolver nada y de paso las variables que necesita la función
    public static void organizarBibilioteca(File ruta, Scanner sc) throws IOException {
        // Necesito un print para que el usuario me de categoría y lo recojo con scanner.
        System.out.print("Escribe el nombre de la categoria: ");
        String categoria = sc.nextLine();
        // Creo la nueva ruta que es la que voy a comprobar si existe o no, esta ruta contiene la ruta inicial + la categoría que el usuario ha introducido en el scanner
        File rutaCategoria = new File(ruta, categoria);
        // Creo una nueva ruta y cambia con "" porque no voy a crear una carpeta, es un archivo de texto
        File rutaCatalogo = new File(rutaCategoria, "catalogo.txt");
        // Ahora compruebo si la ruta de la categoría existe, y si no, la creo
        if (rutaCategoria.exists()){
            System.out.println("La ruta existe: " + rutaCategoria.getAbsolutePath() + ", por lo tanto, no se puede crear.");
        } else {
            rutaCategoria.mkdir();
            System.out.println("La categoria se ha ingresado correctamente: " + rutaCategoria.getAbsolutePath());
        }
        // Ahora compruebo si la ruta catalogo existe, y si no, la creo
        if (rutaCatalogo.exists()){
            System.out.println("La ruta existe: " + rutaCatalogo.getAbsolutePath() + ",por lo tanto, no se puede crear.");
        }
        else{
            rutaCatalogo.createNewFile();
            System.out.println("El archivo " + rutaCatalogo.getAbsolutePath() + " se ha creado correctamente.");
        }
        // Llama a verificarLibro desde esta función porque necesita variables de esta
        verificarLibro(rutaCategoria, sc);
    }
    // Declarar la funcion void porque no devuelve nada y las variables que necesita
    public static void verificarLibro(File rutaCategoria, Scanner sc) throws IOException {
        // Pido el nombre del libro y lo mete en una variable con el sc
        System.out.print("Escribe el nombre del libro: ");
        String libro = sc.nextLine();
        // Crea una nueva ruta entre rutaCategoria y libro
        File rutaLibro = new File(rutaCategoria, libro);
        // Verifica si existe y si no pregunta si lo quiere crear, recogiendolo en sc
        if (rutaLibro.exists()){
            System.out.println("El libro ya existe: " + rutaLibro.getAbsolutePath());
        } else {
            System.out.print("Quiere crear el libro? (si o no): ");
            String respuesta = sc.nextLine();
            // if dentro de if porque hay mas de 2 respuestas, equals se utiliza para string
            if (respuesta.equals("si")) {
                rutaLibro.createNewFile();
                System.out.println("El libro se ha creado correctamente. " + rutaLibro.getAbsolutePath());
            } else if (respuesta.equals("no")) {
                System.out.println("El libro no se ha creado");

            } else {
                System.out.println("Te he dicho que pongas si o no...");
            }
        }


    }


}