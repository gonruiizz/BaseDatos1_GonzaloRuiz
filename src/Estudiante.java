import java.io.Serializable;

public class Estudiante implements Serializable, Comparable<Estudiante>{
    // Atributos: código de matrícula, apellidos, nombre y convocatoria de la asignatura
    private String matricula;
    private String apellidos;
    private String nombre;
    private String convocatoria;

    // Constructor
    public Estudiante(String matricula, String apellidos, String nombre, String convocatoria) {
        this.matricula = matricula;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.convocatoria = convocatoria;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public int compareTo(Estudiante otroAlumno) {
        // Comparar por número de matrícula
        return matricula.compareTo(otroAlumno.getMatricula());
    }

    @Override
    public String toString() {
        return matricula + " | " + apellidos + ", " + nombre + " | " + convocatoria;
    }
}
