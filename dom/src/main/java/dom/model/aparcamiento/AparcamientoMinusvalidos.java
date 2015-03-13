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
@DomainObject(bounded = true, objectType = "AparcamientoMinusvalidos")
@DomainObjectLayout
public class AparcamientoMinusvalidos extends AbstractAparcamiento {

	private boolean gratis;

	/**
	 * Devuelve el valor de la propiedad 'gratis'
	 * 
	 * @return Propiedad gratis
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	public boolean isGratis() {
		return this.gratis;
	}

	/**
	 * Asigna el valor de la propiedad 'gratis'
	 * 
	 * @param gratis
	 *            valor que se le quiere dar a la propiedad 'gratis'
	 */
	public void setGratis(final boolean gratis) {
		this.gratis = gratis;
	}

}
