package dom.model.aparcamiento;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;

/**
 * @author fran
 *
 */

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUPERCLASS_TABLE)
@DomainObject(bounded = true, objectType = "AparcamientoGaraje")
@DomainObjectLayout
public class AparcamientoGaraje extends AbstractAparcamiento {

	private String horasAbierto;
	private String cuota;
	private Integer plazasTotales;
	private Integer plazasNoDisponibles;
	private Integer plazasDisponibles;
	private Boolean vigilancia;

	/**
	 * Devuelve el valor de la propiedad 'horasAbierto'
	 *
	 * @return Propiedad horasAbierto
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	public String getHorasAbierto() {
		return this.horasAbierto;
	}

	/**
	 * Asigna el valor de la propiedad 'horasAbierto'
	 *
	 * @param horasAbierto valor que se le quiere dar a la propiedad
	 *            'horasAbierto'
	 */
	public void setHorasAbierto(final String horasAbierto) {
		this.horasAbierto = horasAbierto;
	}

	/**
	 * Devuelve el valor de la propiedad 'cuota'
	 *
	 * @return Propiedad cuota
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "4")
	@MemberOrder(sequence = "4")
	public String getCuota() {
		return this.cuota;
	}

	/**
	 * Asigna el valor de la propiedad 'cuota'
	 *
	 * @param cuota valor que se le quiere dar a la propiedad 'cuota'
	 */
	public void setCuota(final String cuota) {
		this.cuota = cuota;
	}

	/**
	 * Devuelve el valor de la propiedad 'plazasTotales'
	 *
	 * @return Propiedad plazasTotales
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "5")
	@MemberOrder(sequence = "5")
	public Integer getPlazasTotales() {
		return this.plazasTotales;
	}

	/**
	 * Asigna el valor de la propiedad 'plazasTotales'
	 *
	 * @param plazasTotales valor que se le quiere dar a la propiedad
	 *            'plazasTotales'
	 */
	public void setPlazasTotales(final Integer plazasTotales) {
		this.plazasTotales = plazasTotales;
	}

	/**
	 * Devuelve el valor de la propiedad 'plazasNoDisponibles'
	 *
	 * @return Propiedad plazasNoDisponibles
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "6")
	@MemberOrder(sequence = "6")
	public Integer getPlazasNoDisponibles() {
		return this.plazasNoDisponibles;
	}

	/**
	 * Asigna el valor de la propiedad 'plazasNoDisponibles'
	 *
	 * @param plazasNoDisponibles valor que se le quiere dar a la propiedad
	 *            'plazasNoDisponibles'
	 */
	public void setPlazasNoDisponibles(final Integer plazasNoDisponibles) {
		this.plazasNoDisponibles = plazasNoDisponibles;
	}

	/**
	 * Devuelve el valor de la propiedad 'plazasDisponibles'
	 *
	 * @return Propiedad plazasDisponibles
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "7")
	@MemberOrder(sequence = "7")
	public Integer getPlazasDisponibles() {
		return this.plazasDisponibles;
	}

	/**
	 * Asigna el valor de la propiedad 'plazasDisponibles'
	 *
	 * @param plazasDisponibles valor que se le quiere dar a la propiedad
	 *            'plazasDisponibles'
	 */
	public void setPlazasDisponibles(final Integer plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}

	/**
	 * Devuelve el valor de la propiedad 'vigilancia'
	 *
	 * @return Propiedad vigilancia
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "8")
	@MemberOrder(sequence = "8")
	public Boolean isVigilancia() {
		return this.vigilancia;
	}

	/**
	 * Asigna el valor de la propiedad 'vigilancia'
	 *
	 * @param vigilancia valor que se le quiere dar a la propiedad 'vigilancia'
	 */
	public void setVigilancia(final Boolean vigilancia) {
		this.vigilancia = vigilancia;
	}
}
