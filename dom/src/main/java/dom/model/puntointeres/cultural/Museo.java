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

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("MUSEO")
@Bookmarkable
public class Museo extends PuntoInteresCultural {

	private String contenido;

	/**
	 * Devuelve el valor de la propiedad 'contenido'
	 * @return Propiedad contenido
	 */
	@javax.jdo.annotations.Column(allowsNull = "false")
	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	public String getContenido() {
		return this.contenido;
	}

	/**
	 * Asigna el valor de la propiedad 'contenido'
	 * @param contenido valor que se le quiere dar a la propiedad 'contenido'
	 */
	public void setContenido(final String contenido) {
		this.contenido = contenido;
	}

}
