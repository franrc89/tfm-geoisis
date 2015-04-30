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
@DomainObject(bounded = true, objectType = "AparcamientoTicket")
@DomainObjectLayout
public class AparcamientoTicket extends AbstractAparcamiento {

	private String precioHora;
	private String cuota;
	private Boolean gratis;

	/**
	 * Devuelve el valor de la propiedad 'precioHora'
	 *
	 * @return Propiedad precioHora
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	public String getPrecioHora() {
		return this.precioHora;
	}

	/**
	 * Asigna el valor de la propiedad 'precioHora'
	 *
	 * @param precioHora valor que se le quiere dar a la propiedad 'precioHora'
	 */
	public void setPrecioHora(final String precioHora) {
		this.precioHora = precioHora;
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
	 * Devuelve el valor de la propiedad 'gratis'
	 *
	 * @return Propiedad gratis
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "5")
	@MemberOrder(sequence = "5")
	public Boolean isGratis() {
		return this.gratis;
	}

	/**
	 * Asigna el valor de la propiedad 'gratis'
	 *
	 * @param gratis valor que se le quiere dar a la propiedad 'gratis'
	 */
	public void setGratis(final Boolean gratis) {
		this.gratis = gratis;
	}

}
