package package1;

public class Entite {
	
	// ce qui est vivant et qui peut se déplacer
	// on attribut à une entite son nom (hero ou nom de monstre)
	// et ses statistiques (attaque, deplacement)
	private String nom;
	private int attaque; 
	private int placement_initial_x;
	private int placement_initial_y;
	
	
	
	public Entite(String nom, int attaque, int placement_x, int placement_y) {           
		this.nom = nom;
		this.attaque = attaque;
		this.placement_initial_x = placement_initial_x;
		this.placement_initial_y = placement_initial_y;
		
				
	}
	public String getNom() {
		return this.nom ;
	}
	
	public int getAttaque() {
		return this.attaque;
	}
	
	public int getPlacementInitial_x() {
		return this.placement_initial_x = placement_initial_x;
	}
	
	public int getPlacementInitial_y() {
		return this.placement_initial_y = placement_initial_y;
	}
	
	protected int[] crossMap() {
		return null;
	}
	
	 /**
		*	verifie si une colision entre l'entite et une Figure (avec laquelle l'entite doit interagir)
		*	va se rÃ©aliser cad si les coordonnees des 4 points de Entite rentre en partie
		*	dans les coordonnees des 4 points de Figure
		*/
	protected boolean checkOneColision () {
			return true;
		}

}
