Rafael Orset
Bertrand TOUPANCE
Joachim Courtois
Charlie Bedfert


- Pour executer le programme en ligne de cmd avec maven (dans le dossier cloné) :

	java -cp target\ACL2021-Anonymous-0.0.1-SNAPSHOT.jar src\jeu\Jedi.java

- Si besoin faire :
	mvn package
	mvn compile
	mvn test

Version de maven : Apache Maven 3.8.4
Version de JDK : jdk-17.0.1


1) Présentation du jeu S1

5 classes :
Jedi : creer la fenêtre de jeu
Sith : creer les méchants 
Niveaux : creer et affiche le labyrinthe, s'occupe des déplacements
ChronoTime : creer le timer de jeu
Pion : creer le hero
