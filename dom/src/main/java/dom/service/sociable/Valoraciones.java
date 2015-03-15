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

import dom.model.sociable.ClaseSociable;
import dom.model.sociable.Valoracion;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */
@DomainServiceLayout(named = "Acciones", menuOrder = "10")
@DomainService(nature = NatureOfService.VIEW_MENU_ONLY, repositoryFor = Valoracion.class)
public class Valoraciones {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Valoraciones")
	public List<Valoracion> listar() {
		return this.container.allInstances(Valoracion.class);
	}

	// endregion

	// region > create (action)
	// @MemberOrder(name = "listaValoraciones", sequence = "2")
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nueva Valoración")
	public Valoracion newValoracion(final @ParameterLayout(named = "Objecto a valorar") ClaseSociable claseSociable,
			final @ParameterLayout(named = "Usuario") Usuario usuario,
			final @ParameterLayout(named = "Valoración") String puntuacion) {
		final Valoracion obj = this.container.newTransientInstance(Valoracion.class);
		obj.setClaseSociable(claseSociable);
		obj.setPuntuacion(puntuacion);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Valoración")
	public void removeValoracion(final @ParameterLayout(named = "Objeto") Valoracion objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
