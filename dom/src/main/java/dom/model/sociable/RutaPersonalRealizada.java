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

import dom.model.rutapersonal.RutaPersonal;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("RUTAPERSONALREALIZADA")
@Bookmarkable
@Bounded
public class RutaPersonalRealizada {

	private Date fecha;
	private Usuario usuario;
	private RutaPersonal rutaPersonal;

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
	 * Devuelve el valor de la propiedad 'rutaPersonal'
	 * @return Propiedad rutaPersonal
	 */
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Column(name = "rutapersonal_id", allowsNull = "false")
	public RutaPersonal getRutaPersonal() {
		return this.rutaPersonal;
	}

	/**
	 * Asigna el valor de la propiedad 'rutaPersonal'
	 * @param rutaPersonal valor que se le quiere dar a la propiedad
	 *            'rutaPersonal'
	 */
	public void setRutaPersonal(final RutaPersonal rutaPersonal) {
		this.rutaPersonal = rutaPersonal;
	}

}
