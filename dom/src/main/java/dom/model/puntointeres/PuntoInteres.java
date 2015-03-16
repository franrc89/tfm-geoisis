package dom.model.puntointeres;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.DiscriminatorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.CollectionLayout;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.RenderType;
import org.apache.isis.applib.annotation.Title;

import dom.model.evento.Evento;
import dom.model.ruta.Ruta_PuntoInteres;
import dom.model.rutapersonal.RutaPersonal_PuntoInteres;
import dom.model.sociable.ClaseSociable;
import dom.model.sociable.PuntoInteresVisitado;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@Discriminator(strategy = DiscriminatorStrategy.CLASS_NAME)
@DomainObject(bounded = true, objectType = "PuntoInteres")
@DomainObjectLayout
public abstract class PuntoInteres extends ClaseSociable {

	private String nombre;
	private String descripcion;
	private String ciudad;
	private String direccion;
	private String accesibilidad;
	private SortedSet<Ruta_PuntoInteres> puntosInteres = new TreeSet<Ruta_PuntoInteres>();
	private SortedSet<RutaPersonal_PuntoInteres> rutasPersonales = new TreeSet<RutaPersonal_PuntoInteres>();
	private SortedSet<Evento> eventos = new TreeSet<Evento>();
	private SortedSet<PuntoInteresVisitado> puntosInteresVisitados = new TreeSet<PuntoInteresVisitado>();

	/**
	 * Devuelve el valor de la propiedad 'nombre'
	 * 
	 * @return Propiedad nombre
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
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
	 * Devuelve el valor de la propiedad 'descripcion'
	 * 
	 * @return Propiedad descripcion
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "2")
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Asigna el valor de la propiedad 'descripcion'
	 * 
	 * @param descripcion valor que se le quiere dar a la propiedad
	 *            'descripcion'
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve el valor de la propiedad 'ciudad'
	 * 
	 * @return Propiedad ciudad
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	public String getCiudad() {
		return this.ciudad;
	}

	/**
	 * Asigna el valor de la propiedad 'ciudad'
	 * 
	 * @param ciudad valor que se le quiere dar a la propiedad 'ciudad'
	 */
	public void setCiudad(final String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Devuelve el valor de la propiedad 'direccion'
	 * 
	 * @return Propiedad direccion
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "4")
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * Asigna el valor de la propiedad 'direccion'
	 * 
	 * @param direccion valor que se le quiere dar a la propiedad 'direccion'
	 */
	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve el valor de la propiedad 'accesibilidad'
	 * 
	 * @return Propiedad accesibilidad
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "5")
	public String getAccesibilidad() {
		return this.accesibilidad;
	}

	/**
	 * Asigna el valor de la propiedad 'accesibilidad'
	 * 
	 * @param accesibilidad valor que se le quiere dar a la propiedad
	 *            'accesibilidad'
	 */
	public void setAccesibilidad(final String accesibilidad) {
		this.accesibilidad = accesibilidad;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaRuta'
	 * 
	 * @return Propiedad listaRuta
	 */
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Persistent(column = "puntointeres_id", mappedBy = "puntoInteres", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<Ruta_PuntoInteres> getPuntosInteres() {
		return this.puntosInteres;
	}

	/**
	 * Asigna el valor de la propiedad 'listaRuta'
	 * 
	 * @param listaRuta valor que se le quiere dar a la propiedad 'listaRuta'
	 */
	public void setPuntosInteres(final SortedSet<Ruta_PuntoInteres> puntosInteres) {
		this.puntosInteres = puntosInteres;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaRutaPersonal'
	 * 
	 * @return Propiedad listaRutaPersonal
	 */
	@javax.jdo.annotations.Persistent(table = "rutapersonal_puntointeres")
	@javax.jdo.annotations.Join(column = "puntointeres_id")
	@javax.jdo.annotations.Element(column = "rutapersonal_id")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<RutaPersonal_PuntoInteres> getRutasPersonales() {
		return this.rutasPersonales;
	}

	/**
	 * Asigna el valor de la propiedad 'listaRutaPersonal'
	 * 
	 * @param listaRutaPersonal valor que se le quiere dar a la propiedad
	 *            'listaRutaPersonal'
	 */
	public void setRutasPersonales(final SortedSet<RutaPersonal_PuntoInteres> rutasPersonales) {
		this.rutasPersonales = rutasPersonales;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaEvento'
	 * 
	 * @return Propiedad listaEvento
	 */
	@MemberOrder(sequence = "7")
	@javax.jdo.annotations.Persistent(mappedBy = "puntoInteres", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<Evento> getEventos() {
		return this.eventos;
	}

	/**
	 * Asigna el valor de la propiedad 'listaEvento'
	 * 
	 * @param listaEvento valor que se le quiere dar a la propiedad
	 *            'listaEvento'
	 */
	public void setEventos(final SortedSet<Evento> eventos) {
		this.eventos = eventos;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaVisitas'
	 * 
	 * @return Propiedad listaVisitas
	 */
	@MemberOrder(sequence = "8")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<PuntoInteresVisitado> getPuntosInteresVisitados() {
		return this.puntosInteresVisitados;
	}

	/**
	 * Asigna el valor de la propiedad 'listaVisitas'
	 * 
	 * @param listaVisitas valor que se le quiere dar a la propiedad
	 *            'listaVisitas'
	 */
	public void setPuntosInteresVisitados(final SortedSet<PuntoInteresVisitado> puntosInteresVisitados) {
		this.puntosInteresVisitados = puntosInteresVisitados;
	}

}
