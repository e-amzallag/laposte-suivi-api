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

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Evènement.
 * 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LPEvent {

	/**
	 * Date de l'évènement.
	 */
	private Calendar date;
	/**
	 * Message de l'évènement - Texte riche.
	 */
	private String label;
	/**
	 * Code associé à l’évènement.
	 */
	private LPCodeEvenement code;
	/**
	 * Ordre.
	 */
	private Integer order;

	/**
	 * @return the date
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the code
	 */
	public LPCodeEvenement getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(LPCodeEvenement code) {
		this.code = code;
	}

	/**
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

}
