/**
 * 
 */
package dom.model.sociable;

import java.util.Date;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bounded;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;

import dom.model.puntointeres.PuntoInteres;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("PUNTOINTERESVISITADO")
@Bookmarkable
@Bounded
public class PuntoInteresVisitado {

	private Date fecha;
	private Usuario usuario;
	private PuntoInteres puntoInteres;

	/**
	 * Devuelve el valor de la propiedad 'fecha'
	 * @return Propiedad fecha
	 */
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	@javax.jdo.annotations.Column(allowsNull = "false")
	public Date getFecha() {
		return this.fecha;
	}

	/**
	 * Asigna el valor de la propiedad 'fecha'
	 * @param fecha valor que se le quiere dar a la propiedad 'fecha'
	 */
	public void setFecha(final Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Devuelve el valor de la propiedad 'usuario'
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
	 * @param usuario valor que se le quiere dar a la propiedad 'usuario'
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Devuelve el valor de la propiedad 'puntoInteres'
	 * @return Propiedad puntoInteres
	 */
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Column(name = "puntointeres_id", allowsNull = "false")
	public PuntoInteres getPuntoInteres() {
		return this.puntoInteres;
	}

	/**
	 * Asigna el valor de la propiedad 'puntoInteres'
	 * @param puntoInteres valor que se le quiere dar a la propiedad
	 *            'puntoInteres'
	 */
	public void setPuntoInteres(final PuntoInteres puntoInteres) {
		this.puntoInteres = puntoInteres;
	}

}
