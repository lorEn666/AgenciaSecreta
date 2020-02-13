package herencia;

/**
 * Clase que hereda de la clase 'Agente'. Posee modificador de acceso 'final'
 * indicando que nadie más heredará de esta clase. Esta clase cuenta con un
 * 'toString()' especial.
 * 
 * @author Borja Loren
 * @version 1.0.0
 * @since 10-02-2020
 *
 */
public final class Jefazo extends Agente {
	private int duracionDelMandato;

	/**
	 * Único constructor de la clase que cuenta con sus atributos más los heredados
	 * de la clase 'Agente'.
	 * 
	 * @param String nombre
	 * @param int edad
	 * @param String direccion
	 * @param double salario
	 * @param int duracionDelMandato
	 */
	public Jefazo(String nombre, int edad, String direccion, double salario, int duracionDelMandato) {
		super(nombre, edad, direccion, salario);
		this.duracionDelMandato = duracionDelMandato;
	}

	@Override
	public String toString() {
		return "**************************" + super.toString() + "\n\nDuración del mandato: " + duracionDelMandato
				+ "\n\n**************************";
	}
}
