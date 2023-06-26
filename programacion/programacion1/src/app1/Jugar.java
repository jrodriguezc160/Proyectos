package app1;

import app1.Equipo;
import app1.Futbolista;
import java.util.Random;
import java.util.Scanner;

public class Jugar {

	private int marcadorEquipo1;
	private int marcadorEquipo2;
	private int posesion; // 1 para el equipo 1, 2 para el equipo 2
	private int zona; // dividimos el campo en 4 zonas
	private int dado;
	private Random random;

	public Jugar() {
		marcadorEquipo1 = 0;
		marcadorEquipo2 = 0;
		posesion = 1; // Empieza el equipo 1 con la posesión
		zona = 3; // Para sacar de centro la zona será 3 (centro del campo)
		random = new Random();
	}

	public void jugarPartido() {
		while (marcadorEquipo1 < 3) { // Cuando marcas 3 goles se acaba el juego
			switch (zona) { // empezamos mostrando la situación de la pelota en el campo
					// Después, llamamos al método en cuestión
			case 1: // Portería
				System.out.println("\\nEl balón se encuentra en la zona 1: la portería");
				if (posesion == 1) { // Primero comprobamos qué equipo tiene la posesión del balón
					System.out.println("+----------------------------+-----------------------------+");
					System.out.println("|                            |                             |");
					System.out.println("|                            |                             |");
					System.out.println("+-------+                    |                     +-------+");
					System.out.println("|       |                    |                     |       |");
					System.out.println("+-+     |                    |                     |     +-+");
					System.out.println("| |  |  |                   ´ `                    |     | |");
					System.out.println("| | -@- |                  | · |                   |  ·  | |");
					System.out.println("| |  |  |                   ` ´                    |     | |");
					System.out.println("+-+     |                    |                     |     +-+");
					System.out.println("|       |                    |                     |       |");
					System.out.println("+-------+                    |                     +-------+");
					System.out.println("|                            |                             |");
					System.out.println("|                            |                             |");
					System.out.println("+----------------------------+-----------------------------+");
					System.out.println("\n                         +---+---+");
					System.out.println("           LOCAL         | " + marcadorEquipo1 + " | " + marcadorEquipo2 + " |        VISITANTE         ");
					System.out.println("                         +---+---+");
					tirar();
				} else {
					System.out.println("+----------------------------+-----------------------------+");
					System.out.println("|                            |                             |");
					System.out.println("|                            |                             |");
					System.out.println("+-------+                    |                     +-------+");
					System.out.println("|       |                    |                     |       |");
					System.out.println("+-+     |                    |                     |     +-+");
					System.out.println("| |     |    |              ´ `                    |     | |");
					System.out.println("| |  ·  |   -@-            | · |                   |  ·  | |");
					System.out.println("| |     |    |              ` ´                    |     | |");
					System.out.println("+-+     |                    |                     |     +-+");
					System.out.println("|       |                    |                     |       |");
					System.out.println("+-------+                    |                     +-------+");
					System.out.println("|                            |                             |");
					System.out.println("|                            |                             |");
					System.out.println("+----------------------------+-----------------------------+");
					System.out.println("\n                         +---+---+");
					System.out.println("           LOCAL         | " + marcadorEquipo1 + " | " + marcadorEquipo2 + " |        VISITANTE         ");
					System.out.println("                         +---+---+");
					defender();
				}
				break;
			case 2: // Defensa
				System.out.println("\\nEl balón se encuentra en la zona 2: la defensa");
				System.out.println("+----------------------------+-----------------------------+");
				System.out.println("|                            |                             |");
				System.out.println("|                            |                             |");
				System.out.println("+-------+                    |                     +-------+");
				System.out.println("|       |                    |                     |       |");
				System.out.println("+-+     |                    |                     |     +-+");
				System.out.println("| |     |        |          ´ `                    |     | |");
				System.out.println("| |  ·  |       -@-        | · |                   |  ·  | |");
				System.out.println("| |     |        |          ` ´                    |     | |");
				System.out.println("+-+     |                    |                     |     +-+");
				System.out.println("|       |                    |                     |       |");
				System.out.println("+-------+                    |                     +-------+");
				System.out.println("|                            |                             |");
				System.out.println("|                            |                             |");
				System.out.println("+----------------------------+-----------------------------+");
				System.out.println("\n                         +---+---+");
				System.out.println("           LOCAL         | " + marcadorEquipo1 + " | " + marcadorEquipo2 + " |        VISITANTE         ");
				System.out.println("                         +---+---+");
				if (posesion == 1) {
					accion();
				} else {
					defender();
				}
				break;
			case 3: // Mediocentro
				System.out.println("\nEl balón se encuentra en la zona 3: el centro del campo");
				System.out.println("+----------------------------+-----------------------------+");
				System.out.println("|                            |                             |");
				System.out.println("|                            |                             |");
				System.out.println("+-------+                    |                     +-------+");
				System.out.println("|       |                    |                     |       |");
				System.out.println("+-+     |                    |                     |     +-+");
				System.out.println("| |     |                   ´|`                    |     | |");
				System.out.println("| |  ·  |                  |-@-|                   |  ·  | |");
				System.out.println("| |     |                   `|´                    |     | |");
				System.out.println("+-+     |                    |                     |     +-+");
				System.out.println("|       |                    |                     |       |");
				System.out.println("+-------+                    |                     +-------+");
				System.out.println("|                            |                             |");
				System.out.println("|                            |                             |");
				System.out.println("+----------------------------+-----------------------------+");
				System.out.println("\n                         +---+---+");
				System.out.println("           LOCAL         | " + marcadorEquipo1 + " | " + marcadorEquipo2 + " |        VISITANTE         ");
				System.out.println("                         +---+---+");
				if (posesion == 1) {
					accion();
				} else {
					defender();
				}
				break;
			case 4: // Delantera
				System.out.println("\nEl balón se encuentra en la zona 4: la delantera");
				if (posesion == 1) {
					System.out.println("+----------------------------+-----------------------------+");
					System.out.println("|                            |                             |");
					System.out.println("|                            |                             |");
					System.out.println("+-------+                    |                     +-------+");
					System.out.println("|       |                    |                     |       |");
					System.out.println("+-+     |                    |                     |     +-+");
					System.out.println("| |     |                   ´ `               |    |     | |");
					System.out.println("| |  ·  |                  | · |             -@-   |  ·  | |");
					System.out.println("| |     |                   ` ´               |    |     | |");
					System.out.println("+-+     |                    |                     |     +-+");
					System.out.println("|       |                    |                     |       |");
					System.out.println("+-------+                    |                     +-------+");
					System.out.println("|                            |                             |");
					System.out.println("|                            |                             |");
					System.out.println("+----------------------------+-----------------------------+");
					System.out.println("\n                         +---+---+");
					System.out.println("           LOCAL         | " + marcadorEquipo1 + " | " + marcadorEquipo2 + " |        VISITANTE         ");
					System.out.println("                         +---+---+");
					tirar();
				} else {
					System.out.println("+----------------------------+-----------------------------+");
					System.out.println("|                            |                             |");
					System.out.println("|                            |                             |");
					System.out.println("+-------+                    |                     +-------+");
					System.out.println("|       |                    |                     |       |");
					System.out.println("+-+     |                    |                     |     +-+");
					System.out.println("| |     |                   ´ `                    |  |  | |");
					System.out.println("| |  ·  |                  | · |                   | -@- | |");
					System.out.println("| |     |                   ` ´                    |  |  | |");
					System.out.println("+-+     |                    |                     |     +-+");
					System.out.println("|       |                    |                     |       |");
					System.out.println("+-------+                    |                     +-------+");
					System.out.println("|                            |                             |");
					System.out.println("|                            |                             |");
					System.out.println("+----------------------------+-----------------------------+");
					System.out.println("\n                         +---+---+");
					System.out.println("           LOCAL         | " + marcadorEquipo1 + " | " + marcadorEquipo2 + " |        VISITANTE         ");
					System.out.println("                         +---+---+");
					defender();
				}
				break;
			}

		}

		// Mostramos el marcador
		System.out.println("+---+---+");
		System.out.println("| " + marcadorEquipo1 + " | " + marcadorEquipo2 + " |");
		System.out.println("+---+---+");
	}

	private void defender() { // Cuando la posesión es del otro equipo, defendemos hasta recuperarla
		Scanner sc = new Scanner(System.in);
		System.out.println("\n¿Qué quieres hacer? (1 para hacer una segada, 2 para bloquear, 3 para hacer falta)");

		int opcion = sc.nextInt();
		switch (opcion) { // Acciones defensivas:
		case 1:
			segada();
			break;
		case 2:
			bloquear();
			break;
		case 3:
			falta();
			break;
		default:
			System.err.println("\nERROR:\nOpción no válida.\n");
			break;
		}
		
	}

	private void accion() { // Para atacar:
		Scanner sc = new Scanner(System.in);
		System.out.println("\n¿Qué quieres hacer? (1 para pasar, 2 para regatear, 3 para tirar)");

		int opcion = sc.nextInt();
		switch (opcion) { // Acciones de ataque
		case 1:
			pasar();
			break;
		case 2:
			regatear();
			break;
		case 3:
			tirar();
			break;
		default:
			System.err.println("\nERROR:\nOpción no válida.\n");
			break;
		}
	}
	
	private void segada() {
		System.out.println("\nEl jugador se lanza al suelo a por el balón... (↩ presiona Intro)\n");
		Scanner sc = new Scanner(System.in);
		String espacio = sc.nextLine();
		
		dado = random.nextInt(100) + 1; // Número aleatorio del 1 al 100
		if (dado < 75) { // Probabilidad...
			System.out.println("\nPero no lo consigue...\n");
			zona--;
			// Según la posesión, mostramos un mensaje u otro
			if (posesion == 1) {
				System.out.print("\nEl equipo local conserva el esférico");
			} else {
				System.out.println("\nEl equipo visitante conserva el esférico");
			}
		} else {
			// El dado acierta y la acción se completa
			// La posesión cambia de equipo
			System.out.print("\nY se lleva el cuero!!!");
			if (posesion == 1) {
				posesion = 2;
			} else {
				posesion = 1;
			}
		}
		
		// Pedimos al usuario que presione Intro para controlar la limpieza de la pantalla
		System.out.print(" (↩ presiona Intro)\n");
		String espacio1 = sc.nextLine();

		// Cuando la zona es la portería (1), el equipo rival tira...
		if (zona == 1) {
			tirar();
		}
	}
	
	
	
	// Todos los métodos son similares, por lo que solo habrá comentarios cuando sea necesario
	
	
	
	private void bloquear() {
		System.out.println("\nEl jugador intenta bloquear al rival en un duelo... (↩ presiona Intro)\n");
		Scanner sc = new Scanner(System.in);
		String espacio = sc.nextLine();
		
		dado = random.nextInt(100) + 1;
		if (dado < 50) {
			System.out.println("\nPero no lo consigue...\n");
			zona--;
			if (posesion == 1) {
				System.out.print("\nEl equipo local conserva el esférico");
			} else {
				System.out.print("\nEl equipo visitante conserva el esférico");
			}
		} else {
			System.out.print("\nY se lleva el cuero!!!");
			if (posesion == 1) {
				posesion = 2;
			} else {
				posesion = 1;
			}
		}

		System.out.print(" (↩ presiona Intro)\n");
		String espacio1 = sc.nextLine();
		
		if (zona == 1) {
			tirar();
		}
	}
	
	private void falta() {
		System.out.println("\nEl jugador intenta derribar al rival... (↩ presiona Intro)\n");
		Scanner sc = new Scanner(System.in);
		String espacio = sc.nextLine();
		
		dado = random.nextInt(100) + 1;
		if (dado < 25) {
			System.out.println("\nPero no lo consigue...\n");
			zona--;
			if (posesion == 1) {
				System.out.print("\nEl equipo local conserva el esférico");
			} else {
				System.out.print("\nEl equipo visitante conserva el esférico");
			}
		} else {
			System.out.print("\nY se lleva el cuero!!!");
			if (posesion == 1) {
				posesion = 2;
			} else {
				posesion = 1;
			}
		}
		
		System.out.print(" (↩ presiona Intro)\\n");
		String espacio1 = sc.nextLine();

		if (zona == 1) {
			tirar();
		}
	}

	private void tirar() { // Método para marcar goles
		System.out.println("\nEl jugador se prepara para tirar (↩ presiona Intro)\n");
		System.out.println("    -   _O                                     ,  ___");
		System.out.println("  -    ´/``                                   O/  |   |");
		System.out.println(" -   __/`                                     /`, |   |x`");
		System.out.println("    `    `, @                                ` << |   |xx`");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("");
		
		Scanner sc = new Scanner(System.in);
		String espacio = sc.nextLine();
		
		dado = random.nextInt(100) + 1;
		if (zona == 1) {
			if (dado > 50) {
				System.out.println("Fueraaa!!!");
				System.out.println("\nEl balón pasa a disposición del equipo local.");
				posesion = 1;
				zona = 1;
			} else {
				System.out.println("GOOOL PARA EL EQUIPO VISITANTE!!!");
				marcadorEquipo2++; // El gol sube al marcador
				zona = 3; // La zona se reestablece al centro del campo
				posesion = 1; // Cambio de posesión
				// Mostramos el marcador
				System.out.println("+---+---+");
				System.out.println("| " + marcadorEquipo1 + " | " + marcadorEquipo2 + " |");
				System.out.println("+---+---+");
			}
		} else {
			if (dado < 50) {
				System.out.println("Fueraaa!!!");
				System.out.println("\nEl balón pasa a disposición del equipo visitante");
				posesion = 2;
				zona = 4;
			} else {
				System.out.println("GOOOL PARA EL EQUIPO LOCAL!!!");
				marcadorEquipo1++;
				zona = 3;
				posesion = 2;
				System.out.println("+---+---+");
				System.out.println("| " + marcadorEquipo1 + " | " + marcadorEquipo2 + " |");
				System.out.println("+---+---+");
			}
		}
		
		System.out.print("(↩ presiona Intro)\n");
		String espacio1 = sc.nextLine();
	}

	private void regatear() {
		System.out.println("\nEl jugador intenta un regate... (↩ presiona Intro)\n");
		Scanner sc = new Scanner(System.in);
		String espacio = sc.nextLine();
		dado = random.nextInt(100) + 1;
		if (dado < 50) {
			System.out.println("Pero pierde el balón...");
			if (posesion == 1) {
				System.out.print("\nEl equipo visitante se lleva el esférico");
				posesion = 2;
			} else {
				posesion = 1;
				System.out.print("\nEl equipo local se lleva el esférico");
			}
		} else {
			System.out.print("\nY se lleva el cuero!!!");
			zona++;
		}
		
		System.out.print(" (↩ presiona Intro)\n");
		String espacio1 = sc.nextLine();
	}

	private void pasar() {
		System.out.println("El jugador pasa el balón... (↩ presiona Intro)\n");
		Scanner sc = new Scanner(System.in);
		String espacio = sc.nextLine();
		
		dado = random.nextInt(100) + 1;
		if (dado < 50) {
			System.out.println("Pero el pase es interceptado...");
			if (posesion == 1) {
				System.out.print("\nEl equipo visitante se lleva el esférico");
				posesion = 2;
			} else {
				System.out.print("\nEl equipo local se lleva el esférico.");
				posesion = 1;
			}
		} else {
			System.out.print("\nY su compañero lo recibe!!!");
			zona++;
		}
		
		System.out.print(" (↩ presiona Intro)\n");
		String espacio1 = sc.nextLine();
	}

	public static void main(String[] args) {
		Jugar juego = new Jugar();
		juego.jugarPartido();
	}
}
