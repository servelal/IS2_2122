package es.unican.is2;
@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
	private int cilindrada;

    /**
     * Retorna la cilindrada de la motocicleta
     * @return cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }
    
  
	@Override
    public double precioImpuesto() {
		if (cilindrada <= 125) {
			return 8.84;
		}
		else if (cilindrada < 250) {
			return 15.14;
		}
		else if (cilindrada < 500) {
			return 30.30;
		}
		else if (cilindrada < 1000) {
			return 60.58;
		}
		return 121.16;
    }
}
