package app1;

import app1.Equipo;
import app1.Futbolista;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.Normalizer;
import java.io.Serializable;

public class MetodosEquipo {

	public static void generarEquipos(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos) {
		/* Limpiamos la pantalla */
		System.out.print("\033[H\033[2J");
		System.out.flush();

		// Generamos el equipo con el que España ganó el Mundial
		Equipo equipo1 = new Equipo("España 2010", "ESP2010");
		equipos.add(equipo1);

		// Creamos los futbolistas
		Futbolista futbolista1 = new Futbolista("Iker Casillas", 1, "Portero", "ESP2010");
		Futbolista futbolista2 = new Futbolista("Sergio Ramos", 15, "Defensa", "ESP2010");
		Futbolista futbolista3 = new Futbolista("Carles Puyol", 5, "Defensa", "ESP2010");
		Futbolista futbolista4 = new Futbolista("Gerard Piqué", 3, "Defensa", "ESP2010");
		Futbolista futbolista5 = new Futbolista("Joan Capdevila", 11, "Defensa", "ESP2010");
		Futbolista futbolista6 = new Futbolista("Sergio Busquets", 16, "Centrocampista", "ESP2010");
		Futbolista futbolista7 = new Futbolista("Xabi Alonso", 14, "Centrocampista", "ESP2010");
		Futbolista futbolista8 = new Futbolista("Xavi Hernández", 8, "Centrocampista", "ESP2010");
		Futbolista futbolista9 = new Futbolista("Pedro Rodríguez", 7, "Delantero", "ESP2010");
		Futbolista futbolista10 = new Futbolista("David Villa", 9, "Delantero", "ESP2010");
		Futbolista futbolista11 = new Futbolista("Andrés Iniesta", 6, "Delantero", "ESP2010");

		// Añadimos los futbolistas al ArrayList
		alineacion.add(futbolista1);
		alineacion.add(futbolista2);
		alineacion.add(futbolista3);
		alineacion.add(futbolista4);
		alineacion.add(futbolista5);
		alineacion.add(futbolista6);
		alineacion.add(futbolista7);
		alineacion.add(futbolista8);
		alineacion.add(futbolista9);
		alineacion.add(futbolista10);
		alineacion.add(futbolista11);

		// Generamos el equipo con el que Holanda perdió contra España en el mundial
		Equipo equipo2 = new Equipo("Holanda 2010", "NED2010");
		equipos.add(equipo2);

		// Creamos los futbolistas
		Futbolista futbolista12 = new Futbolista("Maarten Stekelenburg", 1, "Portero", "NED2010");
		Futbolista futbolista13 = new Futbolista("Gregory van der Wiel", 2, "Defensa", "NED2010");
		Futbolista futbolista14 = new Futbolista("John Heitinga", 3, "Defensa", "NED2010");
		Futbolista futbolista15 = new Futbolista("Joris Mathijsen", 4, "Defensa", "NED2010");
		Futbolista futbolista16 = new Futbolista("Van Bronckhorst", 5, "Defensa", "NED2010");
		Futbolista futbolista17 = new Futbolista("Mark van Bommel", 6, "Centrocampista", "NED2010");
		Futbolista futbolista18 = new Futbolista("Nigel de Jong", 7, "Centrocampista", "NED2010");
		Futbolista futbolista19 = new Futbolista("Dirk Kuyt", 8, "Centrocampista", "NED2010");
		Futbolista futbolista20 = new Futbolista("Wesley Sneijder", 9, "Delantero", "NED2010");
		Futbolista futbolista21 = new Futbolista("Arjen Robben", 10, "Delantero", "NED2010");
		Futbolista futbolista22 = new Futbolista("Robin van Persie", 11, "Delantero", "NED2010");

		// Añadimos los futbolistas al ArrayList
		alineacion.add(futbolista12);
		alineacion.add(futbolista13);
		alineacion.add(futbolista14);
		alineacion.add(futbolista15);
		alineacion.add(futbolista16);
		alineacion.add(futbolista17);
		alineacion.add(futbolista18);
		alineacion.add(futbolista19);
		alineacion.add(futbolista20);
		alineacion.add(futbolista21);
		alineacion.add(futbolista22);

		System.out.println("\nEquipos generados correctamente:\n\n"); // Mensaje de éxito
		listarEquipos(alineacion, equipos);
	}

	public static void listarEquipos(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos) {
		/* Limpiamos la pantalla */
		System.out.print("\033[H\033[2J");
		System.out.flush();

		// Vista de plantilla
		System.out.println("\nEquipos guardados:\n");

		// Cabecera de la tabla:
		System.out.println("+--------------------+-----------+");
		System.out.println("| Equipo             | Jugadores |");
		System.out.println("+--------------------+-----------+");

		for (Equipo equipo : equipos) {
			int sizePlantilla = 0;

			for (Futbolista futbolista : alineacion) {
				String codEquipo = futbolista.getCodEquipo(); // Obtener el código de equipo del futbolista

				if (codEquipo.equals(equipo.getCodEquipo())) {
					sizePlantilla++;
				}
			}

			System.out.printf("| %-18s | %-9s |%n", equipo.getNomEquipo(), sizePlantilla);
		}

		System.out.print("+--------------------+-----------+\n\n");
	}

	public static void listarFutbolistas(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos) {
		/* Limpiamos la pantalla */
		System.out.print("\033[H\033[2J");
		System.out.flush();

		// Vista de plantilla
		System.out.println("\nEquipo actual:\n");

		// Bucle para mostrar el ArrayList
		System.out.println("+------------------------+--------+--------------------+--------------------+");
		System.out.println("| Futbolista             | Dorsal | Posición           | Equipo             |");
		System.out.println("+------------------------+--------+--------------------+--------------------+");

		for (Futbolista futbolista : alineacion) {
			String nomEquipo = "";
			String codEquipo = futbolista.getCodEquipo(); // Obtener el código de equipo del futbolista

			for (Equipo equipo : equipos) {
				if (codEquipo.equals(equipo.getCodEquipo())) {
					nomEquipo = equipo.getNomEquipo();
					break;
				}
			}

			System.out.printf("| %-22s | %-6s | %-18s | %-18s |%n", futbolista.getNomJugador(), futbolista.getDorsal(),
					futbolista.getPosicion(), nomEquipo); // Usamos printf para darle formato a la lista
		}

		System.out.print("+------------------------+--------+--------------------+--------------------+\n\n");

		System.out.println("                  ___________");
		System.out.println("                 '._==_==_=_.'");
		System.out.println("                 .-):      (-.");
		System.out.println("                | (|:.     |) |");
		System.out.println("                 '-|:.     |-'");
		System.out.println("                   )::.    (");
		System.out.println("                    '::. .'");
		System.out.println("                      ) (");
		System.out.println("                    _.' '._");
		System.out.println("                   '''''''''\n\n");
	}

	public static void addEquipo(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos) {
		/* Limpiamos la pantalla */
		System.out.print("\033[H\033[2J");
		System.out.flush();

		Scanner sc = new Scanner(System.in);

		System.out.println("Escribe el nombre del nuevo equipo: ");
		String nuevoNomEquipo = sc.nextLine();
		System.out.println("Escribe el código de identificación del equipo (por ejemplo - ESP2010): ");
		String nuevoCodEquipo = sc.nextLine();

		System.out.println("Quieres añadir el equipo " + nuevoNomEquipo + ", con el código " + nuevoCodEquipo
				+ ". ¿Es correcto? (si/no)");
		String opcion = sc.nextLine();
		boolean isRunning = true;
		while (isRunning) {
			switch (opcion) {
			case "si":
				Equipo equipoNuevo = new Equipo(nuevoNomEquipo, nuevoCodEquipo);
				equipos.add(equipoNuevo);
				System.out.println("\nEquipo creado correctamente.");
				isRunning = false;
				break;
			case "no":
				System.err.println("\nOperación cancelada.");
				isRunning = false;
				break;
			default:
				System.out.println("\nERROR:\nOpción no válida.\n");
				break;
			}
		}

		System.out.println("\nAñade futbolistas...");

		addFutbolista(alineacion, equipos, nuevoCodEquipo);

		System.out.println("Equipo creado correctamente: ");
	}

	public static void editEquipo(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos) {
		/* Limpiamos la pantalla */
		System.out.print("\033[H\033[2J");
		System.out.flush();

		Scanner sc = new Scanner(System.in);

		// Vista de plantilla
		System.out.println("\nNombre del equipo: ");
		String nomEquipo = sc.nextLine();
		String codEquipo = "";

		// Comprobamos la existencia del equipo
		boolean equipoEncontrado = false;
		for (Equipo equipo : equipos) {
			if (nomEquipo.equals(equipo.getNomEquipo())) {
				equipoEncontrado = true;
				codEquipo = equipo.getCodEquipo();
				break;
			}
		}

		if (!equipoEncontrado) {
			System.err.println("\nNo se encontró el equipo especificado.");
			return;
		}

		// Bucle para mostrar el ArrayList
		System.out.println("+------------------------+--------+--------------------+--------------------+");
		System.out.println("| Futbolista             | Dorsal | Posición           | Equipo             |");
		System.out.println("+------------------------+--------+--------------------+--------------------+");

		for (Futbolista futbolista : alineacion) {
			if (codEquipo.equals(futbolista.getCodEquipo())) {
				System.out.printf("| %-22s | %-6s | %-18s | %-18s |%n", futbolista.getNomJugador(),
						futbolista.getDorsal(), futbolista.getPosicion(), nomEquipo);
			}
		}
		System.out.println("+------------------------+--------+--------------------+--------------------+");

		System.out.println("\n¿Qué quieres hacer?");
		int opcion = 0; // Opción elegida
		boolean isRunning = true, equipoLleno = false; // Bandera + comprobación
		Scanner scanner = new Scanner(System.in); // Scanner para leer la elección del usuario

		while (isRunning == true) {

			// Menú CRUD
			System.out.println("\n\n+- Menú ---------------------------------+");
			System.out.println("|  1) Listar futbolistas                 |");
			System.out.println("|  2) Añadir futbolista                  |");
			System.out.println("|  3) Editar futbolista                  |");
			System.out.println("|  4) Eliminar futbolista                |");
			System.out.println("|  0) Salir                              |");
			System.out.println("+----------------------------------------+");
			System.out.print("\n-> Elige una opción: ");

			opcion = scanner.nextInt();
			System.out.println("\n");

			// Switch para interactuar con el usuario
			// Antes de cada método se comprueba que haya un equipo creado
			switch (opcion) {
			case 1:
				mostrarEquipo(alineacion, equipos);
				break;
			case 2:
				addFutbolista(alineacion, equipos, codEquipo);
				break;
			case 3:
				editFutbolista(alineacion, equipos);
				break;
			case 4:
				rmFutbolista(alineacion, equipos);
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

	public static void addFutbolista(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos,
			String nuevoCodEquipo) {
		/* Limpiamos la pantalla */
		System.out.print("\033[H\033[2J");
		System.out.flush();

		// Declaramos las variables que vamos a usar y leemos el dorsal del futbolista
		Scanner sc = new Scanner(System.in);
		Scanner scDorsal = new Scanner(System.in);

		boolean isRunning = true;
		boolean bandera = false;

		// Solicitamos nueva información del futbolista
		System.out.println("\n+- Nuevo futbolista -------------------------+\n");

		System.out.print("Nombre: ");
		String nuevoNombre = sc.next();
		sc.nextLine();

		System.out.print("Apellido: ");
		String nuevoApellido = sc.next();
		nuevoNombre += " " + nuevoApellido;
		sc.nextLine();

		System.out.print("Dorsal: ");
		int nuevoDorsal = scDorsal.nextInt();

		System.out.print("Posición: ");
		String nuevaPosicion = sc.next();
		sc.nextLine();

		// Solicitamos confirmación
		System.out.print("\n¿Añadir futbolista? (si/no): ");
		String opcionLeida = sc.nextLine();

		// Switch para las opciones válidas
		do {
			switch (opcionLeida) {
			case "si":
				Futbolista futbolistaNuevo = new Futbolista(nuevoNombre, nuevoDorsal, nuevaPosicion, nuevoCodEquipo);
				alineacion.add(futbolistaNuevo);
				bandera = true;
				System.out.println("\n...\nFutbolista añadido con éxito.\n");
				System.out.println("¿Quieres añadir otro futbolista? (si/no)");
				String otro = sc.nextLine();

				boolean banderaOtro = true;
				while (banderaOtro) {
					switch (otro) {
					case "si":
						banderaOtro = false;
						break;
					case "no":
						System.out.println("\nSaliendo...\n");
						isRunning = false;
						banderaOtro = false;
						break;
					default:
						System.out.println("Opción no válida.");
						break;
					}
				}
				break;
			case "no":
				if (bandera == true) {
					System.out.println("\nOperación cancelada.\n");
				} else {
					System.err.println("Introduce al menos un futbolista!!!");
				}
				isRunning = false;
				break;
			default:
				System.out.println("\nElige una opción válida.\n");
				opcionLeida = sc.nextLine();
				break;
			}
		} while (isRunning);
	}

	public static void mostrarEquipo(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos) {
		/* Limpiamos la pantalla */
		System.out.print("\033[H\033[2J");
		System.out.flush();

		Scanner sc = new Scanner(System.in);

		// Vista de plantilla
		System.out.println("\nNombre del equipo: \n");
		String nomEquipo = sc.nextLine();
		String codEquipo = "";

		// Bucle para mostrar el ArrayList
		System.out.println("+------------------------+--------+--------------------+--------------------+");
		System.out.println("| Futbolista             | Dorsal | Posición           | Equipo             |");
		System.out.println("+------------------------+--------+--------------------+--------------------+");

		for (Equipo equipo : equipos) {
			if (nomEquipo.equals(equipo.getNomEquipo())) {
				codEquipo = equipo.getCodEquipo();

				for (Futbolista futbolista : alineacion) {
					if (codEquipo.equals(futbolista.getCodEquipo())) {
						System.out.printf("| %-22s | %-6s | %-18s | %-18s |%n", futbolista.getNomJugador(),
								futbolista.getDorsal(), futbolista.getPosicion(), nomEquipo);
					}
				}
			}
		}

		System.out.print("+------------------------+--------+--------------------+--------------------+\n\n");

		System.out.println("                  ___________");
		System.out.println("                 '._==_==_=_.'");
		System.out.println("                 .-):      (-.");
		System.out.println("                | (|:.     |) |");
		System.out.println("                 '-|:.     |-'");
		System.out.println("                   )::.    (");
		System.out.println("                    '::. .'");
		System.out.println("                      ) (");
		System.out.println("                    _.' '._");
		System.out.println("                   '''''''''\n\n");
	}

	public static void editFutbolista(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos) {
		/* Limpiamos la pantalla */
		System.out.print("\033[H\033[2J");
		System.out.flush();

		// Declaramos las variables que vamos a usar
		Scanner sc = new Scanner(System.in);
		Scanner scDorsal = new Scanner(System.in);

		// Mensaje para leer el nombre del futbolista que vamos a editar
		System.out.println("¿Qué futbolista quieres editar?");
		String nomFutbolista = sc.nextLine();
		boolean encontrado = false; // Variable para cerciorarnos de que el futbolista existe

		String nomEquipo = "";
		String codEquipo = ""; // Variable para almacenar el código de equipo del futbolista

		// Buscamos el futbolista y obtenemos el código de equipo
		for (Futbolista futbolista : alineacion) {
			if (nomFutbolista.equals(futbolista.getNomJugador())) {
				encontrado = true;
				codEquipo = futbolista.getCodEquipo();
				break;
			}
		}

		if (!encontrado) {
			// Mensaje de error
			System.out.println("No se encontró ningún futbolista con ese nombre.");
			return;
		}

		// Obtenemos el nombre del equipo correspondiente al código de equipo
		for (Equipo equipo : equipos) {
			if (codEquipo.equals(equipo.getCodEquipo())) {
				nomEquipo = equipo.getNomEquipo();
				break;
			}
		}

		for (Futbolista futbolista : alineacion) {
			// Buscamos el futbolista
			if (nomFutbolista.equals(futbolista.getNomJugador())) {
				System.out.println("\nFutbolista encontrado.");
				System.out.println(futbolista.getNomJugador() + ", " + futbolista.getDorsal());
				System.out.println(futbolista.getPosicion() + ", " + nomEquipo);

				// Solicitamos nueva información del futbolista
				System.out.println("\nNuevo futbolista.");

				System.out.print("Nombre: ");
				String nuevoNombre = sc.next();
				sc.nextLine();

				System.out.print("Apellido: ");
				String nuevoApellido = sc.next();
				nuevoNombre += " " + nuevoApellido;
				sc.nextLine();

				System.out.print("Dorsal: ");
				int nuevoDorsal = scDorsal.nextInt();

				System.out.print("Posición: ");
				String nuevaPosicion = sc.next();
				sc.nextLine();

				// Actualizamos los datos del futbolista
				futbolista.setNomJugador(nuevoNombre);
				futbolista.setDorsal(nuevoDorsal);
				futbolista.setPosicion(nuevaPosicion);

				// Mensaje de éxito y salimos del bucle
				System.out.println("Futbolista actualizado exitosamente.\n");

				break;
			}
		}
	}

	public static void rmFutbolista(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos) {
		/* Limpiamos la pantalla */
		System.out.print("\033[H\033[2J");
		System.out.flush();

		// Declaramos las variables que vamos a usar
		Scanner sc = new Scanner(System.in);
		Scanner scDorsal = new Scanner(System.in);

		// Mensaje para leer el nombre del futbolista que vamos a eliminar
		System.out.println("¿Qué futbolista quieres editar?");
		String nomFutbolista = sc.nextLine();
		boolean encontrado = false; // Variable para cerciorarnos de que el futbolista existe

		String nomEquipo = "";
		String codEquipo = ""; // Variable para almacenar el código de equipo del futbolista

		// Buscamos el futbolista y obtenemos el código de equipo
		for (Futbolista futbolista : alineacion) {
			if (nomFutbolista.equals(futbolista.getNomJugador())) {
				encontrado = true;
				codEquipo = futbolista.getCodEquipo();
				break;
			}
		}

		if (!encontrado) {
			// Mensaje de error
			System.out.println("No se encontró ningún futbolista con ese nombre.");
			return;
		}

		// Obtenemos el nombre del equipo correspondiente al código de equipo
		for (Equipo equipo : equipos) {
			if (codEquipo.equals(equipo.getCodEquipo())) {
				nomEquipo = equipo.getNomEquipo();
				break;
			}
		}
		
		for (Futbolista futbolista : alineacion) {
			// Buscamos el futbolista
			if (nomFutbolista.equals(futbolista.getNomJugador())){
				System.out.println("\nFutbolista encontrado.");
				System.out.println(futbolista.getNomJugador() + ", " + futbolista.getDorsal());
				System.out.println(futbolista.getPosicion() + ", " + nomEquipo);
				int posicionArray = alineacion.indexOf(futbolista);
				boolean isRunning = true;

				while (isRunning) {
					// Solicitamos confirmación
					System.out.print("\n¿Seguro que deseas eliminarlo? (si/no): ");
					Scanner opcion = new Scanner(System.in);
					String opcionLeida = opcion.nextLine();

					// Switch para las opciones válidas
					switch (opcionLeida) {
					case "si":
						alineacion.remove(posicionArray);
						isRunning = false;
						System.out.println("\n...\nFutbolista eliminado con éxito.\n");
						break;
					case "no":
						System.out.println("\nOperación cancelada.\n");
						isRunning = false;
						break;
					default:
						System.out.println("\nElige una opción válida.\n");
						break;
					}
				}

				// Variable que se actualiza con cada pasada al ArrayList
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {

			// Mensaje de error
			System.out.println("\nFutbolista no encontrado.\n");
		}
	}

	public static void rmEquipo(ArrayList<Futbolista> alineacion, ArrayList<Equipo> equipos) {
		/* Limpiamos la pantalla */
		System.out.print("\033[H\033[2J");
		System.out.flush();

		Scanner sc = new Scanner(System.in);

		// Vista de plantilla
		System.out.println("\nNombre del equipo: ");
		String nomEquipo = sc.nextLine();
		String codEquipo = "";

		// Comprobamos la existencia del equipo
		boolean equipoEncontrado = false;
		for (Equipo equipo : equipos) {
			if (nomEquipo.equals(equipo.getNomEquipo())) {
				equipoEncontrado = true;
				codEquipo = equipo.getCodEquipo();
				break;
			}
		}

		if (!equipoEncontrado) {
			System.err.println("\nNo se encontró el equipo especificado.");
			return;
		}

		// Bucle para mostrar el ArrayList
		System.out.println("+------------------------+--------+--------------------+--------------------+");
		System.out.println("| Futbolista             | Dorsal | Posición           | Equipo             |");
		System.out.println("+------------------------+--------+--------------------+--------------------+");

		for (Futbolista futbolista : alineacion) {
			if (codEquipo.equals(futbolista.getCodEquipo())) {
				System.out.printf("| %-22s | %-6s | %-18s | %-18s |%n", futbolista.getNomJugador(),
						futbolista.getDorsal(), futbolista.getPosicion(), nomEquipo);
			}
		}
		System.out.println("+------------------------+--------+--------------------+--------------------+");

		System.out.println("\n¿Quieres borrar el equipo " + nomEquipo + ", con el código " + codEquipo + "? (si/no)");
		String opcion = sc.nextLine();
		boolean isRunning = true;
		Equipo equipoEncontrado1 = null;

		while (isRunning) {
			switch (opcion) {
			case "si":
				for (Equipo equipo : equipos) {
					if (codEquipo.equals(equipo.getCodEquipo())) {
						equipoEncontrado1 = equipo;
						break;
					}
				}

				if (equipoEncontrado1 != null) {
					equipos.remove(equipoEncontrado1);
					System.out.println("\nEquipo borrado correctamente.");
				} else {
					System.err.println("\nNo se encontró el equipo especificado.");
				}

				isRunning = false;
				break;
			case "no":
				System.err.println("\nOperación cancelada.");
				isRunning = false;
				break;
			default:
				System.err.println("\nERROR:\nOpción no válida.\n");
				break;
			}
		}
	}
}
