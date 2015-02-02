package dom.model.puntointeres;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.DiscriminatorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bounded;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;
import org.apache.isis.applib.annotation.Title;

import dom.model.evento.Evento;
import dom.model.ruta.Ruta_PuntoInteres;
import dom.model.rutapersonal.RutaPersonal;
import dom.model.sociable.ClaseSociable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@Discriminator(strategy = DiscriminatorStrategy.CLASS_NAME)
@ObjectType("PUNTOINTERES")
@Bookmarkable
@Bounded
public class PuntoInteres extends ClaseSociable {

	private String nombre;
	private String descripcion;
	private String ciudad;
	private String direccion;
	private String accesibilidad;
	// private SortedSet<Ruta> listaRuta = new TreeSet<Ruta>();
	private SortedSet<Ruta_PuntoInteres> listaRuta = new TreeSet<Ruta_PuntoInteres>();
	private SortedSet<RutaPersonal> listaRutaPersonal = new TreeSet<RutaPersonal>();
	private SortedSet<Evento> listaEvento = new TreeSet<Evento>();

	/**
	 * Devuelve el valor de la propiedad 'nombre'
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
	 * @param nombre valor que se le quiere dar a la propiedad 'nombre'
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el valor de la propiedad 'descripcion'
	 * @return Propiedad descripcion
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Asigna el valor de la propiedad 'descripcion'
	 * @param descripcion valor que se le quiere dar a la propiedad
	 *            'descripcion'
	 */
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve el valor de la propiedad 'ciudad'
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
	 * @param ciudad valor que se le quiere dar a la propiedad 'ciudad'
	 */
	public void setCiudad(final String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Devuelve el valor de la propiedad 'direccion'
	 * @return Propiedad direccion
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "4")
	@MemberOrder(sequence = "4")
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * Asigna el valor de la propiedad 'direccion'
	 * @param direccion valor que se le quiere dar a la propiedad 'direccion'
	 */
	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve el valor de la propiedad 'accesibilidad'
	 * @return Propiedad accesibilidad
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "5")
	@MemberOrder(sequence = "5")
	public String getAccesibilidad() {
		return this.accesibilidad;
	}

	/**
	 * Asigna el valor de la propiedad 'accesibilidad'
	 * @param accesibilidad valor que se le quiere dar a la propiedad
	 *            'accesibilidad'
	 */
	public void setAccesibilidad(final String accesibilidad) {
		this.accesibilidad = accesibilidad;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaRuta'
	 * @return Propiedad listaRuta
	 */
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Persistent(column = "puntointeres_id", mappedBy = "puntoInteres", dependentElement = "false")
	@Render(Type.EAGERLY)
	public SortedSet<Ruta_PuntoInteres> getListaRuta() {
		return this.listaRuta;
	}

	/**
	 * Asigna el valor de la propiedad 'listaRuta'
	 * @param listaRuta valor que se le quiere dar a la propiedad 'listaRuta'
	 */
	public void setListaRuta(final SortedSet<Ruta_PuntoInteres> listaRuta) {
		this.listaRuta = listaRuta;
	}

	@MemberOrder(name = "listaRuta", sequence = "4")
	public PuntoInteres add(final Ruta_PuntoInteres ruta_PuntoInteres) {
		ruta_PuntoInteres.setPuntoInteres(this);
		this.listaRuta.add(ruta_PuntoInteres);
		return this;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaRutaPersonal'
	 * @return Propiedad listaRutaPersonal
	 */
	@javax.jdo.annotations.Persistent(table = "rutapersonal_puntointeres")
	@javax.jdo.annotations.Join(column = "puntointeres_id")
	@javax.jdo.annotations.Element(column = "rutapersonal_id")
	@Render(Type.EAGERLY)
	public SortedSet<RutaPersonal> getListaRutaPersonal() {
		return this.listaRutaPersonal;
	}

	/**
	 * Asigna el valor de la propiedad 'listaRutaPersonal'
	 * @param listaRutaPersonal valor que se le quiere dar a la propiedad
	 *            'listaRutaPersonal'
	 */
	public void setListaRutaPersonal(final SortedSet<RutaPersonal> listaRutaPersonal) {
		this.listaRutaPersonal = listaRutaPersonal;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaEvento'
	 * @return Propiedad listaEvento
	 */
	@javax.jdo.annotations.Column(name = "puntointeres_id", allowsNull = "true")
	@Title(sequence = "7")
	@MemberOrder(sequence = "7")
	@Render(Type.EAGERLY)
	public SortedSet<Evento> getListaEvento() {
		return this.listaEvento;
	}

	/**
	 * Asigna el valor de la propiedad 'listaEvento'
	 * @param listaEvento valor que se le quiere dar a la propiedad
	 *            'listaEvento'
	 */
	public void setListaEvento(final SortedSet<Evento> listaEvento) {
		this.listaEvento = listaEvento;
	}

}
