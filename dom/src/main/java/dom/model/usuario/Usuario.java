/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package dom.model.usuario;

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

import dom.model.rutapersonal.RutaPersonal;
import dom.model.sociable.Asistencia;
import dom.model.sociable.Comentario;
import dom.model.sociable.Favorito;
import dom.model.sociable.PuntoInteresVisitado;
import dom.model.sociable.RutaPersonalRealizada;
import dom.model.sociable.RutaRealizada;
import dom.model.sociable.Valoracion;

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@DomainObject(bounded = true, objectType = "USUARIO")
@DomainObjectLayout
public class Usuario implements Comparable<Usuario> {

	private String nombre;
	private String apellido;
	private String password;
	private SortedSet<RutaPersonal> rutasPersonales = new TreeSet<RutaPersonal>();
	private SortedSet<Asistencia> asistencias = new TreeSet<Asistencia>();
	private SortedSet<Comentario> comentarios = new TreeSet<Comentario>();
	private SortedSet<Valoracion> valoraciones = new TreeSet<Valoracion>();
	private SortedSet<Favorito> favoritos = new TreeSet<Favorito>();
	private SortedSet<RutaRealizada> rutasRealizadas = new TreeSet<RutaRealizada>();
	private SortedSet<RutaPersonalRealizada> rutasPersonalesRealizadas = new TreeSet<RutaPersonalRealizada>();
	private SortedSet<PuntoInteresVisitado> puntosInteresVisitados = new TreeSet<PuntoInteresVisitado>();

	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	/**
	 * Devuelve el valor de la propiedad 'nombre'
	 * @return Propiedad nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	/**
	 * Devuelve el valor de la propiedad 'apellido'
	 * @return Propiedad apellido
	 */
	public String getApellido() {
		return this.apellido;
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
	 * Asigna el valor de la propiedad 'apellido'
	 *
	 * @param apellido valor que se le quiere dar a la propiedad 'apellido'
	 */
	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Devuelve el valor de la propiedad 'RutaPersonal'
	 *
	 * @return Propiedad RutaPersonal
	 */
	// @javax.jdo.annotations.Column(name = "usuario_id", allowsNull = "false")

	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<RutaPersonal> getRutasPersonales() {
		return this.rutasPersonales;
	}

	/**
	 * Asigna el valor de la propiedad 'RutaPersonal'
	 *
	 * @param RutaPersonal valor que se le quiere dar a la propiedad
	 *            'RutaPersonal'
	 */
	public void setRutasPersonales(final SortedSet<RutaPersonal> rutaPersonal) {
		this.rutasPersonales = rutaPersonal;
	}

	/***
	 * Añade la ruta a la de rutas personales del usuario
	 *
	 * @param ruta
	 */
	public void addToRutasPersonales(final RutaPersonal ruta) {
		if (ruta == null || this.rutasPersonales.contains(ruta)) {
			return;
		}
		ruta.setUsuario(this);
		this.rutasPersonales.add(ruta);
	}

	/**
	 * Elimina la ruta a la de rutas personales del usuario
	 *
	 * @param ruta
	 */
	public void removeFromRutasPersonales(final RutaPersonal ruta) {
		if (ruta == null || !this.rutasPersonales.contains(ruta)) {
			return;
		}
		ruta.setUsuario(null);
		this.rutasPersonales.remove(ruta);
	}

	/**
	 * Devuelve el valor de la propiedad 'asistencias'
	 *
	 * @return Propiedad asistencias
	 */
	@MemberOrder(sequence = "4")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	/**
	 * Asigna el valor de la propiedad 'asistencias'
	 *
	 * @param asistencias valor que se le quiere dar a la propiedad
	 *            'asistencias'
	 */
	public void setAsistencias(final SortedSet<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	/**
	 * Devuelve el valor de la propiedad 'Comentarios'
	 *
	 * @return Propiedad Comentarios
	 */
	@MemberOrder(sequence = "4")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<Comentario> getComentarios() {
		return this.comentarios;
	}

	/**
	 * Asigna el valor de la propiedad 'Comentarios'
	 *
	 * @param Comentarios valor que se le quiere dar a la propiedad
	 *            'Comentarios'
	 */
	public void setComentarios(final SortedSet<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * Devuelve el valor de la propiedad 'Valoraciones'
	 *
	 * @return Propiedad Valoraciones
	 */
	@MemberOrder(sequence = "5")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<Valoracion> getValoraciones() {
		return this.valoraciones;
	}

	/**
	 * Asigna el valor de la propiedad 'Valoraciones'
	 *
	 * @param Valoraciones valor que se le quiere dar a la propiedad
	 *            'Valoraciones'
	 */
	public void setValoraciones(final SortedSet<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

	/**
	 * Devuelve el valor de la propiedad 'Favoritos'
	 *
	 * @return Propiedad Favoritos
	 */
	@MemberOrder(sequence = "6")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<Favorito> getFavoritos() {
		return this.favoritos;
	}

	/**
	 * Asigna el valor de la propiedad 'Favoritos'
	 *
	 * @param Favoritos valor que se le quiere dar a la propiedad 'Favoritos'
	 */
	public void setFavoritos(final SortedSet<Favorito> favoritos) {
		this.favoritos = favoritos;
	}

	/**
	 * Devuelve el valor de la propiedad 'RutasRealizadas'
	 *
	 * @return Propiedad RutasRealizadas
	 */
	@MemberOrder(sequence = "7")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<RutaRealizada> getRutasRealizadas() {
		return this.rutasRealizadas;
	}

	/**
	 * Asigna el valor de la propiedad 'RutasRealizadas'
	 *
	 * @param RutasRealizadas valor que se le quiere dar a la propiedad
	 *            'RutasRealizadas'
	 */
	public void setRutasRealizadas(final SortedSet<RutaRealizada> rutasRealizadas) {
		this.rutasRealizadas = rutasRealizadas;
	}

	/**
	 * Devuelve el valor de la propiedad 'RutasPersonalesRealizadas'
	 *
	 * @return Propiedad RutasPersonalesRealizadas
	 */
	@MemberOrder(sequence = "8")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<RutaPersonalRealizada> getRutasPersonalesRealizadas() {
		return this.rutasPersonalesRealizadas;
	}

	/**
	 * Asigna el valor de la propiedad 'RutasPersonalesRealizadas'
	 *
	 * @param RutasPersonalesRealizadas valor que se le quiere dar a la
	 *            propiedad 'RutasPersonalesRealizadas'
	 */
	public void setRutasPersonalesRealizadas(final SortedSet<RutaPersonalRealizada> rutasPersonalesRealizadas) {
		this.rutasPersonalesRealizadas = rutasPersonalesRealizadas;
	}

	/**
	 * Devuelve el valor de la propiedad 'PuntosInteresVisitados'
	 *
	 * @return Propiedad PuntosInteresVisitados
	 */
	@MemberOrder(sequence = "9")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<PuntoInteresVisitado> getPuntosInteresVisitados() {
		return this.puntosInteresVisitados;
	}

	/**
	 * Asigna el valor de la propiedad 'PuntosInteresVisitados'
	 *
	 * @param PuntosInteresVisitados valor que se le quiere dar a la propiedad
	 *            'PuntosInteresVisitados'
	 */
	public void setPuntosInteresVisitados(final SortedSet<PuntoInteresVisitado> puntosInteresVisitados) {
		this.puntosInteresVisitados = puntosInteresVisitados;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final Usuario o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "nombre");
	}

	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "10")
	@MemberOrder(sequence = "10")
	/**
	 * Devuelve el valor de la propiedad 'password'
	 * @return Propiedad password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Asigna el valor de la propiedad 'password'
	 * @param password valor que se le quiere dar a la propiedad 'password'
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

}
