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

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bounded;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import dom.model.evento.Evento;
import dom.model.rutapersonal.RutaPersonal;

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("USUARIO")
@Bookmarkable
@Bounded
public class Usuario implements Comparable<Usuario> {

	private String nombre;
	private String apellido;
	private SortedSet<RutaPersonal> listaRutaPersonal = new TreeSet<RutaPersonal>();
	private SortedSet<Evento> listaEvento = new TreeSet<Evento>();

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
	 * @param nombre valor que se le quiere dar a la propiedad 'nombre'
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Asigna el valor de la propiedad 'apellido'
	 * @param apellido valor que se le quiere dar a la propiedad 'apellido'
	 */
	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaRutaPersonal'
	 * @return Propiedad listaRutaPersonal
	 */
	// @javax.jdo.annotations.Column(name = "usuario_id", allowsNull = "false")

	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Persistent(mappedBy = "usuario", dependentElement = "false")
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

	/***
	 * Añade la ruta a la lista de rutas personales del usuario
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
	 * Devuelve el valor de la propiedad 'listaEvento'
	 * @return Propiedad listaEvento
	 */
	@javax.jdo.annotations.Persistent(table = "Usuario_Evento")
	@javax.jdo.annotations.Join(column = "usuario_id")
	@javax.jdo.annotations.Element(column = "evento_id")
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
