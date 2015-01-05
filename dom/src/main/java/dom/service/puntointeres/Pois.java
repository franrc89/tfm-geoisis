package dom.service.puntointeres;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotInServiceMenu;

import dom.model.puntointeres.Poi;

@DomainService(menuOrder = "10", repositoryFor = Poi.class)
public class Pois {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<Poi> listar() {
		return this.container.allInstances(Poi.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public Poi crear(final @Named("Nombre") String nombre, final @Named("Ciudad") String ciudad) {
		final Poi obj = this.container.newTransientInstance(Poi.class);
		obj.setNombre(nombre);
		obj.setCiudad(ciudad);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") Poi objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
