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
 * Liste des services disponibles.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LPDeliveryChoice {

	/**
	 * Modification de livraison.
	 */
	private LPCodeDeliveryChoice deliveryChoice;

	/**
	 * @return the deliveryChoice
	 */
	public LPCodeDeliveryChoice getDeliveryChoice() {
		return deliveryChoice;
	}

	/**
	 * @param deliveryChoice the deliveryChoice to set
	 */
	public void setDeliveryChoice(LPCodeDeliveryChoice deliveryChoice) {
		this.deliveryChoice = deliveryChoice;
	}

}
