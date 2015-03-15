/**
 * 
 */
package dom.service.sociable;

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
import dom.model.sociable.Asistencia;
import dom.model.sociable.Intencion;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */
@DomainServiceLayout(named = "Acciones", menuOrder = "10")
@DomainService(nature = NatureOfService.VIEW_MENU_ONLY, repositoryFor = Asistencia.class)
public class Asistencias {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Asistencias")
	// @NotInServiceMenu
	public List<Asistencia> listar() {
		return this.container.allInstances(Asistencia.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nueva Asistencia")
	public Asistencia newAsistencia(final @ParameterLayout(named = "Usuario") Usuario usuario,
			final @ParameterLayout(named = "Evento") Evento evento,
			final @ParameterLayout(named = "Intención") Intencion intencion) {
		final Asistencia obj = this.container.newTransientInstance(Asistencia.class);
		obj.setEvento(evento);
		obj.setUsuario(usuario);
		obj.setIntencion(intencion);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Asistencia")
	public void removeAsistencia(final @ParameterLayout(named = "Objeto") Asistencia objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
