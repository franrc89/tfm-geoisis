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

import dom.model.rutapersonal.RutaPersonal;
import dom.model.sociable.RutaPersonalRealizada;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */
@DomainService(menuOrder = "10", repositoryFor = RutaPersonalRealizada.class)
public class RealizarRutaPersonal {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	public List<RutaPersonalRealizada> listar() {
		return this.container.allInstances(RutaPersonalRealizada.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(name = "listaRutasPersonalesRealizadas", sequence = "2")
	public RutaPersonalRealizada crear(
			final @ParameterLayout(named = "Ruta Personal") RutaPersonal rutaPersonal,
			final @ParameterLayout(named = "Usuario") Usuario usuario) {
		final RutaPersonalRealizada obj = this.container
				.newTransientInstance(RutaPersonalRealizada.class);
		obj.setRutaPersonal(rutaPersonal);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	// @NotInServiceMenu
	public void borrar(
			final @ParameterLayout(named = "Objeto") RutaPersonalRealizada objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
