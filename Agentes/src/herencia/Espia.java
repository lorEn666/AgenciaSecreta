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
public final class Espia extends Agente {
	private final String RUTA = "./recursos/pisos.txt";

	/**
	 * Único constructor de la clase que cuenta con sus atributos más los heredados
	 * de la clase 'Agente'.
	 * 
	 * @param nombre
	 * @param edad
	 * @param direccion
	 * @param salario
	 */
	public Espia(String nombre, int edad, String direccion, double salario) {
		super(nombre, edad, direccion, salario);
	}

	/**
	 * Método que será concatenado en el método toString() para listar el contenido
	 * del fichero pisos.txt y así mostrar los pisos asignados a los agentes de tipo
	 * 'Espia'.
	 * 
	 * @return String pisos
	 */
	public String getPisos() {
		String pisos = "";
		File ficheroPisos = new File(RUTA);
		try {
			Scanner sc = new Scanner(ficheroPisos);
			while (sc.hasNextLine()) {
				pisos += sc.nextLine() + "\n";
			}
			sc.close();
		} catch (FileNotFoundException e) {
		}
		return pisos;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\nPisos asignados:\n" + getPisos();
	}
}
