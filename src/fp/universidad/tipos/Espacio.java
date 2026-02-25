package fp.universidad.tipos;
import java.util.Objects;

import fp.utiles.Checkers;
public class Espacio implements Comparable<Espacio>{
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
@Override
	public boolean equals(Object obj) {
		if (this==obj) return true;
		if (obj==null || getClass() != obj.getClass())return false;
		Espacio otro=(Espacio) obj;
		return Objects.equals(nombre,otro.nombre) &&
				Objects.equals(planta, otro.planta);
				
	}
@Override
	public int hashCode() {
		return Objects.hash(nombre,planta);
	}
@Override
	public  int compareTo(Espacio otro) {
		int comparacion=Integer.compare(this.planta,otro.planta);
		if (comparacion!=0) return comparacion;
		
		return this.nombre.compareTo(otro.nombre);
		
		
		
		
	}
	
}
