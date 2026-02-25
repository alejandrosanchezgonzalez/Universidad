package fp.universidad.tipos;
import java.util.Objects;

import fp.utiles.Checkers;

public record Nota (
        Asignatura asignatura,
        int anioInicioCurso,
        Convocatoria convocatoria,
        double valor,
        boolean mencionHonor,
        Calificacion calificacion
) implements Comparable<Nota>{

    // Constructor con mención de honor
    public Nota {
    	
    	Checkers.checkNoNull(asignatura,convocatoria);
        Checkers.check("el valor debe estar entre 0 y 10",valor >= 0 && valor <= 10);
        Checkers.check("Solo puede haber mención de honor si la nota es mayor o igual a 9", !mencionHonor || valor >= 9);

        

       

        calificacion = calcularCalificacion(valor, mencionHonor);
    }

    // Constructor sin mención de honor
    public Nota(Asignatura asignatura,
                int anioInicioCurso,
                Convocatoria convocatoria,
                double valor) {

        this(asignatura, anioInicioCurso, convocatoria, valor, false, null);
        
        
    }

    private static Calificacion calcularCalificacion(double valor, boolean mencionHonor) {
        if (valor < 5) {
            return Calificacion.SUSPENSO;
        } else if (valor < 7) {
            return Calificacion.APROBADO;
        } else if (valor < 9) {
            return Calificacion.NOTABLE;
        } else {
            return mencionHonor
                    ? Calificacion.MATRICULA_DE_HONOR
                    : Calificacion.SOBRESALIENTE;
        }
    }

    private String cursoAcademico() {
        int anioFin = anioInicioCurso + 1;
        String ultimosDos = String.valueOf(anioFin).substring(2);
        return anioInicioCurso + "-" + ultimosDos;
    }

    @Override
    public String toString() {
        return asignatura + ", "
                + cursoAcademico() + ", "
                + convocatoria + ", "
                + valor + ", "
                + calificacion;
    }
    
    @Override
	public boolean equals(Object obj) {
		if (this==obj) return true;
		if (obj==null || getClass() != obj.getClass())return false;
		Nota otra=(Nota) obj;
		return Objects.equals(asignatura,otra.asignatura) &&
				Objects.equals(convocatoria, otra.convocatoria)&&
				Objects.equals(anioInicioCurso,otra.anioInicioCurso);
				
	}
@Override
	public int hashCode() {
		return Objects.hash(asignatura,convocatoria,anioInicioCurso);
	}

@Override
public  int compareTo(Nota otra) {
		int comparacion=Integer.compare(this.anioInicioCurso,otra.anioInicioCurso);
		if (comparacion!=0) return comparacion;
		
		comparacion=this.asignatura.compareTo(otra.asignatura);
		if (comparacion!=0) return comparacion;
		
		
		return this.convocatoria.compareTo(otra.convocatoria);
		
		
		
		
	}
}

