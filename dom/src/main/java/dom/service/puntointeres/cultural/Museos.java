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

import dom.model.puntointeres.cultural.Museo;

@DomainServiceLayout(named = "POIs Civiles", menuOrder = "10")
@DomainService(repositoryFor = Museo.class)
public class Museos {

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
	@ActionLayout(named = "Listar Museos")
	public List<Museo> listar() {
		return this.container.allInstances(Museo.class);
	}

	// endregion

	// region > find (action)
	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Buscar Museos")
	public List<Museo> find(
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Nombre") String nombre,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Descripcion") String descripcion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Direccion") String direccion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Tipo") String tipo,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Epoca") String epoca,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Visitable") Boolean visitable,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Estado") String estado,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Contenido") String contenido,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Location") String location) {

		final javax.jdo.PersistenceManager pm = this.isisJdoSupport.getJdoPersistenceManager();
		final Query q = pm.newQuery(Museo.class);

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
		if (contenido != null && contenido != "") {
			sb.append("contenido.matches(\".*" + contenido + ".*\")");
		}

		String filtro = sb.toString();
		if (filtro.endsWith("&&")) {
			filtro = filtro.substring(0, filtro.length() - 3);
		}

		q.setFilter(filtro);

		@SuppressWarnings("unchecked")
		final List<Museo> results = (List<Museo>) q.execute();

		return results;
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Museo")
	public Museo newMuseo(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Descripción") String descripcion,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @ParameterLayout(named = "Tipo") String tipo, final @ParameterLayout(named = "Epoca") String epoca,
			final @ParameterLayout(named = "Visitable") Boolean visitable,
			final @ParameterLayout(named = "Conservación") String estado,
			final @ParameterLayout(named = "Estilo") String contenido,
			final @ParameterLayout(named = "Localización") String location) {
		final Museo obj = this.container.newTransientInstance(Museo.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setDireccion(direccion);
		obj.setAccesibilidad(accesibilidad);
		obj.setTipo(tipo);
		obj.setEpoca(epoca);
		obj.setVisitable(visitable);
		obj.setEstado(estado);
		obj.setContenido(contenido);
		obj.setLocation(this.locationLookupService.lookup(location));
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Museo")
	public void removeMuseo(final @ParameterLayout(named = "Objeto") Museo objeto) {
		this.container.remove(objeto);
	}

	// endregion

}
