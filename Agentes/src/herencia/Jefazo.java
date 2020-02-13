package herencia;

/**
 * Clase que hereda de la clase 'Agente'. Posee modificador de acceso 'final'
 * indicando que nadie m�s heredar� de esta clase. Esta clase cuenta con un
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
	 * �nico constructor de la clase que cuenta con sus atributos m�s los heredados
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
		return "**************************" + super.toString() + "\n\nDuraci�n del mandato: " + duracionDelMandato
				+ "\n\n**************************";
	}
}
