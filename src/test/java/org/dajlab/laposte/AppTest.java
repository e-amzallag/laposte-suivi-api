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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.dajlab.laposte.domaine.LPEvent;
import org.dajlab.laposte.domaine.LPLangue;
import org.dajlab.laposte.domaine.LPShipment;
import org.dajlab.laposte.domaine.LPSuivi;
import org.dajlab.laposte.domaine.LPTimeline;
import org.junit.jupiter.api.Test;

/**
 * Tests simples de l'api sur les jeux de données La Poste.
 */
public class AppTest {

	@Test
	public void testApp() {
		// Remplacer la clé par une clé sandbox
		ILaPosteService service = new LaPosteServiceImpl("cleokapi");

		try {
			// Courrier
			LPSuivi suivi = service.getSuivi("4P36275770836");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("1K36275770836");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("4G11111111110");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("RK633119313NZ", LPLangue.en_GB);
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode()
					+ " " + suivi.getShipment().getEvent().get(0).getLabel());
			// assertEquals(LPLangue.en_GB, suivi.getLang()); // langue retournée fr_FR...

			suivi = service.getSuivi("3P11111111110");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode()
					+ " " + suivi.getShipment().getEvent().get(0).getLabel());

			assertEquals(LPLangue.fr_FR, suivi.getLang());
			assertNotNull(suivi.getScope());
			assertEquals(200, suivi.getReturnCode(), "Code retour incorrect");
			LPShipment shipment = suivi.getShipment();
			assertNotNull(shipment.getIdShip());
			assertNotNull(shipment.getHolder());
			// assertNotNull(shipment.getUrlDetail()); // null
			assertNotNull(shipment.getProduct());
			assertNotNull(shipment.isFinal());
			// assertNotNull(shipment.getEntryDate()); // null
			assertNotNull(shipment.getDeliveryDate());

			LPEvent event = shipment.getEvent().get(0);
			assertNotNull(event.getCode());
			assertNotNull(event.getDate());
			assertNotNull(event.getLabel());
			assertNotNull(event.getOrder());

			LPTimeline timeline = shipment.getTimeline().get(0);
			assertNotNull(timeline.getCountry());
			// assertNotNull(timeline.getDate()); // null
			assertNotNull(timeline.getId());
			assertNotNull(timeline.getLongLabel());
			assertNotNull(timeline.getShortLabel());
			assertNotNull(timeline.getType());

//			LPContextData contextData = shipment.getContextData(); // null
//			assertNotNull(contextData.getArrivalCountry());
//			assertNotNull(contextData.getDeliveryChoice());
//			assertNotNull(contextData.getOriginCountry());
//			assertNotNull(contextData.getPartner());
//			assertNotNull(contextData.getRemovalPoint());

			suivi = service.getSuivi("XX032057485XX");
			assertNull(suivi);

			// Colis
			suivi = service.getSuivi("8R11111111110");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("115111111111111");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("5S11111111110");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

//			suivi = service.getSuivi("3SAAAA1111111"); // JSON retourné malformé...
//			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("6P01007508742");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("6T11111111110");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("6W111111111XX");
			assertNull(suivi);

			// Chronopost
			suivi = service.getSuivi("FD633119313NZ");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("GF111111110NZ");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("114111111111111");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("GM111111110NZ");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("ZZ111111110NZ");
			System.out.println(suivi.getShipment().getIdShip() + " " + suivi.getShipment().getEvent().get(0).getCode());

			suivi = service.getSuivi("FA633119313XX");
			assertNull(suivi);

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
}
