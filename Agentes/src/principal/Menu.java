package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que contiene los m�todos que pintan los men�s usados durante la
 * ejecuci�n de la aplicaci�n.
 * 
 * @author Borja Loren
 * @version 1.0.0
 * @since 10-02-2020
 *
 */
public class Menu {

	/**
	 * M�todo que pinta el men� principal de la aplicaci�n.
	 * 
	 * @return int opci�n escogida por el usuario.
	 * 
	 * @throws InputMismatchException lanzada cuando el tipo de dato introducido por
	 *                                el usuario no coincide con el solicitado.
	 *                                Excepci�n gestionada en la clase 'Main'.
	 */
	public static int menu() throws InputMismatchException {
		Scanner leer = new Scanner(System.in);
		System.out.println("1) Listar todos los agentes");
		System.out.println("2) B�squeda por salario");
		System.out.println("3) Ingresar nuevo piso");
		System.out.println("4) Ingresar nueva arma");
		System.out.println("5) Ingresar nuevo agente");
		System.out.println("6) Encriptar toda la informaci�n");
		System.out.println("7) Desencriptar toda la informaci�n");
		System.out.println("8) Salir");
		return leer.nextInt();
	}

	/**
	 * M�todo que pinta el men� durante el ingreso de un nuevo agente.
	 * 
	 * @return int opci�n escogida por el usuario.
	 * 
	 * @throws InputMismatchException lanzada cuando el tipo de dato introducido por
	 *                                el usuario no coincide con el solicitado.
	 *                                Excepci�n gestionada en la clase 'Main'.
	 */
	public static int menuIngreso() throws InputMismatchException {
		Scanner leer = new Scanner(System.in);
		System.out.println("1) Jefazo");
		System.out.println("2) Agente esp�a");
		System.out.println("3) Agente secreto 007");
		System.out.println("4) Volver");
		return leer.nextInt();
	}
}
