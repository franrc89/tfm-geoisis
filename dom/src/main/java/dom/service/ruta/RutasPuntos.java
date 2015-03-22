package dom.service.ruta;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import dom.model.puntointeres.PuntoInteres;
import dom.model.ruta.Ruta;
import dom.model.ruta.Ruta_PuntoInteres;

@DomainServiceLayout(named = "Rutas", menuOrder = "10")
@DomainService(nature = NatureOfService.VIEW_MENU_ONLY, repositoryFor = Ruta_PuntoInteres.class)
public class RutasPuntos {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Puntos en Ruta")
	public List<Ruta_PuntoInteres> listar() {
		return this.container.allInstances(Ruta_PuntoInteres.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Punto en Ruta")
	public Ruta_PuntoInteres newRuta_PuntoInteres(final @ParameterLayout(named = "Orden") Integer orden,
			final @ParameterLayout(named = "Ruta") Ruta ruta,
			final @ParameterLayout(named = "PuntoInteres") PuntoInteres poi) {
		final Ruta_PuntoInteres obj = this.container.newTransientInstance(Ruta_PuntoInteres.class);
		obj.setOrden(orden);
		obj.setRuta(ruta);
		obj.setLocation(poi.getLocation());
		obj.setPuntoInteres(poi);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Punto en Ruta")
	public void removeRuta_PuntoInteres(final @ParameterLayout(named = "Objeto") Ruta_PuntoInteres objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
