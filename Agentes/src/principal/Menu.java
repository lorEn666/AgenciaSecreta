package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

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
	
	public static int menuIngreso() throws InputMismatchException {
		Scanner leer = new Scanner(System.in);
		System.out.println("1) Jefazo");
		System.out.println("2) Agente espía");
		System.out.println("3) Agente secreto 007");
		System.out.println("4) Volver");
		return leer.nextInt();
	}
}
