package dom.service.rutapersonal;

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
import dom.model.rutapersonal.RutaPersonal;
import dom.model.rutapersonal.RutaPersonal_PuntoInteres;

@DomainServiceLayout(named = "Rutas", menuOrder = "10")
@DomainService(nature = NatureOfService.VIEW_MENU_ONLY, repositoryFor = RutaPersonal_PuntoInteres.class)
public class RutasPersonalesPuntos {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Puntos en Ruta Personal")
	public List<RutaPersonal_PuntoInteres> listar() {
		return this.container.allInstances(RutaPersonal_PuntoInteres.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Punto en Ruta Personal")
	public RutaPersonal_PuntoInteres newRutaPersonal_PuntoInteres(
			final @ParameterLayout(named = "Orden") Integer orden,
			final @ParameterLayout(named = "Ruta Personal") RutaPersonal rutaPersonal,
			final @ParameterLayout(named = "PuntoInteres") PuntoInteres poi) {
		final RutaPersonal_PuntoInteres obj = this.container.newTransientInstance(RutaPersonal_PuntoInteres.class);
		obj.setOrden(orden);
		obj.setRutaPersonal(rutaPersonal);
		obj.setPuntoInteres(poi);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Punto en Ruta Personal")
	public void removeRutaPersonal_PuntoInteres(
			final @ParameterLayout(named = "Objeto") RutaPersonal_PuntoInteres objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
