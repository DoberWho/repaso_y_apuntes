package ficheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import ficheros.datos.Persona;

/**
 * Lectura y escritura de ficheros planos
 */
public class Ficheros02 {

	private final String RUTA_FICHERO = "C:\\ficheroObjecto.txt";

	/**
	 * Como se lee un fichero con Objecto Clase
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void lectura() throws IOException, ClassNotFoundException {

		Persona persona; // defino la variable persona
		File fichero = new File(RUTA_FICHERO);

		ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

		int i = 1;
		try {
			while (true) { // lectura del fichero
				persona = (Persona) dataIS.readObject(); // leer una Persona
				System.out.print(i + "=>");
				i++;
				System.out.printf("Nombre: %s, edad: %d %n", persona.getNombre(), persona.getEdad());
			}
		} catch (EOFException eo) {
			System.out.println("FIN DE LECTURA.");
		} catch (StreamCorruptedException x) {
			System.out.println("Error de lectura:" + x.getMessage());
		}

		dataIS.close(); // cerrar stream de entrada
	}

	/**
	 * Forma más simple para escribir un fichero Plano
	 */
	public void escritura() throws IOException {
		Persona persona;// defino variable persona

		File fichero = new File("FichPersona.dat");// declara el fichero
		FileOutputStream fileout = new FileOutputStream(fichero, true); // crea el flujo de salida
		// conecta el flujo de bytes al flujo de datos
		ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

		String nombres[] = { "Ana", "Luis Miguel", null, "Pedro", "Manuel", "Andrés", "Julio", "Antonio", "María Jesús" };

		int edades[] = { 14, 15, 13, 15, 16, 12, 16, 14, 13 };
		for (int i = 0; i < edades.length; i++) { // recorro los arrays
			persona = new Persona(nombres[i], edades[i]); // creo la persona
			dataOS.writeObject(persona); // escribo la persona en el fichero
			System.out.println("GRABO LOS DATOS DE PERSONA.");
		}
		dataOS.close(); // cerrar stream de salida
	}

	/**
	 * Preguntas Teoricas:
	 */

	/**
	 * 1.- ¿Cual es que requisito de la clase Persona para poder usarse en la
	 * lectura/escritura? .- Que sea una Persona en un censo ciudadano con derecho a
	 * voto .- Que sea una clase que implemente Serializable <= TRUE .- Que
	 * implemente los metodos de la clase DbObject .- Que tenga todos los valores
	 * correctos antes de la lectura
	 */

	/**
	 * 2.- A la hora de guardar los datos ¿Que pasa si no tenemos rellenados todos
	 * los campos del objecto? 
	 * .- Se abre un portal interdimensional; donde una versión futura de ti mismo te dira: 
	 "No hay tiempo de explicaciones, ven conmigo". 
	 *.- Falla por una FileNotFoundException 
	 *.- Guarda los datos; pero a la hora de leer fallará por Corrupción de Fichero <= TRUE 
	 *.- Falla por una Excepción no controlada 
	 */

	public static void main(String[] args) {

		Ficheros02 main = new Ficheros02();
		try {
			main.escritura();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			main.lectura();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
