package paquete;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clase01 {

	private String privado = "privado";
	
	private static String stPrivado = "";
	
	public String publico = "publico";
	
	public static String stPublico = "";
	
	protected String protegido = "";
	
	String paquete = "";		
	
	
	/**
	 * 
	 * @param strDate - Tiene que tener formato dd-MM-yyyy
	 * @return
	 */
	public boolean esFechaCorrecta(String strDate) {
		SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");
		
		Date date;
		try {
			date = spf.parse(strDate);
		} catch (ParseException e) { 
			e.printStackTrace();
			return false;
		}

		int year = date.getYear();
		Date cur = new Date();
		if (year > cur.getYear()) {
			return false;
		}

		return true;
	}
}
