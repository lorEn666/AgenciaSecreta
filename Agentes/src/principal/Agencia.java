package principal;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import herencia.Agente;
import herencia.Espia;
import herencia.Jefazo;
import herencia.Secreto;

/**
 * Clase que almacena (en un array) todos los agentes pertenecientes a la
 * agencia secreta. Contiene los métodos que simularían las funciones a realizar
 * por una agencia (ingresar nuevos agentes, búsquedas por salario, etc.).
 * Implementa la interfaz 'Serializable' que permitirá la escritura binaria en
 * disco de esta clase.
 * 
 * @author Borja Loren
 * @version 1.0.0
 * @since 10-02-2020
 *
 */
public class Agencia implements Serializable {
	private Agente[] agencia;

	/**
	 * Único constructor de la clase que inicializa el array (tipo de dato 'Agente')
	 * donde se almacenan todos los agentes (hasta un máximo de 20).
	 */
	public Agencia() {
		this.agencia = new Agente[20];
	}

	/**
	 * Método que registra un nuevo agente solicitando una serie de datos al usuario
	 * para llevar a cabo el registro en base a la opción escogida.
	 * 
	 * @throws InputMismatchException Lanzada cuando el tipo de dato introducido por
	 *                                el usuario no coincide con el solicitado.
	 *                                Excepción gestionada en la clase 'Main'.
	 */
	public void ingresarNuevoAgente() throws InputMismatchException {
		int opcion = 0;

		switch (opcion = Menu.menuIngreso()) {
		case 1:
			agencia[primerEspacioDisponible()] = new Jefazo(nombreAgente(), edadAgente(), direccionAgente(),
					salarioAgente(), mandatoJefazo());
			break;
		case 2:
			agencia[primerEspacioDisponible()] = new Espia(nombreAgente(), edadAgente(), direccionAgente(),
					salarioAgente());
			break;
		case 3:
			agencia[primerEspacioDisponible()] = new Secreto(nombreAgente(), edadAgente(), direccionAgente(),
					salarioAgente(), muertesAgenteSecreto());
		}
	}

	/**
	 * Método que busca la primera posición libre en el array que almacena los tipo
	 * de dato 'Agente'. Usado al registrar un nuevo miembro durante la ejecución
	 * del método ingresarNuevoAgente().
	 * 
	 * @return int i Primera posición libre del array.
	 */
	private int primerEspacioDisponible() {
		for (int i = 0; i < agencia.length; i++) {
			if (agencia[i] == null) {
				return i;
			}
		}
		System.err.println("Agencia completa. No pueden darse de alta nuevos agentes.");
		return -1;
	}

	/**
	 * Pregunta al usuario el nombre del agente a registrar.
	 * 
	 * @return String nombre introducido por el usuario.
	 */
	private String nombreAgente() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese nombre del nuevo agente:");
		return leer.nextLine().trim();
	}

	/**
	 * Pregunta al usuario la edad del agente a registrar.
	 * 
	 * @return int edad introducida por el usuario.
	 */
	private int edadAgente() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese edad del nuevo agente:");
		return leer.nextInt();
	}

	/**
	 * Pregunta al usuario la dirección del agente a registrar.
	 * 
	 * @return String dirección introducida por el usuario.
	 */
	private String direccionAgente() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese dirección del nuevo agente:");
		return leer.nextLine().trim();
	}

	/**
	 * Pregunta al usuario el salario del agente a registrar.
	 * 
	 * @return double salario introducido por el usuario.
	 */
	private double salarioAgente() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese salario mensual del nuevo agente:");
		return leer.nextDouble();
	}

	/**
	 * Pregunta al usuario por la duración del mandato del agente a registrar.
	 * Invocado solo si el registro es para un agente del tipo 'Jefazo'.
	 * 
	 * @return int años de duración del mandato introducidos por el usuario.
	 */
	private int mandatoJefazo() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese duración del mandato (en años) del nuevo jefazo:");
		return leer.nextInt();
	}

	/**
	 * Pregunta al usuario por el número de víctimas del agente a registrar.
	 * Invocado solo si el registro es para un agente del tipo 'Secreto'.
	 * 
	 * @return int número de víctimas introducido por el usuario.
	 */
	private int muertesAgenteSecreto() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese número de víctimas del nuevo agente secreto 007:");
		return leer.nextInt();
	}

	/**
	 * Método que muestra por pantalla todos los agentes registrados en la agencia
	 * (en el array agencia[]).
	 */
	public void listarTodosLosAgentes() {
		for (int i = 0; i < agencia.length; i++) {
			if (agencia[i] != null) {
				System.out.println(agencia[i]);
			}
		}
	}

	/**
	 * Método que busca todos los agentes registrados en la agencia que tengan un
	 * salario superior a la cantidad introducida por el usuario tras ser
	 * preguntado.
	 */
	public void busquedaAgentesPorSalario() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Inserte salario para filtrar la búsqueda:");
		double salarioBusqueda = leer.nextDouble();
		for (int i = 0; i < agencia.length; i++) {
			if (agencia[i] != null && agencia[i].getSalario() > salarioBusqueda) {
				System.out.println(agencia[i].getNombre());
			}
		}
	}

	/**
	 * Método invocado desde la clase 'IoDatos' que borra todas las posiciones del
	 * array que contengan un tipo de dato 'Agente'. Esto será usado tras la
	 * encriptación de los datos de la agencia.
	 */
	public void resetearAgencia() {
		for (int i = 0; i < agencia.length; i++) {
			if (agencia[i] != null)
				agencia[i] = null;
		}
	}
}
