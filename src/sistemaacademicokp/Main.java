package sistemaacademicokp;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private static ArrayList<Nota> notas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> registrarEstudiante();
                case 2 -> listarEstudiantes();
                case 3 -> buscarEstudiante();
                case 4 -> actualizarEstudiante();
                case 5 -> eliminarEstudiante();
                case 6 -> registrarAsignatura();
                case 7 -> listarAsignaturas();
                case 8 -> buscarAsignatura();
                case 9 -> actualizarAsignatura();
                case 10 -> eliminarAsignatura();
                case 11 -> registrarNota();
                case 12 -> listarNotas();
                case 13 -> buscarNota();
                case 14 -> actualizarNota();
                case 15 -> eliminarNota();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n===== SISTEMA ACADÉMICO - UPC =====");
        System.out.println("-- Estudiantes --");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar estudiante por código");
        System.out.println("4. Actualizar estudiante");
        System.out.println("5. Eliminar estudiante");
        System.out.println("-- Asignaturas --");
        System.out.println("6. Registrar asignatura");
        System.out.println("7. Listar asignaturas");
        System.out.println("8. Buscar asignatura por código");
        System.out.println("9. Actualizar asignatura");
        System.out.println("10. Eliminar asignatura");
        System.out.println("-- Notas --");
        System.out.println("11. Registrar nota");
        System.out.println("12. Listar notas");
        System.out.println("13. Buscar nota");
        System.out.println("14. Actualizar nota");
        System.out.println("15. Eliminar nota");
        System.out.println("0. Salir");
    }

    public static void registrarEstudiante() {
        System.out.println("\n-- Registrar estudiante --");
        String codigo = leerTexto("Código: ");
        if (buscarEstudiantePorCodigo(codigo) != null) {
            System.out.println("Ya existe un estudiante con ese código.");
            return;
        }
        String nombre = leerTexto("Nombre: ");
        String apellido = leerTexto("Apellido: ");
        int edad = leerEntero("Edad: ");
        int semestre = leerEntero("Semestre: ");
        estudiantes.add(new Estudiante(codigo, nombre, apellido, edad, semestre));
        System.out.println("Estudiante registrado con éxito.");
    }

    public static void listarEstudiantes() {
        System.out.println("\n-- Lista de estudiantes --");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }

    public static void buscarEstudiante() {
        System.out.println("\n-- Buscar estudiante --");
        String codigo = leerTexto("Código a buscar: ");
        Estudiante e = buscarEstudiantePorCodigo(codigo);
        System.out.println(e != null ? e : "Estudiante no encontrado.");
    }

    public static void actualizarEstudiante() {
        System.out.println("\n-- Actualizar estudiante --");
        String codigo = leerTexto("Código del estudiante a actualizar: ");
        Estudiante e = buscarEstudiantePorCodigo(codigo);
        if (e == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }
        e.setNombre(leerTexto("Nuevo nombre: "));
        e.setApellido(leerTexto("Nuevo apellido: "));
        e.setEdad(leerEntero("Nueva edad: "));
        e.setSemestre(leerEntero("Nuevo semestre: "));
        System.out.println("Estudiante actualizado con éxito.");
    }

    public static void eliminarEstudiante() {
        System.out.println("\n-- Eliminar estudiante --");
        String codigo = leerTexto("Código del estudiante a eliminar: ");
        Estudiante e = buscarEstudiantePorCodigo(codigo);
        if (e == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }
        estudiantes.remove(e);
        System.out.println("Estudiante eliminado con éxito.");
    }

    private static Estudiante buscarEstudiantePorCodigo(String codigo) {
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                return e;
            }
        }
        return null;
    }
}
