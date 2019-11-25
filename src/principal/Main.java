package principal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import paquete.Clase01;

public class Main {
	
	public boolean isNumeric(String str) {
		try {
			Integer.valueOf(str);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
				
		Date date1 = new Date();
		
		Clase01 clase = new Clase01();
		Clase01 clase01 = new Clase01();
		Clase01 clase02 = new Clase01(); 
	
		
		Clase01.stPublico = "Modifica Clase";
		clase.stPublico = "Modifica Obj";
		
		System.out.println("OBJ: "+clase.stPublico);
		System.out.println("OBJ: "+clase01.stPublico);
		System.out.println("OBJ: "+clase02.stPublico);
		System.out.println("CLASS: "+Clase01.stPublico); 
				
		Date date2 = new Date();
		System.out.println("EQUALS:"+date1.equals(date2));
		System.out.println("Before:"+date1.before(date2));
		System.out.println("After:"+date1.after(date2));
		

	}

}
