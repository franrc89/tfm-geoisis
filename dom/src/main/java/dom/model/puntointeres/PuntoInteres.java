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
package dom.model.puntointeres;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import dom.model.evento.Evento;
import dom.model.ruta.Ruta;

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("PUNTOINTERES")
@Bookmarkable
public class PuntoInteres implements Comparable<PuntoInteres> {

	private String nombre;
	private String descripcion;
	private String ciudad;
	private String direccion;
	private String accesibilidad;
	private SortedSet<Ruta> listaRuta = new TreeSet<Ruta>();
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
	@javax.jdo.annotations.Column(allowsNull = "true")
	@Title(sequence = "6")
	@MemberOrder(sequence = "6")
	public SortedSet<Ruta> getListaRuta() {
		return this.listaRuta;
	}

	/**
	 * Asigna el valor de la propiedad 'listaRuta'
	 * @param listaRuta valor que se le quiere dar a la propiedad 'listaRuta'
	 */
	public void setListaRuta(final SortedSet<Ruta> listaRuta) {
		this.listaRuta = listaRuta;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaEvento'
	 * @return Propiedad listaEvento
	 */
	@javax.jdo.annotations.Column(allowsNull = "true")
	@Title(sequence = "7")
	@MemberOrder(sequence = "7")
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

	@Override
	public int compareTo(final PuntoInteres o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "nombre");
	}

}
