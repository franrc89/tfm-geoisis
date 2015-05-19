package dom.service.puntointeres.negocio;

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

import dom.model.puntointeres.negocio.Restaurante;

@DomainServiceLayout(named = "POIs Negocios", menuOrder = "10")
@DomainService(repositoryFor = Restaurante.class)
public class Restaurantes {

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
	@ActionLayout(named = "Listar Restaurantes")
	public List<Restaurante> listar() {
		return this.container.allInstances(Restaurante.class);
	}

	// endregion

	// region > find (action)
	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Buscar Restaurantes")
	public List<Restaurante> find(
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Nombre") String nombre,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Descripcion") String descripcion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Direccion") String direccion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Mail") String mail,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Web") String web,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Telefono") String telefono,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Tipo") String tipo,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Clasificacion") String clasificacion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Location") String location) {

		final javax.jdo.PersistenceManager pm = this.isisJdoSupport.getJdoPersistenceManager();
		final Query q = pm.newQuery(Restaurante.class);

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
		if (mail != null && mail != "") {
			sb.append("mail.matches(\".*" + mail + ".*\") &&");
		}
		if (web != null && web != "") {
			sb.append("web.matches(\".*" + web + ".*\") &&");
		}
		if (telefono != null && telefono != "") {
			sb.append("telefono.matches(\".*" + telefono + ".*\") &&");
		}
		if (tipo != null && tipo != "") {
			sb.append("tipo.matches(\".*" + tipo + ".*\") &&");
		}
		if (clasificacion != null && clasificacion != "") {
			sb.append("clasificacion < " + clasificacion);
		}

		String filtro = sb.toString();
		if (filtro.endsWith("&&")) {
			filtro = filtro.substring(0, filtro.length() - 3);
		}

		q.setFilter(filtro);

		@SuppressWarnings("unchecked")
		final List<Restaurante> results = (List<Restaurante>) q.execute();

		return results;
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Restaurante")
	public Restaurante newRestaurante(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Descripción") String descripcion,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @ParameterLayout(named = "Correo Electrónico") String mail,
			final @ParameterLayout(named = "Página web") String web,
			final @ParameterLayout(named = "Teléfono") String telefono,
			final @ParameterLayout(named = "Tipo") String tipo,
			final @ParameterLayout(named = "Clasificación") Integer clasificacion,
			final @ParameterLayout(named = "Location") String location
	// final @ParameterLayout(named = "Latitud") Double latitud,
	// final @ParameterLayout(named = "Longitud") Double longitud
	) {
		final Restaurante obj = this.container.newTransientInstance(Restaurante.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setDireccion(direccion);
		obj.setAccesibilidad(accesibilidad);
		obj.setMail(mail);
		obj.setWeb(web);
		obj.setTelefono(telefono);
		obj.setTipo(tipo);
		obj.setClasificacion(clasificacion);
		// obj.setLocation(new Location(latitud, longitud));
		obj.setLocation(this.locationLookupService.lookup(location));
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// region > remove (action)
	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Restaurante")
	public void removeRestaurante(final @ParameterLayout(named = "Objeto") Restaurante objeto) {
		this.container.remove(objeto);
	}

	// endregion

}
