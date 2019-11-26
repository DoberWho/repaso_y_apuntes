package examen.ficheros;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Lectura y escritura de ficheros planos
 */
public class Ficheros03 {

	private final String RUTA_FICHERO = "C:\\ficheroRandom.txt";

	/**
	 * Como se lee un fichero con Objecto Clase
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void lectura() throws IOException, ClassNotFoundException {

		File fichero = new File(RUTA_FICHERO);

		RandomAccessFile raf = new RandomAccessFile(fichero, "r"); // Leer Read
		//
		int id, dep, posicion;
		Double salario;
		char apellido[] = new char[10], aux;

		posicion = 0; // para situarnos al principio

		for (;;) { // recorro el fichero
			raf.seek(posicion); // nos posicionamos en posicion
			id = raf.readInt(); // obtengo id de empleado

			// recorro uno a uno los caracteres del apellido
			for (int i = 0; i < apellido.length; i++) {
				aux = raf.readChar();
				apellido[i] = aux; // los voy guardando en el array
			}

			// convierto a String el array
			String apellidos = new String(apellido);
			dep = raf.readInt(); // obtengo dep
			salario = raf.readDouble(); // obtengo salario

			if (id > 0) {
				String format = "ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n";
				System.out.printf(format, id, apellidos.trim(), dep, salario);
			}

			// me posiciono para el sig empleado, cada empleado ocupa 36 bytes
			posicion = posicion + 36;

			// Si he recorrido todos los bytes salgo del for
			if (raf.getFilePointer() == raf.length())
				break;

		} // fin bucle for
		raf.close(); // cerrar fichero
	}

	/**
	 * Forma más simple para escribir un fichero Plano
	 */
	public void escritura() throws IOException {

		File fichero = new File("FichPersona.dat");// declara el fichero

		String nombres[] = { "Ana", "Luis Miguel", null, "Pedro", "Manuel", "Andrés", "Julio", "Antonio",
				"María Jesús" };

		int edades[] = { 14, 15, 13, 15, 16, 12, 16, 14, 13 };

		RandomAccessFile raf = new RandomAccessFile(fichero, "rw"); // Leer+Escribir Read+Write
		StringBuffer sbuf = null;
		for (int i = 0; i < nombres.length; i++) {

			raf.write(i + 1);

			sbuf = new StringBuffer(nombres[i]);
			sbuf.setLength(10);
			raf.writeChars(sbuf.toString());			

			raf.writeInt(edades[i]);
		}
		raf.close();

	}

	/**
	 * Preguntas Teoricas:
	 */

	/**
	 * 1.- ¿Debemos leer/escribir en el mismo orden para evitar problemas?
	 * .- Si; Leemos/Escribimos los campos del objeto, no el serializable <= TRUE
	 * .- Si; Tenemos que leer el primer objecto siempre antes del segundo, o no funcionará el programa
	 * .- No; usamos un objecto serializable, por lo que se encarga el lenguaje
	 * .- No; por que Rick nos ayudará a encontrar el orden de los Mortys hasta encontrar al malvado.
	 */
 
	/**
	 * 2.-¿Se pueden escribir Strings?
	 * .- Si; podemos escribir cualquier tipo de objeto
	 * .- No; no existe la función pero podemos escribirlo usando un StringBuffer
	 * .- No; por que no hay un metodo para ello, estamos obligados a usar un array de char
	 * .- Si; por que los tejedores hilan el destino en los tapices del tiempo usando strings
	 * 
	 */
	
	/**
	 * 3.- ¿Que tipo de permisos podemos tener en el RandomAccessFile?
	 * .- "r", "rw", "rws", or "rwd" <= TRUE
	 * .- "r", "ra"
	 * .- "r", "w"
	 * .- "Arr", basado en los gritos de piratas venidos desde el más allá para conquista a Elaine Marley
	 */
	 

	public static void main(String[] args) {

		Ficheros03 main = new Ficheros03();
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
