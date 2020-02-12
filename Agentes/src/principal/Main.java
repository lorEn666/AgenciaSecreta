package principal;

import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		Agencia a = new Agencia();
		IoDatos d = new IoDatos();
		int opcion = 0;

		do {
			try {
				switch (opcion = Menu.menu()) {
				case 1:
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
					d.desencriptarInformacion(a);
				}
			} catch (InputMismatchException e) {
				System.err.println("Error. El tipo de dato introducido no coincide con el solicitado.");
			} catch (Exception e) {
			}
		} while (opcion != 8);
	}
}
