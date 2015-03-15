/**
 * 
 */
package dom.service.aparcamiento;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import dom.model.aparcamiento.AparcamientoTicket;

/**
 * @author fran
 * 
 */
@DomainServiceLayout(named = "Aparcamientos", menuOrder = "10")
@DomainService(repositoryFor = AparcamientoTicket.class)
public class AparcamientosTicket {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Aparcamiento Ticket")
	public List<AparcamientoTicket> listar() {
		return this.container.allInstances(AparcamientoTicket.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Aparcamiento Ticket")
	public AparcamientoTicket newAparcamientoTicket(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Precio hora") float precioHora,
			final @ParameterLayout(named = "Cuota") float cuota,
			final @ParameterLayout(named = "Gratuito") boolean gratuito) {
		final AparcamientoTicket obj = this.container.newTransientInstance(AparcamientoTicket.class);
		obj.setNombre(nombre);
		obj.setDireccion(direccion);
		obj.setPrecioHora(precioHora);
		obj.setCuota(cuota);
		obj.setGratis(gratuito);

		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Aparcamiento Ticket")
	public void removeAparcamientoTicket(final @ParameterLayout(named = "Objeto") AparcamientoTicket objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
