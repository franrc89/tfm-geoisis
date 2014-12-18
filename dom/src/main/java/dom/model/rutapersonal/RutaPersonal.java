package dom.model.rutapersonal;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import dom.model.puntointeres.PuntoInteres;
import dom.model.usuario.Usuario;

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("RUTAPERSONAL")
@Bookmarkable
public class RutaPersonal implements Comparable<RutaPersonal> {

	private String nombre;
	private String duracion;
	private Usuario usuario;
	private SortedSet<PuntoInteres> listaPuntoInteres = new TreeSet<PuntoInteres>();

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
	 * Devuelve el valor de la propiedad 'duracion'
	 * @return Propiedad duracion
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	public String getDuracion() {
		return this.duracion;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaPuntoInteres'
	 * @return Propiedad listaPuntoInteres
	 */
	@javax.jdo.annotations.Persistent(table = "PuntoInteres_RutaPersonal")
	@javax.jdo.annotations.Join(column = "puntointeres_id")
	@javax.jdo.annotations.Element(column = "rutapersonal_id")
	public SortedSet<PuntoInteres> getListaPuntoInteres() {
		return this.listaPuntoInteres;
	}

	/**
	 * Asigna el valor de la propiedad 'nombre'
	 * @param nombre valor que se le quiere dar a la propiedad 'nombre'
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Asigna el valor de la propiedad 'duracion'
	 * @param duracion valor que se le quiere dar a la propiedad 'duracion'
	 */
	public void setDuracion(final String duracion) {
		this.duracion = duracion;
	}

	/**
	 * Asigna el valor de la propiedad 'listaPuntoInteres'
	 * @param listaPuntoInteres valor que se le quiere dar a la propiedad
	 *            'listaPuntoInteres'
	 */
	public void setListaPuntoInteres(final SortedSet<PuntoInteres> listaPuntoInteres) {
		this.listaPuntoInteres = listaPuntoInteres;
	}

	/**
	 * Devuelve el valor de la propiedad 'usuario'
	 * @return Propiedad usuario
	 */
	@javax.jdo.annotations.Column(name = "usuario_id", allowsNull = "false")
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
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
