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
package dom.model.puntointeres;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, columns = {
		@javax.jdo.annotations.Column(name = "puntointeres_id"), @javax.jdo.annotations.Column(name = "ruta_id") })
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("PUNTOINTERES_RUTA")
@Bookmarkable
public class PuntoInteres_Ruta implements Comparable<PuntoInteres_Ruta> {

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

	@Override
	public int compareTo(final PuntoInteres_Ruta o) {
		// TODO Auto-generated method stub
		return ObjectContracts.compare(this, o, "orden");
	}

}
