/**
 * 
 */
package dom.service.sociable;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotInServiceMenu;

import dom.model.sociable.ClaseSociable;
import dom.model.sociable.Comentario;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */
@DomainService(menuOrder = "10", repositoryFor = Comentario.class)
public class Comentarios {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<Comentario> listar() {
		return this.container.allInstances(Comentario.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public Comentario crear(final @Named("Usuario") Usuario usuario,
			final @Named("Objecto a comentar") ClaseSociable clase, final @Named("Comentario") String texto) {
		final Comentario obj = this.container.newTransientInstance(Comentario.class);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		obj.setTexto(texto);
		obj.setClaseSociable(clase);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") Comentario objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
