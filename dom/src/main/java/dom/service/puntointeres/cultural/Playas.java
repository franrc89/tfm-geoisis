package dom.service.puntointeres.cultural;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotInServiceMenu;

import dom.model.puntointeres.cultural.Playa;

@DomainService(menuOrder = "10", repositoryFor = Playa.class)
public class Playas {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<Playa> listar() {
		return this.container.allInstances(Playa.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public Playa crear(final @Named("Nombre") String nombre, final @Named("Descripción") String descripcion,
			final @Named("Cuidad") String ciudad, final @Named("Dirección") String direccion,
			final @Named("Accesibilidad") String accesibilidad, final @Named("Tipo") String tipo,
			final @Named("Epoca") String epoca, final @Named("Protegido") String protegido,
			final @Named("Longitud") Float longitud, final @Named("Ocupación") String ocupacion,
			final @Named("Bandera Azul") String bazul, final @Named("Parking") String parking,
			final @Named("Socorrismo") String socorrismo) {
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

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") Playa objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
