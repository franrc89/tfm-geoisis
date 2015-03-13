package dom.model.evento;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;

import dom.model.sociable.ClaseSociable;

/**
 * @author fran
 * 
 */

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DomainObjectLayout
public abstract class AbstractEvento extends ClaseSociable {

	private String nombre;
	private String descripcion;

	/**
	 * Devuelve el valor de la propiedad 'nombre'
	 * 
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
	 * 
	 * @param nombre
	 *            valor que se le quiere dar a la propiedad 'nombre'
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el valor de la propiedad 'descripcion'
	 * 
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
	 * 
	 * @param descripcion
	 *            valor que se le quiere dar a la propiedad 'descripcion'
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

}
