/**
 * 
 */
package dom.model.sociable;

/**
 * @author fran
 * 
 */
public enum Intencion {

	SI("Si, asistiré"), NOSE("Todavia no lo he decidido"), NO("No asistiré");

	private String frase;

	private Intencion(final String frase) {
		this.frase = frase;
	}

	/**
	 * Devuelve el valor de la propiedad 'frase'
	 * @return Propiedad frase
	 */
	public String getFrase() {
		return this.frase;
	}

}
