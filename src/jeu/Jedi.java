package jeu;
import javax.swing.JFrame;
public class Jedi extends JFrame{

	public Jedi() 
    {
		add(new Niveaux());
	}
	public static void main(String[] args) {
		Jedi Obi = new Jedi();
		Obi.setVisible(true);
		Obi.setTitle("Star wars");
		Obi.setSize(380,420);
		Obi.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Obi.setLocationRelativeTo(null);
	}
}