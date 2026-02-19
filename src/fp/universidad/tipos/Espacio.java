package fp.universidad.tipos;
import fp.utiles.Checkers;
public class Espacio {
	private TipoEspacio tipo;
	private String nombre;
	private int capacidad;
	private final int planta;
	
	public Espacio(TipoEspacio tipo, String nombre, int capacidad, int planta) {
		this.tipo=tipo;
		this.nombre=nombre;
		this.capacidad=capacidad;
		this.planta=planta;
		
		Checkers.check("La capacidad debe ser mayor que 0",capacidad > 0);
		
	}

	public TipoEspacio getTipo() {
		return tipo;
	}

	public void setTipo(TipoEspacio tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getPlanta() {
		return planta;
	}
	@Override
	public String toString() {
        return nombre + " (planta " + planta + ")";
    }

}
