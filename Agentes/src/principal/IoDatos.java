package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IoDatos {
	private final String PISOS = "./recursos/pisos.txt";
	private final String ARMAS = "./recursos/armas.txt";
	private final String DATOS = "./recursos/datos.dat";

	private File pisos;
	private File armas;
	private File datos;
	private PrintWriter pw;
	private ObjectInputStream desencriptar;
	private ObjectOutputStream encriptar;

	public IoDatos() {
		this.pisos = new File(PISOS);
		this.armas = new File(ARMAS);
		this.datos = new File(DATOS);
		this.pw = null;
		this.desencriptar = null;
		this.encriptar = null;
	}

	private void abrirEscrituraPisos() {
		try {
			pw = new PrintWriter(new FileWriter(pisos, true));
		} catch (IOException e) {
		}
	}

	private void abrirEscrituraArmas() {
		try {
			pw = new PrintWriter(new FileWriter(armas, true));
		} catch (IOException e) {
		}
	}

	private void abrirEncriptacion() {
		try {
			encriptar = new ObjectOutputStream(new FileOutputStream(datos));
		} catch (IOException e) {
		}
	}

	private void abrirDesencriptacion() {
		try {
			desencriptar = new ObjectInputStream(new FileInputStream(datos));
		} catch (IOException e) {
		}
	}

	public void ingresarPiso() {
		Scanner leer = new Scanner(System.in);
		abrirEscrituraPisos();
		System.out.println("Ingrese localidad donde está ubicada el piso:");
		pw.print(leer.nextLine().trim() + ", ");
		System.out.println("Ingrese nombre de la ubicación del piso (Ej: Paseo Andrade):");
		pw.print(leer.nextLine().trim() + " ");
		System.out.println("Ingrese el número de la ubicación (Ej: 3):");
		try {
			pw.print("número " + leer.nextInt() + "\n");
		} catch (InputMismatchException e) {
			System.err.println("Error. Se le pide un número. El registro no ha podido llevarse a cabo.");
			return;
		}
		pw.close();
		System.out.println("Registro realizado con éxito.");
	}

	public void ingresarArma() {
		Scanner leer = new Scanner(System.in);
		abrirEscrituraArmas();
		System.out.println("Ingrese arma que desea registrar:");
		pw.print(leer.nextLine().trim() + "\n");
		pw.close();
		System.out.println("Registro realizado con éxito.");
	}

	public void encriptarInformacion(Agencia a) {
		abrirEncriptacion();

		try {
			encriptar.writeObject(a);
		} catch (IOException e) {
		} finally {
			try {
				encriptar.close();
				System.out.println("Datos encriptados con éxito.");
			} catch (IOException e) {
			}
		}

		if (pisos.exists())
			pisos.delete();

		if (armas.exists())
			armas.delete();

		a.resetearAgencia();
	}

	public void desencriptarInformacion(Agencia a) {
		abrirDesencriptacion();

		try {
			a = (Agencia) desencriptar.readObject();
		} catch (ClassNotFoundException | IOException e) {
		} finally {
			try {
				desencriptar.close();
				System.out.println("Datos desencriptados con éxito.");
			} catch (IOException e) {
			}
		}
	}
}
