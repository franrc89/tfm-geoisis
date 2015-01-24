/**
 * 
 */
package dom.service.aparcamiento;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotInServiceMenu;

import dom.model.aparcamiento.AparcamientoMinusvalidos;

/**
 * @author fran
 * 
 */
@DomainService(menuOrder = "10", repositoryFor = AparcamientoMinusvalidos.class)
public class AparcamientosMinusvalidos {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<AparcamientoMinusvalidos> listar() {
		return this.container.allInstances(AparcamientoMinusvalidos.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public AparcamientoMinusvalidos crear(final @Named("Nombre") String nombre,
			final @Named("Dirección") String direccion, final @Named("Gratuito") boolean gratuito) {
		final AparcamientoMinusvalidos obj = this.container.newTransientInstance(AparcamientoMinusvalidos.class);
		obj.setNombre(nombre);
		obj.setDireccion(direccion);
		obj.setGratis(gratuito);

		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") AparcamientoMinusvalidos objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
