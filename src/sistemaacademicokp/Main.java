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
}
