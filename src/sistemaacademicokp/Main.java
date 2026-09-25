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
}
