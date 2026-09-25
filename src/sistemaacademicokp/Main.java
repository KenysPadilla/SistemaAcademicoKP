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

    public static void registrarAsignatura () {
        System.out.println("\n-- Registrar asignatura --");
        String codigo = leerTexto("Código: ");
        if (buscarAsignaturaPorCodigo(codigo) != null) {
            System.out.println("Ya existe una asignatura con ese código.");
            return;
        }
        String nombre = leerTexto("Nombre: ");
        int creditos = leerEntero("Créditos: ");
        String docente = leerTexto("Docente: ");
        asignaturas.add(new Asignatura(codigo, nombre, creditos, docente));
        System.out.println("Asignatura registrada con éxito.");
    }

    public static void listarAsignaturas() {
        System.out.println("\n-- Lista de asignaturas --");
        if (asignaturas.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }
        for (Asignatura a : asignaturas) {
            System.out.println(a);
        }
    }

    public static void buscarAsignatura() {
        System.out.println("\n-- Buscar asignatura --");
        String codigo = leerTexto("Código a buscar: ");
        Asignatura a = buscarAsignaturaPorCodigo(codigo);
        System.out.println(a != null ? a : "Asignatura no encontrada.");
    }

    public static void actualizarAsignatura() {
        System.out.println("\n-- Actualizar asignatura --");
        String codigo = leerTexto("Código de la asignatura a actualizar: ");
        Asignatura a = buscarAsignaturaPorCodigo(codigo);
        if (a == null) {
            System.out.println("Asignatura no encontrada.");
            return;
        }
        a.setNombre(leerTexto("Nuevo nombre: "));
        a.setCreditos(leerEntero("Nuevos créditos: "));
        a.setDocente(leerTexto("Nuevo docente: "));
        System.out.println("Asignatura actualizada con éxito.");
    }

    public static void eliminarAsignatura() {
        System.out.println("\n-- Eliminar asignatura --");
        String codigo = leerTexto("Código de la asignatura a eliminar: ");
        Asignatura a = buscarAsignaturaPorCodigo(codigo);
        if (a == null) {
            System.out.println("Asignatura no encontrada.");
            return;
        }
        asignaturas.remove(a);
        System.out.println("Asignatura eliminada con éxito.");
    }

    private static Asignatura buscarAsignaturaPorCodigo(String codigo) {
        for (Asignatura a : asignaturas) {
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                return a;
            }
        }
        return null;
    }

    public static void registrarNota() {
        System.out.println("\n-- Registrar nota --");
        String codEst = leerTexto("Código del estudiante: ");
        Estudiante e = buscarEstudiantePorCodigo(codEst);
        if (e == null) {
            System.out.println("Estudiante no encontrado. Regístrelo primero.");
            return;
        }
        String codAsig = leerTexto("Código de la asignatura: ");
        Asignatura a = buscarAsignaturaPorCodigo(codAsig);
        if (a == null) {
            System.out.println("Asignatura no encontrada. Regístrela primero.");
            return;
        }
        double valor = leerDecimal("Nota (0.0 - 5.0): ");
        String periodo = leerTexto("Periodo (ej. 2026-2): ");
        notas.add(new Nota(e, a, valor, periodo));
        System.out.println("Nota registrada con éxito.");
    }

    public static void listarNotas() {
        System.out.println("\n-- Lista de notas --");
        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas.");
            return;
        }
        for (Nota n : notas) {
            System.out.println(n);
        }
    }

    public static void buscarNota() {
        System.out.println("\n-- Buscar nota --");
        String codEst = leerTexto("Código del estudiante: ");
        String codAsig = leerTexto("Código de la asignatura: ");
        boolean encontrada = false;
        for (Nota n : notas) {
            if (n.getEstudiante().getCodigo().equalsIgnoreCase(codEst)
                    && n.getAsignatura().getCodigo().equalsIgnoreCase(codAsig)) {
                System.out.println(n);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontraron notas para esa búsqueda.");
        }
    }

    public static void actualizarNota() {
        System.out.println("\n-- Actualizar nota --");
        String codEst = leerTexto("Código del estudiante: ");
        String codAsig = leerTexto("Código de la asignatura: ");
        String periodo = leerTexto("Periodo de la nota a actualizar: ");
        Nota n = buscarNotaExacta(codEst, codAsig, periodo);
        if (n == null) {
            System.out.println("Nota no encontrada.");
            return;
        }
        n.setValor(leerDecimal("Nuevo valor de la nota: "));
        System.out.println("Nota actualizada con éxito.");
    }

    public static void eliminarNota() {
        System.out.println("\n-- Eliminar nota --");
        String codEst = leerTexto("Código del estudiante: ");
        String codAsig = leerTexto("Código de la asignatura: ");
        String periodo = leerTexto("Periodo de la nota a eliminar: ");
        Nota n = buscarNotaExacta(codEst, codAsig, periodo);
        if (n == null) {
            System.out.println("Nota no encontrada.");
            return;
        }
        notas.remove(n);
        System.out.println("Nota eliminada con éxito.");
    }

    private static Nota buscarNotaExacta(String codEst, String codAsig, String periodo) {
        for (Nota n : notas) {
            if (n.getEstudiante().getCodigo().equalsIgnoreCase(codEst)
                    && n.getAsignatura().getCodigo().equalsIgnoreCase(codAsig)
                    && n.getPeriodo().equalsIgnoreCase(periodo)) {
                return n;
            }
        }
        return null;
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    private static double leerDecimal(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Ingrese un número decimal válido.");
            }
        }
    }
}
