package dom.model.rutapersonal;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bounded;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import dom.model.puntointeres.PuntoInteres;
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
	private SortedSet<PuntoInteres> listaPuntoInteres = new TreeSet<PuntoInteres>();

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

	public void modifyUsuario(final Usuario usuario) {
		if (usuario == null || this.usuario == usuario) {
			return;
		}
		if (usuario != null) {
			this.usuario.removeFromListaRutaPersonal(this);
		}
		usuario.addToListaRutaPersonal(this);
	}

	public void clearUsuario() {
		if (this.usuario == null) {
			return;
		}
		this.usuario.removeFromListaRutaPersonal(this);
	}

	/**
	 * Devuelve el valor de la propiedad 'listaPuntoInteres'
	 * @return Propiedad listaPuntoInteres
	 */
	@javax.jdo.annotations.Persistent(table = "rutapersonal_puntointeres")
	@javax.jdo.annotations.Join(column = "rutapersonal_id")
	@javax.jdo.annotations.Element(column = "puntointeres_id")
	@Render(Type.EAGERLY)
	public SortedSet<PuntoInteres> getListaPuntoInteres() {
		return this.listaPuntoInteres;
	}

	/**
	 * Asigna el valor de la propiedad 'listaPuntoInteres'
	 * @param listaPuntoInteres valor que se le quiere dar a la propiedad
	 *            'listaPuntoInteres'
	 */
	public void setListaPuntoInteres(final SortedSet<PuntoInteres> listaPuntoInteres) {
		this.listaPuntoInteres = listaPuntoInteres;
	}

	@MemberOrder(name = "listaPuntoInteres", sequence = "4")
	public RutaPersonal add(final PuntoInteres puntoInteres) {
		this.listaPuntoInteres.add(puntoInteres);
		puntoInteres.getListaRutaPersonal().add(this);
		return this;
	}

	@MemberOrder(name = "listaPuntoInteres", sequence = "5")
	public RutaPersonal remove(final PuntoInteres puntoInteres) {
		this.listaPuntoInteres.remove(puntoInteres);
		puntoInteres.getListaRutaPersonal().remove(this);
		return this;
	}

	public String disableRemove(final PuntoInteres puntoInteres) {
		return getListaPuntoInteres().isEmpty() ? "Función no disponible" : null;
	}

	public String validateRemove(final PuntoInteres puntoInteres) {
		if (!getListaPuntoInteres().contains(puntoInteres)) {
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
