package principal;

import java.util.InputMismatchException;

/**
 * Aplicación que simula el registro de agentes que trabajan para una agencia
 * secreta. Un agente puede ser de varios tipos (herencia) y la información
 * sensible de la agencia podrá ser encriptada (ficheros).
 * 
 * @author Borja Loren
 * @version 1.0.0
 * @since 10-02-2020
 *
 */
public class Main {

	/**
	 * Método principal que dará funcionalidad a la opción escogida por el usuario
	 * tras pintar el menú. Al inicio de la ejecución se crea un tipo de dato
	 * 'Agencia' y otro 'IoDatos' para trabajar con ellos. Aquí se gestionarán gran
	 * parte de las excepciones que lancen los métodos usados durante la ejecución.
	 * 
	 * @param String[] args
	 */
	public static void main(String[] args) {
		Agencia a = new Agencia();
		IoDatos d = new IoDatos();
		int opcion = 0;

		do {
			try {
				switch (opcion = Menu.menu()) {
				case 1:
					d.comprobacion();
					a.listarTodosLosAgentes();
					break;
				case 2:
					a.busquedaAgentesPorSalario();
					break;
				case 3:
					d.ingresarPiso();
					break;
				case 4:
					d.ingresarArma();
					break;
				case 5:
					a.ingresarNuevoAgente();
					break;
				case 6:
					d.encriptarInformacion(a);
					break;
				case 7:
					a = d.desencriptarInformacion(a);
				}
			} catch (InputMismatchException e) {
				System.err.println("Error. El tipo de dato introducido no coincide con el solicitado.");
			} catch (EncryptException e) {
				System.err.println(e.getMessage());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} while (opcion != 8);
	}
}
