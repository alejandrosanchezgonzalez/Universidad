package fp.universidad.tipos;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public record Tutoria(
        DayOfWeek dia_de_la_semana,
        LocalTime hora_inicio,
        LocalTime hora_fin
) {


//  día + hora_inicio + duración
public Tutoria(DayOfWeek dia_de_la_semana,
            LocalTime hora_inicio,
            int duracion_min) {
 this(dia_de_la_semana,
      hora_inicio,
      hora_inicio.plusMinutes(duracion_min));
}
	
	public long duracion() {
		return ChronoUnit.MINUTES.between(hora_inicio,hora_fin);
	}
	
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
}

