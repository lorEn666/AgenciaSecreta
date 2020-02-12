package herencia;

import java.io.File;
import java.io.IOException;

public final class Secreto extends Agente {
	private final String RUTA="./recursos/armas.txt";
	private int muertes;
	private File ficheroArmas;
	
	public Secreto(String nombre, int edad, String direccion, double salario, int muertes) {
		super(nombre, edad, direccion, salario);
		
		this.muertes = muertes;
		this.ficheroArmas = new File(RUTA);

		if (!ficheroArmas.exists()) {
			try {
				ficheroArmas.createNewFile();
			} catch (IOException e) {
			}
		}
	}
	
	
}
