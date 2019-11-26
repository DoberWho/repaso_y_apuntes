package examen.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Lectura y escritura de ficheros planos
 */
public class Ficheros01 {

	private final String RUTA_FICHERO = "C:\ficheroPlano.txt";

	/**
	 * Como se lee un fichero plano; linea por linea
	 * 
	 * @throws IOException
	 */
	public void lectura() throws IOException { 
		
		File file = new File(RUTA_FICHERO);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String curLine = null;
		while ((curLine = reader.readLine()) != null) {
			System.out.println(curLine); // valor de la linea que acaba de leer
		}
		System.out.println(curLine); // Ultima linea leida
		reader.close();

	}

	/**
	 * Forma más simple para escribir un fichero Plano 
	 */
	public void escritura() throws IOException {

		BufferedWriter fichero = new BufferedWriter(new FileWriter(RUTA_FICHERO));
		for (int i = 1; i < 11; i++) {
			fichero.write("Fila numero: " + i); // escribe una línea
			fichero.newLine(); // escribe un salto de línea
		}
		fichero.close();
	}
	
	/**
	 * Preguntas Teoricas:
	 */
	
	/**
	 * 1.- ¿Cuando termina de leer el readLine de BufferedReader?
	 * .- Cuando encuentra EOF <= TRUE
	 * .- Cuando falla por un TryCatch
	 * .- Cuando devuelve false
	 * .- Cuando una orden Jedi viene a reclamar los derechos sobre los sobreranos del planeta Yabin4
	 */
	
	/**
	 * 2.- ¿Que pasa si no hacemos un newLine() despues de escribir con BufferedWriter.write, y antes de escribir
	 * la siguiente?
	 * .- Un Barbaro aparecerá entre las sombras cada noche; para obligarte a escribir la historia de Cymmeria
	 * .- Falla por un IOException, al no marcar la nueva linea
	 * .- Que la nueva linea aparecerá directamente a continuación de la anterior <= TRUE
	 * .- No escribe la linea; y no guarda nada en el fichero
	 */
	
	/**
	 * 3.- Si el fichero no existe a la hora de lectura. ¿Cual es la excepción más especifica que puede saltar?
	 * .- FileNotFoundException <= TRUE
	 * .- IOException
	 * .- Exception 
	 * .- Ermac = Error Macro
	 */
	
	/**
	 * 4.- A la hora de leer un fichero; si queremos guardarnos TODAS las lineas leidas:
	 * .- Debemos generar un algoritmo de inteligencia artifical llamado HAL; que acepte 9000 caracteres.
	 * .- Pasamos por consola el valor de cada linea y guardamos eso usando copiar y pegar.
	 * .- Usamos un Array de Integer para recoger el valor binario del string leido
	 * .- Añadimos una variables String antes del bucle, y concatenamos el valor de cada linea a esta. <= TRUE
	 */

}
