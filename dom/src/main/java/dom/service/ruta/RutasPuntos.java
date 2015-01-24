package dom.service.ruta;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotInServiceMenu;

import dom.model.puntointeres.PuntoInteres;
import dom.model.ruta.Ruta;
import dom.model.ruta.Ruta_PuntoInteres;

@DomainService(menuOrder = "10", repositoryFor = Ruta_PuntoInteres.class)
public class RutasPuntos {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<Ruta_PuntoInteres> listar() {
		return this.container.allInstances(Ruta_PuntoInteres.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public Ruta_PuntoInteres crear(final @Named("Orden") Integer orden, final @Named("Ruta") Ruta ruta,
			final @Named("PuntoInteres") PuntoInteres poi) {
		final Ruta_PuntoInteres obj = this.container.newTransientInstance(Ruta_PuntoInteres.class);
		obj.setOrden(orden);
		obj.setRuta(ruta);
		obj.setPuntoInteres(poi);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") Ruta_PuntoInteres objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
