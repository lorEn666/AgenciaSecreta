package herencia;

import java.io.Serializable;

/**
 * Clase con modificador de acceso 'abstract' de la que heredar�n el resto de
 * agentes dados de alta durante la ejecuci�n. Contiene los atributos
 * principales que compartir�n todos los tipos de agentes.
 * 
 * @author Borja Loren
 * @version 1.0.0
 * @since 10-02-2020
 *
 */
public abstract class Agente implements Serializable {
	protected String nombre;
	protected int edad;
	protected String direccion;
	protected double salario;

	/**
	 * �nico constructor de la clase que contiene los atributos principales.
	 * 
	 * @param String nombre
	 * @param int    edad
	 * @param String direccion
	 * @param double salario
	 */
	public Agente(String nombre, int edad, String direccion, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.salario = salario;
	}

	/**
	 * Proporciona el nombre del agente.
	 * 
	 * @return String nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Proporciona el salario del agente.
	 * 
	 * @return double salario
	 */
	public double getSalario() {
		return salario;
	}
	
	@Override
	public String toString() {
		return "\n\nNombre: " + nombre + "\n\nEdad: " + edad + "\n\nDirecci�n: " + direccion + "\n\nSalario: " + salario
				+ "�";
	}
}
