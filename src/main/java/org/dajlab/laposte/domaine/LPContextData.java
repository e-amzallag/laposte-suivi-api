/*
 * Copyright 2020 Erik Amzallag
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.dajlab.laposte.domaine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Informations supplémentaires.
 * 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LPContextData {

	/**
	 * Point de retrait.
	 */
	private LPRemovalPoint removalPoint;

	/**
	 * Services disponibles.
	 */
	private LPDeliveryChoice deliveryChoice;

	/**
	 * Code pays d’origine.
	 */
	private String originCountry;

	/**
	 * Code pays destination.
	 */
	private String arrivalCountry;

	/**
	 * Info sur poste internationale.
	 */
	private LPPartner partner;

	/**
	 * @return the removalPoint
	 */
	public LPRemovalPoint getRemovalPoint() {
		return removalPoint;
	}

	/**
	 * @param removalPoint the removalPoint to set
	 */
	public void setRemovalPoint(LPRemovalPoint removalPoint) {
		this.removalPoint = removalPoint;
	}

	/**
	 * @return the deliveryChoice
	 */
	public LPDeliveryChoice getDeliveryChoice() {
		return deliveryChoice;
	}

	/**
	 * @param deliveryChoice the deliveryChoice to set
	 */
	public void setDeliveryChoice(LPDeliveryChoice deliveryChoice) {
		this.deliveryChoice = deliveryChoice;
	}

	/**
	 * @return the originCountry
	 */
	public String getOriginCountry() {
		return originCountry;
	}

	/**
	 * @param originCountry the originCountry to set
	 */
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}

	/**
	 * @return the arrivalCountry
	 */
	public String getArrivalCountry() {
		return arrivalCountry;
	}

	/**
	 * @param arrivalCountry the arrivalCountry to set
	 */
	public void setArrivalCountry(String arrivalCountry) {
		this.arrivalCountry = arrivalCountry;
	}

	/**
	 * @return the partner
	 */
	public LPPartner getPartner() {
		return partner;
	}

	/**
	 * @param partner the partner to set
	 */
	public void setPartner(LPPartner partner) {
		this.partner = partner;
	}

}
