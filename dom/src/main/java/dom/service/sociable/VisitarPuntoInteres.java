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

import dom.model.puntointeres.PuntoInteres;
import dom.model.sociable.PuntoInteresVisitado;
import dom.model.usuario.Usuario;

/**
 * @author fran
 * 
 */
@DomainService(menuOrder = "10", repositoryFor = PuntoInteresVisitado.class)
public class VisitarPuntoInteres {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<PuntoInteresVisitado> listar() {
		return this.container.allInstances(PuntoInteresVisitado.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(name = "listaPuntosInteresVisitados", sequence = "2")
	public PuntoInteresVisitado crear(final @Named("Punto Interes") PuntoInteres puntoInteres,
			final @Named("Usuario") Usuario usuario) {
		final PuntoInteresVisitado obj = this.container.newTransientInstance(PuntoInteresVisitado.class);
		obj.setPuntoInteres(puntoInteres);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") PuntoInteresVisitado objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
