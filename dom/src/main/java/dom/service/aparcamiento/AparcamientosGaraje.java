/**
 * 
 */
package dom.service.aparcamiento;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import dom.model.aparcamiento.AparcamientoGaraje;

/**
 * @author fran
 * 
 */
@DomainService(menuOrder = "10", repositoryFor = AparcamientoGaraje.class)
public class AparcamientosGaraje {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	public List<AparcamientoGaraje> listar() {
		return this.container.allInstances(AparcamientoGaraje.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public AparcamientoGaraje crear(
			final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Cuota") float cuota,
			final @ParameterLayout(named = "Horas abierto") float horasAbierto,
			final @ParameterLayout(named = "Plazas totales") Integer plazasTotales,
			final @ParameterLayout(named = "Plazas disponibles") Integer plazasDisponibles,
			final @ParameterLayout(named = "Plazas NO disponibles") Integer plazasNoDisponibles,
			final @ParameterLayout(named = "Vigilancia") boolean vigilancia) {
		final AparcamientoGaraje obj = this.container
				.newTransientInstance(AparcamientoGaraje.class);
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
	// @NotInServiceMenu
	public void borrar(
			final @ParameterLayout(named = "Objeto") AparcamientoGaraje objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
