package fp.utiles;

public class Asignatura {
	private final String nombre;
	private final String codigo;
	private final double creditos;
	private final TipoAsignatura tipo;
	private final int curso;
	
	public Asignatura(String nombre, String codigo, double creditos, TipoAsignatura tipo, int curso) {
		this.nombre=nombre;
		this.codigo=codigo;
		this.creditos=creditos;
		this.tipo=tipo;
		this.curso=curso;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public double getCreditos() {
		return creditos;
	}

	public TipoAsignatura getTipo() {
		return tipo;
	}

	public int getCurso() {
		return curso;
	}
	
	public String getAcronimo() {
		//TODO:calcular el acronimo con las mayusculas de la asignatura
		return null;
	}
	
	public String toString() {
		return "(" + codigo + ")" + nombre;
	}
	

	

}
