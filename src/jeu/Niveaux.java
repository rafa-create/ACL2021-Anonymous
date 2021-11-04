package jeu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Niveaux extends JPanel implements ActionListener,Runnable {
	private Dimension d;
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    static boolean Enjeu = true;
    private final int Taille_block = 23;
    private final int Nbre_block = 15;
    private final int Taille_ecran = Nbre_block * Taille_block;
    private int Niveau;
    private Image Coeur;
    private Image mechant;
    private Image chevalier;
    private boolean Tpok=true;
    private int chronos=60;
    private int Pause=1000;
    

    private final short Niveau1[] = 
    	// Etoile blanche sortie ok 
    	// Violet TP ok 
    	// Vert clé
    	// Rouge Recupération de vie ok 
    	// Noir piege ok 
    	// Magie bleu 
    	// Spawn gris 
    	// marron  ouvre une porte
    	// Matrice du Niveau1 
        // 0 sa place un cube
        // 1 une barre verticale à gauche du point pixélisé
        // 2 une barre horizontale en haut '' '' ''
        // 4 une barre verticaile à droite '' '' ''
        // 8 une barre horizontale en bas '' '' '' 
        // 16 un espace vide
    	// 32 Point blanc 
    	// 64 point violet
    	//128 point rouge
    	//256 point noire
    	//512 point bleu
    	//1024 point gris
    	//2056 point vert 
        //17 = 16 + 1 = espace vide + barre verticale
        // etc ...
      { 1043, 18, 18, 18, 26, 26, 26, 26, 26, 26, 26, 26, 18, 18, 22,
        17, 16, 17, 17, 81, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        17, 16, 17, 17, 19, 18, 18, 18, 18, 18, 18, 18, 17, 16, 20,
        17, 16, 17, 17, 17, 19, 18, 17, 16, 16, 16, 16, 16, 16, 20,
        17, 16, 18, 18, 17, 17, 16, 18, 18, 18, 18, 19, 19, 22, 20,
        17, 24, 24, 24, 17, 17, 16, 18, 18, 22, 16, 18, 19, 20, 20,
        17, 17, 16, 16, 17, 17, 19, 18, 18, 18, 18, 16, 17, 21, 20,
        83, 17, 16, 16, 16, 16, 17, 19, 17, 19, 18, 18, 17, 17, 20,
        17, 19, 19, 17, 19, 531, 17, 17, 17, 17, 23, 16, 17, 21, 20,
        17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 21, 16, 17, 21, 22,
        17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 21, 16, 17, 29, 20,
        17, 17, 17, 17, 17, 16, 17, 17, 153, 17, 21, 16, 16, 17, 20,
        17, 17, 17, 16, 17, 16, 17, 17, 17, 17, 21, 16, 25, 17, 20,
        17, 16, 16, 16, 17, 16, 16, 273, 16, 16, 17, 16, 16, 16, 20,
        25, 24, 24, 24, 25, 24, 24, 28, 24, 26, 26, 26, 26, 26, 46 };
    private final short Niveau2[] = 
    	 //Matrice du Niveau 2 
   	{	1043, 18, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 94,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 530, 17, 21,
            17, 19, 18, 18, 18, 16, 18, 18, 18, 18, 18, 18, 18, 16, 21,
            17, 17, 16, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 17, 21,
            17, 17, 19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 16, 21,
            17, 16, 18, 18, 273, 17, 19, 26, 26, 26, 26, 26, 2074, 25, 21,
            17, 16, 16, 16, 17, 17, 25, 24, 24, 24, 24, 24, 24, 24, 29,
            17, 16, 16, 16, 17, 17, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            83, 18, 18, 18, 17, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 19, 18, 18, 18, 18, 18, 18, 21, 22, 20,
            19, 18, 18, 18, 18, 16, 147, 18, 18, 18, 18, 16, 21, 20, 20,
            17, 16, 16, 16, 16, 16, 26, 26, 26, 26, 26, 24, 63, 20, 20,
            19, 18, 26, 26, 4122, 17, 25, 24, 24, 24, 16, 24, 24, 28, 20,
            9, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28 };
    private short[] Donnee;
    private Timer temps;
    
    Pion obi= new Pion(10,10,50,50);
    Sith ana= new Sith(10,10);
    
    public Niveaux() {
        Initialisation();
        addKeyListener(new TAdapter());
        setFocusable(true);
        initJeu();
    }
    private void Verif() {
    	//Variable de position Rappel
    	if((obi.getX()<=0 || obi .getX()>=341)&&(obi.getY()<=0 || obi .getY()>=341)) {
    		obi.setX(0);
    		obi.setY(0);
    	}
    }
    private void Teleportation() 
    {
    	if(obi.getX()==102 && obi.getY()==33) 
    	{
    		obi.setX(-4);
    		obi.setY(6);
    		Tpok=false;
    		//Evite problème
    		//obi.setY(7);
    	}
    	else if(obi.getX()==10 && obi.getY()==171) 
    	{	
    		//Evite problème
    		//obi.setX(5);
    		obi.setX(4);
    		obi.setY(-6);
    		Tpok=false;
    	}
    }
    private void Dessine_Chrono(Graphics2D g2d) {
    	g2d.setFont(smallFont);
        g2d.setColor(new Color(5, 181, 79));
        String time = "Temps " + chronos;
        g2d.drawString(time, -Taille_ecran / 4 + 175, Taille_ecran + 16);
    	
    }
    private void Diminue_temps() {
    	chronos--;
    }
    private void perdVie() 
	{
		//Perd Vie si il est sur le noir
    	if(obi.getX()==171 && obi.getY()==309) {
    		obi.setV(-10);
    	}
    	//gagne de la vie si il est sur la case rouge 
    	if(obi.getX()==194 && obi.getY()==263) {
    		obi.setV(10);
    	}
    }
    private void GagneNRJ() {
    	//Gagne NRJ si il est sur la case bleue
    	if(obi.getX()==125 && obi.getY()==194) {
    		obi.setN(10);
    	}
    }
       private void Initialisation() {

    	Donnee = new short[Nbre_block * Nbre_block];
        d = new Dimension(400, 400);
        temps = new Timer(40, this);
        temps.start();
    }

    private void Jouer(Graphics2D g2d) {
    	if(obi.getV()<=0) {
    		System.out.println("Defaite");
        	String Victoire = "Vous perdu";
            g2d.setColor(Color.RED);
            g2d.drawString(Victoire, (Taille_ecran)/4, 175);
    		
    	} else if (obi.getX()==332 && obi.getY()==332) 
        {
        	Enjeu=false;
        	System.out.println("Victoire");
        	String Victoire = "Vous avez gagné";
            g2d.setColor(Color.YELLOW);
            g2d.drawString(Victoire, (Taille_ecran)/4, 175);
        }
    	else if(chronos <=0) {
    		Enjeu=false;
    		String Victoire = "Vous avez manqué de temps";
            g2d.setColor(Color.YELLOW);
            g2d.drawString(Victoire, (Taille_ecran)/4, 175);
    		
    	}
         else {
        	Teleportation();
        	GagneNRJ();
        	Verif();
        	//ana.setX1();
        	//ana.setY1();
            //Une fois vos classes faites s'est presque fini 
            //Manque fonction deplacement du héros
            //Manque fonction deplacement méchant
            //Manque fonction dessin méchant
        	Dessine_jedi(g2d); 
        	//Dessine_mechant(g2d);
        	perdVie();
        	Dessine_Chrono(g2d);
        	Diminue_temps();
        	Verif_mouv();
        }
    }
   // private void Dessine_mechant(Graphics2D g2d) {
    	//g2d.fillRect(ana.getX1(), ana.getY1(), 10, 10);
    	//System.out.println(ana.getX1()+"/ "+ ana.getY1());
    //}
    
      
    private void Dessine_jedi(Graphics2D g2d) {
    	g2d.fillOval(obi.getX(), obi.getY(), 6, 6);
    	//System.out.println("ObiX = "+obi.getX()+" / ObiY = "+ obi.getY() + " / ObiVie =" + obi.Vie+"/ ObiNRJ ="+obi.NRJ);
    }
    private void Affiche_Ecran(Graphics2D g2d) 
    {
    	String start = "Espace pour commencer";
        g2d.setColor(Color.BLUE);
        g2d.drawString(start, (Taille_ecran)/4, 175);
    }

    private void Affiche_Niveau(Graphics2D g) {
        g.setFont(smallFont);
        g.setColor(new Color(5, 181, 79));
        String s = "Niveau " + Niveau;
        g.drawString(s, -Taille_ecran / 4 + 96, Taille_ecran + 16);
    }

    private void DessineMap(Graphics2D g2d) {

        short i = 0;
        int x, y;

        for (y = 0; y < Taille_ecran; y += Taille_block) {
            for (x = 0; x < Taille_ecran; x += Taille_block) {

                g2d.setColor(new Color(0,72,47));
                g2d.setStroke(new BasicStroke(5));
                
                if ((Niveau1[i] == 0)) { 
                	g2d.fillRect(x, y, Taille_block, Taille_block);
                 }

                if ((Donnee[i] & 1) != 0) { 
                    g2d.drawLine(x, y, x, y + Taille_block - 1);
                }

                if ((Donnee[i] & 2) != 0) { 
                    g2d.drawLine(x, y, x + Taille_block - 1, y);
                }

                if ((Donnee[i] & 4) != 0) { 
                    g2d.drawLine(x + Taille_block - 1, y, x + Taille_block - 1,
                            y + Taille_block - 1);
                }

                if ((Donnee[i] & 8) != 0) { 
                    g2d.drawLine(x, y + Taille_block - 1, x + Taille_block - 1,
                            y + Taille_block - 1);
                }

                if ((Donnee[i] & 32) != 0) { 
                    g2d.setColor(new Color(255,255,255));
                    g2d.fillOval(x+10, y+10, 6, 6);
               }
                if ((Donnee[i] & 64) != 0) { 
                    g2d.setColor(new Color(238,130,238));
                    g2d.fillOval(x+10, y+10, 6, 6);
                    //System.out.println(x+10+"/: "+x+10);
               }
                if ((Donnee[i] & 128) != 0) { 
                    g2d.setColor(new Color(255,0,0));
                    g2d.fillOval(x+10, y+10, 6, 6);
               }
                if ((Donnee[i] & 256) != 0) { 
                    g2d.setColor(new Color(0,0,0));
                    g2d.fillOval(x+10, y+10, 6, 6);
               }
                if ((Donnee[i] & 512) != 0) { 
                    g2d.setColor(new Color(0,0,255));
                    g2d.fillOval(x+10, y+10, 6, 6);
               }
                if ((Donnee[i] & 1024) != 0) { 
                    g2d.setColor(new Color(169,169,169));
                    g2d.fillOval(x+10, y+10, 6, 6);
               }
                if ((Donnee[i] & 2048) != 0) { 
                    g2d.setColor(new Color(0,255,0));
                    g2d.fillOval(x+10, y+10, 6, 6);
               }
                if ((Donnee[i] & 4096) != 0) { 
                    g2d.setColor(new Color(139,69,19));
                    g2d.fillOval(x+10, y+10, 6, 6);
               }
                i++;
            }
        }
    }

    private void initJeu() {
    	Niveau = 1;
        initNiveau();
    }

    private void initNiveau() {
        for (int i = 0; i < Nbre_block * Nbre_block; i++) {
            Donnee[i] = Niveau1[i];
        }

        Continue();
    }
    private void Verif_mouv() {
    	
    }

    private void Continue() {
    	//int dx = 1;
        //for (int i = 0; i < Nbr_mechant; i++) {
            // Position de départ des méchant
        	// avec leur vitesse actuelle
        //	mechant_y[i] = 4 * Taille_block; 
          //  mechant_x[i] = 4 * Taille_block;
           // mechant_dy[i] = 0;
            //mechant_dX[i] = dx;
            //dx = -dx;
            //int random = (int) (Math.random() * (Vitesse_act + 1));

            //if (random > Vitesse_act) {
            //    random = Vitesse_act;
            //}

            //Vitesse_mechant[i] = Vitesse_possible[random];
        //}
        //estMort = false;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.orange);
        g2d.fillRect(0, 0, d.width, d.height);

        DessineMap(g2d);
        Affiche_Niveau(g2d);

        if (Enjeu) {
        	Jouer(g2d);
        } else {
        	Affiche_Ecran(g2d);
        }
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }
    //controls
    class TAdapter extends KeyAdapter 
    {
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (Enjeu) {
                if (key == KeyEvent.VK_LEFT) {
                   obi.setX(-1);                   
                } else if (key == KeyEvent.VK_RIGHT) {
                	obi.setX(1);
                } else if (key == KeyEvent.VK_UP) {
                	obi.setY(-1);
                } else if (key == KeyEvent.VK_DOWN) {
                	obi.setY(1);
                } else if (key == KeyEvent.VK_ESCAPE && temps.isRunning()) {
                	Enjeu = false;
                } 
            } else {
                if (key == KeyEvent.VK_SPACE) {
                	Enjeu = true;
                    initJeu();
                }
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
	@Override
	public void run() {
		while(Enjeu) {
			chronos--;
			try {
				Thread.sleep(Pause);
			}catch(InterruptedException e) {}
		}		
	}
}