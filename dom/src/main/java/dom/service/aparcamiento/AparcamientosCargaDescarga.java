/**
 * 
 */
package dom.service.aparcamiento;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotInServiceMenu;

import dom.model.aparcamiento.AparcamientoCargaDescarga;

/**
 * @author fran
 * 
 */
@DomainService(menuOrder = "10", repositoryFor = AparcamientoCargaDescarga.class)
public class AparcamientosCargaDescarga {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<AparcamientoCargaDescarga> listar() {
		return this.container.allInstances(AparcamientoCargaDescarga.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public AparcamientoCargaDescarga crear(final @Named("Nombre") String nombre,
			final @Named("Dirección") String direccion, final @Named("Gratuito") boolean gratuito) {
		final AparcamientoCargaDescarga obj = this.container.newTransientInstance(AparcamientoCargaDescarga.class);
		obj.setNombre(nombre);
		obj.setDireccion(direccion);
		obj.setGratis(gratuito);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") AparcamientoCargaDescarga objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
