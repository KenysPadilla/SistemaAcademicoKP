package sistemaacademicokp;

public class Main {

    public static void main(String[] args) {
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
