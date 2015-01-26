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

import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("FAVORITO")
@Bookmarkable
@Bounded
public class Favorito implements Comparable<Favorito> {

	private Date fecha;
	private String alias;
	private Usuario usuario;
	private ClaseSociable claseSociable;

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
	 * Devuelve el valor de la propiedad 'alias'
	 * @return Propiedad alias
	 */
	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	@javax.jdo.annotations.Column(allowsNull = "false")
	public String getAlias() {
		return this.alias;
	}

	/**
	 * Asigna el valor de la propiedad 'alias'
	 * @param alias valor que se le quiere dar a la propiedad 'alias'
	 */
	public void setAlias(final String alias) {
		this.alias = alias;
	}

	/**
	 * Devuelve el valor de la propiedad 'usuario'
	 * @return Propiedad usuario
	 */
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
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
	 * Devuelve el valor de la propiedad 'claseSociable'
	 * @return Propiedad claseSociable
	 */
	@Title(sequence = "4")
	@MemberOrder(sequence = "4")
	@javax.jdo.annotations.Column(name = "clasesociable_id", allowsNull = "false")
	public ClaseSociable getClaseSociable() {
		return this.claseSociable;
	}

	/**
	 * Asigna el valor de la propiedad 'claseSociable'
	 * @param claseSociable valor que se le quiere dar a la propiedad
	 *            'claseSociable'
	 */
	public void setClaseSociable(final ClaseSociable claseSociable) {
		this.claseSociable = claseSociable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final Favorito o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "fecha");
	}

}
