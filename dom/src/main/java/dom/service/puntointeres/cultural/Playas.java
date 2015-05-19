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

import dom.model.puntointeres.cultural.Playa;

@DomainServiceLayout(named = "POIs Civiles", menuOrder = "10")
@DomainService(repositoryFor = Playa.class)
public class Playas {

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
	@ActionLayout(named = "Listar Playas")
	public List<Playa> listar() {
		return this.container.allInstances(Playa.class);
	}

	// endregion

	// region > find (action)
	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Buscar Playas")
	public List<Playa> find(
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Nombre") String nombre,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Descripcion") String descripcion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Direccion") String direccion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Tipo") String tipo,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Epoca") String epoca,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Visitable") Boolean visitable,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Estado") String estado,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Longitud") String longitud,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Ocupacion") String ocupacion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Bazul") Boolean bazul,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Parking") Boolean parking,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Socorrismo") Boolean socorrismo,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Location") String location) {

		final javax.jdo.PersistenceManager pm = this.isisJdoSupport.getJdoPersistenceManager();
		final Query q = pm.newQuery(Playa.class);

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
		if (longitud != null && longitud != "") {
			sb.append("longitud <" + longitud + " &&");
		}
		if (ocupacion != null && ocupacion != "") {
			sb.append("ocupacion.matches(\".*" + ocupacion + ".*\") &&");
		}
		if (bazul != null) {
			sb.append("bazul == " + bazul + " &&");
		}
		if (parking != null) {
			sb.append("parking == " + parking + " &&");
		}
		if (socorrismo != null) {
			sb.append("socorrismo == " + socorrismo + " &&");
		}

		String filtro = sb.toString();
		if (filtro.endsWith("&&")) {
			filtro = filtro.substring(0, filtro.length() - 3);
		}

		q.setFilter(filtro);

		@SuppressWarnings("unchecked")
		final List<Playa> results = (List<Playa>) q.execute();

		return results;
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nueva Playa")
	public Playa newPlaya(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Descripción") String descripcion,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @ParameterLayout(named = "Tipo") String tipo, final @ParameterLayout(named = "Epoca") String epoca,
			final @ParameterLayout(named = "Visitable") Boolean visitable,
			final @ParameterLayout(named = "Conservación") String estado,
			final @ParameterLayout(named = "Longitud") Float longitud,
			final @ParameterLayout(named = "Ocupación") String ocupacion,
			final @ParameterLayout(named = "Bandera Azul") Boolean bazul,
			final @ParameterLayout(named = "Parking") Boolean parking,
			final @ParameterLayout(named = "Socorrismo") Boolean socorrismo,
			final @ParameterLayout(named = "Localización") String location) {
		final Playa obj = this.container.newTransientInstance(Playa.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setDireccion(direccion);
		obj.setAccesibilidad(accesibilidad);
		obj.setTipo(tipo);
		obj.setEpoca(epoca);
		obj.setVisitable(visitable);
		obj.setEstado(estado);
		obj.setLongitud(longitud);
		obj.setOcupacion(ocupacion);
		obj.setBazul(bazul);
		obj.setParking(parking);
		obj.setSocorrismo(socorrismo);
		obj.setLocation(this.locationLookupService.lookup(location));
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Playa")
	public void removePlaya(final @ParameterLayout(named = "Objeto") Playa objeto) {
		this.container.remove(objeto);
	}

	// endregion

}
