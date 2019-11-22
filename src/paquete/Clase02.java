package paquete;

public class Clase02 {

	private void prueba() {
		
		Clase01 clase = new Clase01();
		clase.publico = "";
		clase.paquete = "";
		clase.protegido = "";
		
		clase.stPublico = "";
		Clase01.stPublico = "";
	}
	
	public boolean isNumeric(String str) {
		try {
			Integer.valueOf(str);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
}
