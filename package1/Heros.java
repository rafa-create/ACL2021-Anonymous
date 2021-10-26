package package1;

public class Heros extends Entite{

	// fonction estMort si en contacte avec un monstre
	// fonction combat
	// fonction déplacement
	//les héros ont une certaine jauge de vie
	
	private static final String PACMAN_COLOR = "yellow"; // the Pacman default color
	private static final int LIFE_START = 3;//nombre de vie de pacman
	public static final int SPEED_PACMAN = 10;//doit etre un multiple de taille de case
	private static final int PALIER = 10000;//palier pour gagner une vie
	private ArcCircle pac;//representation graphique de pacman
	private boolean supra;// est ce que le hero a mangé une super gomme
	private String dernierePosition;
	private String toGo;// La direction que pacman veut prendre
	private String previousMove;//Le dernier mouvement d
	private int life;// the hero life
	private int score;// the hero score
	private int palier;//prochain palier pour gagner une vie
	
	public Heros(String nom, int attaque, int placement_x, int placement_y, int PdV) {
		super(nom, attaque, placement_x, placement_y);
		
	
		

		/**
	   * Create a new Figure_hero.
	   *
	   * @param size taille de pacman
		 * @param x position absolue x de pacman
		 * @param y position absolue y de pacman
	   * @pre size >= 0
	   * @post life >= 0
	   */
		public Pacman(int size, int x, int y) {
			this.pac = new ArcCircle(size, x, y, PACMAN_COLOR, 0, 360);
			//initialize the direction of pacman
			this.dernierePosition = PacManLauncher.LEFT;
			this.ouverture = this.OUVERTURE_MIN;
			this.deplaceOuverture(PacManLauncher.LEFT);
			this.life = this.LIFE_START;
			this.supra = false;
			this.previousMove = PacManLauncher.LEFT;
			this.palier = Pacman.PALIER;
		}

		/**
		* remove one life of pacman
		*
		* @return if one life carry off
		*/
		public boolean carryOff () {
			boolean ret = false;
			if (this.life > 0) {
				this.life -= 1;
				ret = true;
			}
			return ret;
		}
		/**
	   * Give the pacman life
	   *
	   * @return the pacman life
	   */
		public int getLife () {
			return this.life;
		}
		/**
		 * up the score to this.SCORE_Gomme.
		 */
		public void upScoreGomme () {
			this.score += Gomme.SCORE_GOMME;
			if (this.score >= this.palier) {
				this.life++;
				this.palier += Pacman.PALIER;
			}
		}
		/**
		 * up the score to this.SCORE_Gomme.
		 */
		public void upScoreFantomme () {
			this.score += Ghost.SCORE_FANTOME;
		}
		/**
	   * Give the pacman score
	   *
	   * @return the pacman score
	   */
		public int getScore () {
			return this.score;
		}
		/**
	   * Give the pacman speed
	   *
	   * @return the pacman speed
	   */
		public int getSpeed () {
			return Pacman.SPEED_PACMAN;
		}
		/**
	   * Give the pacman x location in pixels
	   *
	   * @return the pacman x location in pixels
	   */
		public int getX () {
			return this.pac.getX();
		}
		/**
	   * Give the figure y location in pixels
	   *
	   * @return the figure y location in pixels
	   */
		public int getY () {
			return this.pac.getY();
		}
		/**
	   * Give the pacman width in pixels
	   *
	   * @return the pacman width in pixels
	   */
		public int getWidth () {
			return this.pac.getWidth();
		}

		/**
		 * dessine la representation de pacman
		 */
		public void draw () {
			this.pac.draw();
		}

		/**
		* move the pacman and all figures which blend him
		* @param toward la direction vers laquelle pacman devrait aller
		*/
		public void move (String toward) {
			int dx = 0;
			int dy = 0;

			if (this.testMove(toward)) {
				int[] crossMap = this.crossMap(toward);
				dx = crossMap[0];
				dy = crossMap[1];

				crossMap = this.checkColision(toward, dx, dy);
				dx = crossMap[0];
				dy = crossMap[1];

				this.deplaceOuverture(toward);
				this.animateMouth();
				this.move(dx, dy);//move the pacman
				this.previousMove = toward;
			} else {
				int[] crossMap = this.crossMap(this.previousMove);
				dx = crossMap[0];
				dy = crossMap[1];

				crossMap = this.checkColision(this.previousMove, dx, dy);
				dx = crossMap[0];
				dy = crossMap[1];

				this.deplaceOuverture(this.previousMove);
				this.animateMouth();
				this.move(dx, dy);//move the pacman
			}
			this.invariant();
		}

		/**
		 * verifie si un deplacement est possible
		 * @param  String toward la direction vers laquelle pacman devrait aller
		 * @return vrai si le deplacement est possible
		 */
		private boolean testMove (String toward) {
			boolean haveMoved = false;
			Figure[][] map = this.map.getMap();

			if(this.getX() % this.map.getTailleCase() == 0 && this.getY() % this.map.getTailleCase() == 0) {
				int[] colLign = this.getColLign();
		    int colonne = colLign[0];
		    int ligne = colLign[1];

				Figure fup = map[ligne-1][colonne];
				Figure fdown = map[ligne+1][colonne];
				Figure fleft = map[ligne][colonne-1];
				Figure fright = map[ligne][colonne+1];

				switch (toward) {
					case PacManLauncher.UP :
						if (fup.getClass().getName().compareTo("view.Wall") != 0) {
							haveMoved = true;
						} else {
						}
						break;
					case PacManLauncher.DOWN :
						if (fdown.getClass().getName().compareTo("view.Wall") != 0) {
							haveMoved = true;
						} else {
						}
						break;
					case PacManLauncher.LEFT :
						if (fleft.getClass().getName().compareTo("view.Wall") != 0) {
							haveMoved = true;
						} else {
						}
						break;
					case PacManLauncher.RIGHT :
						if (fright.getClass().getName().compareTo("view.Wall") != 0) {
							haveMoved = true;
						} else {
						}
						break;
				}
			}

			return haveMoved;
		}

		/**
		 * deplace l'entite d'un variation dx et dy
		 * relative a la position actuelle de l'Entite
		 * @param int dx le deplacement relatif Ã  x
		 * @param int dy le deplacement relatif Ã  y
		 */
		public void move (int dx, int dy) {
			this.pac.move(dx, dy);
		}

	/**
	 * Change mouth pacman direction to the new mouth pacman direction .
	 * @param direction the new mouth pacman direction
	 * @pre direction.equals("UP") || direction.equals("LEFT") || direction.equals("DOWN")|| direction.equals("RIGHT")
	 */
		private void deplaceOuverture(String direction) {
			int as = 0;
			int ae = 0;

			if (direction.equals(PacManLauncher.UP)) {
				as = (90-ouverture);
				ae = (-360+2*ouverture);
			} else if (direction.equals(PacManLauncher.LEFT)) {
				as = (180-ouverture);
				ae = (-360+2*ouverture);
			} else if (direction.equals(PacManLauncher.DOWN)) {
				as = (270-ouverture);
				ae = (-360+2*ouverture);
			} else if (direction.equals(PacManLauncher.RIGHT)) {
				as = (-ouverture);
				ae = (-360+2*ouverture);
			}

			this.pac.setAngleStart(as);
			this.pac.setAngleExtent(ae);
			this.dernierePosition = direction;
		}


		/**
	   * definie les actions que l'entite va devoir realiser avec un objet de type gomme
	   * qui est en position (i,j) sur la Map
	   * @param Figure[][] map la carte ayant les objets de type gomme
	   * @param int        i   position colonne pour la Map
	   * @param int        j   position ligne dans la Map
	   * @pre (map[i][j] instanceof Gomme) && (i>=0 && j>=0)
	   */
		protected void actionWithGom (Figure[][] map, int i, int j) {
			Figure f = map[i][j];
			if (f instanceof Gomme) {
				Gomme tmp = (Gomme)f;
				if (tmp.getGomme() != null) {
					tmp.setGomme(null);//plus de gomme
					tmp.draw();
					map[i][j] = tmp;
					this.map.pickGom();
					this.upScoreGomme();
					if (tmp.getSupra()) {
						// Mettre tous les fantome en peur
						this.supra = true;
					}
				} else {
					//deja pas de gomme donc rien a faire
				}
			}
		}

		public boolean getPMSupra() {
			return this.supra;
		}

		public void resetSupra() {
			this.supra = false;
		}


		/**
		*	pacman peut agir sur les mur et les gommes
		*/
		public boolean typeCaseToCheck (Figure f) {
			return (f instanceof Wall) || (f instanceof Gomme);
		}

		/**
		*	animation of the mouth of pacman
		*/
		public void animateMouth()
		{
			if(mouthIsOpen) {
				//fermeture
				this.ouverture = this.OUVERTURE_MIN;
			} else {
				//ouverture
				this.ouverture = this.OUVERTURE_MAX;
			}
			this.deplaceOuverture(this.dernierePosition);
			this.mouthIsOpen = !this.mouthIsOpen;
		}

		/**
		 * verifie si une colission avec un fantome est effective
		 * @param  Ghost f le potentiel fantome sur le chemin de pacman
		 * @return vrai si une collision est effective
		 */
		public boolean colisionGhost (Ghost f) {
			boolean ret = false;

			int xf = f.getX();//x de fpac
			int yf = f.getY();//y de f
			int sf = f.getWidth();//size f

			int xt = this.getX();//x
			int yt = this.getY();//y
			int st = this.getWidth();//size

			boolean posMinX = (xt < (xf+sf)) || ((xt+st) < (xf+sf));//inferieur bord droit
			boolean posMaxX = (xt > xf) || (xt+st > xf);//superieur bord gauche
			boolean posMinY = (yt < (yf+sf)) || (yt+st < (yf+sf));//inferieur bord bas
			boolean posMaxY = (yt > yf) || (yt+st > yf);//superieur bord haut

			if (posMinX && posMaxX && posMinY && posMaxY) {
				ret = true;
			}

			return ret;
		}

		/**
		* Check the class invariant
		*/
		protected void invariant() {
			this.pac.invariant();
			assert this.pac.getColor().equals("yellow") : "Invariant violated: wrong dimensions";
		}

	}
