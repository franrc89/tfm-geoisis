/**
 * 
 */
package dom.service.sociable;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import dom.model.sociable.ClaseSociable;
import dom.model.sociable.Valoracion;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */
@DomainService(menuOrder = "10", repositoryFor = Valoracion.class)
public class Valoraciones {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	public List<Valoracion> listar() {
		return this.container.allInstances(Valoracion.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(name = "listaValoraciones", sequence = "2")
	public Valoracion crear(
			final @ParameterLayout(named = "Objecto a valorar") ClaseSociable claseSociable,
			final @ParameterLayout(named = "Usuario") Usuario usuario,
			final @ParameterLayout(named = "Valoración") String puntuacion) {
		final Valoracion obj = this.container
				.newTransientInstance(Valoracion.class);
		obj.setClaseSociable(claseSociable);
		obj.setPuntuacion(puntuacion);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	// @NotInServiceMenu
	public void borrar(
			final @ParameterLayout(named = "Objeto") Valoracion objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
