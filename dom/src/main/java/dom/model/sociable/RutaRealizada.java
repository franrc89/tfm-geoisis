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
import org.apache.isis.applib.util.ObjectContracts;

import dom.model.ruta.Ruta;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("RUTAREALIZADA")
@Bookmarkable
@Bounded
public class RutaRealizada implements Comparable<RutaRealizada> {

	private Date fecha;
	private Usuario usuario;
	private Ruta ruta;

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
	 * Devuelve el valor de la propiedad 'ruta'
	 * @return Propiedad ruta
	 */
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Column(name = "ruta_id", allowsNull = "false")
	public Ruta getRuta() {
		return this.ruta;
	}

	/**
	 * Asigna el valor de la propiedad 'ruta'
	 * @param ruta valor que se le quiere dar a la propiedad 'ruta'
	 */
	public void setRuta(final Ruta ruta) {
		this.ruta = ruta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final RutaRealizada o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "fecha");
	}

}
