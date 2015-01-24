/*
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  Licensed to the Apache Software Foundation (ASF) under one
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

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Bounded;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import dom.model.puntointeres.PuntoInteres;

@PersistenceCapable
// @javax.jdo.annotations.DatastoreIdentity(strategy =
// javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("RUTA_PUNTOINTERES")
@Bookmarkable
@Bounded
public class Ruta_PuntoInteres implements Comparable<Ruta_PuntoInteres> {

	// @javax.jdo.annotations.PrimaryKey
	// @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY, column =
	// "ruta_id")
	@javax.jdo.annotations.PrimaryKey(name = "id_ruta")
	private Ruta ruta;

	// @javax.jdo.annotations.PrimaryKey
	// @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY, column =
	// "puntointeres_id")
	@javax.jdo.annotations.PrimaryKey(name = "id_puntointeres")
	private PuntoInteres puntoInteres;

	private Integer orden;

	/**
	 * Devuelve el valor de la propiedad 'orden'
	 * @return Propiedad orden
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	public Integer getOrden() {
		return this.orden;
	}

	/**
	 * Asigna el valor de la propiedad 'orden'
	 * @param orden valor que se le quiere dar a la propiedad 'orden'
	 */
	public void setOrden(final Integer orden) {
		this.orden = orden;
	}

	/**
	 * Devuelve el valor de la propiedad 'ruta'
	 * @return Propiedad ruta
	 */
	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	@javax.jdo.annotations.Column(allowsNull = "false")
	public Ruta getRuta() {
		return this.ruta;
	}

	/**
	 * Asigna el valor de la propiedad 'ruta'
	 * @param ruta valor que se le quiere dar a la propiedad 'ruta'
	 */
	public void setRuta(final Ruta ruta) {
		this.ruta = ruta;
	}

	/**
	 * Devuelve el valor de la propiedad 'puntoInteres'
	 * @return Propiedad puntoInteres
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	public PuntoInteres getPuntoInteres() {
		return this.puntoInteres;
	}

	/**
	 * Asigna el valor de la propiedad 'puntoInteres'
	 * @param puntoInteres valor que se le quiere dar a la propiedad
	 *            'puntoInteres'
	 */
	public void setPuntoInteres(final PuntoInteres puntoInteres) {
		this.puntoInteres = puntoInteres;
	}

	@Override
	public int compareTo(final Ruta_PuntoInteres o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "orden");
	}

}
