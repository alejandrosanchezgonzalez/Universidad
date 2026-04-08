package fp.universidad.tipos;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import fp.utiles.Checkers;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Profesor extends Persona{
	
	private TipoCategoria categoria;
	private SortedSet<Tutoria> tutorias;
	private Map<Asignatura,Double> mapa;
	
	public Profesor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, TipoCategoria categoria) {
		super(dni, nombre, apellidos, fechaNacimiento,email);
		
		Checkers.check("un profesor debe tener 18 o mas años", super.getEdad()>=18);
		this.tutorias= new TreeSet<>();
		this.categoria=categoria;
		this.mapa=new HashMap<>();
		
		

	}

	

	public TipoCategoria getCategoria() {
		return this.categoria;
	}



	public void setCategoria(TipoCategoria categoria) {
		this.categoria = categoria;
	}



	public SortedSet<Tutoria> getTutorias() {
	    return new TreeSet<>(tutorias);
	}



	public void setTutorias(SortedSet<Tutoria> tutorias) {
		this.tutorias = tutorias;
	}
	
	public void nuevaTutoria( DayOfWeek dia_de_la_semana,LocalTime horaInicio, Integer duracionMinutos) {
        tutorias.add(new Tutoria( dia_de_la_semana,horaInicio, duracionMinutos));
    }

    public void borraTutoria( DayOfWeek dia_de_la_semana,LocalTime horaInicio) {
        tutorias.remove(new Tutoria( dia_de_la_semana,horaInicio, 0));
    }

    public void borraTutorias() {
        tutorias.clear();
    }
    
    public List<Asignatura> getAsignaturas() {
        return new ArrayList<Asignatura>(mapa.keySet());
    }
    
    public List<Double> getCreditos() {
        return new ArrayList<Double>(mapa.values());
    }
    
    public void imparteAsignatura(Asignatura a, Double credito) {
    	Checkers.check("dale mas corason",a.creditos()<=credito);
    	Checkers.check("mmm",this.getDedicacionTotal()+ credito <=24);
    	mapa.put(a, credito);
    	
    	
    }
    
    public void eliminaAsignatura(Asignatura a) {
    	mapa.remove(a);
    	
    }
    
    public Double dedicacionAsignatura(Asignatura a) {
    	Double r=0.0;
    	if (mapa.keySet().contains(a))
    		 r=mapa.get(a);
    	return r;
    	
    }
    
    public Double getDedicacionTotal() {
    	Double suma=0.0;
    	for(Double creditos:mapa.values()) {
    		suma+=creditos;
    	}
    	return suma;
    	
    }
    
    
    
    public void setFechaNacimiento(LocalDate fecha) {
    	Checkers.check("un proifesor debe ser mayor de edad", getEdad()>=18);
    	super.setFechaNacimiento(fecha);
    }
	
public String toString() {

    return super.toString() +"(" + getCategoria() + ")";
	

	

}
}
