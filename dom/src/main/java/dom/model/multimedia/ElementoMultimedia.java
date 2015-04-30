package dom.model.multimedia;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@DomainObject(bounded = true, objectType = "ElementoMultimedia")
@DomainObjectLayout
public class ElementoMultimedia implements Comparable<ElementoMultimedia> {

	private MimeType tipo;
	private Boolean interno;
	private String uri;

	/**
	 * Devuelve el valor de la propiedad 'tipo'
	 * 
	 * @return Propiedad tipo
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	public MimeType getTipo() {
		return this.tipo;
	}

	/**
	 * Asigna el valor de la propiedad 'tipo'
	 * 
	 * @param tipo
	 *            valor que se le quiere dar a la propiedad 'tipo'
	 */
	public void setTipo(final MimeType tipo) {
		this.tipo = tipo;
	}

	/**
	 * Devuelve el valor de la propiedad 'interno'
	 * 
	 * @return Propiedad interno
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	public Boolean isInterno() {
		return this.interno;
	}

	/**
	 * Asigna el valor de la propiedad 'interno'
	 * 
	 * @param interno
	 *            valor que se le quiere dar a la propiedad 'interno'
	 */
	public void setInterno(final Boolean interno) {
		this.interno = interno;
	}

	/**
	 * Devuelve el valor de la propiedad 'uri'
	 * 
	 * @return Propiedad uri
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "3")
	public String getUri() {
		return this.uri;
	}

	/**
	 * Asigna el valor de la propiedad 'uri'
	 * 
	 * @param uri
	 *            valor que se le quiere dar a la propiedad 'uri'
	 */
	public void setUri(final String uri) {
		this.uri = uri;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final ElementoMultimedia o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "nombre");
	}

}
