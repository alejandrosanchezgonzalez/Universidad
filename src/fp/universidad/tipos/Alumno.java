package fp.universidad.tipos;
import java.util.Set;
import fp.utiles.Checkers;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class Alumno extends Persona{
	private Set<Asignatura> asignaturas;
	private Expediente expediente;
	
	public Alumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		super(dni, nombre, apellidos, fechaNacimiento, email);
		setEmail(email);
		
		this.asignaturas= new HashSet<Asignatura>();
		this.expediente = new Expediente();
		}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}
	
	public void setEmail(String email) {
		Checkers.check("el email tiene que acabar en @alum.us.es", email.endsWith("@alum.us.es"));
		Checkers.check("El email no puede ser vacío", email != null && !email.isEmpty());
		super.setEmail(email);
	}
	public Integer getCurso() {
		Integer curso=0;
		for (Asignatura a: getAsignaturas()) {
			if(a.curso()>curso) {
				curso=a.curso();
				
			}
		}
		return curso;
	}
	
	public void matriculaAsignatura(Asignatura a ) {
		Checkers.check(getApellidos(), ! estaMatriculadoEn(a));
		asignaturas.add(a);
	}
	
	public void eliminaAsignatura(Asignatura a) {
		Checkers.check(getApellidos(), estaMatriculadoEn(a));
		asignaturas.remove(a);
	}
	
	public Boolean estaMatriculadoEn(Asignatura a) {
		return asignaturas.contains(a);
	}
	
	///public void evaluaAsignaturas(Asignatura a,Integer curso, Convocatoria convocatoria, Double nota, Boolean mencionHonor) {
		///Checkers.check(getApellidos(), estaMatriculadoEn(a));
		///expediente.nuevaNota(new Nota(a,curso,convocatoria,nota,mencionHonor));
	///}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Alumno)) return false;

        Alumno other = (Alumno) obj;

        return Objects.equals(getDni(), other.getDni()) &&
               Objects.equals(getApellidos(), other.getApellidos()) &&
               Objects.equals(getNombre(), other.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDni(), getApellidos(), getNombre());
    }
    
	@Override
	
	public String toString() {
		return "(" + getCurso() + "º)" + super.toString();
	}
	

}
