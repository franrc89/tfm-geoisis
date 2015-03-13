/**
 * 
 */
package dom.service.aparcamiento;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import dom.model.aparcamiento.AparcamientoMinusvalidos;

/**
 * @author fran
 * 
 */
@DomainService(menuOrder = "10", repositoryFor = AparcamientoMinusvalidos.class)
public class AparcamientosMinusvalidos {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	public List<AparcamientoMinusvalidos> listar() {
		return this.container.allInstances(AparcamientoMinusvalidos.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public AparcamientoMinusvalidos crear(
			final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Gratuito") boolean gratuito) {
		final AparcamientoMinusvalidos obj = this.container
				.newTransientInstance(AparcamientoMinusvalidos.class);
		obj.setNombre(nombre);
		obj.setDireccion(direccion);
		obj.setGratis(gratuito);

		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	// @NotInServiceMenu
	public void borrar(
			final @ParameterLayout(named = "Objeto") AparcamientoMinusvalidos objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
