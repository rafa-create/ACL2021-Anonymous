Rafael Orset
Bertrand TOUPANCE
Joachim Courtois
Charlie Bedfert


1) Execution du programme avec maven

- En ligne de cmd (dans le dossier cloné) taper :

Pour windows:
	java -cp target\ACL2021-Anonymous-0.0.1-SNAPSHOT.jar jeu.Jedi
Pour mac : 	
	java -cp target/ACL2021-Anonymous-0.0.1-SNAPSHOT.jar jeu.Jedi

- Si besoin faire :
	mvn package
	mvn compile
	mvn test

Version de maven : Apache Maven 3.8.4
Version de JDK : jdk-17.0.1


2) Présentation du code du S1

5 classes :
Jedi : creer la fenêtre de jeu
Sith : creer les méchants 
Niveaux : creer et affiche le labyrinthe, s'occupe des déplacements
ChronoTime : creer le timer de jeu
Pion : creer le hero
