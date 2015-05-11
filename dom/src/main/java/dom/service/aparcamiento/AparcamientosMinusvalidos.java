/**
 *
 */
package dom.service.aparcamiento;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.isisaddons.wicket.gmap3.cpt.service.LocationLookupService;

import dom.model.aparcamiento.AparcamientoMinusvalidos;

/**
 * @author fran
 *
 */
@DomainServiceLayout(named = "Aparcamientos", menuOrder = "10")
@DomainService(repositoryFor = AparcamientoMinusvalidos.class)
public class AparcamientosMinusvalidos {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Aparcamiento Minusválidos")
	public List<AparcamientoMinusvalidos> listar() {
		return this.container.allInstances(AparcamientoMinusvalidos.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Aparcamiento Minusválidos")
	public AparcamientoMinusvalidos newAparcamientoMinusvalidos(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Gratuito") Boolean gratuito,
			final @ParameterLayout(named = "Localización") String location) {
		final AparcamientoMinusvalidos obj = this.container.newTransientInstance(AparcamientoMinusvalidos.class);
		obj.setNombre(nombre);
		obj.setDireccion(direccion);
		obj.setGratis(gratuito);
		obj.setLocation(this.locationLookupService.lookup(location));

		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Aparcamiento Minusválidos")
	public void removeAparcamientoMinusvalidos(final @ParameterLayout(named = "Objeto") AparcamientoMinusvalidos objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	LocationLookupService locationLookupService = new LocationLookupService();

	// endregion

}
