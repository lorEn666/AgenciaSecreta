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

/**
 * Clase que se encarga de todas las gestiones a la hora de escribir fichero de
 * texto y binarios empleando los m�todos que contiene.
 * 
 * @author Borja Loren
 * @version 1.0.0
 * @since 10-02-2020
 *
 */
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

	/**
	 * �nico constructor de la clase que tiene como atributos todas las clases
	 * necesarias para escritura y lectura tanto de fichero de texto plano como de
	 * ficheros binarios, as� como los 'File' con sus respectivas rutas.
	 */
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
			throw new EncryptException("No es posible realizar nuevos registros hasta desencriptar la informaci�n.");
		}
		Scanner leer = new Scanner(System.in);
		abrirEscrituraPisos();
		System.out.println("Ingrese localidad donde est� ubicada el piso:");
		pw.print(leer.nextLine().trim() + ", ");
		System.out.println("Ingrese nombre de la ubicaci�n del piso (Ej: Paseo Andrade):");
		pw.print(leer.nextLine().trim() + " ");
		System.out.println("Ingrese el n�mero de la ubicaci�n (Ej: 3):");
		try {
			pw.print("n�mero " + leer.nextInt() + "\n");
		} catch (InputMismatchException e) {
			System.err.println("Error. Se le pide un n�mero. El registro no ha podido llevarse a cabo.");
			return;
		}
		pw.close();
		System.out.println("Registro realizado con �xito.");
	}

	public void ingresarArma() throws EncryptException {
		if (datosArmas.exists()) {
			throw new EncryptException("No es posible realizar nuevos registros hasta desencriptar la informaci�n.");
		}
		Scanner leer = new Scanner(System.in);
		abrirEscrituraArmas();
		System.out.println("Ingrese arma que desea registrar:");
		pw.println(leer.nextLine().trim());
		pw.close();
		System.out.println("Registro realizado con �xito.");
	}

	/**
	 * M�todo encargado de pasar la clase 'Agencia' a un fichero binario antes del
	 * reseteo contenido en dicha clase. Tras esto se llama a los m�todos
	 * encriptarPisos() y encriptarArmas().
	 * 
	 * @param Agencia a
	 * @throws EncryptException
	 */
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
		System.out.println("Datos encriptados con �xito.");
	}

	/**
	 * M�todo que devuelve el estado original a la clase 'Agencia' y desde donde se
	 * llaman los m�todos desencriptarPisos() y desencriptarArmas() que har�n lo
	 * propio restableciendo los ficheros de texto que los conten�an.
	 * 
	 * @param Agencia a
	 * @return Agencia a
	 * @throws EncryptException Excepci�n lanzada cuando no existan datos
	 *                          encriptados. Permitir� abortar el m�todo y saltar
	 *                          directamente a la clase 'Main' que es desde donde se
	 *                          gestiona.
	 */
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
		System.out.println("Datos desencriptados con �xito");
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

	/**
	 * M�todo llamado desde la clase 'Main' que comprueba si los datos de la clase
	 * 'Agencia' han sido encriptados anteriormente. De ser as�, lanz�ra la
	 * excepci�n y la aplicaci�n no permitir� el registro de nuevos agentes hasta
	 * desencriptar la informaci�n.
	 * 
	 * @throws EncryptException Excepci�n gestionada desde la clase 'Main'.
	 */
	public void comprobacion() throws EncryptException {
		if (datosAgencia.exists()) {
			throw new EncryptException("No es posible realizar nuevos registros hasta desencriptar la informaci�n.");
		}
	}
}
