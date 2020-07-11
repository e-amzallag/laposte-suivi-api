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

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Modification de livraison.
 *
 */
public enum LPCodeDeliveryChoice {

	POSSIBLE(1, "Possible"), CHOISI(2, "Choisi");

	private int code;

	private String label;

	private LPCodeDeliveryChoice(int code, String label) {
		this.code = code;
		this.label = label;
	}

	/**
	 * 
	 * @param code code delivery
	 * @return DeliveryChoice
	 */
	@JsonCreator
	public static LPCodeDeliveryChoice fromCode(int code) {

		for (LPCodeDeliveryChoice codeDelivery : LPCodeDeliveryChoice.values()) {
			if (codeDelivery.getCode() == code) {
				return codeDelivery;
			}
		}
		return null;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

}
