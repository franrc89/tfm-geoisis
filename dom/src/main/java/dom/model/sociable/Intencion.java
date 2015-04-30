/**
 *
 */
package dom.model.sociable;

/**
 * @author fran
 *
 */
public enum Intencion {

	Si("Si, asistiré"), Indeciso("Todavia no lo he decidido"), No("No asistiré");

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
