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
package org.dajlab.laposte;

import org.dajlab.laposte.domaine.LPLangue;
import org.dajlab.laposte.domaine.LPSuivi;
import org.dajlab.laposte.domaine.LPSuiviException;

/**
 * Interface d'accès à l'API de La Poste Suivi v2.
 * 
 * @author Erik
 *
 */
public interface ILaPosteService {

	/**
	 * Recherche le suivi d'un envoi.
	 * 
	 * @param numeroSuivi le numéro de suivi
	 * @return le suivi
	 * @throws LPSuiviException en cas d'erreur
	 */
	LPSuivi getSuivi(final String numeroSuivi) throws LPSuiviException;

	/**
	 * Recherche le suivi d'un envoi.
	 * 
	 * @param numeroSuivi le numéro de suivi
	 * @param langue      langue de retour souhaitée
	 * @return le suivi
	 * @throws LPSuiviException en cas d'erreur
	 */
	LPSuivi getSuivi(final String numeroSuivi, final LPLangue langue) throws LPSuiviException;
}
