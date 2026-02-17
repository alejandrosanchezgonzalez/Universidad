package fp.universidad.tipos;

public record Nota(
        Asignatura asignatura,
        int anioInicioCurso,
        Convocatoria convocatoria,
        double valor,
        boolean mencionHonor,
        Calificacion calificacion
) {

    // Constructor con mención de honor
    public Nota {
        if (asignatura == null) {
            throw new IllegalArgumentException("La asignatura no puede ser nula");
        }

        if (convocatoria == null) {
            throw new IllegalArgumentException("La convocatoria no puede ser nula");
        }

        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("El valor debe estar entre 0 y 10");
        }

        if (mencionHonor && valor < 9) {
            throw new IllegalArgumentException("Solo puede haber mención de honor si la nota es >= 9");
        }

        calificacion = calcularCalificacion(valor, mencionHonor);
    }

    // Constructor sin mención de honor
    public Nota(Asignatura asignatura,
                int anioInicioCurso,
                Convocatoria convocatoria,
                double valor) {

        this(asignatura, anioInicioCurso, convocatoria, valor, false, null);
    }

    private static Calificacion calcularCalificacion(double valor, boolean mencionHonor) {
        if (valor < 5) {
            return Calificacion.SUSPENSO;
        } else if (valor < 7) {
            return Calificacion.APROBADO;
        } else if (valor < 9) {
            return Calificacion.NOTABLE;
        } else {
            return mencionHonor
                    ? Calificacion.MATRICULA_DE_HONOR
                    : Calificacion.SOBRESALIENTE;
        }
    }

    private String cursoAcademico() {
        int anioFin = anioInicioCurso + 1;
        String ultimosDos = String.valueOf(anioFin).substring(2);
        return anioInicioCurso + "-" + ultimosDos;
    }

    
    public String toString() {
        return asignatura + ", "
                + cursoAcademico() + ", "
                + convocatoria + ", "
                + valor + ", "
                + calificacion;
    }
}

