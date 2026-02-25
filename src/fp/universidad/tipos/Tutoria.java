package fp.universidad.tipos;
import java.time.DayOfWeek;
import fp.utiles.Checkers;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;


public record Tutoria(
        DayOfWeek dia_de_la_semana,
        LocalTime hora_inicio,
        LocalTime hora_fin
) implements Comparable<Tutoria> {


//  día + hora_inicio + duración
public Tutoria(DayOfWeek dia_de_la_semana,
            LocalTime hora_inicio,
            int duracion_min) {
 this(dia_de_la_semana,
      hora_inicio,
      hora_inicio.plusMinutes(duracion_min));
 Checkers.checkNoNull(dia_de_la_semana,hora_inicio,hora_fin);
 Checkers.check("la tutoria debe durar al menos 15 minutos", ChronoUnit.MINUTES.between(hora_inicio, hora_fin) >= 15);
 Checkers.check("La tutoria solo puede ser de lunes a viernes",dia_de_la_semana!=DayOfWeek.SATURDAY && dia_de_la_semana!=DayOfWeek.SUNDAY);
}
	
	public long duracion() {
		return ChronoUnit.MINUTES.between(hora_inicio,hora_fin);
	}
	
	@Override
	public String toString() {
		return letraDia(dia_de_la_semana) +" "+ hora_inicio + "-" + hora_fin;
	}
	
	private static String letraDia(DayOfWeek dia_de_la_semana) {
		return switch (dia_de_la_semana) {
		case MONDAY -> "L";
        case TUESDAY -> "M";
        case WEDNESDAY -> "X";
        case THURSDAY -> "J";
        case FRIDAY -> "V";
        default -> "";
    };
    
	}
	
	 @Override
		public boolean equals(Object obj) {
			if (this==obj) return true;
			if (obj==null || getClass() != obj.getClass())return false;
			Tutoria otra=(Tutoria) obj;
			return Objects.equals(dia_de_la_semana,otra.dia_de_la_semana) &&
				   Objects.equals(hora_inicio,otra.hora_inicio);
					
		}
	@Override
		public int hashCode() {
			return Objects.hash(dia_de_la_semana,hora_inicio);
		}

	@Override
	public  int compareTo(Tutoria otra) {
			int comparacion=this.dia_de_la_semana.compareTo(otra.dia_de_la_semana);
			if (comparacion!=0) return comparacion;
			
			
			return this.hora_inicio.compareTo(otra.hora_inicio);
			
			
			
			
		}
}

