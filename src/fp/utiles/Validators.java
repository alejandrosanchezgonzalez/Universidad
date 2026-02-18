package fp.utiles;

public class Validators {
	
	public static Boolean sonDigitos(String cadena) {
		Boolean res =true;
		for (int i = 0; i <cadena.length(); i++) {
			//Esquema para todo
			if (! Character.isDigit(cadena.charAt(i))) {
				res=false;
				break;
			}
		}
		return res;
		
	}

}
