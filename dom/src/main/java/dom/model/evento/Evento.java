/**
 * 
 */
package dom.model.evento;

import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import dom.model.puntointeres.PuntoInteres;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("EVENTO")
@Bookmarkable
public class Evento extends AbstractEvento implements Comparable<Evento> {

	private Date fechaInicio;
	private Date fechaFin;
	private PuntoInteres puntoInteres;
	private SortedSet<Usuario> listaUsuario = new TreeSet<Usuario>();

	/**
	 * Devuelve el valor de la propiedad 'fechaInicio'
	 * @return Propiedad fechaInicio
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	/**
	 * Asigna el valor de la propiedad 'fechaInicio'
	 * @param fechaInicio valor que se le quiere dar a la propiedad
	 *            'fechaInicio'
	 */
	public void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Devuelve el valor de la propiedad 'fechaFin'
	 * @return Propiedad fechaFin
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "4")
	@MemberOrder(sequence = "4")
	public Date getFechaFin() {
		return this.fechaFin;
	}

	/**
	 * Asigna el valor de la propiedad 'fechaFin'
	 * @param fechaFin valor que se le quiere dar a la propiedad 'fechaFin'
	 */
	public void setFechaFin(final Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Devuelve el valor de la propiedad 'puntoInteres'
	 * @return Propiedad puntoInteres
	 */
	@javax.jdo.annotations.Column(name = "puntointeres_id", allowsNull = "false")
	@Title(sequence = "5")
	@MemberOrder(sequence = "5")
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

	/**
	 * Devuelve el valor de la propiedad 'listaUsuario'
	 * @return Propiedad listaUsuario
	 */
	@javax.jdo.annotations.Persistent(table = "Usuario_Evento")
	@javax.jdo.annotations.Join(column = "usuario_id")
	@javax.jdo.annotations.Element(column = "evento_id")
	public SortedSet<Usuario> getListaUsuario() {
		return this.listaUsuario;
	}

	/**
	 * Asigna el valor de la propiedad 'listaUsuario'
	 * @param listaUsuario valor que se le quiere dar a la propiedad
	 *            'listaUsuario'
	 */
	public void setListaUsuario(final SortedSet<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	@Override
	public int compareTo(final Evento o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "nombre");
	}
}
