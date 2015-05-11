package dom.service.puntointeres.negocio;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.query.QueryDefault;
import org.isisaddons.wicket.gmap3.cpt.service.LocationLookupService;

import dom.model.puntointeres.negocio.Restaurante;

@DomainServiceLayout(named = "POIs Negocios", menuOrder = "10")
@DomainService(repositoryFor = Restaurante.class)
public class Restaurantes {

	// region > listAll (action)
	// @javax.inject.Inject
	// private IsisJdoSupport isisJdoSupport;

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Restaurantes")
	public List<Restaurante> listar() {
		return this.container.allInstances(Restaurante.class);
	}

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Buscar Restaurantes")
	public List<Restaurante> buscarBAK(final @ParameterLayout(named = "Nombre") String nombre) {

		final QueryDefault<Restaurante> query = QueryDefault.create(Restaurante.class, "buscarRestaurantes", "nombre",
				nombre);

		return this.container.allMatches(query);
	}

	// @Action(semantics = SemanticsOf.SAFE)
	// @MemberOrder(sequence = "1")
	// @ActionLayout(named = "Buscar Restaurantes")
	// public List<Restaurante> buscar(final @ParameterLayout(named = "Texto")
	// String texto) {
	// return this.container.allMatches(Restaurante.class, texto);
	// }

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

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Restaurante")
	public void removeRestaurante(final @ParameterLayout(named = "Objeto") Restaurante objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	LocationLookupService locationLookupService = new LocationLookupService();

	// endregion

}
