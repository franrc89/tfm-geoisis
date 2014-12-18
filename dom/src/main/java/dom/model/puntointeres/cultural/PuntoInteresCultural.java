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
package dom.model.puntointeres.cultural;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;

import dom.model.puntointeres.PuntoInteres;

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("PUNTOINTERESCULTURAL")
@Bookmarkable
public class PuntoInteresCultural extends PuntoInteres {

	private String tipo;
	private String epoca;
	private String visitable;
	private String estado;

	/**
	 * Devuelve el valor de la propiedad 'tipo'
	 * @return Propiedad tipo
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * Asigna el valor de la propiedad 'tipo'
	 * @param tipo valor que se le quiere dar a la propiedad 'tipo'
	 */
	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Devuelve el valor de la propiedad 'epoca'
	 * @return Propiedad epoca
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	public String getEpoca() {
		return this.epoca;
	}

	/**
	 * Asigna el valor de la propiedad 'epoca'
	 * @param epoca valor que se le quiere dar a la propiedad 'epoca'
	 */
	public void setEpoca(final String epoca) {
		this.epoca = epoca;
	}

	/**
	 * Devuelve el valor de la propiedad 'visitable'
	 * @return Propiedad visitable
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	public String getVisitable() {
		return this.visitable;
	}

	/**
	 * Asigna el valor de la propiedad 'visitable'
	 * @param visitable valor que se le quiere dar a la propiedad 'visitable'
	 */
	public void setVisitable(final String visitable) {
		this.visitable = visitable;
	}

	/**
	 * Devuelve el valor de la propiedad 'estado'
	 * @return Propiedad estado
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "4")
	@MemberOrder(sequence = "4")
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Asigna el valor de la propiedad 'estado'
	 * @param estado valor que se le quiere dar a la propiedad 'estado'
	 */
	public void setEstado(final String estado) {
		this.estado = estado;
	}

}
