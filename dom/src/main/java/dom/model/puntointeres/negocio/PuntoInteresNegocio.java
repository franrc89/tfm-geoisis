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
package dom.model.puntointeres.negocio;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;

import dom.model.puntointeres.PuntoInteres;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUPERCLASS_TABLE)
@DomainObject(bounded = true, objectType = "PuntoInteresNegocio")
@DomainObjectLayout
public abstract class PuntoInteresNegocio extends PuntoInteres {

	private String mail;
	private String web;
	private String telefono;
	private String tipo;

	/**
	 * Devuelve el valor de la propiedad 'mail'
	 * 
	 * @return Propiedad mail
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	public String getMail() {
		return this.mail;
	}

	/**
	 * Asigna el valor de la propiedad 'mail'
	 * 
	 * @param mail
	 *            valor que se le quiere dar a la propiedad 'mail'
	 */
	public void setMail(final String mail) {
		this.mail = mail;
	}

	/**
	 * Devuelve el valor de la propiedad 'web'
	 * 
	 * @return Propiedad web
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	public String getWeb() {
		return this.web;
	}

	/**
	 * Asigna el valor de la propiedad 'web'
	 * 
	 * @param web
	 *            valor que se le quiere dar a la propiedad 'web'
	 */
	public void setWeb(final String web) {
		this.web = web;
	}

	/**
	 * Devuelve el valor de la propiedad 'telefono'
	 * 
	 * @return Propiedad telefono
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "3")
	@MemberOrder(sequence = "3")
	public String getTelefono() {
		return this.telefono;
	}

	/**
	 * Asigna el valor de la propiedad 'telefono'
	 * 
	 * @param telefono
	 *            valor que se le quiere dar a la propiedad 'telefono'
	 */
	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Devuelve el valor de la propiedad 'tipo'
	 * 
	 * @return Propiedad tipo
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "4")
	@MemberOrder(sequence = "4")
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * Asigna el valor de la propiedad 'tipo'
	 * 
	 * @param tipo
	 *            valor que se le quiere dar a la propiedad 'tipo'
	 */
	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

}
