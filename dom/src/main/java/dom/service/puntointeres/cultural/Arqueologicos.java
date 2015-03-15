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

import dom.model.puntointeres.cultural.Arqueologico;

@DomainServiceLayout(named = "POIs Civiles", menuOrder = "10")
@DomainService(repositoryFor = Arqueologico.class)
public class Arqueologicos {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Arqueológicos")
	public List<Arqueologico> listar() {
		return this.container.allInstances(Arqueologico.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Arqueológico")
	public Arqueologico newArqueologico(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Descripción") String descripcion,
			final @ParameterLayout(named = "Cuidad") String ciudad,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @ParameterLayout(named = "Estilo") String estilo) {
		final Arqueologico obj = this.container.newTransientInstance(Arqueologico.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setCiudad(ciudad);
		obj.setDireccion(direccion);
		obj.setAccesibilidad(accesibilidad);
		obj.setEstilo(estilo);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Arqueológico")
	public void removeArqueologico(final @ParameterLayout(named = "Objeto") Arqueologico objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
