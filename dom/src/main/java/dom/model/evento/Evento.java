/**
 *
 */
package dom.model.evento;

import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.RenderType;
import org.apache.isis.applib.annotation.Title;

import dom.model.puntointeres.PuntoInteres;
import dom.model.sociable.Asistencia;

/**
 * @author fran
 *
 */

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUPERCLASS_TABLE)
@DomainObject(bounded = true, objectType = "Evento")
@DomainObjectLayout
public class Evento extends AbstractEvento {

	private Date fechaInicio;
	private Date fechaFin;
	private PuntoInteres puntoInteres;
	private SortedSet<Asistencia> asistencias = new TreeSet<Asistencia>();

	/**
	 * Devuelve el valor de la propiedad 'fechaInicio'
	 *
	 * @return Propiedad fechaInicio
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "3")
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	/**
	 * Asigna el valor de la propiedad 'fechaInicio'
	 *
	 * @param fechaInicio valor que se le quiere dar a la propiedad
	 *            'fechaInicio'
	 */
	public void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Devuelve el valor de la propiedad 'fechaFin'
	 *
	 * @return Propiedad fechaFin
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "4")
	public Date getFechaFin() {
		return this.fechaFin;
	}

	/**
	 * Asigna el valor de la propiedad 'fechaFin'
	 *
	 * @param fechaFin valor que se le quiere dar a la propiedad 'fechaFin'
	 */
	public void setFechaFin(final Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Devuelve el valor de la propiedad 'puntoInteres'
	 *
	 * @return Propiedad puntoInteres
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "2")
	@MemberOrder(sequence = "5")
	public PuntoInteres getPuntoInteres() {
		return this.puntoInteres;
	}

	/**
	 * Asigna el valor de la propiedad 'puntoInteres'
	 *
	 * @param puntoInteres valor que se le quiere dar a la propiedad
	 *            'puntoInteres'
	 */
	public void setPuntoInteres(final PuntoInteres puntoInteres) {
		this.puntoInteres = puntoInteres;
	}

	/**
	 * Devuelve el valor de la propiedad 'asistencias'
	 *
	 * @return Propiedad asistencias
	 */
	@MemberOrder(sequence = "6")
	@javax.jdo.annotations.Persistent(column = "evento_id", mappedBy = "evento", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	/**
	 * Asigna el valor de la propiedad 'asistencias'
	 *
	 * @param asistencias valor que se le quiere dar a la propiedad
	 *            'asistencias'
	 */
	public void setAsistencias(final SortedSet<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

}
