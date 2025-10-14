import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;



/*Ejercicio 9: Asistente personal de archivos
Menú principal con opciones:
    Verificar archivo
    Explorar carpeta
    Crear carpeta
    Crear archivo
    Trabajar con URIs
    Salir
Funciones principales: mostrarMenu(), verificarArchivo(), explorarDirectorio(), crearCarpeta(), crearArchivo(), trabajarConURI().
Requisitos: cada función independiente, uso de Scanner, switch, do-while, manejo de errores.*/

public class Fichero9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    verificarArchivo(sc);
                    break;

                case 2:
                    explorarCarpeta(sc);
                    break;

                case 3:
                    crearCarpeta(sc);
                    break;

                case 4:
                    crearArchivo(sc);
                    break;

                case 5:
                    trabajarConURI(sc);
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida, intenta de nuevo.");
            }
        } while (opcion !=6);

        sc.close();
    }

    public static void mostrarMenu(){
        System.out.println("=== ASISTENTE PERSONAL DE ARCHIVOS ===");
        System.out.println("1. Verificar archivo");
        System.out.println("2. Explorar carpeta");
        System.out.println("3. Crear carpeta");
        System.out.println("4. Crear archivo");
        System.out.println("5. Trabajar con URI");
        System.out.println("6. Salir");
    }

    public static void verificarArchivo(Scanner sc){
        System.out.println("Introduce la ruta del archivo");
        String ruta = sc.nextLine();
        File archivo = new File(ruta);

        if (archivo.exists()) {
            System.out.println("El archivo existe, su nombre es: " + archivo.getName() + " su ruta absoluta es: " + archivo.getAbsolutePath() + ", y su tamaño es de: " + archivo.length() + " bytes");
        } else {
            System.out.println("El archivo no existe");
        }
    }

    public static void explorarCarpeta(Scanner sc){
        System.out.print("Introduce la ruta de la carpeta");
        String ruta = sc.nextLine();
        File carpeta = new File(ruta);

        if (carpeta.exists() && carpeta.isDirectory()) {
            String[] archivos = carpeta.list();
            System.out.println("Contenido de la carpeta: ");
            for (String nombre : archivos) {
                System.out.println("- " + nombre);
            }
        } else {
            System.out.println("La ruta no es válida.");
        }
    }

    public static void crearCarpeta(Scanner sc){
        System.out.print("Escribe la ruta donde quiere crear la carpeta: ");
        String rutaCarpeta = sc.nextLine();

        System.out.print("Introduce el nombre de la carpeta que quiere crear: ");
        String nombreCarpeta = sc.nextLine();

        File carpeta = new File (rutaCarpeta, nombreCarpeta);

        if (carpeta.exists()) {
            System.out.println("La carpeta ya existe maquina. ");
        } else if (carpeta.mkdirs()) {
            System.out.println("Carpeta creada con exito en: " + carpeta.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear la carpeta. ");
        }
    }

    public static void crearArchivo(Scanner sc){
        System.out.print("Escribe la ruta donde quiere crear el archivo: ");
        String rutaArchivo = sc.nextLine();

        System.out.print("Introduce el nombre del nuevo archivo: ");
        String nombreArchivo = sc.nextLine();

        File archivo = new File(rutaArchivo, nombreArchivo);

        if(archivo.exists()){
            System.out.println("El archivo ya existe inutil. ");
        } else {
            try {
                if (archivo.createNewFile()){
                    System.out.println("Archivo creado con exito en: " + archivo.getAbsolutePath());

                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo.");
            }
        }
    }

    public static void trabajarConURI(Scanner sc){
        System.out.print("Introduce una URI valida: ");
        String textoUri = sc.nextLine();

        try {
            URI uri = new URI(textoUri);
            File archivo = new File(uri);

            if(archivo.exists()){
                System.out.println("El archivo referenciado por la URI existe.");
                System.out.println("Ruta: " + archivo.getAbsolutePath());
            } else {
                System.out.println("El archivo no existe en la URI dada. ");
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}