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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import org.dajlab.laposte.domaine.LPLangue;
import org.dajlab.laposte.domaine.LPSuivi;
import org.dajlab.laposte.domaine.LPSuiviException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implémentation du service.
 * 
 *
 */
public class LaPosteServiceImpl implements ILaPosteService {

	/**
	 * URL du webservice.
	 */
	private static final String URL = "https://api.laposte.fr/suivi/v2/idships/";

	/**
	 * Okapi key.
	 */
	private String key;

	/**
	 * Constructeur.
	 * 
	 * @param okapiKey private Okapi key
	 */
	public LaPosteServiceImpl(String okapiKey) {
		key = okapiKey;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public LPSuivi getSuivi(String numeroSuivi) throws LPSuiviException {

		return getSuivi(numeroSuivi, null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public LPSuivi getSuivi(String numeroSuivi, LPLangue langue) throws LPSuiviException {

		String url = URL + numeroSuivi;
		if (langue != null) {
			url += "?lang=" + langue.name();
		}
		try {
			String output = callRestService(url);
			if (output != null) {
				ObjectMapper mapper = new ObjectMapper();
				return mapper.readValue(output, LPSuivi.class);
			}
		} catch (Exception e) {
			throw new LPSuiviException(e.getMessage());
		}
		return null;
	}

	/**
	 * Call the service.
	 * 
	 * @param url full url
	 * @return JSON representation
	 * @throws LPSuiviException en cas d'exception
	 */
	private String callRestService(String url) throws LPSuiviException {
		try {
			URL fullurl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) fullurl.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-Okapi-Key", key);
			if (conn.getResponseCode() != 200) {
				return null;
			}

			return new BufferedReader(new InputStreamReader(conn.getInputStream())).lines()
					.collect(Collectors.joining("\n"));

		} catch (Exception e) {
			throw new LPSuiviException(e.getMessage());
		}
	}

}
