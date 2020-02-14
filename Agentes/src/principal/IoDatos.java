package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	private final String DATOS_AGENCIA = "./recursos/datosAgencia.dat";
	private final String DATOS_PISOS = "./recursos/datosPisos.dat";
	private final String DATOS_ARMAS = "./recursos/datosArmas.dat";

	private File pisos;
	private File armas;
	private File datosAgencia;
	private File datosPisos;
	private File datosArmas;
	private Scanner sc;
	private PrintWriter pw;
	private DataInputStream desencriptarTxt;
	private DataOutputStream encriptarTxt;
	private ObjectInputStream desencriptar;
	private ObjectOutputStream encriptar;

	public IoDatos() {
		this.pisos = new File(PISOS);
		this.armas = new File(ARMAS);
		this.datosAgencia = new File(DATOS_AGENCIA);
		this.datosPisos = new File(DATOS_PISOS);
		this.datosArmas = new File(DATOS_ARMAS);
		this.sc = null;
		this.pw = null;
		this.desencriptarTxt = null;
		this.encriptarTxt = null;
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

	private void abrirEncriptacionAgencia() {
		try {
			encriptar = new ObjectOutputStream(new FileOutputStream(datosAgencia));
		} catch (IOException e) {
		}
	}

	private void abrirEncriptacionPisos() {
		try {
			sc = new Scanner(pisos);
			encriptarTxt = new DataOutputStream(new FileOutputStream(datosPisos));
		} catch (FileNotFoundException e) {
		}
	}

	private void abrirEncriptacionArmas() {
		try {
			sc = new Scanner(armas);
			encriptarTxt = new DataOutputStream(new FileOutputStream(datosArmas));
		} catch (FileNotFoundException e) {
		}
	}

	private void abrirDesencriptacionAgencia() {
		try {
			desencriptar = new ObjectInputStream(new FileInputStream(datosAgencia));
		} catch (IOException e) {
		}
	}

	private void abrirDesencriptacionPisos() {
		try {
			pw = new PrintWriter(new FileWriter(pisos, true));
			desencriptarTxt = new DataInputStream(new FileInputStream(datosPisos));
		} catch (IOException e) {
		}
	}

	private void abrirDesencriptacionArmas() {
		try {
			pw = new PrintWriter(new FileWriter(armas, true));
			desencriptarTxt = new DataInputStream(new FileInputStream(datosArmas));
		} catch (IOException e) {
		}
	}

	public void ingresarPiso() throws EncryptException {
		if (datosPisos.exists()) {
			throw new EncryptException(
					"No es posible realizar nuevos registros hasta desencriptar la información.");
		}
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

	public void ingresarArma() throws EncryptException {
		if (datosArmas.exists()) {
			throw new EncryptException(
					"No es posible realizar nuevos registros hasta desencriptar la información.");
		}
		Scanner leer = new Scanner(System.in);
		abrirEscrituraArmas();
		System.out.println("Ingrese arma que desea registrar:");
		pw.print(leer.nextLine().trim() + "\n");
		pw.close();
		System.out.println("Registro realizado con éxito.");
	}

	public void encriptarInformacion(Agencia a) throws EncryptException {
		if (!pisos.exists() || !armas.exists()) {
			throw new EncryptException("No existen datos suficientes para encriptar.");
		}
		abrirEncriptacionAgencia();

		try {
			encriptar.writeObject(a);
		} catch (IOException e) {
		} finally {
			try {
				encriptar.close();
			} catch (IOException e) {
			}
		}
		a.resetearAgencia();
		encriptarPisos();
		encriptarArmas();

	}

	private void encriptarPisos() {
		abrirEncriptacionPisos();

		try {
			while (sc.hasNextLine()) {
				encriptarTxt.writeUTF(sc.nextLine());
			}
		} catch (IOException e) {
		} finally {
			try {
				sc.close();
				encriptarTxt.close();
			} catch (IOException e) {
			}
		}
		pisos.delete();
	}

	private void encriptarArmas() {
		abrirEncriptacionArmas();

		try {
			while (sc.hasNextLine()) {
				encriptarTxt.writeUTF(sc.nextLine());
			}
		} catch (IOException e) {
		} finally {
			try {
				sc.close();
				encriptarTxt.close();
			} catch (IOException e) {
			}
		}
		armas.delete();
		System.out.println("Datos encriptados con éxito.");
	}

	public Agencia desencriptarInformacion(Agencia a) throws EncryptException {
		if (!datosAgencia.exists() || !datosPisos.exists() || !datosArmas.exists()) {
			throw new EncryptException("No existen datos encriptados.");
		}

		desencriptarPisos();
		desencriptarArmas();
		abrirDesencriptacionAgencia();

		try {
			a = (Agencia) desencriptar.readObject();
		} catch (ClassNotFoundException | IOException e) {
		} finally {
			try {
				desencriptar.close();
			} catch (IOException e) {
			}
		}
		datosAgencia.delete();
		System.out.println("Datos desencriptados con éxito");
		return a;
	}

	private void desencriptarPisos() {
		abrirDesencriptacionPisos();

		try {
			while (true) {
				pw.write(desencriptarTxt.readUTF() + "\n");
			}
		} catch (IOException e) {
		} finally {
			try {
				pw.close();
				desencriptarTxt.close();
			} catch (IOException e) {
			}
		}
		datosPisos.delete();
	}

	private void desencriptarArmas() {
		abrirDesencriptacionArmas();

		try {
			while (true) {
				pw.write(desencriptarTxt.readUTF() + "\n");
			}
		} catch (IOException e) {
		} finally {
			try {
				pw.close();
				desencriptarTxt.close();
			} catch (IOException e) {
			}
		}
		datosArmas.delete();
	}

	public void comprobacion() throws EncryptException {
		if (datosAgencia.exists()) {
			throw new EncryptException(
					"No es posible realizar nuevos registros hasta desencriptar la información.");
		}
	}
}
