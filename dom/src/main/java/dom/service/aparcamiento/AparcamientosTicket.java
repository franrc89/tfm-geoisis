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

import dom.model.aparcamiento.AparcamientoTicket;

/**
 * @author fran
 *
 */
@DomainServiceLayout(named = "Aparcamientos", menuOrder = "10")
@DomainService(repositoryFor = AparcamientoTicket.class)
public class AparcamientosTicket {

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
	@ActionLayout(named = "Listar Aparcamiento Ticket")
	public List<AparcamientoTicket> listar() {
		return this.container.allInstances(AparcamientoTicket.class);
	}

	// endregion

	// region > find (action)
	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Buscar Aparcamientos Ticket")
	public List<AparcamientoTicket> find(
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Nombre") String nombre,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Direccion") String direccion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Cuota") String cuota,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Gratuito") Boolean gratuito,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "PrecioHora") String precioHora,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Location") String location) {

		final javax.jdo.PersistenceManager pm = this.isisJdoSupport.getJdoPersistenceManager();
		final Query q = pm.newQuery(AparcamientoTicket.class);

		final StringBuilder sb = new StringBuilder();

		if (nombre != null && nombre != "") {
			sb.append("nombre.matches(\".*" + nombre + ".*\") &&");
		}
		if (direccion != null && direccion != "") {
			sb.append("direccion.matches(\".*" + direccion + ".*\") &&");
		}
		if (cuota != null && cuota != "") {
			sb.append("cuota.matches(\".*" + cuota + ".*\") &&");
		}
		if (precioHora != null && precioHora != "") {
			sb.append("precioHora.matches(\".*" + precioHora + ".*\") &&");
		}
		if (gratuito != null) {
			sb.append("gratuito == " + gratuito);
		}

		String filtro = sb.toString();
		if (filtro.endsWith("&&")) {
			filtro = filtro.substring(0, filtro.length() - 3);
		}

		q.setFilter(filtro);

		@SuppressWarnings("unchecked")
		final List<AparcamientoTicket> results = (List<AparcamientoTicket>) q.execute();

		return results;
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Aparcamiento Ticket")
	public AparcamientoTicket newAparcamientoTicket(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Precio hora") String precioHora,
			final @ParameterLayout(named = "Cuota") String cuota,
			final @ParameterLayout(named = "Gratuito") Boolean gratuito,
			final @ParameterLayout(named = "Localización") String location) {
		final AparcamientoTicket obj = this.container.newTransientInstance(AparcamientoTicket.class);
		obj.setNombre(nombre);
		obj.setDireccion(direccion);
		obj.setPrecioHora(precioHora);
		obj.setCuota(cuota);
		obj.setGratis(gratuito);
		obj.setLocation(this.locationLookupService.lookup(location));

		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Aparcamiento Ticket")
	public void removeAparcamientoTicket(final @ParameterLayout(named = "Objeto") AparcamientoTicket objeto) {
		this.container.remove(objeto);
	}

	// endregion

}
