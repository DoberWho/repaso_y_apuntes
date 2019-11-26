package examen.polimorfismo;

public class Main {
	/*
	 * Esta clase es para probar el Polimorfismo 
	 */
	public static void main(String[] args) {
		
		// Adulto ad = new Adulto();
		// Persona persona = new Persona();
		
		Padre padre = new Padre();
		Hijo hijo = new Hijo();
		HijoMayor hijoMayor = new HijoMayor();
		
		System.out.println("Padre - Persona:"+(padre instanceof Persona));
		System.out.println("Padre - Adulto:"+(padre instanceof Adulto));
		
		System.out.println("Hijo - Persona:"+(hijo instanceof Persona));
		System.out.println("Hijo - Adulto:"+(hijo instanceof Adulto));
		
		System.out.println("HijoMayor - Persona:"+(hijoMayor instanceof Persona));
		System.out.println("HijoMayor - Adulto:"+(hijoMayor instanceof Adulto));
		//System.out.println("HijoMayor - Padre:"+(hijoMayor instanceof Padre)); // No se Puede
		
		/**
		Padre - Persona:true
		Padre - Adulto:true
		
		Hijo - Persona:true
		Hijo - Adulto:false
		
		HijoMayor - Persona:true
		HijoMayor - Adulto:true

		 */
		
		
		/**
		 * Preguntas Teoricas:
		 */
		
		/**
		 * 1.- ¿Podemos hacer instancia de Interface o Abstract?
		 * .- No; no se puede hacer una instancia de ninguna
		 */
		
	}
}
