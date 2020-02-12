package herencia;

public final class Jefazo extends Agente {
	private int duracionDelMandato;

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
