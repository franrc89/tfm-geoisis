package dom.service.puntointeres.cultural;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import dom.model.puntointeres.cultural.Playa;

@DomainServiceLayout(named = "POIs Civiles", menuOrder = "10")
@DomainService(repositoryFor = Playa.class)
public class Playas {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Playas")
	public List<Playa> listar() {
		return this.container.allInstances(Playa.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nueva Playa")
	public Playa newPlaya(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Descripción") String descripcion,
			final @ParameterLayout(named = "Cuidad") String ciudad,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @ParameterLayout(named = "Tipo") String tipo, final @ParameterLayout(named = "Epoca") String epoca,
			final @ParameterLayout(named = "Protegido") String protegido,
			final @ParameterLayout(named = "Longitud") Float longitud,
			final @ParameterLayout(named = "Ocupación") String ocupacion,
			final @ParameterLayout(named = "Bandera Azul") String bazul,
			final @ParameterLayout(named = "Parking") String parking,
			final @ParameterLayout(named = "Socorrismo") String socorrismo) {
		final Playa obj = this.container.newTransientInstance(Playa.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setCiudad(ciudad);
		obj.setDireccion(direccion);
		obj.setAccesibilidad(accesibilidad);
		obj.setTipo(tipo);
		obj.setLongitud(longitud);
		obj.setOcupacion(ocupacion);
		obj.setBazul(bazul);
		obj.setParking(parking);
		obj.setSocorrismo(socorrismo);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Playa")
	public void removePlaya(final @ParameterLayout(named = "Objeto") Playa objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
