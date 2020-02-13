package principal;

/**
 * Clase desde la que se crear� una nueva excepci�n que lanzar� el programa
 * cuando cualquier aspecto relacionado con la encriptaci�n/desencriptaci�n lo
 * requiera. Hereda de la clase 'Exception'.
 * 
 * @author Borja Loren
 * @version 1.0.0
 * @since 10-02-2020
 *
 */
public class EncriptacionException extends Exception {
	/**
	 * Constructor de la clase.
	 * 
	 * @param String mensajeError heredado de la clase padre 'Exception'
	 */
	public EncriptacionException(String mensajeError) {
		super(mensajeError);
	}
}
