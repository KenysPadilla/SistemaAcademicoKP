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
}
