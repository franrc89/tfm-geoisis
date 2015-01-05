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

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;

@ObjectType("ALOJAMIENTO")
@Bookmarkable
public class Alojamiento extends PuntoInteresNegocio {

	private String clasificacion;

	/**
	 * Devuelve el valor de la propiedad 'clasificacion'
	 * @return Propiedad clasificacion
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	public String getClasificacion() {
		return this.clasificacion;
	}

	/**
	 * Asigna el valor de la propiedad 'clasificacion'
	 * @param clasificacion valor que se le quiere dar a la propiedad
	 *            'clasificacion'
	 */
	public void setClasificacion(final String clasificacion) {
		this.clasificacion = clasificacion;
	}

}
