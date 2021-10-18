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

}
