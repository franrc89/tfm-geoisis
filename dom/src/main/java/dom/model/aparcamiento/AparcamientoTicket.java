package dom.model.aparcamiento;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bounded;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;

/**
 * @author fran
 * 
 */

@ObjectType("APARCAMIENTOTICKET")
@Bookmarkable
@Bounded
public class AparcamientoTicket extends AbstractAparcamiento {

	private float precioHora;
	private float cuota;
	private boolean gratis;

	/**
	 * Devuelve el valor de la propiedad 'precioHora'
	 * @return Propiedad precioHora
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	public float getPrecioHora() {
		return this.precioHora;
	}

	/**
	 * Asigna el valor de la propiedad 'precioHora'
	 * @param precioHora valor que se le quiere dar a la propiedad 'precioHora'
	 */
	public void setPrecioHora(final float precioHora) {
		this.precioHora = precioHora;
	}

	/**
	 * Devuelve el valor de la propiedad 'cuota'
	 * @return Propiedad cuota
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "4")
	@MemberOrder(sequence = "4")
	public float getCuota() {
		return this.cuota;
	}

	/**
	 * Asigna el valor de la propiedad 'cuota'
	 * @param cuota valor que se le quiere dar a la propiedad 'cuota'
	 */

	public void setCuota(final float cuota) {
		this.cuota = cuota;
	}

	/**
	 * Devuelve el valor de la propiedad 'gratis'
	 * @return Propiedad gratis
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "5")
	@MemberOrder(sequence = "5")
	public boolean isGratis() {
		return this.gratis;
	}

	/**
	 * Asigna el valor de la propiedad 'gratis'
	 * @param gratis valor que se le quiere dar a la propiedad 'gratis'
	 */
	public void setGratis(final boolean gratis) {
		this.gratis = gratis;
	}

}
