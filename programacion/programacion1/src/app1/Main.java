package app1;

import app1.Equipo;
import app1.Futbolista;
import app1.Ficheros;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.Normalizer;
import java.io.Serializable;

/**
 * Este programa permite gestionar un equipo de fútbol con sus futbolistas
 * Además, implementa un juego sencillo y dinámico
 * @author: Javier Rodríguez Cortés
 * @version: 01/06/2023/B
 * @see <a href = "https://orchid-button-554758.framer.app"/> miJavaDoc – Mi primer JavaDoc </a>
 */

public class Main {
	
	private static boolean equipoLleno = false;
	
	public static void main(String[] args) {
		// Primero, creamos el ArrayList en el que vamos a guardar los futbolistas
		ArrayList<Futbolista> alineacion = new ArrayList<>();
		ArrayList<Equipo> equipoActual = new ArrayList<>();

		// Definimos las variables que vamos a usar para el menú
		int opcion = 0; // Opción elegida
		boolean isRunning = true; // Bandera + comprobación
		Scanner scanner = new Scanner(System.in); // Scanner para leer la elección del usuario

		while (isRunning == true) {

			// Menú CRUD
			System.out.println("+- Menú ---------------------------------+");
			System.out.println("|  1) Jugar                              |");
			System.out.println("|  2) Equipo                             |");
			System.out.println("|  3) Guardar partida                    |");
			System.out.println("|  4) Cargar partida                     |");
			System.out.println("|  0) Salir                              |");
			System.out.println("+----------------------------------------+");
			System.out.print("\n-> Elige una opción: ");

			opcion = scanner.nextInt();
			System.out.println("\n");

			// Switch para interactuar con el usuario
			// Antes de cada método se comprueba que haya un equipo creado
			switch (opcion) {
			case 1:
				Jugar.main(args); // Método para jugar
				break;
			case 2:
				menuEquipo(alineacion, equipoActual); // Menú de equipo
				equipoLleno = true;
				break;
			case 3:
				if (equipoLleno == true) {
					Ficheros.save(alineacion, equipoActual); // Guardar en ficheros
				} else {
					System.err.println("Primero debes crear un equipo!!!\n\n");
				}
				break;
			case 4:
				Ficheros.load(alineacion, equipoActual); // Cargar datos desde fichero
				equipoLleno = true;
				break;
			case 0:
				String s = "😄";
				System.out.println("Bye bye! " + s);
				isRunning = false;
				break;
			default:
				System.err.println("ERROR:\nOpción no válida.\n");
				break;
			}
		}
		scanner.close();
	}

	public static void menuEquipo(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos) {
		// Definimos las variables que vamos a usar para el menú
		int opcion = 0; // Opción elegida
		boolean isRunning = true; // Bandera + comprobación
		Scanner scanner = new Scanner(System.in); // Scanner para leer la elección del usuario

		while (isRunning == true) {

			// Menú CRUD
			System.out.println("\n\n+- Menú ---------------------------------+");
			System.out.println("|  1) Listar equipos                     |");
			System.out.println("|  2) Listar futbolistas                 |");
			System.out.println("|  3) Añadir equipo                      |");
			System.out.println("|  4) Editar equipo                      |");
			System.out.println("|  5) Eliminar equipo                    |");
			System.out.println("|  0) Salir                              |");
			System.out.println("+----------------------------------------+");
			System.out.print("\n-> Elige una opción: ");

			opcion = scanner.nextInt();
			System.out.println("\n");

			// Switch para interactuar con el usuario
			// Antes de cada método se comprueba que haya un equipo creado
			switch (opcion) {
			case 1:
				if (equipoLleno == true) {
					MetodosEquipo.listarEquipos(alineacion, equipos);
				} else {
					System.out.println("Parece que no hay ningún equipo creado. ¿Quieres añadir 2 equipos para jugar? (si/no)");
					String s = "";
					Scanner scanner2 = new Scanner(System.in);
					s = scanner2.nextLine();

					s = Normalizer.normalize(s, Normalizer.Form.NFD);
					s = s.toLowerCase();
					s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

					if (s.equals("si")) {
						MetodosEquipo.generarEquipos(alineacion, equipos);
						equipoLleno = true;
					}
				}
				break;
			case 2:
				if (equipoLleno == true) {
					MetodosEquipo.listarFutbolistas(alineacion, equipos);
				} else {
					System.out.println("Parece que no hay ningún equipo creado. ¿Quieres añadir 2 equipos para jugar?");
					String s = "";
					Scanner scanner2 = new Scanner(System.in);
					s = scanner2.nextLine();

					s = Normalizer.normalize(s, Normalizer.Form.NFD);
					s = s.toLowerCase();
					s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

					if (s.equals("si")) {
						MetodosEquipo.generarEquipos(alineacion, equipos);
						equipoLleno = true;
					}
				}
				break;
			case 3:
				if (equipoLleno == true) {
					MetodosEquipo.addEquipo(alineacion, equipos);
				} else {
					System.out.println("Parece que no hay ningún equipo creado. ¿Quieres añadir 2 equipos para jugar?");
					String s = "";
					Scanner scanner2 = new Scanner(System.in);
					s = scanner2.nextLine();

					// Pasamos el texto a minúsculas y quitamos las tildes para optimizarlo
					s = Normalizer.normalize(s, Normalizer.Form.NFD);
					s = s.toLowerCase();
					s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

					if (s.equals("si")) {
						MetodosEquipo.generarEquipos(alineacion, equipos);
						equipoLleno = true;
					}
				}
				break;
			case 4:
				if (equipoLleno == true) {
					MetodosEquipo.editEquipo(alineacion, equipos);
				} else {
					System.out.println("Parece que no hay ningún equipo creado. ¿Quieres añadir 2 equipos para jugar?");
					String s = "";
					Scanner scanner2 = new Scanner(System.in);
					s = scanner2.nextLine();

					s = Normalizer.normalize(s, Normalizer.Form.NFD);
					s = s.toLowerCase();
					s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

					if (s.equals("si")) {
						MetodosEquipo.generarEquipos(alineacion, equipos);
						equipoLleno = true;
					}
				}
				break;
			case 5:
				if (equipoLleno == true) {
					MetodosEquipo.rmEquipo(alineacion, equipos);
				} else {
					System.out.println("Parece que no hay ningún equipo creado. ¿Quieres añadir 2 equipos para jugar? (si/no)");
					String s = "";
					Scanner scanner2 = new Scanner(System.in);
					s = scanner2.nextLine();

					s = Normalizer.normalize(s, Normalizer.Form.NFD);
					s = s.toLowerCase();
					s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

					if (s.equals("si")) {
						MetodosEquipo.generarEquipos(alineacion, equipos);
						equipoLleno = true;
					}
				}
				break;
			case 0:
				isRunning = false;
				break;
			default:
				System.err.println("ERROR:\nOpción no válida.\n");
				break;
			}
		}
	}
}
