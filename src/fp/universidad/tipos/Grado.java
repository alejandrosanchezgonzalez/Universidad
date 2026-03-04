package fp.universidad.tipos;
import java.util.Set;
import fp.utiles.Checkers;

import java.util.HashSet;
import java.util.Objects;

public class Grado implements Comparable<Grado>{
	private String nombre;
	private Set<Asignatura> obligatorias;
	private Set<Asignatura> optativas;
	private int minimoCreditosOptativas;
	
	public Grado(String nombre,Set <Asignatura> obligatorias, Set <Asignatura> optativas, int numeroDeCreditos) {
		Checkers.checkNoNull(nombre,obligatorias,optativas);
		
		
		this.nombre=nombre;
		this.minimoCreditosOptativas=numeroDeCreditos;
		this.obligatorias=new HashSet<>();
		this.optativas=new HashSet<>();
		
		if(!this.optativas.isEmpty()) {
			double creditosExistentes=this.optativas.iterator().next().creditos();
			
			for (Asignatura a:optativas) {
			Checkers.check("todas las optativas deben tener el mismo numero de creditos", a.creditos()==creditosExistentes);
		}
		}
		Checkers.check("el minimo de creditos supera el total disponible", minimoCreditosOptativas<=getTotalCreditosOptativas());
		Checkers.check("El mínimo de créditos optativos debe ser >=0", minimoCreditosOptativas>=0);


		
		
		
	}
	
	public int getNumeroTotalDeCreditos() {
		int sumaObligatorias=0;
		
		for (Asignatura a:obligatorias) {
			sumaObligatorias+=a.creditos();
			
		}
		
		return sumaObligatorias + minimoCreditosOptativas;
	}
	
	private int getTotalCreditosOptativas() {
        int suma = 0;

        for (Asignatura a : optativas) {
            suma += a.creditos();
        }

        return suma;
    }
	
	public void agregarObligatoria(Asignatura a) {
		Checkers.checkNoNull(a);
		obligatorias.add(a);
	}
	
	public void agregarOptativa( Asignatura a) {
		Checkers.checkNoNull(a);
		
	
		optativas.add(a);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grado other = (Grado) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	@Override
    public int compareTo(Grado other) {
        return this.nombre.compareTo(other.nombre);
    }

	
	

}
