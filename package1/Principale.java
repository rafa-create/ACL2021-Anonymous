package package1;


// lancement du jeu

public class Principale {
	private Map maps;
	private Hero hero;
	private Ghost[] ghost;
	public static final String UP = "UP";
	public static final String DOWN = "DOWN";
	public static final String LEFT = "LEFT";
	public static final String RIGHT = "RIGHT";
	  /**
	   * initialize au lancement le jeu 
	   * en creant la map de niveau 1
	   * le hero et les fantomes (que des fantomes au niveau 1)
	   */
  public Principale () {

  }
  
  public static void main(String[] args) throws InterruptedException {
	// creation du jeu particulier et de son afficheur
	// classe qui lance le moteur de jeu generique

	}

	/**
	   * change la map en prenant le niveau passe en parametre
	   * @param int lvl le niveau souhaité
	   */
  public void upLvl (int lvl) {
	  }
	  
  //creer tous les monstres necessaires en fonction de la map
  public void fillmonstres () {
	    }
  
//dessine la map, le hero d'un niveau
  public void draw () {

      }
  /**
  * retourne le hero de la partie
  * @return le hero de la partie
  */
  public Pacman getPacman () {	 
 }
  /**
   * lance le deroulement du jeu
   * en regardant la touche utiliser par l'utilisateur pour deplacer pacman
   * puis deplace les fantomes
   * et verifie les colisions eventuelles entre pacman et les fantomes
   * (sans redessiner toute la map)
   */
  public void animate () {
  }
 /**
  * verifie s'il existe une colision entre le héro et l'un des fantome
  * si oui alors il perd une vie
  * et toutes les Entites sont repositionner Ã  leur point de dÃ©part pour le niveau en cours
  * @return true si une colision existe
  */
  private boolean collisionGhost () {
 }
}