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
}
