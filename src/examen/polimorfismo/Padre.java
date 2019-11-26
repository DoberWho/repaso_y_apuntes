package examen.polimorfismo;

public class Padre extends Persona implements Adulto {

	@Override
	public boolean isAdulto() {
		return true;
	}

	@Override
	public boolean siEsAdulto() {
		return isAdulto();
	}

}
