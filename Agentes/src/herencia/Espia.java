package herencia;

import java.io.File;
import java.io.IOException;

public final class Espia extends Agente {
	private final String RUTA = "./recursos/pisos.txt";
	private File ficheroPisos;

	public Espia(String nombre, int edad, String direccion, double salario) {
		super(nombre, edad, direccion, salario);
		
		this.ficheroPisos = new File(RUTA);

		if (!ficheroPisos.exists()) {
			try {
				ficheroPisos.createNewFile();
			} catch (IOException e) {
			}
		}
	}

}
