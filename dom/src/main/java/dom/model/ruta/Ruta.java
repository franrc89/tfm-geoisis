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
package dom.model.ruta;

import java.util.SortedSet;
import java.util.TreeSet;

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

import dom.model.sociable.ClaseSociable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@ObjectType("RUTA")
@Bookmarkable
@Bounded
public class Ruta extends ClaseSociable {

	private String nombre;
	private String duracion;
	private SortedSet<Ruta_PuntoInteres> listaPuntoInteres = new TreeSet<Ruta_PuntoInteres>();

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
	 * Asigna el valor de la propiedad 'duracion'
	 * @param duracion valor que se le quiere dar a la propiedad 'duracion'
	 */
	public void setDuracion(final String duracion) {
		this.duracion = duracion;
	}

	/**
	 * Devuelve el valor de la propiedad 'listaPuntoInteres'
	 * @return Propiedad listaPuntoInteres
	 */
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Persistent(name = "ruta_id", mappedBy = "ruta", dependentElement = "false")
	@Render(Type.EAGERLY)
	public SortedSet<Ruta_PuntoInteres> getListaPuntoInteres() {
		return this.listaPuntoInteres;
	}

	/**
	 * Asigna el valor de la propiedad 'listaPuntoInteres'
	 * @param listaPuntoInteres valor que se le quiere dar a la propiedad
	 *            'listaPuntoInteres'
	 */
	public void setListaPuntoInteres(final SortedSet<Ruta_PuntoInteres> listaPuntoInteres) {
		this.listaPuntoInteres = listaPuntoInteres;
	}

	@MemberOrder(name = "listaPuntoInteres", sequence = "4")
	public Ruta add(final Ruta_PuntoInteres ruta_PuntoInteres) {
		ruta_PuntoInteres.setRuta(this);
		this.listaPuntoInteres.add(ruta_PuntoInteres);
		return this;
	}

}
