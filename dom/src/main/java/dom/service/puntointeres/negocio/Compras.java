package dom.service.puntointeres.negocio;

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

import dom.model.puntointeres.negocio.Compra;

@DomainServiceLayout(named = "POIs Negocios", menuOrder = "10")
@DomainService(repositoryFor = Compra.class)
public class Compras {

	// region > listAll (action)

	@Action(semantics = SemanticsOf.SAFE)
	@MemberOrder(sequence = "1")
	@ActionLayout(named = "Listar Establecimientos")
	public List<Compra> listar() {
		return this.container.allInstances(Compra.class);
	}

	// endregion

	// region > create (action)
	@MemberOrder(sequence = "2")
	@ActionLayout(named = "Nuevo Establecimiento")
	public Compra newCompra(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Descripción") String descripcion,
			final @ParameterLayout(named = "Dirección") String direccion,
			final @ParameterLayout(named = "Accesibilidad") String accesibilidad,
			final @ParameterLayout(named = "Correo Electrónico") String mail,
			final @ParameterLayout(named = "Página web") String web,
			final @ParameterLayout(named = "Teléfono") String telefono,
			final @ParameterLayout(named = "Tipo") String tipo, final @ParameterLayout(named = "Precio") String precio,
			final @ParameterLayout(named = "Localización") String location) {
		final Compra obj = this.container.newTransientInstance(Compra.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setDireccion(direccion);
		obj.setAccesibilidad(accesibilidad);
		obj.setMail(mail);
		obj.setWeb(web);
		obj.setTelefono(telefono);
		obj.setTipo(tipo);
		obj.setPrecio(precio);
		obj.setLocation(this.locationLookupService.lookup(location));
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(sequence = "3")
	@ActionLayout(named = "Borrar Establecimiento")
	public void removeCompra(final @ParameterLayout(named = "Objeto") Compra objeto) {
		this.container.remove(objeto);
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	LocationLookupService locationLookupService = new LocationLookupService();

	// endregion

}
