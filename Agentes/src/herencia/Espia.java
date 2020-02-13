package herencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public final class Espia extends Agente {
	private final String RUTA = "./recursos/pisos.txt";

	public Espia(String nombre, int edad, String direccion, double salario) {
		super(nombre, edad, direccion, salario);
	}

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
