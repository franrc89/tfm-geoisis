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

import dom.model.aparcamiento.AparcamientoCargaDescarga;

/**
 * @author fran
 *
 */

@DomainServiceLayout(named = "Aparcamientos", menuOrder = "10")
@DomainService(repositoryFor = AparcamientoCargaDescarga.class)
public class AparcamientosCargaDescarga {

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
	@ActionLayout(named = "Listar Aparcamiento Carga Descarga")
	public List<AparcamientoCargaDescarga> listar() {
		return this.container.allInstances(AparcamientoCargaDescarga.class);
	}

	// endregion

	// region > find (action)
	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Buscar Aparcamientos Carga Descarga")
	public List<AparcamientoCargaDescarga> find(
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Nombre") String nombre,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Direccion") String direccion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Gratuito") Boolean gratuito,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Location") String location) {

		final javax.jdo.PersistenceManager pm = this.isisJdoSupport.getJdoPersistenceManager();
		final Query q = pm.newQuery(AparcamientoCargaDescarga.class);

		final StringBuilder sb = new StringBuilder();

		if (nombre != null && nombre != "") {
			sb.append("nombre.matches(\".*" + nombre + ".*\") &&");
		}
		if (direccion != null && direccion != "") {
			sb.append("direccion.matches(\".*" + direccion + ".*\") &&");
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
		final List<AparcamientoCargaDescarga> results = (List<AparcamientoCargaDescarga>) q.execute();

		return results;
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Aparcamiento Carga Descarga")
	public AparcamientoCargaDescarga newAparcamientoCargaDescarga(
			final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Gratuito") Boolean gratuito,
			final @ParameterLayout(named = "Localización") String location) {
		final AparcamientoCargaDescarga obj = this.container.newTransientInstance(AparcamientoCargaDescarga.class);
		obj.setNombre(nombre);
		obj.setDireccion(direccion);
		obj.setGratis(gratuito);
		obj.setLocation(this.locationLookupService.lookup(location));

		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Aparcamiento Carga Descarga")
	public void removeAparcamientoCargaDescarga(
			final @ParameterLayout(named = "Objeto") AparcamientoCargaDescarga objeto) {
		this.container.remove(objeto);
	}

	// endregion

}
