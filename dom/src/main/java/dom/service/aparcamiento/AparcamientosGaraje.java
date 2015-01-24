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

import dom.model.aparcamiento.AparcamientoGaraje;

/**
 * @author fran
 * 
 */
@DomainService(menuOrder = "10", repositoryFor = AparcamientoGaraje.class)
public class AparcamientosGaraje {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<AparcamientoGaraje> listar() {
		return this.container.allInstances(AparcamientoGaraje.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public AparcamientoGaraje crear(final @Named("Nombre") String nombre, final @Named("Dirección") String direccion,
			final @Named("Cuota") float cuota, final @Named("Horas abierto") float horasAbierto,
			final @Named("Plazas totales") Integer plazasTotales,
			final @Named("Plazas disponibles") Integer plazasDisponibles,
			final @Named("Plazas NO disponibles") Integer plazasNoDisponibles,
			final @Named("Vigilancia") boolean vigilancia) {
		final AparcamientoGaraje obj = this.container.newTransientInstance(AparcamientoGaraje.class);
		obj.setNombre(nombre);
		obj.setDireccion(direccion);
		obj.setCuota(cuota);
		obj.setHorasAbierto(horasAbierto);
		obj.setPlazasTotales(plazasTotales);
		obj.setPlazasDisponibles(plazasDisponibles);
		obj.setPlazasNoDisponibles(plazasNoDisponibles);
		obj.setVigilancia(vigilancia);

		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") AparcamientoGaraje objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
