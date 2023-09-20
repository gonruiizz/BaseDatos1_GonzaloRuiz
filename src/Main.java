import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        // Añadimos los estudiantes a la lista de Bases de Datos.
        ArrayList<Estudiante> alumnosBD = new ArrayList<>();
        alumnosBD.add(new Estudiante("C2324", "López García", "Luis", "BD-1"));
        alumnosBD.add(new Estudiante("C2327", "García Pérez", "María", "BD-2"));
        alumnosBD.add(new Estudiante("C2328", "Pérez Pérez", "José", "BD-1"));

        // Creamos el archivo de los alumnos de BD.
        crearArchivo(alumnosBD, "Alumnos_BD.ser");

        // Añadimos los estudiantes a la lista de IS.
        ArrayList<Estudiante> alumnosIS = new ArrayList<>();
        alumnosIS.add(new Estudiante("C2324", "López García", "Luis", "IS-1"));
        alumnosIS.add(new Estudiante("C2326", "Álvarez Pérez", "Luisa", "IS-3"));
        alumnosIS.add(new Estudiante("C2328", "Pérez Pérez", "José", "IS-1"));

        // Creamos el archivo de los alumnos de BD.
        crearArchivo(alumnosIS, "Alumnos_IS.ser");

        // Leemos los datos de los archivos
        ArrayList<Estudiante> alumnos_BD = new ArrayList<>();
        ArrayList<Estudiante> alumnos_IS = new ArrayList<>();

        leerAchivo(alumnos_BD, "Alumnos_BD.ser");
        leerAchivo(alumnos_IS, "Alumnos_IS.ser");

        // Creamos la lista final
        ArrayList<Estudiante> listaFinal = new ArrayList<>();
        listaFinal.addAll(alumnos_BD);
        listaFinal.addAll(alumnos_IS);

        // Ordenar por número de matrícula
        Collections.sort(listaFinal);

        // Guardar la lista fusionada en un nuevo archivo
        crearArchivo(listaFinal, "Resultado.ser");

        for (Estudiante estudiante : listaFinal) {
            System.out.println(estudiante);
        }

    }

    // Método para leer de un archivo.
    private static void leerAchivo(ArrayList<Estudiante> estudiantes, String nombreArchivo) {

        try {
            FileInputStream archivo = new FileInputStream(nombreArchivo);
            ObjectInputStream ois = new ObjectInputStream(archivo);


          while (true) {
                Estudiante estudiante = (Estudiante) ois.readObject();
                estudiantes.add(estudiante);
          }

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer.");
        }
    }

    // Método para crear un archivo
    private static void crearArchivo(ArrayList<Estudiante> estudiantes, String nombreArchivo) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo));

            for (Estudiante estudiante : estudiantes){
                oos.writeObject(estudiante);
            }

            System.out.println("El archivo se ha creado");
            oos.close();
        } catch (IOException e) {
            System.out.println("No se ha podido crear el archivo.");
            System.out.println(e);
        }
    }
}