package fp.universidad.tipos;

public record Asignatura(
        String nombre,
        String codigo,
        double creditos,
        TipoAsignatura tipo,
        int curso
) {

    public Asignatura {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }

        if (codigo == null || !codigo.matches("\\d{7}")) {
            throw new IllegalArgumentException("El código debe tener exactamente 7 dígitos");
        }

        if (creditos <= 0) {
            throw new IllegalArgumentException("Los créditos deben ser positivos");
        }

        if (tipo == null) {
            throw new IllegalArgumentException("El tipo no puede ser nulo");
        }

        if (curso <= 0) {
            throw new IllegalArgumentException("El curso debe ser positivo");
        }
    }

    public String acronimo() {
        //TODO calcular el acrónimo a partir de las mayúsculas del nombre
        return null;
    }

    @Override
    public String toString() {
        return "(" + codigo + ") " + nombre;
    }
}
