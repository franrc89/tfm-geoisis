package dom.service.rutapersonal;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import dom.model.rutapersonal.RutaPersonal;
import dom.model.usuario.Usuario;

@DomainServiceLayout(named = "Rutas", menuOrder = "10")
@DomainService(repositoryFor = RutaPersonal.class)
public class RutasPersonales {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Rutas Personales")
	public List<RutaPersonal> listar() {
		return this.container.allInstances(RutaPersonal.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nueva Ruta Personal")
	public RutaPersonal newRutaPersonal(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Duración") String duracion,
			final @ParameterLayout(named = "Usuario") Usuario usuario) {
		final RutaPersonal obj = this.container.newTransientInstance(RutaPersonal.class);
		obj.setNombre(nombre);
		obj.setDuracion(duracion);
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Ruta Personal")
	public void removeRutaPersonal(final @ParameterLayout(named = "Objeto") RutaPersonal objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
