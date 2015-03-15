package dom.service.puntointeres.cultural;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import dom.model.puntointeres.cultural.Popular;

@DomainServiceLayout(named = "POIs Civiles", menuOrder = "10")
@DomainService(repositoryFor = Popular.class)
public class Populares {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Populares")
	public List<Popular> listar() {
		return this.container.allInstances(Popular.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Popular")
	public Popular newPopular(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Descripción") String descripcion,
			final @ParameterLayout(named = "Cuidad") String ciudad,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @ParameterLayout(named = "Tipo") String tipo, final @ParameterLayout(named = "Estilo") String estilo) {
		final Popular obj = this.container.newTransientInstance(Popular.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setCiudad(ciudad);
		obj.setDireccion(direccion);
		obj.setAccesibilidad(accesibilidad);
		obj.setTipo(tipo);
		obj.setEstilo(estilo);

		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Popular")
	public void removePopular(final @ParameterLayout(named = "Objeto") Popular objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
