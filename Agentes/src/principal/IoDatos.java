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
	private PrintWriter pw;
	private ObjectInputStream desencriptar;
	private ObjectOutputStream encriptar;

	public IoDatos() {
		this.pw = null;
		this.desencriptar = null;
		this.encriptar = null;
	}

	private void abrirEscrituraPisos() {
		try {
			pw = new PrintWriter(new FileWriter("./recursos/pisos.txt", true));
		} catch (IOException e) {
		}
	}

	private void abrirEscrituraArmas() {
		try {
			pw = new PrintWriter(new FileWriter("./recursos/armas.txt", true));
		} catch (IOException e) {
		}
	}

	private void abrirEncriptacion() {
		try {
			encriptar = new ObjectOutputStream(new FileOutputStream("./recursos/datos.dat"));
		} catch (IOException e) {
		}
	}

	private void abrirDesencriptacion() {
		try {
			desencriptar = new ObjectInputStream(new FileInputStream("./recursos/datos.dat"));
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
		System.out.println("Ingrese arma que desea ingresar:");
		pw.print(leer.nextLine().trim() + "\n");
		pw.close();
		System.out.println("Registro realizado con éxito.");
	}
	
	public void encriptarInformacion(Agencia a) {
		File pisos = new File("./recursos/pisos.txt");
		File armas = new File("./recursos/armas.txt");
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
		}
	}
}
