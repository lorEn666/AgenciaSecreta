package herencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public final class Secreto extends Agente {
	private final String RUTA = "./recursos/armas.txt";
	private int muertes;

	public Secreto(String nombre, int edad, String direccion, double salario, int muertes) {
		super(nombre, edad, direccion, salario);
		this.muertes = muertes;
	}

	public String getArmas() {
		String armas = "";
		File ficheroArmas = new File(RUTA);
		try {
			Scanner sc = new Scanner(ficheroArmas);
			while (sc.hasNextLine()) {
				armas += sc.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
		}
		return armas;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\nVíctimas: " + muertes + "\n\nArmas asignadas:\n" + getArmas();
	}
}
