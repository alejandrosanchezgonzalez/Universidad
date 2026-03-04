package fp.universidad.tipos;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.utiles.Checkers;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Profesor extends Persona{
	
	private TipoCategoria categoria;
	private SortedSet<Tutoria> tutorias;
	
	public Profesor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, TipoCategoria categoria) {
		super(dni, nombre, apellidos, fechaNacimiento,email);
		
		Checkers.check("un profesor debe tener 18 o mas años", super.getEdad()>=18);
		this.tutorias= new TreeSet<>();
		this.categoria=categoria;
		
		

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
	
	public void nuevaTutoria(LocalTime horaInicio, Integer duracionMinutos, DayOfWeek dia_de_la_semana) {
        tutorias.add.(new Tutoria(horaInicio, duracionMinutos, dia_de_la_semana));
    }

    public void borraTutoria(LocalTime horaInicio, DayOfWeek dia_de_la_semana) {
        tutorias.remove(new Tutoria(horaInicio, 0, dia_de_la_semana));
    }

    public void borraTutorias() {
        tutorias.clear();
    }
    
    public void setFechaNacimiento(LocalDate fecha) {
    	Checkers.check("un proifesor debe ser mayor de edad", getEdad()>=18);
    	super.setFechaNacimiento(fecha);
    }
	
public String toString() {

    return super.toString() +"(" + getCategoria() + ")";
	

	

}
}
