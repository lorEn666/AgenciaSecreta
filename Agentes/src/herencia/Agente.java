package herencia;

import java.io.Serializable;

public abstract class Agente implements Serializable {
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

	public String getNombre() {
		return nombre;
	}

	public double getSalario() {
		return salario;
	}

	@Override
	public String toString() {
		return "\n\nNombre: " + nombre + "\n\nEdad: " + edad + "\n\nDirección: " + direccion + "\n\nSalario: " + salario
				+ "€";
	}
}
