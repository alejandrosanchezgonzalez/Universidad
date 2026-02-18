package fp.universidad.tipos;
import fp.utiles.Checkers;
import fp.utiles.Validators;

public record Asignatura(
        String nombre,
        String codigo,
        double creditos,
        TipoAsignatura tipo,
        int curso
) {
	//El código numérico de una **asignatura** consta de 7 dígitos (por ejemplo, `"0000230"`). El número de créditos es
	//siempre mayor que cero y su curso debe tener en cuenta que los grados constan de 4 años.

    public Asignatura {
    	
    	Checkers.checkNoNull(nombre,codigo,tipo);
    	Checkers.check("El código debe tener exactamente 7 dígitos",codigo.matches("\\d{7}"));
    	Checkers.check("Los creditos deben ser mayor que 0", creditos > 0);
    	Checkers.check("El curso debe estar entre 1 y 4 ", curso >= 1 && curso <= 4);
 
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
