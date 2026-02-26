package fp.universidad.tipos;
import java.util.ArrayList;
import java.util.Objects;

import fp.utiles.Checkers;

public class Centro implements Comparable<Centro>{
	private final String nombre;
	private final String direccion;
	private final int planta;
	private final int sotano;
	
	private ArrayList<Espacio> espacios;
	
	public Centro (String nombre, String direccion, int planta, int sotano) {
		Checkers.check("un centro debe tener al menos una planta", planta>0);
		Checkers.check("un centro solo puede tener 0 o mas sotanos", sotano>=0);
		
		this.nombre=nombre;
		this.direccion=direccion;
		this.planta=planta;
		this.sotano=sotano;
		this.espacios=new ArrayList<>();
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getPlanta() {
		return planta;
	}

	public int getSotano() {
		return sotano;
	}
	
	public void nuevoEspacio(Espacio e) {
		int plantaEspacio=e.getPlanta();
		if(plantaEspacio<-sotano || plantaEspacio>planta-1) {
			throw new IllegalArgumentException("Planta inválida : debe estar entre" 
												+ (-sotano) + "y" + (planta-1));
		}
		espacios.add(e);
		}
	
	public void eliminarEspacio(Espacio e) {
		espacios.remove(e);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj) return true;
		if (obj==null || getClass() != obj.getClass())return false;
		Centro otro=(Centro) obj;
		return Objects.equals(this.nombre,otro.nombre); 
				
				
	}
@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

@Override
public  int compareTo(Centro otro) {
		return this.nombre.compareTo(otro.nombre);
		
		
		
		
	}

}
