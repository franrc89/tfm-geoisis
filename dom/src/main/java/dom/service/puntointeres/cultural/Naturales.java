package dom.service.puntointeres.cultural;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.NotInServiceMenu;

import dom.model.puntointeres.cultural.Natural;

@DomainService(menuOrder = "10", repositoryFor = Natural.class)
public class Naturales {

	// region > listAll (action)

	@ActionSemantics(Of.SAFE)
	@MemberOrder(sequence = "1")
	public List<Natural> listar() {
		return this.container.allInstances(Natural.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	public Natural crear(final @Named("Nombre") String nombre, final @Named("Descripción") String descripcion,
			final @Named("Cuidad") String ciudad, final @Named("Dirección") String direccion,
			final @Named("Accesibilidad") String accesibilidad, final @Named("Tipo") String tipo,
			final @Named("Epoca") String epoca, final @Named("Protegido") String protegido) {
		final Natural obj = this.container.newTransientInstance(Natural.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setCiudad(ciudad);
		obj.setDireccion(direccion);
		obj.setAccesibilidad(accesibilidad);
		obj.setTipo(tipo);
		obj.setEpoca(epoca);
		obj.setProtegido(protegido);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// @MemberOrder(sequence = "3")
	@NotInServiceMenu
	public void borrar(final @Named("Objeto") Natural objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
