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

import dom.model.sociable.ClaseSociable;
import dom.model.sociable.Comentario;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */
@DomainServiceLayout(named = "Acciones", menuOrder = "10")
@DomainService(repositoryFor = Comentario.class)
public class Comentarios {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Comentarios")
	public List<Comentario> listar() {
		return this.container.allInstances(Comentario.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Comentario")
	public Comentario newComentario(final @ParameterLayout(named = "Usuario") Usuario usuario,
			final @ParameterLayout(named = "Objecto a comentar") ClaseSociable clase,
			final @ParameterLayout(named = "Comentario") String texto) {
		final Comentario obj = this.container.newTransientInstance(Comentario.class);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		obj.setTexto(texto);
		obj.setClaseSociable(clase);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Comentario")
	public void removeComentario(final @ParameterLayout(named = "Objeto") Comentario objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
