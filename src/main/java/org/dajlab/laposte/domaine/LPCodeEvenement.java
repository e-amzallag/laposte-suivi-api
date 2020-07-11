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

public enum LPCodeEvenement {

	DR1("Déclaratif réceptionné", 1),

	PC1("Pris en charge", 2),

	PC2("Pris en charge dans le pays d’expédition", 2),

	ET1("En cours de traitement", 3),

	ET2("En cours de traitement dans le pays d’expédition", 3),

	ET3("En cours de traitement dans le pays de destination", 3),

	ET4("En cours de traitement dans un pays de transit", 3),

	EP1("En attente de présentation", 3),

	DO1("Entrée en Douane", 3),

	DO2("Sortie de Douane", 3),

	DO3("Retenu en Douane", 3),

	PB1("Problème en cours", 3),

	PB2("Problème résolu", 3),

	MD2("Mis en distribution", 4),

	ND1("Non distribuable", 4),

	AG1("En attente d’être retiré au guichet", 4),

	RE1("Retourné à l’expéditeur", 4),

	DI1("Distribué", 5),

	DI2("Distribué à l’expéditeur", 5);

	private String libelle;

	private int etape;

	private LPCodeEvenement(String libelle, int etape) {
		this.libelle = libelle;
		this.etape = etape;
	}

	@JsonCreator
	public static LPCodeEvenement fromCode(String code) {

		for (LPCodeEvenement codeEvent : LPCodeEvenement.values()) {
			if (codeEvent.name().equals(code)) {
				return codeEvent;
			}
		}
		return null;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @return the etape
	 */
	public int getEtape() {
		return etape;
	}

}
