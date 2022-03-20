package Personajes;

import java.util.Arrays;

public class Mago extends Personaje {

//	Constantes

	private static final int INTELIGENCIA_MIN = 17;
	private static final int FUERZA_MAX = 15;
	private static final int RESTA_VIDA_HECHIZO = 10;

//	Atributos

	private String[] nombreHechizos = new String[4];

//	Constructor

	public Mago(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima, String[] nombreHechizos)
			throws PersonajeException {
		super(nombre, raza, fuerza, inteligencia, vidaMaxima);

		comprobarFuerza();
		comprobarInteligencia();

		for (int i = 0; i < nombreHechizos.length; i++) {

			this.nombreHechizos[i] = "";

		}

	}

	public void comprobarInteligencia() throws PersonajeException {

		if (inteligencia < INTELIGENCIA_MIN) {

			throw new PersonajeException("La inteligencia no puede ser menor a 17");

		}

	}

	public void comprobarFuerza() throws PersonajeException {

		if (fuerza > FUERZA_MAX) {

			throw new PersonajeException("La fuerza no puede ser mayor a 15");

		}

	}

	public void aprendeHechizo(String nombreHechizo) {

//		Variables
		boolean lleno = false;

//		Introducir hechizos

		for (int i = 0; i < nombreHechizos.length; i++) {

			if (nombreHechizos[i].equals("")) {

				nombreHechizos[i] = nombreHechizo;
				lleno = false;
				break;

			} else {

				lleno = true;

			}

		}

		if (lleno) {

			System.out.println("No puedes aprender mas hechizos");

		}

	}

	public void lanzaHechizo(Personaje personaje, String hechizo) throws PersonajeException {

//		var
		boolean encontrado = false;

//		Buscamos si esta el hechizo

		for (int i = 0; i < nombreHechizos.length; i++) {

			if (nombreHechizos[i].equals(hechizo)) {

				encontrado = true;
				break;

			}

		}

//		Lanzamos excepción sino encuentra el hechizo

		if (!encontrado) {

			throw new PersonajeException("No existe el hechizo que has introducido");

		}

//		Restamos vida al personaje.

		System.out.println("VIDA ACTUAL PESONAJE: " + personaje.getVidaActual());

		personaje.setVidaActual(personaje.getVidaActual() - RESTA_VIDA_HECHIZO);

		System.out.println("VIDA DESPUÉS DEL HECHIZO:" + personaje.getVidaActual());

//		Eliminamos el hechizo.

		for (int i = 0; i < nombreHechizos.length; i++) {

			if (nombreHechizos[i].equals(hechizo)) {

				nombreHechizos[i] = "";

			}

		}

		System.out.println("Se ha eliminado el hechizo " + hechizo);

	}

	@Override
	public String toString() {
		return "Mago [nombreHechizos=" + Arrays.toString(nombreHechizos) + ", toString()=" + super.toString() + "]";
	}

}
