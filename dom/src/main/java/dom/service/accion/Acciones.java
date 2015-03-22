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
package dom.service.accion;

import java.util.Date;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;

import dom.model.evento.Evento;
import dom.model.puntointeres.PuntoInteres;
import dom.model.ruta.Ruta;
import dom.model.ruta.Ruta_PuntoInteres;
import dom.model.rutapersonal.RutaPersonal;
import dom.model.rutapersonal.RutaPersonal_PuntoInteres;
import dom.model.sociable.Asistencia;
import dom.model.sociable.ClaseSociable;
import dom.model.sociable.Comentario;
import dom.model.sociable.Favorito;
import dom.model.sociable.Intencion;
import dom.model.sociable.PuntoInteresVisitado;
import dom.model.sociable.RutaPersonalRealizada;
import dom.model.sociable.RutaRealizada;
import dom.model.sociable.Valoracion;
import dom.model.usuario.Usuario;

@DomainServiceLayout(named = "Usuarios", menuOrder = "10")
@DomainService(nature = NatureOfService.VIEW_CONTRIBUTIONS_ONLY, repositoryFor = Usuario.class)
public class Acciones {

	@MemberOrder(name = "General", sequence = "3")
	@ActionLayout(named = "Borrar Usuario")
	public void removeUsuario(final @ParameterLayout(named = "Objeto") Usuario objeto) {
		this.container.remove(objeto);
	}

	// region > create (action)
	@MemberOrder(name = "Asistencias", sequence = "2")
	@ActionLayout(named = "Nueva Asistencia")
	public Asistencia newAsistencia(final @ParameterLayout(named = "Usuario") Usuario usuario,
			final @ParameterLayout(named = "Evento") Evento evento,
			final @ParameterLayout(named = "Intención") Intencion intencion) {
		final Asistencia obj = this.container.newTransientInstance(Asistencia.class);
		obj.setEvento(evento);
		obj.setUsuario(usuario);
		obj.setIntencion(intencion);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// region > create (action)
	@MemberOrder(name = "Comentarios", sequence = "2")
	@ActionLayout(named = "Nuevo Comentario")
	public Comentario newComentario(final @ParameterLayout(named = "Usuario") Usuario usuario,
			final @ParameterLayout(named = "Objecto a comentar") ClaseSociable clase,
			final @ParameterLayout(named = "Comentario") String texto) {
		final Comentario obj = this.container.newTransientInstance(Comentario.class);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		obj.setTexto(texto);
		obj.setClaseSociable(clase);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// region > create (action)
	@MemberOrder(name = "Favoritos", sequence = "2")
	@ActionLayout(named = "Nuevo Favorito")
	public Favorito newFavorito(final @ParameterLayout(named = "Alias") String alias,
			final @ParameterLayout(named = "Usuario") Usuario usuario,
			final @ParameterLayout(named = "Objeto favorito") ClaseSociable claseSociable) {
		final Favorito obj = this.container.newTransientInstance(Favorito.class);
		obj.setAlias(alias);
		obj.setClaseSociable(claseSociable);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// region > create (action)
	@MemberOrder(name = "Rutas", sequence = "2")
	@ActionLayout(named = "Nueva Ruta")
	public Ruta newRuta(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Duración") String duracion) {
		final Ruta obj = this.container.newTransientInstance(Ruta.class);
		obj.setNombre(nombre);
		obj.setDuracion(duracion);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	@MemberOrder(name = "RutasPersonales", sequence = "2")
	@ActionLayout(named = "Nueva Ruta Personal")
	public RutaPersonal newRutaPersonal(final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Duración") String duracion,
			final @ParameterLayout(named = "Usuario") Usuario usuario) {
		final RutaPersonal obj = this.container.newTransientInstance(RutaPersonal.class);
		obj.setNombre(nombre);
		obj.setDuracion(duracion);
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// region > create (action)
	@MemberOrder(name = "PuntosInteresRuta", sequence = "2")
	@ActionLayout(named = "Nuevo Punto en Ruta")
	public Ruta_PuntoInteres newRuta_PuntoInteres(final @ParameterLayout(named = "Orden") Integer orden,
			final @ParameterLayout(named = "Ruta") Ruta ruta,
			final @ParameterLayout(named = "PuntoInteres") PuntoInteres poi) {
		final Ruta_PuntoInteres obj = this.container.newTransientInstance(Ruta_PuntoInteres.class);
		obj.setOrden(orden);
		obj.setRuta(ruta);
		obj.setPuntoInteres(poi);
		obj.setLocation(poi.getLocation());
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// region > create (action)
	@MemberOrder(name = "PuntosInteresRutaPersonal", sequence = "2")
	@ActionLayout(named = "Nuevo Punto en Ruta Personal")
	public RutaPersonal_PuntoInteres newRutaPersonal_PuntoInteres(
			final @ParameterLayout(named = "Orden") Integer orden,
			final @ParameterLayout(named = "Ruta Personal") RutaPersonal rutaPersonal,
			final @ParameterLayout(named = "PuntoInteres") PuntoInteres poi) {
		final RutaPersonal_PuntoInteres obj = this.container.newTransientInstance(RutaPersonal_PuntoInteres.class);
		obj.setOrden(orden);
		obj.setRutaPersonal(rutaPersonal);
		obj.setPuntoInteres(poi);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// region > create (action)
	@MemberOrder(name = "RutasRealizadas", sequence = "2")
	@ActionLayout(named = "Nueva Ruta Realizada")
	public RutaRealizada newRutaRealizada(final @ParameterLayout(named = "Ruta") Ruta ruta,
			final @ParameterLayout(named = "Usuario") Usuario usuario) {
		final RutaRealizada obj = this.container.newTransientInstance(RutaRealizada.class);
		obj.setRuta(ruta);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// region > create (action)
	@MemberOrder(name = "RutasPersonalesRealizadas", sequence = "2")
	@ActionLayout(named = "Nueva Ruta Personal Realizada")
	public RutaPersonalRealizada newRutaPersonalRealizada(
			final @ParameterLayout(named = "Ruta Personal") RutaPersonal rutaPersonal,
			final @ParameterLayout(named = "Usuario") Usuario usuario) {
		final RutaPersonalRealizada obj = this.container.newTransientInstance(RutaPersonalRealizada.class);
		obj.setRutaPersonal(rutaPersonal);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// region > create (action)
	// @MemberOrder(name = "listaValoraciones", sequence = "2")
	@MemberOrder(name = "Valoraciones", sequence = "2")
	@ActionLayout(named = "Nueva Valoración")
	public Valoracion newValoracion(final @ParameterLayout(named = "Objecto a valorar") ClaseSociable claseSociable,
			final @ParameterLayout(named = "Usuario") Usuario usuario,
			final @ParameterLayout(named = "Valoración") String puntuacion) {
		final Valoracion obj = this.container.newTransientInstance(Valoracion.class);
		obj.setClaseSociable(claseSociable);
		obj.setPuntuacion(puntuacion);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// region > create (action)
	@MemberOrder(name = "PuntosInteresVisitados", sequence = "2")
	@ActionLayout(named = "Nuevo Punto Interés Visitado")
	public PuntoInteresVisitado newPuntoInteresVisitado(
			final @ParameterLayout(named = "Punto Interes") PuntoInteres puntoInteres,
			final @ParameterLayout(named = "Usuario") Usuario usuario) {
		final PuntoInteresVisitado obj = this.container.newTransientInstance(PuntoInteresVisitado.class);
		obj.setPuntoInteres(puntoInteres);
		obj.setFecha(new Date());
		obj.setUsuario(usuario);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// region > create (action)
	@MemberOrder(name = "Eventos", sequence = "2")
	@ActionLayout(named = "Nuevo Evento")
	public Evento newEvento(final @ParameterLayout(named = "Punto Interes") PuntoInteres poi,
			final @ParameterLayout(named = "Nombre") String nombre,
			final @ParameterLayout(named = "Descripción") String descripcion,
			final @ParameterLayout(named = "Fecha Inicio") Date fechaInicio,
			final @ParameterLayout(named = "Fecha Fin") Date fechaFin) {
		final Evento obj = this.container.newTransientInstance(Evento.class);
		obj.setNombre(nombre);
		obj.setDescripcion(descripcion);
		obj.setFechaInicio(fechaInicio);
		obj.setFechaFin(fechaFin);
		obj.setPuntoInteres(poi);
		this.container.persistIfNotAlready(obj);
		return obj;
	}

	// endregion

	// region > injected services

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
