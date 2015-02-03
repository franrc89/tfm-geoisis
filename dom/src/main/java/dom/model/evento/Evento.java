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
import org.apache.isis.applib.annotation.Bounded;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;
import org.apache.isis.applib.annotation.Title;

import dom.model.puntointeres.PuntoInteres;
import dom.model.sociable.Asistencia;

/**
 * @author fran
 * 
 */

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("EVENTO")
@Bookmarkable
@Bounded
public class Evento {

	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private PuntoInteres puntoInteres;
	private SortedSet<Asistencia> listaAsistencia = new TreeSet<Asistencia>();

	/**
	 * Devuelve el valor de la propiedad 'nombre'
	 * @return Propiedad nombre
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Asigna el valor de la propiedad 'nombre'
	 * @param nombre valor que se le quiere dar a la propiedad 'nombre'
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el valor de la propiedad 'descripcion'
	 * @return Propiedad descripcion
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Asigna el valor de la propiedad 'descripcion'
	 * @param descripcion valor que se le quiere dar a la propiedad
	 *            'descripcion'
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

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
	@javax.jdo.annotations.Column(allowsNull = "false")
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
	 * Devuelve el valor de la propiedad 'listaAsistencia'
	 * @return Propiedad listaAsistencia
	 */
	@Title(sequence = "6")
	@MemberOrder(sequence = "6")
	@javax.jdo.annotations.Persistent(column = "evento_id", mappedBy = "evento", dependentElement = "false")
	@Render(Type.EAGERLY)
	public SortedSet<Asistencia> getListaAsistencia() {
		return this.listaAsistencia;
	}

	/**
	 * Asigna el valor de la propiedad 'listaAsistencia'
	 * @param listaAsistencia valor que se le quiere dar a la propiedad
	 *            'listaAsistencia'
	 */
	public void setListaAsistencia(final SortedSet<Asistencia> listaAsistencia) {
		this.listaAsistencia = listaAsistencia;
	}

}
