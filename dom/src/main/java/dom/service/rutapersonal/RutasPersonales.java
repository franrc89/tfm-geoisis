package dom.service.rutapersonal;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotInServiceMenu;

import dom.model.rutapersonal.RutaPersonal;
import dom.model.usuario.Usuario;

@DomainService(menuOrder = "10", repositoryFor = RutaPersonal.class)
public class RutasPersonales {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(name = "listaRutaPersonal", sequence = "1")
	public List<RutaPersonal> listar() {
		return this.container.allInstances(RutaPersonal.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(name = "listaRutaPersonal", sequence = "2")
	public RutaPersonal crear(final @Named("Nombre") String nombre, final @Named("Duración") String duracion,
			final @Named("Usuario") Usuario usuario) {
		final RutaPersonal obj = this.container.newTransientInstance(RutaPersonal.class);
		obj.setNombre(nombre);
		obj.setDuracion(duracion);
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") RutaPersonal objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
