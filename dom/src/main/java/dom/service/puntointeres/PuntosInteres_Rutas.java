package dom.service.puntointeres;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotInServiceMenu;

import dom.model.puntointeres.PuntoInteres_Ruta;

@DomainService(menuOrder = "10", repositoryFor = PuntoInteres_Ruta.class)
public class PuntosInteres_Rutas {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<PuntoInteres_Ruta> listar() {
		return this.container.allInstances(PuntoInteres_Ruta.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public PuntoInteres_Ruta crear(final @Named("Orden") Integer orden) {
		final PuntoInteres_Ruta obj = this.container.newTransientInstance(PuntoInteres_Ruta.class);
		obj.setOrden(orden);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") PuntoInteres_Ruta objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
