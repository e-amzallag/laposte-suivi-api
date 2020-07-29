# API Java pour l'API Suivi v2 de La Poste.

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.dajlab/laposte-suivi-api/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.dajlab/laposte-suivi-api)

Voir https://developer.laposte.fr/products/suivi/latest pour plus d'informations sur l'API officielle Suivi de La Poste.


## Cas d'utilisation

Pour obtenir le suivi d'un courrier, Colissimo ou Chronopost :

```java
ILaPosteService service = new LaPosteServiceImpl("cleOkapi");

LPSuivi suivi = service.getSuivi("4P36275770836");
```

Pour exécuter les tests, vous devez vous munir d'une clé sandbox.