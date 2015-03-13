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
import dom.model.sociable.Favorito;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */
@DomainService(menuOrder = "10", repositoryFor = Favorito.class)
public class Favoritos {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	public List<Favorito> listar() {
		return this.container.allInstances(Favorito.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(name = "listaFavoritos", sequence = "2")
	public Favorito crear(
			final @ParameterLayout(named = "Alias") String alias,
			final @ParameterLayout(named = "Usuario") Usuario usuario,
			final @ParameterLayout(named = "Objeto favorito") ClaseSociable claseSociable) {
		final Favorito obj = this.container
				.newTransientInstance(Favorito.class);
		obj.setAlias(alias);
		obj.setClaseSociable(claseSociable);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	// @NotInServiceMenu
	public void borrar(final @ParameterLayout(named = "Objeto") Favorito objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
