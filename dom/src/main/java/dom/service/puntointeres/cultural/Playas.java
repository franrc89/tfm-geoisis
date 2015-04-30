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
import org.isisaddons.wicket.gmap3.cpt.service.LocationLookupService;

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
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @ParameterLayout(named = "Tipo") String tipo, final @ParameterLayout(named = "Epoca") String epoca,
			final @ParameterLayout(named = "Visitable") Boolean visitable,
			final @ParameterLayout(named = "Conservación") String estado,
			final @ParameterLayout(named = "Longitud") Float longitud,
			final @ParameterLayout(named = "Ocupación") String ocupacion,
			final @ParameterLayout(named = "Bandera Azul") Boolean bazul,
			final @ParameterLayout(named = "Parking") Boolean parking,
			final @ParameterLayout(named = "Socorrismo") Boolean socorrismo,
			final @ParameterLayout(named = "Localización") String location) {
		final Playa obj = this.container.newTransientInstance(Playa.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setDireccion(direccion);
		obj.setAccesibilidad(accesibilidad);
		obj.setTipo(tipo);
		obj.setEpoca(epoca);
		obj.setVisitable(visitable);
		obj.setEstado(estado);
		obj.setLongitud(longitud);
		obj.setOcupacion(ocupacion);
		obj.setBazul(bazul);
		obj.setParking(parking);
		obj.setSocorrismo(socorrismo);
		obj.setLocation(this.locationLookupService.lookup(location));
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

	LocationLookupService locationLookupService = new LocationLookupService();

	// endregion

}
