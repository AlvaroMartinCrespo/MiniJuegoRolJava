package Principal;

import Personajes.*;
import java.util.*;

public class Main {

	static Scanner entrada = new Scanner(System.in);
	static final int MAX_ALMACEN = 100;

	public static void main(String[] args) {

//		var
		int accionMenu;

//		instanciamos la array donde se almacenan los personajes.
		ArrayPersonajes array;

		try {

			array = new ArrayPersonajes(MAX_ALMACEN);

//			Menu
			do {

				mostrarMenu();
				accionMenu = accionMenu();

				try {

					tratarMenu(accionMenu, array);

				} catch (PersonajeException e) {

					System.out.println(e.getMessage());

				}

			} while (accionMenu != 6);

		} catch (AlmacenamientoException e1) {

			System.out.println(e1.getMessage());
		}

	}

	public static Personaje crearPersonaje() throws PersonajeException {

//		var
		int eleccion;
		String nombre, raza;
		int fuerza, inteligencia, vidaMaxima;
		boolean comprobar = true;

		System.out.println(".:SISTEMA DE CREACIÓN DE PERSONAJES:.");

		do {

			System.out.println("¿Que desea crear un MAGO o un CLERIGO (1.Mago - 2.Clerigo)");
			eleccion = entrada.nextInt();

			if (eleccion != 1 && eleccion != 2) {
				System.out.println("Introduce 1 o 2");
			}

		} while (eleccion != 1 && eleccion != 2);

		if (eleccion == 1) {

//			var
			String[] hechizos = new String[4];

//			instancia
			Mago nuevoMago;

//			datos
			System.out.println(".:SISTEMA DE CREACIÓN DE MAGO:.");

			System.out.println("Introduce tu nombre:");
			nombre = entrada.next();
			System.out.println("Introduca el valor de fuerza:");
			fuerza = entrada.nextInt();
			System.out.println("Introduce el valor de inteligencia:");
			inteligencia = entrada.nextInt();
			System.out.println("Introduce la cantidad de vida máxima:");
			vidaMaxima = entrada.nextInt();

			do {

				System.out.println("Introduce el tipo de raza que eres: (Humano, Elfo, Orco, Enano)");
				raza = entrada.next();

				raza = raza.toUpperCase();

				if (TRaza.ELFO.name().equals(raza)) {

					nuevoMago = new Mago(nombre, TRaza.ELFO, fuerza, inteligencia, vidaMaxima, hechizos);

					return nuevoMago;

				} else if (TRaza.HUMANO.name().equals(raza)) {

					nuevoMago = new Mago(nombre, TRaza.HUMANO, fuerza, inteligencia, vidaMaxima, hechizos);

					return nuevoMago;

				} else if (TRaza.ORCO.name().equals(raza)) {

					nuevoMago = new Mago(nombre, TRaza.ORCO, fuerza, inteligencia, vidaMaxima, hechizos);

					return nuevoMago;

				} else if (TRaza.ENANO.name().equals(raza)) {

					nuevoMago = new Mago(nombre, TRaza.ENANO, fuerza, inteligencia, vidaMaxima, hechizos);

					return nuevoMago;

				} else {

					System.out.println("Raza incorrecta");
					comprobar = false;

				}

			} while (!comprobar);

		} else {

//			var 
			String nombreDios = "";

//			instanciamos el clerigo
			Clerigo nuevoClerigo;

			System.out.println(".:SISTEMA DE CREACIÓN DE CLERIGO:.");

//			datos

			System.out.println("Introduce tu nombre:");
			nombre = entrada.next();
			System.out.println("Introduca el valor de fuerza:");
			fuerza = entrada.nextInt();
			System.out.println("Introduce el valor de inteligencia:");
			inteligencia = entrada.nextInt();
			System.out.println("Introduce la cantidad de vida máxima:");
			vidaMaxima = entrada.nextInt();
			System.out.println("Introduce el nombre del dios:");
			nombreDios = entrada.next();

			do {

				System.out.println("Introduce el tipo de raza que eres: (Humano, Elfo, Orco, Enano)");
				raza = entrada.next();

				raza = raza.toUpperCase();

				if (TRaza.ELFO.name().equals(raza)) {

					nuevoClerigo = new Clerigo(nombre, TRaza.ELFO, fuerza, inteligencia, vidaMaxima, nombreDios);

					return nuevoClerigo;

				} else if (TRaza.HUMANO.name().equals(raza)) {

					nuevoClerigo = new Clerigo(nombre, TRaza.HUMANO, fuerza, inteligencia, vidaMaxima, nombreDios);

					return nuevoClerigo;

				} else if (TRaza.ORCO.name().equals(raza)) {

					nuevoClerigo = new Clerigo(nombre, TRaza.ORCO, fuerza, inteligencia, vidaMaxima, nombreDios);

					return nuevoClerigo;

				} else if (TRaza.ENANO.name().equals(raza)) {

					nuevoClerigo = new Clerigo(nombre, TRaza.ENANO, fuerza, inteligencia, vidaMaxima, nombreDios);

					return nuevoClerigo;

				} else {

					System.out.println("Raza incorrecta");
					comprobar = false;

				}

			} while (!comprobar);

		}

		return null;

	}

	public static void mostrarMenu() {

		System.out.println();
		System.out.println(".:MENU DEL JUEGO:.");
		System.out.println(
				"1.Alta de personaje\n2.Mago aprende hechizo\n3.Mago lanza hechizo\n4.Clérigo cura al mago\n5.Mostrar el listado de personajes\n6.Salir");

	}

	public static int accionMenu() {

//		var
		int accion;

		System.out.println("¿Que desea hacer?");
		accion = entrada.nextInt();

		return accion;

	}

	public static void tratarMenu(int accion, ArrayPersonajes array) throws PersonajeException {

//		vars
		String nombre, nombreHechizo;

//		instanciamos mago, clerigo y personaje;
		Mago mago;
		Clerigo clerigo;
		Personaje personaje;

		switch (accion) {

		case 1:

			try {

				personaje = crearPersonaje();
				array.introducirPersonaje(personaje);

			} catch (PersonajeException e) {

				System.out.println(e.getMessage());

			}

			break;

		case 2:

			System.out.println(".:APRENDER HECHIZO A UN MAGO:.");
			System.out.println("Introduce el nombre del mago:");
			nombre = entrada.next();

			mago = (Mago) array.buscarMago(nombre);

			if (mago != null) {

				System.out.println("Introduce el nombre del hechizo que quieres aprender:");
				nombreHechizo = entrada.next();
				mago.aprendeHechizo(nombreHechizo);

			}

			break;

		case 3:

			System.out.println(".:MAGO LANZA UN ATAQUE:.");
			System.out.println("Introduce el nombre del mago:");
			nombre = entrada.next();

			mago = (Mago) array.buscarMago(nombre);

			System.out.println("Nombre del personaje al que le quieras lanzar el hechizo:");
			nombre = entrada.next();

			personaje = array.buscarPersonaje(nombre);

			if (mago != null && personaje != null) {

				System.out.println("Introduce el nombre del hechizo que quieras lanzar:");
				nombreHechizo = entrada.next();

				mago.lanzaHechizo(personaje, nombreHechizo);

			}

			break;

		case 4:

			System.out.println(".:CLERIGO CURA A UN MAGO:.");
			System.out.println("Introduce el nombre del clerigo:");
			nombre = entrada.next();

			clerigo = (Clerigo) array.buscarClerigo(nombre);

			System.out.println("Nombre del personaje al que le quieras curar:");
			nombre = entrada.next();

			personaje = array.buscarPersonaje(nombre);

			clerigo.curar(personaje);

			break;

		case 5:

			array.mostrarPersonajes();

			break;

		case 6:

			System.out.println(".:SALIENDO DEL JUEGO:.");

			break;

		}

	}

}
