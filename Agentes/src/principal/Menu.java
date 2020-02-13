package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que contiene los métodos que pintan los menús usados durante la
 * ejecución de la aplicación.
 * 
 * @author Borja Loren
 * @version 1.0.0
 * @since 10-02-2020
 *
 */
public class Menu {

	/**
	 * Método que pinta el menú principal de la aplicación.
	 * 
	 * @return int opción escogida por el usuario.
	 * 
	 * @throws InputMismatchException lanzada cuando el tipo de dato introducido por
	 *                                el usuario no coincide con el solicitado.
	 *                                Excepción gestionada en la clase 'Main'.
	 */
	public static int menu() throws InputMismatchException {
		Scanner leer = new Scanner(System.in);
		System.out.println("1) Listar todos los agentes");
		System.out.println("2) Búsqueda por salario");
		System.out.println("3) Ingresar nuevo piso");
		System.out.println("4) Ingresar nueva arma");
		System.out.println("5) Ingresar nuevo agente");
		System.out.println("6) Encriptar toda la información");
		System.out.println("7) Desencriptar toda la información");
		System.out.println("8) Salir");
		return leer.nextInt();
	}

	/**
	 * Método que pinta el menú durante el ingreso de un nuevo agente.
	 * 
	 * @return int opción escogida por el usuario.
	 * 
	 * @throws InputMismatchException lanzada cuando el tipo de dato introducido por
	 *                                el usuario no coincide con el solicitado.
	 *                                Excepción gestionada en la clase 'Main'.
	 */
	public static int menuIngreso() throws InputMismatchException {
		Scanner leer = new Scanner(System.in);
		System.out.println("1) Jefazo");
		System.out.println("2) Agente espía");
		System.out.println("3) Agente secreto 007");
		System.out.println("4) Volver");
		return leer.nextInt();
	}
}
