package principal;

import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		Agencia a = new Agencia();
		int opcion = 0;

		do {
			try {
				switch (opcion = Menu.menu()) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					a.ingresarNuevoAgente();
					break;
				case 6:
					break;
				case 7:

				}
			} catch (InputMismatchException e) {
				System.err.println("Error. El tipo de dato introducido no coincide con el solicitado.");
			} catch (Exception e) {
			}
		} while (opcion != 8);
	}
}
