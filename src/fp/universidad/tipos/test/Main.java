package fp.universidad.tipos.test;

import java.time.LocalDate;

import fp.universidad.tipos.Persona;

public class Main {

	public static void main(String[] args) {
		
		 Persona p1 = new Persona(
		                "28864657W",
		                "Pascual",
		                "García Vaquero",
		                LocalDate.of(1998, 9, 15),
		                "pascual@email.com",
		                27
		        );

		        Persona p2 = new Persona(
		                "12345678A",
		                "Ana",
		                "López Martín",
		                LocalDate.of(2000, 3, 10),
		                24
		        );

		        System.out.println(p1);
		        System.out.println(p2);
		    
	Espacio aula = new Espacio(TipoEspacio.AULA_TEORIA, "A3.10", 30, 3);
    System.out.println(aula);         
    System.out.println(aula.getTipo());
    
	}
}
		

	
	
		





