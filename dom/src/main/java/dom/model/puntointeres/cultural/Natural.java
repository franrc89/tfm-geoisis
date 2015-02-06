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

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUPERCLASS_TABLE)
@ObjectType("NATURAL")
@Bookmarkable
public class Natural extends PuntoInteresCultural {

	private String tipo;
	private String epoca;
	private String protegido;

	/**
	 * Devuelve el valor de la propiedad 'tipo'
	 * @return Propiedad tipo
	 */
	@Override
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
	@Override
	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Devuelve el valor de la propiedad 'epoca'
	 * @return Propiedad epoca
	 */
	@Override
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "2")
	public String getEpoca() {
		return this.epoca;
	}

	/**
	 * Asigna el valor de la propiedad 'epoca'
	 * @param epoca valor que se le quiere dar a la propiedad 'epoca'
	 */
	@Override
	public void setEpoca(final String epoca) {
		this.epoca = epoca;
	}

	/**
	 * Devuelve el valor de la propiedad 'protegido'
	 * @return Propiedad protegido
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "3")
	public String getProtegido() {
		return this.protegido;
	}

	/**
	 * Asigna el valor de la propiedad 'protegido'
	 * @param protegido valor que se le quiere dar a la propiedad 'protegido'
	 */
	public void setProtegido(final String protegido) {
		this.protegido = protegido;
	}

}
