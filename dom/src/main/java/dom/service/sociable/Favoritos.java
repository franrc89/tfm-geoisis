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
import dom.model.sociable.Favorito;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */
@DomainServiceLayout(named = "Acciones", menuOrder = "10")
@DomainService(nature = NatureOfService.VIEW_MENU_ONLY, repositoryFor = Favorito.class)
public class Favoritos {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Favoritos")
	public List<Favorito> listar() {
		return this.container.allInstances(Favorito.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Favorito")
	public Favorito newFavorito(final @ParameterLayout(named = "Alias") String alias,
			final @ParameterLayout(named = "Usuario") Usuario usuario,
			final @ParameterLayout(named = "Objeto favorito") ClaseSociable claseSociable) {
		final Favorito obj = this.container.newTransientInstance(Favorito.class);
		obj.setAlias(alias);
		obj.setClaseSociable(claseSociable);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Favorito")
	public void removeFavorito(final @ParameterLayout(named = "Objeto") Favorito objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
