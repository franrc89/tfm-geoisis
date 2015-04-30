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

import dom.model.aparcamiento.AparcamientoGaraje;

/**
 * @author fran
 *
 */
@DomainServiceLayout(named = "Aparcamientos", menuOrder = "10")
@DomainService(repositoryFor = AparcamientoGaraje.class)
public class AparcamientosGaraje {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Aparcamiento Garaje")
	public List<AparcamientoGaraje> listar() {
		return this.container.allInstances(AparcamientoGaraje.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Aparcamiento Garaje")
	public AparcamientoGaraje newAparcamientoGaraje(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Cuota") String cuota,
			final @ParameterLayout(named = "Horas abierto") String horasAbierto,
			final @ParameterLayout(named = "Plazas totales") Integer plazasTotales,
			final @ParameterLayout(named = "Plazas disponibles") Integer plazasDisponibles,
			final @ParameterLayout(named = "Plazas NO disponibles") Integer plazasNoDisponibles,
			final @ParameterLayout(named = "Vigilancia") Boolean vigilancia) {
		final AparcamientoGaraje obj = this.container.newTransientInstance(AparcamientoGaraje.class);
		obj.setNombre(nombre);
		obj.setDireccion(direccion);
		obj.setCuota(cuota);
		obj.setHorasAbierto(horasAbierto);
		obj.setPlazasTotales(plazasTotales);
		obj.setPlazasDisponibles(plazasDisponibles);
		obj.setPlazasNoDisponibles(plazasNoDisponibles);
		obj.setVigilancia(vigilancia);

		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Aparcamiento Garaje")
	public void removeAparcamientoGaraje(final @ParameterLayout(named = "Objeto") AparcamientoGaraje objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	LocationLookupService locationLookupService = new LocationLookupService();

	// endregion

}
