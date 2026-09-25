package sistemaacademicokp;

public class Main {

    public static void main(String[] args) {
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
}
