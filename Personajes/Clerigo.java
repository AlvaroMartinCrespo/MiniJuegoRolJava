package Personajes;

public class Clerigo extends Personaje {

//	Constantes

	private static final int FUERZA_MIN = 18;
	private static final int INTELIGENCIA_MAX = 16;
	private static final int INTELIGENCIA_MIN = 12;
	private static final int CURA = 10;

//	Atributos

	private String nombreDios;

//	Constructor

	public Clerigo(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima, String nombreDios)
			throws PersonajeException {

		super(nombre, raza, fuerza, inteligencia, vidaMaxima);

		this.nombreDios = nombreDios;

		comprobarFuerza();
		comprobarInteligencia();

	}

	public void comprobarFuerza() throws PersonajeException {

		if (this.fuerza < 18) {

			throw new PersonajeException("La fuerza no puede ser menor a 18");

		}

	}

	public void comprobarInteligencia() throws PersonajeException {

		if (this.inteligencia > 16 && this.inteligencia < 12) {

			throw new PersonajeException("La inteligencia tiene que tener un valor entre 12 y 16");

		}

	}

	public void curar(Personaje personaje) throws PersonajeException {

		System.out.println("VIDA DE PERSONAJE: " + personaje.getVidaActual());

		personaje.setVidaActual(personaje.getVidaActual() + CURA);

		System.out.println(
				"--Has utilizado cura al personaje-- \nVIDA ACTUAL DEL PERSONAJE: " + personaje.getVidaActual());

	}

	@Override
	public String toString() {
		return "Clerigo [nombreDios=" + nombreDios + ", toString()=" + super.toString() + "]";
	}

}
