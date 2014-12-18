package dom.service.ruta;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotInServiceMenu;

import dom.model.ruta.Ruta;

@DomainService(menuOrder = "10", repositoryFor = Ruta.class)
public class Rutas {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<Ruta> listar() {
		return this.container.allInstances(Ruta.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public Ruta crear(final @Named("Nombre") String nombre, final @Named("Duración") String duracion) {
		final Ruta obj = this.container.newTransientInstance(Ruta.class);
		obj.setNombre(nombre);
		obj.setDuracion(duracion);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") Ruta objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
