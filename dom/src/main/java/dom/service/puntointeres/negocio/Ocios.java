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

import dom.model.puntointeres.negocio.Ocio;

@DomainServiceLayout(named = "POIs Negocios", menuOrder = "10")
@DomainService(repositoryFor = Ocio.class)
public class Ocios {

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
	@ActionLayout(named = "Listar Locales Ocio")
	public List<Ocio> listar() {
		return this.container.allInstances(Ocio.class);
	}

	// endregion

	// region > find (action)
	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Buscar Locales Ocio")
	public List<Ocio> find(
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Nombre") String nombre,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Descripcion") String descripcion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Direccion") String direccion,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Mail") String mail,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Web") String web,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Telefono") String telefono,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Tipo") String tipo,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Precio") String precio,
			final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named = "Location") String location) {

		final javax.jdo.PersistenceManager pm = this.isisJdoSupport.getJdoPersistenceManager();
		final Query q = pm.newQuery(Ocio.class);

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
			sb.append("tipo.matches(\".*" + tipo + ".*\")");
		}
		if (precio != null && precio != "") {
			sb.append("precio.matches(\".*" + precio + ".*\")");
		}

		String filtro = sb.toString();
		if (filtro.endsWith("&&")) {
			filtro = filtro.substring(0, filtro.length() - 3);
		}

		q.setFilter(filtro);

		@SuppressWarnings("unchecked")
		final List<Ocio> results = (List<Ocio>) q.execute();

		return results;
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Local Ocio")
	public Ocio newOcio(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Descripción") String descripcion,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @ParameterLayout(named = "Correo Electrónico") String mail,
			final @ParameterLayout(named = "Página web") String web,
			final @ParameterLayout(named = "Teléfono") String telefono,
			final @ParameterLayout(named = "Tipo") String tipo, final @ParameterLayout(named = "Precio") String precio,
			final @ParameterLayout(named = "Localización") String location) {
		final Ocio obj = this.container.newTransientInstance(Ocio.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setDireccion(direccion);
		obj.setAccesibilidad(accesibilidad);
		obj.setMail(mail);
		obj.setWeb(web);
		obj.setTelefono(telefono);
		obj.setTipo(tipo);
		obj.setPrecio(precio);
		obj.setLocation(this.locationLookupService.lookup(location));
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Local Ocio")
	public void removeOcio(final @ParameterLayout(named = "Objeto") Ocio objeto) {
		this.container.remove(objeto);
	}

	// endregion

}
