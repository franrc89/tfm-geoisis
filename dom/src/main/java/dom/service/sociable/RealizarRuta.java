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
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import dom.model.ruta.Ruta;
import dom.model.sociable.RutaRealizada;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */
@DomainServiceLayout(named = "Acciones", menuOrder = "10")
@DomainService(repositoryFor = RutaRealizada.class)
public class RealizarRuta {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Rutas Realizadas")
	public List<RutaRealizada> listar() {
		return this.container.allInstances(RutaRealizada.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nueva Ruta Realizada")
	public RutaRealizada newRutaRealizada(final @ParameterLayout(named = "Ruta") Ruta ruta,
			final @ParameterLayout(named = "Usuario") Usuario usuario) {
		final RutaRealizada obj = this.container.newTransientInstance(RutaRealizada.class);
		obj.setRuta(ruta);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Ruta Realizada")
	public void removeRutaRealizada(final @ParameterLayout(named = "Objeto") RutaRealizada objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
