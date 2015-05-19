package dom.service.puntointeres.cultural;

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

import dom.model.puntointeres.cultural.Religioso;

@DomainServiceLayout(named = "POIs Civiles", menuOrder = "10")
@DomainService(repositoryFor = Religioso.class)
public class Religiosos {

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
	@ActionLayout(named = "Listar Religiosos")
	public List<Religioso> listar() {
		return this.container.allInstances(Religioso.class);
	}

	// endregion

	// region > find (action)
	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Buscar Religiosos")
	public List<Religioso> find(
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Nombre") String nombre,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Descripcion") String descripcion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Direccion") String direccion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Tipo") String tipo,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Epoca") String epoca,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Visitable") Boolean visitable,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Estado") String estado,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Estilo") String estilo,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Location") String location) {

		final javax.jdo.PersistenceManager pm = this.isisJdoSupport.getJdoPersistenceManager();
		final Query q = pm.newQuery(Religioso.class);

		final StringBuilder sb = new StringBuilder();

		if (nombre != null && nombre != "") {
			sb.append("nombre.matches(\".*" + nombre + ".*\") &&");
		}
		if (descripcion != null && descripcion != "") {
			sb.append("descripcion.matches(\".*" + descripcion + ".*\") &&");
		}
		if (direccion != null && direccion != "") {
			sb.append("direccion.matches(\".*" + direccion + ".*\") &&");
		}
		if (accesibilidad != null && accesibilidad != "") {
			sb.append("accesibilidad.matches(\".*" + accesibilidad + ".*\") &&");
		}
		if (tipo != null && tipo != "") {
			sb.append("tipo.matches(\".*" + tipo + ".*\") &&");
		}
		if (epoca != null && epoca != "") {
			sb.append("epoca.matches(\".*" + epoca + ".*\") &&");
		}
		if (visitable != null) {
			sb.append("visitable == " + visitable + " &&");
		}
		if (estado != null && estado != "") {
			sb.append("estado.matches(\".*" + estado + ".*\") &&");
		}
		if (estilo != null && estilo != "") {
			sb.append("estilo.matches(\".*" + estilo + ".*\")");
		}

		String filtro = sb.toString();
		if (filtro.endsWith("&&")) {
			filtro = filtro.substring(0, filtro.length() - 3);
		}

		q.setFilter(filtro);

		@SuppressWarnings("unchecked")
		final List<Religioso> results = (List<Religioso>) q.execute();

		return results;
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Religioso")
	public Religioso newReligioso(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Descripción") String descripcion,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @ParameterLayout(named = "Tipo") String tipo, final @ParameterLayout(named = "Epoca") String epoca,
			final @ParameterLayout(named = "Visitable") Boolean visitable,
			final @ParameterLayout(named = "Conservación") String estado,
			final @ParameterLayout(named = "Estilo") String estilo,
			final @ParameterLayout(named = "Localización") String location) {
		final Religioso obj = this.container.newTransientInstance(Religioso.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setDireccion(direccion);
		obj.setAccesibilidad(accesibilidad);
		obj.setTipo(tipo);
		obj.setEpoca(epoca);
		obj.setVisitable(visitable);
		obj.setEstado(estado);
		obj.setEstilo(estilo);
		obj.setLocation(this.locationLookupService.lookup(location));
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Religioso")
	public void removeReligioso(final @ParameterLayout(named = "Objeto") Religioso objeto) {
		this.container.remove(objeto);
	}

	// endregion

}
