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

public enum LPTypeAction {

	OK(1, "OK"), ALEA(0, "Aléa"), KO(-1, "KO");

	/**
	 * Code.
	 */
	private int code;

	/**
	 * Label.
	 */
	private String label;

	private LPTypeAction(int code, String label) {
		this.code = code;
		this.label = label;
	}

	/**
	 * 
	 * @param code code type
	 * @return type
	 */
	@JsonCreator
	public static LPTypeAction fromCode(int code) {

		for (LPTypeAction codeType : LPTypeAction.values()) {
			if (codeType.getCode() == code) {
				return codeType;
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
