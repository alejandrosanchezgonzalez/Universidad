package fp.universidad.tipos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Persona {
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String email;
	private int edad;
	
	public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, int edad) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.fechaNacimiento=fechaNacimiento;
		this.email=email;
		this.edad=edad;
		
	}
	
	public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, int edad) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.fechaNacimiento=fechaNacimiento;
		this.email="";
		this.edad=edad;
		
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public int getEdad() {
		return edad;
	}
	
	
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String toString() {

	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    return dni + " – " +
	           apellidos + ", " +
	           nombre + " – " +
	           fechaNacimiento.format(formato);
	}

	

}
