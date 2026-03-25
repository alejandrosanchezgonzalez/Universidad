package fp.universidad.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Ficheros;

public class FactoriaUniversidad {

	public static Espacio creaEspacio(String cadena) {
		return new Espacio(cadena);
		
		
		
		
	}
	
	public static List<Espacio> leeEspacios(String rutaFichero){
		List<String> lineas = Ficheros.leeFichero("error de lectura",rutaFichero);
		List<Espacio> espacios = new ArrayList<>();
		
		for (String linea : lineas) {
            if (linea != null && !linea.trim().isEmpty()) {
                espacios.add(creaEspacio(linea));
            }
        }

        return espacios;
    }
	
	public static Alumno creaAlumno(String linea ) {
        String[] partes = linea.split(",");

        String dni = partes[0];
        String nombre = partes[1];
        String apellidos = partes[2];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate fecha = LocalDate.parse(partes[3], formatter);

        String email = partes[4];

        return new Alumno(dni, nombre, apellidos, fecha, email);
	}
	
	public static List<Alumno> leeAlumnos(String rutaFichero){
		List<String> lineas =Ficheros.leeFichero("error de lectura", rutaFichero);
		List<Alumno> alumnos = new ArrayList<>();
		
		for (String linea:lineas) {
			if(linea!=null && !linea.trim().isEmpty()) {
				alumnos.add(creaAlumno(linea));
			}
		}
		return alumnos;
	}
	
	//public static Asignatura creaAsignatura() {
		
	//}
	
	public static Nota creaNota(String notaStr) {
		String[] trozos=notaStr.split(",");
		
		Asignatura a =creaAsignatura(trozos[0].strip());
		Integer cursoAcademico= Integer.parseInt(trozos[1].strip());
		Convocatoria convocatoria= Convocatoria.valueOf(trozos[2].strip());
		Double nota= Double.parseDouble(trozos[3].strip());
		Boolean mencionHonor=Boolean.parseBoolean(trozos[4].strip());
		
		return new Nota(a,cursoAcademico,convocatoria,nota,mencionHonor);
		
	}
	
	public static List<Nota> leeNotas(String rutaFichero) {
		
		List<String> lineas =Ficheros.leeFichero("error de lectura", rutaFichero);
		List<Nota> notas = new ArrayList<>();
		
		for (String linea:lineas) {
			if(linea!=null && !linea.trim().isEmpty()) {
				notas.add(creaNota(linea));
			}
		}
		return notas;
	}
	
		
	


}
