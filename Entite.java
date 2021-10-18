public class Entite {
	
	// ce qui est vivant et qui peut se déplacer
	// on attribut à une entite son nom (hero ou nom de monstre)
	// et ses statistiques (attaque, deplacement)
	private String nom;
	private int attaque; 
	private deplacement;
	private placement_initial;
	
	public Entite(String nom, String niveau, String attaque) {
		this.nom = nom;
		this.niveau = niveau;
		this.attaque = attaque;
	}
	public String getNom() {
		return this.nom ;
	}
	
	
	public int getNiveau() {
		return this.niveau ;
	}
	
	public int getAttaque() {
		return this.attaque;
	}
	

}
