Mardi 6 juillet 2021 au soir,
- le serveur d'authentification uaa (de cloudfoundry) s'est avéré capricieux
- le serveur d'autorisation hydra (de google / ory) s'est avéré complexe et imcomplet
  (besoin d'ajouter et coder des providers)
- le serveur d'autorisation "keycloak" s'est avéré beaucoup plus approprié
  (basé sur java>=8 et wildfly, simple à installé , console d'admin très bien, ...)
- pour l'instant le dialogue entre les projets
   "myBasicOAuth2Client" et "keycloak" et "serverRestBehindGateway" 
   fonctionne à peu près bien.

Reste à améliorer dès que possible (debut aout ou plus tard):
- différents profiles de "serverRestBehindGateway" : avec ou sans oauth2
- tester "myBasicOAuth2Client" avec différents users et différents scopes
- faire cohabiter parties "public sans auth" dans "myBasicOAuth2Client"

Restera encore à améliorer dès que possible (encore plus tard):
- transposition de "myBasicOAuth2Client" vers "myApiGateway"
- utilisation de TokenRelay dans "myApiGateway"
- ....

---------------------
futur document ici avec api gateway (spring-cloud)