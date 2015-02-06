/**
 * 
 */
package dom.model.sociable;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bounded;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;
import org.apache.isis.applib.util.ObjectContracts;

/**
 * @author fran
 * 
 */

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@Bookmarkable
@Bounded
public abstract class ClaseSociable implements Comparable<ClaseSociable> {

	private SortedSet<Comentario> listaComentario = new TreeSet<Comentario>();
	private SortedSet<Favorito> listaFavorito = new TreeSet<Favorito>();
	private SortedSet<Valoracion> listaValoracion = new TreeSet<Valoracion>();

	/**
	 * Devuelve el valor de la propiedad 'listaComentario'
	 * @return Propiedad listaComentario
	 */
	@MemberOrder(sequence = "1")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@Render(Type.EAGERLY)
	public SortedSet<Comentario> getListaComentario() {
		return this.listaComentario;
	}

	/**
	 * Asigna el valor de la propiedad 'listaComentario'
	 * @param listaComentario valor que se le quiere dar a la propiedad
	 *            'listaComentario'
	 */
	public void setListaComentario(final SortedSet<Comentario> listaComentario) {
		this.listaComentario = listaComentario;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaFavorito'
	 * @return Propiedad listaFavorito
	 */
	@MemberOrder(sequence = "2")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@Render(Type.EAGERLY)
	public SortedSet<Favorito> getListaFavorito() {
		return this.listaFavorito;
	}

	/**
	 * Asigna el valor de la propiedad 'listaFavorito'
	 * @param listaFavorito valor que se le quiere dar a la propiedad
	 *            'listaFavorito'
	 */
	public void setListaFavorito(final SortedSet<Favorito> listaFavorito) {
		this.listaFavorito = listaFavorito;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaValoracion'
	 * @return Propiedad listaValoracion
	 */
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@Render(Type.EAGERLY)
	public SortedSet<Valoracion> getListaValoracion() {
		return this.listaValoracion;
	}

	/**
	 * Asigna el valor de la propiedad 'listaValoracion'
	 * @param listaValoracion valor que se le quiere dar a la propiedad
	 *            'listaValoracion'
	 */
	public void setListaValoracion(final SortedSet<Valoracion> listaValoracion) {
		this.listaValoracion = listaValoracion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final ClaseSociable o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "nombre");
	}

}
