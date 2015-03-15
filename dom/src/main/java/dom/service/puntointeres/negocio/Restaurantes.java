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

import dom.model.puntointeres.negocio.Restaurante;

@DomainServiceLayout(named = "POIs Negocios", menuOrder = "10")
@DomainService(repositoryFor = Restaurante.class)
public class Restaurantes {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Restaurantes")
	public List<Restaurante> listar() {
		return this.container.allInstances(Restaurante.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Restaurante")
	public Restaurante newRestaurante(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Descripción") String descripcion,
			final @ParameterLayout(named = "Cuidad") String ciudad,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @ParameterLayout(named = "Clasificación") String clasificacion) {
		final Restaurante obj = this.container.newTransientInstance(Restaurante.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setCiudad(ciudad);
		obj.setDireccion(direccion);
		obj.setAccesibilidad(accesibilidad);
		obj.setClasificacion(clasificacion);
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

	// endregion

}