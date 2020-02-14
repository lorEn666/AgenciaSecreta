package herencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase que hereda de la clase 'Agente'. Posee modificador de acceso 'final'
 * indicando que nadie más heredará de esta clase.
 * 
 * @author Borja Loren
 * @version 1.0.0
 * @since 10-02-2020
 *
 */
public final class Secreto extends Agente {
	private final String RUTA = "./recursos/armas.txt";
	private int muertes;

	/**
	 * Único constructor de la clase que cuenta con sus atributos más los heredados
	 * de la clase 'Agente'.
	 * 
	 * @param nombre
	 * @param edad
	 * @param direccion
	 * @param salario
	 * @param muertes
	 */
	public Secreto(String nombre, int edad, String direccion, double salario, int muertes) {
		super(nombre, edad, direccion, salario);
		this.muertes = muertes;
	}

	/**
	 * Método que será concatenado en el método toString() para listar el contenido
	 * del fichero armas.txt y así mostrar las armas asignadas a los agentes de tipo
	 * 'Secreto'.
	 * 
	 * @return String armas
	 */
	public String getArmas() {
		String armas = "";
		File ficheroArmas = new File(RUTA);
		try {
			Scanner sc = new Scanner(ficheroArmas);
			while (sc.hasNextLine()) {
				armas += sc.nextLine() + "\n";
			}
			sc.close();
		} catch (FileNotFoundException e) {
		}
		return armas;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\nVíctimas: " + muertes + "\n\nArmas asignadas:\n" + getArmas();
	}
}
