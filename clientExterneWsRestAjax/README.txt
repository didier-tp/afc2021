pour activer la page appelAjax.html et les fichiers annexes
depuis le protocole http: (et pas file:) 
on peut :
1 ajouter un fichier index.html avec un lien vers appelAjax.html
2 installer la technologie nodeJs
3 via la sous partie npm de nodeJs on va installer lite-server
  npm install -g lite-server
4 on se place dans le répertoire comportant index.html
  on lance la commande lite-server
  ça démarre automatiquement un mini server (http://localhost:3000)
  qui prend en charge tout le contenu du répertoire courant
5 utilisation depuis un navigateur lancé automatiquement.