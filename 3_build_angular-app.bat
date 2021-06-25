REM nodeJs , npm , @angular/cli doivent etre installés
REM si besoin npm install -g @angular/cli
REM si besoin cd angular-app puis npm install
cd my-angular-app
ng build --prod
REM elements construits dans my-angular-app/dist/my-angular-app

REM possibilité :
REM on peut éventuellement recopier tous les fichiers générés
REM dans my-angular-app/dist/my-angular-app 
REM vers le repertoire src/main/resources/static de 
REM l'application springBoot (pour jusxtaposer frontEnd et BackEnd)
REM URL de test: http://localhost:8585/serverRest/index.html