package dom.service.evento;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotInServiceMenu;

import dom.model.evento.Evento;

@DomainService(menuOrder = "10", repositoryFor = Evento.class)
public class Eventos {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<Evento> listar() {
		return this.container.allInstances(Evento.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public Evento crear(final @Named("Nombre") String nombre, final @Named("Descripción") String descripcion,
			final @Named("Fecha Inicio") Date fechaInicio, final @Named("Fecha Fin") Date fechaFin) {
		final Evento obj = this.container.newTransientInstance(Evento.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setFechaInicio(fechaInicio);
		obj.setFechaFin(fechaFin);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") Evento objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
