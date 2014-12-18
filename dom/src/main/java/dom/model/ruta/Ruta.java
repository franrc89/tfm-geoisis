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

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import dom.model.puntointeres.PuntoInteres;

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("RUTA")
@Bookmarkable
public class Ruta implements Comparable<Ruta> {

	private String nombre;
	private String duracion;
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
	@javax.jdo.annotations.Persistent(table = "PuntoInteres_Ruta")
	@javax.jdo.annotations.Join(column = "puntointeres_id")
	@javax.jdo.annotations.Element(column = "ruta_id")
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final Ruta o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "nombre");
	}

}
