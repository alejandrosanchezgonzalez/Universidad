package fp.universidad.tipos;
import java.time.DayOfWeek;
import fp.utiles.Checkers;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import fp.utiles.Checkers;

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
}

