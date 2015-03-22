package dom.model.rutapersonal;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.RenderType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import dom.model.sociable.RutaPersonalRealizada;
import dom.model.usuario.Usuario;

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@DomainObject(bounded = true, objectType = "RutaPersonal")
@DomainObjectLayout
public class RutaPersonal implements Comparable<RutaPersonal> {

	private String nombre;
	private String duracion;
	private Usuario usuario;
	private SortedSet<RutaPersonal_PuntoInteres> puntosInteresRutaPersonal = new TreeSet<RutaPersonal_PuntoInteres>();
	private SortedSet<RutaPersonalRealizada> rutasPersonalesRealizadas = new TreeSet<RutaPersonalRealizada>();

	/**
	 * Devuelve el valor de la propiedad 'nombre'
	 * 
	 * @return Propiedad nombre
	 */
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	@javax.jdo.annotations.Column(allowsNull = "false")
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Asigna el valor de la propiedad 'nombre'
	 * 
	 * @param nombre valor que se le quiere dar a la propiedad 'nombre'
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el valor de la propiedad 'duracion'
	 * 
	 * @return Propiedad duracion
	 */
	@MemberOrder(sequence = "2")
	@javax.jdo.annotations.Column(allowsNull = "false")
	public String getDuracion() {
		return this.duracion;
	}

	/**
	 * Asigna el valor de la propiedad 'duracion'
	 * 
	 * @param duracion valor que se le quiere dar a la propiedad 'duracion'
	 */
	public void setDuracion(final String duracion) {
		this.duracion = duracion;
	}

	/**
	 * Devuelve el valor de la propiedad 'usuario'
	 * 
	 * @return Propiedad usuario
	 */
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Column(allowsNull = "false")
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * Asigna el valor de la propiedad 'usuario'
	 * 
	 * @param usuario valor que se le quiere dar a la propiedad 'usuario'
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaPuntoInteres'
	 * 
	 * @return Propiedad listaPuntoInteres
	 */
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Persistent(name = "rutapersonal_id", mappedBy = "rutaPersonal", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<RutaPersonal_PuntoInteres> getPuntosInteresRutaPersonal() {
		return this.puntosInteresRutaPersonal;
	}

	/**
	 * Asigna el valor de la propiedad 'listaPuntoInteres'
	 * 
	 * @param listaPuntoInteres valor que se le quiere dar a la propiedad
	 *            'listaPuntoInteres'
	 */
	public void setPuntosInteresRutaPersonal(final SortedSet<RutaPersonal_PuntoInteres> puntosInteresRutaPersonal) {
		this.puntosInteresRutaPersonal = puntosInteresRutaPersonal;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaRutasPersonalesCompletadas'
	 * 
	 * @return Propiedad listaRutasPersonalesCompletadas
	 */
	@MemberOrder(sequence = "4")
	@javax.jdo.annotations.Persistent(name = "rutapersonal_id", mappedBy = "rutaPersonal", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<RutaPersonalRealizada> getRutasPersonalesRealizadas() {
		return this.rutasPersonalesRealizadas;
	}

	/**
	 * Asigna el valor de la propiedad 'listaRutasPersonalesCompletadas'
	 * 
	 * @param listaRutasPersonalesCompletadas valor que se le quiere dar a la
	 *            propiedad 'listaRutasPersonalesCompletadas'
	 */
	@MemberOrder(sequence = "5")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public void setRutasPersonalesRealizadas(final SortedSet<RutaPersonalRealizada> rutasPersonalesRealizadas) {
		this.rutasPersonalesRealizadas = rutasPersonalesRealizadas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final RutaPersonal o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "nombre");
	}

}
