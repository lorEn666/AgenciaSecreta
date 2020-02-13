package principal;

import java.io.Serializable;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import herencia.Agente;
import herencia.Espia;
import herencia.Jefazo;
import herencia.Secreto;

public class Agencia implements Serializable {
	private Agente[] agencia;

	public Agencia() {
		this.agencia = new Agente[20];
	}

	public void ingresarNuevoAgente() throws InputMismatchException {
		int opcion = 0;

		switch (opcion = Menu.menuIngreso()) {
		case 1:
			agencia[primerEspacioDisponible()] = new Jefazo(nombreAgente(), edadAgente(), direccionAgente(),
					salarioAgente(), mandatoJefazo());
			break;
		case 2:
			agencia[primerEspacioDisponible()] = new Espia(nombreAgente(), edadAgente(), direccionAgente(),
					salarioAgente());
			break;
		case 3:
			agencia[primerEspacioDisponible()] = new Secreto(nombreAgente(), edadAgente(), direccionAgente(),
					salarioAgente(), muertesAgenteSecreto());
		}
	}

	private int primerEspacioDisponible() {
		for (int i = 0; i < agencia.length; i++) {
			if (agencia[i] == null) {
				return i;
			}
		}
		System.err.println("Agencia completa. No pueden darse de alta nuevos agentes.");
		return -1;
	}

	private String nombreAgente() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese nombre del nuevo agente:");
		return leer.nextLine().trim();
	}

	private int edadAgente() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese edad del nuevo agente:");
		return leer.nextInt();
	}

	private String direccionAgente() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese dirección del nuevo agente:");
		return leer.nextLine().trim();
	}

	private double salarioAgente() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese salario mensual del nuevo agente:");
		return leer.nextDouble();
	}

	private int mandatoJefazo() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese duración del mandato (en años) del nuevo jefazo:");
		return leer.nextInt();
	}

	private int muertesAgenteSecreto() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese número de víctimas del nuevo agente secreto 007:");
		return leer.nextInt();
	}

	public void listarTodosLosAgentes() {
		for (int i = 0; i < agencia.length; i++) {
			if (agencia[i] != null) {
				System.out.println(agencia[i]);
			}
		}
	}

	public void busquedaAgentesPorSalario() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Inserte salario para filtrar la búsqueda:");
		double salarioBusqueda = leer.nextDouble();
		for (int i = 0; i < agencia.length; i++) {
			if (agencia[i] != null && agencia[i].getSalario() > salarioBusqueda) {
				System.out.println(agencia[i].getNombre());
			}
		}
	}

	public void resetearAgencia() {
		for (int i = 0; i < agencia.length; i++) {
			if (agencia[i] != null)
				agencia[i] = null;
		}
	}
}
