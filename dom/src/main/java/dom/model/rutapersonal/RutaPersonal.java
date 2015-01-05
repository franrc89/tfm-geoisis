package dom.model.rutapersonal;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bounded;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import dom.model.puntointeres.Poi;
import dom.model.usuario.Usuario;

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("RUTAPERSONAL")
@Bookmarkable
@Bounded
public class RutaPersonal implements Comparable<RutaPersonal> {

	private String nombre;
	private String duracion;
	private Usuario usuario;
	private SortedSet<Poi> listaPoi = new TreeSet<Poi>();

	/**
	 * Devuelve el valor de la propiedad 'nombre'
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
	 * @param nombre valor que se le quiere dar a la propiedad 'nombre'
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el valor de la propiedad 'duracion'
	 * @return Propiedad duracion
	 */
	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	@javax.jdo.annotations.Column(allowsNull = "false")
	public String getDuracion() {
		return this.duracion;
	}

	/**
	 * Asigna el valor de la propiedad 'duracion'
	 * @param duracion valor que se le quiere dar a la propiedad 'duracion'
	 */
	public void setDuracion(final String duracion) {
		this.duracion = duracion;
	}

	/**
	 * Devuelve el valor de la propiedad 'usuario'
	 * @return Propiedad usuario
	 */
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Column(allowsNull = "false")
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * Asigna el valor de la propiedad 'usuario'
	 * @param usuario valor que se le quiere dar a la propiedad 'usuario'
	 */
	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaElementoRuta'
	 * @return Propiedad listaElementoRuta
	 */

	/**
	 * Devuelve el valor de la propiedad 'listaPoi'
	 * @return Propiedad listaPoi
	 */
	// @javax.jdo.annotations.Persistent(table = "Poi_RutaPersonal")
	// @javax.jdo.annotations.Element(column = "Poi_id")
	// @javax.jdo.annotations.Join(column = "rutapersonal_id")
	@Join
	public SortedSet<Poi> getListaPoi() {
		return this.listaPoi;
	}

	/**
	 * Asigna el valor de la propiedad 'listaPoi'
	 * @param listaPoi valor que se le quiere dar a la propiedad 'listaPoi'
	 */
	public void setListaPoi(final SortedSet<Poi> listaPoi) {
		this.listaPoi = listaPoi;
	}

	@MemberOrder(name = "listaPoi", sequence = "4")
	public RutaPersonal add(final Poi poi) {
		this.listaPoi.add(poi);
		return this;
	}

	@MemberOrder(name = "listaPoi", sequence = "5")
	public RutaPersonal remove(final Poi poi) {
		this.listaPoi.remove(poi);
		return this;
	}

	public String disableRemove(final Poi poi) {
		return getListaPoi().isEmpty() ? "Función no disponible" : null;
	}

	public String validateRemove(final Poi poi) {
		if (!getListaPoi().contains(poi)) {
			return "No pertenece a la lista";
		}

		return null;
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
