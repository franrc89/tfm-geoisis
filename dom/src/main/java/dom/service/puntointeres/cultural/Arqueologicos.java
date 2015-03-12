package dom.service.puntointeres.cultural;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotInServiceMenu;

import dom.model.puntointeres.cultural.Arqueologico;

@DomainService(menuOrder = "10", repositoryFor = Arqueologico.class)
public class Arqueologicos {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<Arqueologico> listar() {
		return this.container.allInstances(Arqueologico.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public Arqueologico crear(final @Named("Nombre") String nombre, final @Named("Descripción") String descripcion,
			final @Named("Cuidad") String ciudad, final @Named("Dirección") String direccion,
			final @Named("Accesibilidad") String accesibilidad, final @Named("Estilo") String estilo) {
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

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") Arqueologico objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
