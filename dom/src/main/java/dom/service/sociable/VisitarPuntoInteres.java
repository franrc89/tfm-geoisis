/**
 * 
 */
package dom.service.sociable;

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

import dom.model.puntointeres.PuntoInteres;
import dom.model.sociable.PuntoInteresVisitado;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */
@DomainServiceLayout(named = "Acciones", menuOrder = "10")
@DomainService(nature = NatureOfService.VIEW_MENU_ONLY, repositoryFor = PuntoInteresVisitado.class)
public class VisitarPuntoInteres {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Punto Interés Visitado")
	public List<PuntoInteresVisitado> listar() {
		return this.container.allInstances(PuntoInteresVisitado.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Punto Interés Visitado")
	public PuntoInteresVisitado newPuntoInteresVisitado(
			final @ParameterLayout(named = "Punto Interes") PuntoInteres puntoInteres,
			final @ParameterLayout(named = "Usuario") Usuario usuario) {
		final PuntoInteresVisitado obj = this.container.newTransientInstance(PuntoInteresVisitado.class);
		obj.setPuntoInteres(puntoInteres);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Punto Interés Visitado")
	public void removePuntoInteresVisitado(final @ParameterLayout(named = "Objeto") PuntoInteresVisitado objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
