package fp.universidad.tipos;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

public class Expediente {
	private List<Nota>notas;
	
	public Expediente() {
		this.notas= new ArrayList<>();
		
	}
	
	public void nuevaNota(Nota n) {
		notas.remove(n);
		notas.add(n);
	}
	
	public double getNotaMedia() {
		if (notas.isEmpty()) {
			return 0.0;
		}
		double suma=0;
		int contador=0;
		for(Nota n: notas) {
			if(n.valor()>=5) {
				suma+=n.valor();
				contador++;
			}
		}
		
		if (contador==0) {
			return 0.0;
		}
		
		return suma/contador;
	}

	@Override
	public String toString() {
		return notas.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(notas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expediente other = (Expediente) obj;
		return Objects.equals(notas, other.notas);
	}
	

	
	

}
