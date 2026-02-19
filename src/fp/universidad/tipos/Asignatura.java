package fp.universidad.tipos;
import fp.utiles.Checkers;
import fp.utiles.Validators;

public record Asignatura (
        String nombre,
        String codigo,
        double creditos,
        TipoAsignatura tipo,
        int curso
)implements Comparable<Asignatura> {
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
//COMPARE TO
    @Override
    public int compareTo(Asignatura o) {
    	return this.codigo.compareTo(o.codigo);
    }
//EQUALS
    @Override
    public boolean equals(Object o) {
    	return (o instanceof Asignatura a) && codigo.equals(a.codigo);
    }
//HASHCODE
    @Override
    public int hashCode() {
    	return codigo.hashCode();
    }
    @Override
    public String toString() {
        return "(" + codigo + ") " + nombre;
    }
}
