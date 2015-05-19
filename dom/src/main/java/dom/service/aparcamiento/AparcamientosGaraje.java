/**
 *
 */
package dom.service.aparcamiento;

import java.util.List;

import javax.jdo.Query;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.isisaddons.wicket.gmap3.cpt.service.LocationLookupService;

import dom.model.aparcamiento.AparcamientoGaraje;

/**
 * @author fran
 *
 */
@DomainServiceLayout(named = "Aparcamientos", menuOrder = "10")
@DomainService(repositoryFor = AparcamientoGaraje.class)
public class AparcamientosGaraje {

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	LocationLookupService locationLookupService = new LocationLookupService();

	@javax.inject.Inject
	private IsisJdoSupport isisJdoSupport;

	// endregion

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Aparcamiento Garaje")
	public List<AparcamientoGaraje> listar() {
		return this.container.allInstances(AparcamientoGaraje.class);
	}

	// endregion

	// region > find (action)
	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Buscar Aparcamientos Garaje")
	public List<AparcamientoGaraje> find(
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Nombre") String nombre,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Direccion") String direccion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Cuota") String cuota,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "HorasAbierto") String horasAbierto,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "PlazasTotales") String plazasTotales,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "PlazasDisponibles") String plazasDisponibles,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "PlazasNoDisponibles") String plazasNoDisponibles,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Vigilancia") Boolean vigilancia,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Location") String location) {

		final javax.jdo.PersistenceManager pm = this.isisJdoSupport.getJdoPersistenceManager();
		final Query q = pm.newQuery(AparcamientoGaraje.class);

		final StringBuilder sb = new StringBuilder();

		if (nombre != null && nombre != "") {
			sb.append("nombre.matches(\".*" + nombre + ".*\") &&");
		}
		if (direccion != null && direccion != "") {
			sb.append("direccion.matches(\".*" + direccion + ".*\") &&");
		}
		if (vigilancia != null) {
			sb.append("vigilancia == " + vigilancia);
		}

		String filtro = sb.toString();
		if (filtro.endsWith("&&")) {
			filtro = filtro.substring(0, filtro.length() - 3);
		}

		q.setFilter(filtro);

		@SuppressWarnings("unchecked")
		final List<AparcamientoGaraje> results = (List<AparcamientoGaraje>) q.execute();

		return results;
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
			final @ParameterLayout(named = "Vigilancia") Boolean vigilancia,
			final @ParameterLayout(named = "Localización") String location) {
		final AparcamientoGaraje obj = this.container.newTransientInstance(AparcamientoGaraje.class);
		obj.setNombre(nombre);
		obj.setDireccion(direccion);
		obj.setCuota(cuota);
		obj.setHorasAbierto(horasAbierto);
		obj.setPlazasTotales(plazasTotales);
		obj.setPlazasDisponibles(plazasDisponibles);
		obj.setPlazasNoDisponibles(plazasNoDisponibles);
		obj.setVigilancia(vigilancia);
		obj.setLocation(this.locationLookupService.lookup(location));

		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Aparcamiento Garaje")
	public void removeAparcamientoGaraje(final @ParameterLayout(named = "Objeto") AparcamientoGaraje objeto) {
		this.container.remove(objeto);
	}

	// endregion

}
