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
	private SortedSet<RutaPersonal> listaRutaPersonal = new TreeSet<RutaPersonal>();
	private SortedSet<Asistencia> listaAsistenciaEventos = new TreeSet<Asistencia>();
	private SortedSet<Comentario> listaComentarios = new TreeSet<Comentario>();
	private SortedSet<Valoracion> listaValoraciones = new TreeSet<Valoracion>();
	private SortedSet<Favorito> listaFavoritos = new TreeSet<Favorito>();
	private SortedSet<RutaRealizada> listaRutasRealizadas = new TreeSet<RutaRealizada>();
	private SortedSet<RutaPersonalRealizada> listaRutasPersonalesRealizadas = new TreeSet<RutaPersonalRealizada>();
	private SortedSet<PuntoInteresVisitado> listaPuntosInteresVisitados = new TreeSet<PuntoInteresVisitado>();

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
	 * @param nombre
	 *            valor que se le quiere dar a la propiedad 'nombre'
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Asigna el valor de la propiedad 'apellido'
	 * 
	 * @param apellido
	 *            valor que se le quiere dar a la propiedad 'apellido'
	 */
	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaRutaPersonal'
	 * 
	 * @return Propiedad listaRutaPersonal
	 */
	// @javax.jdo.annotations.Column(name = "usuario_id", allowsNull = "false")

	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<RutaPersonal> getListaRutaPersonal() {
		return this.listaRutaPersonal;
	}

	/**
	 * Asigna el valor de la propiedad 'listaRutaPersonal'
	 * 
	 * @param listaRutaPersonal
	 *            valor que se le quiere dar a la propiedad 'listaRutaPersonal'
	 */
	public void setListaRutaPersonal(
			final SortedSet<RutaPersonal> listaRutaPersonal) {
		this.listaRutaPersonal = listaRutaPersonal;
	}

	/***
	 * Añade la ruta a la lista de rutas personales del usuario
	 * 
	 * @param ruta
	 */
	public void addToListaRutaPersonal(final RutaPersonal ruta) {
		if (ruta == null || this.listaRutaPersonal.contains(ruta)) {
			return;
		}
		ruta.setUsuario(this);
		this.listaRutaPersonal.add(ruta);
	}

	/**
	 * Elimina la ruta a la lista de rutas personales del usuario
	 * 
	 * @param ruta
	 */
	public void removeFromListaRutaPersonal(final RutaPersonal ruta) {
		if (ruta == null || !this.listaRutaPersonal.contains(ruta)) {
			return;
		}
		ruta.setUsuario(null);
		this.listaRutaPersonal.remove(ruta);
	}

	/**
	 * Devuelve el valor de la propiedad 'listaAsistenciaEventos'
	 * 
	 * @return Propiedad listaAsistenciaEventos
	 */
	@MemberOrder(sequence = "4")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<Asistencia> getListaAsistenciaEventos() {
		return this.listaAsistenciaEventos;
	}

	/**
	 * Asigna el valor de la propiedad 'listaAsistenciaEventos'
	 * 
	 * @param listaAsistenciaEventos
	 *            valor que se le quiere dar a la propiedad
	 *            'listaAsistenciaEventos'
	 */
	public void setListaAsistenciaEventos(
			final SortedSet<Asistencia> listaAsistenciaEventos) {
		this.listaAsistenciaEventos = listaAsistenciaEventos;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaComentarios'
	 * 
	 * @return Propiedad listaComentarios
	 */
	@MemberOrder(sequence = "4")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<Comentario> getListaComentarios() {
		return this.listaComentarios;
	}

	/**
	 * Asigna el valor de la propiedad 'listaComentarios'
	 * 
	 * @param listaComentarios
	 *            valor que se le quiere dar a la propiedad 'listaComentarios'
	 */
	public void setListaComentarios(final SortedSet<Comentario> listaComentarios) {
		this.listaComentarios = listaComentarios;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaValoraciones'
	 * 
	 * @return Propiedad listaValoraciones
	 */
	@MemberOrder(sequence = "5")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<Valoracion> getListaValoraciones() {
		return this.listaValoraciones;
	}

	/**
	 * Asigna el valor de la propiedad 'listaValoraciones'
	 * 
	 * @param listaValoraciones
	 *            valor que se le quiere dar a la propiedad 'listaValoraciones'
	 */
	public void setListaValoraciones(
			final SortedSet<Valoracion> listaValoraciones) {
		this.listaValoraciones = listaValoraciones;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaFavoritos'
	 * 
	 * @return Propiedad listaFavoritos
	 */
	@MemberOrder(sequence = "6")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<Favorito> getListaFavoritos() {
		return this.listaFavoritos;
	}

	/**
	 * Asigna el valor de la propiedad 'listaFavoritos'
	 * 
	 * @param listaFavoritos
	 *            valor que se le quiere dar a la propiedad 'listaFavoritos'
	 */
	public void setListaFavoritos(final SortedSet<Favorito> listaFavoritos) {
		this.listaFavoritos = listaFavoritos;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaRutasRealizadas'
	 * 
	 * @return Propiedad listaRutasRealizadas
	 */
	@MemberOrder(sequence = "7")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<RutaRealizada> getListaRutasRealizadas() {
		return this.listaRutasRealizadas;
	}

	/**
	 * Asigna el valor de la propiedad 'listaRutasRealizadas'
	 * 
	 * @param listaRutasRealizadas
	 *            valor que se le quiere dar a la propiedad
	 *            'listaRutasRealizadas'
	 */
	public void setListaRutasRealizadas(
			final SortedSet<RutaRealizada> listaRutasRealizadas) {
		this.listaRutasRealizadas = listaRutasRealizadas;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaRutasPersonalesRealizadas'
	 * 
	 * @return Propiedad listaRutasPersonalesRealizadas
	 */
	@MemberOrder(sequence = "8")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<RutaPersonalRealizada> getListaRutasPersonalesRealizadas() {
		return this.listaRutasPersonalesRealizadas;
	}

	/**
	 * Asigna el valor de la propiedad 'listaRutasPersonalesRealizadas'
	 * 
	 * @param listaRutasPersonalesRealizadas
	 *            valor que se le quiere dar a la propiedad
	 *            'listaRutasPersonalesRealizadas'
	 */
	public void setListaRutasPersonalesRealizadas(
			final SortedSet<RutaPersonalRealizada> listaRutasPersonalesRealizadas) {
		this.listaRutasPersonalesRealizadas = listaRutasPersonalesRealizadas;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaPuntosInteresVisitados'
	 * 
	 * @return Propiedad listaPuntosInteresVisitados
	 */
	@MemberOrder(sequence = "9")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
	@CollectionLayout(render = RenderType.EAGERLY)
	public SortedSet<PuntoInteresVisitado> getListaPuntosInteresVisitados() {
		return this.listaPuntosInteresVisitados;
	}

	/**
	 * Asigna el valor de la propiedad 'listaPuntosInteresVisitados'
	 * 
	 * @param listaPuntosInteresVisitados
	 *            valor que se le quiere dar a la propiedad
	 *            'listaPuntosInteresVisitados'
	 */
	public void setListaPuntosInteresVisitados(
			final SortedSet<PuntoInteresVisitado> listaPuntosInteresVisitados) {
		this.listaPuntosInteresVisitados = listaPuntosInteresVisitados;
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

}
