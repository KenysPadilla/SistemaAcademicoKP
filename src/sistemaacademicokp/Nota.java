package sistemaacademicokp;

public class Nota {
    private Estudiante estudiante;
    private Asignatura asignatura;
    private double valor;
    private String periodo;

    public Nota() {
    }

    public Nota(Estudiante estudiante, Asignatura asignatura, double valor, String periodo) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.valor = valor;
        this.periodo = periodo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Estudiante: " + estudiante.getCodigo() + " - " + estudiante.getNombre()
                + " | Asignatura: " + asignatura.getCodigo() + " - " + asignatura.getNombre()
                + " | Nota: " + valor
                + " | Periodo: " + periodo;
    }
}
