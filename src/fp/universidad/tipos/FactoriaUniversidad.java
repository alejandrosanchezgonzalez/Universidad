package fp.universidad.tipos;

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


}
