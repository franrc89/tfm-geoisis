/**
 * 
 */
package dom.model.usuario;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

/**
 * @author fran
 * 
 */
@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, columns = {
		@javax.jdo.annotations.Column(name = "usuario_id"), @javax.jdo.annotations.Column(name = "evento_id") })
@ObjectType("USUARIO_EVENTO")
@Bookmarkable
public class Usuario_Evento implements Comparable<Usuario_Evento> {

	private String intencion;

	/**
	 * Devuelve el valor de la propiedad 'intencion'
	 * @return Propiedad intencion
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	public String getIntencion() {
		return this.intencion;
	}

	/**
	 * Asigna el valor de la propiedad 'intencion'
	 * @param intencion valor que se le quiere dar a la propiedad 'intencion'
	 */
	public void setIntencion(final String intencion) {
		this.intencion = intencion;
	}

	@Override
	public int compareTo(final Usuario_Evento o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "orden");
	}
}
