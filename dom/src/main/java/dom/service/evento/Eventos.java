package dom.service.evento;

import java.util.Date;
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

import dom.model.evento.Evento;
import dom.model.puntointeres.PuntoInteres;

@DomainServiceLayout(named = "Eventos", menuOrder = "10")
@DomainService(nature = NatureOfService.VIEW_MENU_ONLY, repositoryFor = Evento.class)
public class Eventos {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Eventos")
	public List<Evento> listar() {
		return this.container.allInstances(Evento.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Evento")
	public Evento newEvento(final @ParameterLayout(named = "Punto Interes") PuntoInteres poi,
			final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Descripción") String descripcion,
			final @ParameterLayout(named = "Fecha Inicio") Date fechaInicio,
			final @ParameterLayout(named = "Fecha Fin") Date fechaFin) {
		final Evento obj = this.container.newTransientInstance(Evento.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setFechaInicio(fechaInicio);
		obj.setFechaFin(fechaFin);
		obj.setPuntoInteres(poi);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Evento")
	public void removeEvento(final @ParameterLayout(named = "Objeto") Evento objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
