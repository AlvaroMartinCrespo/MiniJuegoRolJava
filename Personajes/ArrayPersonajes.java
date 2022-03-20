package Personajes;

public class ArrayPersonajes {

	private Personaje[] personajes;
	private int numeroAlmacenamiento;

	public ArrayPersonajes(int capacidadAlmacen) throws AlmacenamientoException {

		if(numeroAlmacenamiento==100) {
			throw new AlmacenamientoException("No se pueden crear mas personajes. Has llegado al límite que son 100");
		}
		
		personajes = new Personaje[capacidadAlmacen];
		numeroAlmacenamiento = 0;

	}

	public void introducirPersonaje(Personaje personaje) {

		personajes[numeroAlmacenamiento] = personaje;
		numeroAlmacenamiento++;

	}

	public void mostrarPersonajes() {

		for (int i = 0; i < personajes.length; i++) {

			if (personajes[i] != null) {

				System.out.println(personajes[i].toString());

			}

		}

	}

	public Personaje buscarPersonaje(String nombre) {

//		personaje
		Personaje personaje;

		for (int i = 0; i < personajes.length; i++) {

			if (personajes[i] != null) {

				if (personajes[i].getNombre().equals(nombre)) {

					if (personajes[i] instanceof Mago) {

						return personajes[i];

					} else if (personajes[i] instanceof Clerigo) {

						return personajes[i];

					}

				}

			}

		}

		return null;
	}

	public Personaje buscarMago(String nombre) {

//		personaje
		Personaje personaje;

		for (int i = 0; i < personajes.length; i++) {

			if (personajes[i] != null) {

				if (personajes[i].getNombre().equals(nombre)) {

					if (personajes[i] instanceof Mago) {

						return personajes[i];

					} else {

						System.out.println("Ese personaje no es un Mago");
						break;

					}

				}

			} else {

				System.out.println("No existe ese nombre de Mago");
				break;

			}

		}
		return null;

	}

	public Personaje buscarClerigo(String nombre) {

//		personaje
		Personaje personaje;

		for (int i = 0; i < personajes.length; i++) {

			if (personajes[i] != null) {

				if (personajes[i].getNombre().equals(nombre)) {

					if (personajes[i] instanceof Clerigo) {

						return personajes[i];

					} else {

						System.out.println("Ese personaje no es un Clerigo");
						break;

					}

				}

			} else {

				System.out.println("No existe ese nombre de Clerigo");
				break;

			}

		}
		return null;

	}

}
