package herencia;

public abstract class Agente {
	protected String nombre;
	protected int edad;
	protected String direccion;
	protected double salario;
	
	public Agente(String nombre, int edad, String direccion, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.salario = salario;
	}
	
	
}
