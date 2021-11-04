ROLLAND guillaume
FRERET remi

Etant à la racine du projet,
- Pour executer le programme :

	java -cp bin/ logic.PacManLauncher

- Si besoin de compiler les class faire :

	javac src/*/*.java -d bin/


1) Présentation du jeu

Pac-Man est un jeu qui consiste à déplacer un personnage (Pac-Man) à l’intérieur d’un labyrinthe,
afin de lui faire manger des gommes qui s’y trouvent,
en évitant d’être touché par un fantôme.

Au début du jeu, Pac-Man dispose de quelques vies et
tous les 10000 points, il gagne 1 vie.

Quand Pac-Man a consommé toutes les gommes, il passe au niveau supérieur.
Losrque le dernier niveau est compléter, le niveau reprend en gardant ses points et vies.

Certaines gommes, appelées super-gommes, permettent, quand Pac-Man les mange, de lui donner temporairement
le pouvoir de manger les fantômes. Chaque fantôme rapporte des points.
Quand un fantôme est mangé, il retourne vers la zone centrale, où il peut se regénérer et redevenir “normal”.

Le meilleur score s'affiche et est enregistré pour les prochaines parties.
