/**
 * 
 */
package dom.model.sociable;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import dom.model.evento.Evento;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@DomainObject(bounded = true, objectType = "Asistencia")
@DomainObjectLayout
public class Asistencia implements Comparable<Asistencia> {

	private Usuario usuario;
	private Evento evento;
	private Intencion intencion;

	/**
	 * Devuelve el valor de la propiedad 'intencion'
	 * 
	 * @return Propiedad intencion
	 */
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	@javax.jdo.annotations.Column(allowsNull = "false")
	public Intencion getIntencion() {
		return this.intencion;
	}

	/**
	 * Asigna el valor de la propiedad 'intencion'
	 * 
	 * @param intencion
	 *            valor que se le quiere dar a la propiedad 'intencion'
	 */
	public void setIntencion(final Intencion intencion) {
		this.intencion = intencion;
	}

	/**
	 * Devuelve el valor de la propiedad 'usuario'
	 * 
	 * @return Propiedad usuario
	 */
	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	@javax.jdo.annotations.Column(allowsNull = "false")
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * Asigna el valor de la propiedad 'usuario'
	 * 
	 * @param usuario
	 *            valor que se le quiere dar a la propiedad 'usuario'
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Devuelve el valor de la propiedad 'evento'
	 * 
	 * @return Propiedad evento
	 */
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Column(name = "evento_id", allowsNull = "false")
	public Evento getEvento() {
		return this.evento;
	}

	/**
	 * Asigna el valor de la propiedad 'evento'
	 * 
	 * @param evento
	 *            valor que se le quiere dar a la propiedad 'evento'
	 */
	public void setEvento(final Evento evento) {
		this.evento = evento;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final Asistencia o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "usuario");
	}

}
