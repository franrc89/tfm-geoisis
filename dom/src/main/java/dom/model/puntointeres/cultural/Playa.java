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

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUPERCLASS_TABLE)
@DomainObject(bounded = true, objectType = "Playa")
@DomainObjectLayout
public class Playa extends PuntoInteresCultural {

	private String tipo;
	private Float longitud;
	private String ocupacion;
	private Boolean bazul;
	private Boolean parking;
	private Boolean socorrismo;

	/**
	 * Devuelve el valor de la propiedad 'tipo'
	 *
	 * @return Propiedad tipo
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	@Override
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * Asigna el valor de la propiedad 'tipo'
	 *
	 * @param tipo valor que se le quiere dar a la propiedad 'tipo'
	 */
	@Override
	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Devuelve el valor de la propiedad 'longitud'
	 *
	 * @return Propiedad longitud
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "2")
	public Float getLongitud() {
		return this.longitud;
	}

	/**
	 * Asigna el valor de la propiedad 'longitud'
	 *
	 * @param longitud valor que se le quiere dar a la propiedad 'longitud'
	 */
	public void setLongitud(final Float longitud) {
		this.longitud = longitud;
	}

	/**
	 * Devuelve el valor de la propiedad 'ocupacion'
	 *
	 * @return Propiedad ocupacion
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "3")
	public String getOcupacion() {
		return this.ocupacion;
	}

	/**
	 * Asigna el valor de la propiedad 'ocupacion'
	 *
	 * @param ocupacion valor que se le quiere dar a la propiedad 'ocupacion'
	 */
	public void setOcupacion(final String ocupacion) {
		this.ocupacion = ocupacion;
	}

	/**
	 * Devuelve el valor de la propiedad 'bazul'
	 *
	 * @return Propiedad bazul
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "4")
	public Boolean isBazul() {
		return this.bazul;
	}

	/**
	 * Asigna el valor de la propiedad 'bazul'
	 *
	 * @param bazul valor que se le quiere dar a la propiedad 'bazul'
	 */
	public void setBazul(final Boolean bazul) {
		this.bazul = bazul;
	}

	/**
	 * Devuelve el valor de la propiedad 'parking'
	 *
	 * @return Propiedad parking
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "5")
	public Boolean isParking() {
		return this.parking;
	}

	/**
	 * Asigna el valor de la propiedad 'parking'
	 *
	 * @param parking valor que se le quiere dar a la propiedad 'parking'
	 */
	public void setParking(final Boolean parking) {
		this.parking = parking;
	}

	/**
	 * Devuelve el valor de la propiedad 'socorrismo'
	 *
	 * @return Propiedad socorrismo
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@MemberOrder(sequence = "6")
	public Boolean isSocorrismo() {
		return this.socorrismo;
	}

	/**
	 * Asigna el valor de la propiedad 'socorrismo'
	 *
	 * @param socorrismo valor que se le quiere dar a la propiedad 'socorrismo'
	 */
	public void setSocorrismo(final Boolean socorrismo) {
		this.socorrismo = socorrismo;
	}

}
