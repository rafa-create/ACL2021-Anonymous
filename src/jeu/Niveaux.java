package jeu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Niveaux extends JPanel implements ActionListener {
	private Dimension d;	
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    static boolean Enjeu = false;
    private final int Taille_block = 23;
    private final int Nbre_block = 15;
    private final int Taille_ecran = Nbre_block * Taille_block;
    private int Niveau;
    int [] pos_X= {10,10};
    int L;
    int H;
    private boolean Mouv_XD=true;
    private boolean Mouv_XG=true;
    private boolean Mouv_XB=true;
    private boolean Mouv_XH=true;
    int compteur=1;
    boolean ok= false;
    int cmp=1;// nbre de fois que les ennemies bougent
    int cmp1=1;
    int cmp2=1;
    int cmp3=1;
    int a1 =1;
    int artillerie=5;
    private boolean CanDead=true;
    private ImageIcon heros1=new ImageIcon(getClass().getResource(("/jeu/giphy.gif")));
    private Image heros;
    private ImageIcon Mechant1=new ImageIcon(getClass().getResource(("/jeu/salameche.png")));
    private Image Mechant;
    private ImageIcon coeur1=new ImageIcon(getClass().getResource(("/jeu/coeur.gif")));
    private Image coeur;
    private ImageIcon mort1=new ImageIcon(getClass().getResource(("/jeu/mort.gif")));
    private Image mort;
    private ImageIcon mortbis1=new ImageIcon(getClass().getResource(("/jeu/mort1.gif")));
    private Image mortbis;
    private ImageIcon TP1=new ImageIcon(getClass().getResource(("/jeu/tp.gif")));
    private Image TP;
    private ImageIcon cle1=new ImageIcon(getClass().getResource(("/jeu/cle.gif")));
    private Image cle;
    private boolean CanDead1=true;
    private boolean CanDead2=true;
    private boolean CanDead3=true;
    private boolean regen=true;
    
    

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
     {1043, 18, 18, 18, 26, 26, 26, 26, 26, 26, 26, 26, 18, 18, 22,
        17, 16, 17, 17, 81, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        17, 16, 17, 17, 19, 18, 18, 18, 18, 18, 18, 18, 17, 16, 20,
        17, 16, 17, 17, 17, 19, 18, 17, 16, 16, 16, 16, 16, 16, 20,
        17, 16, 18, 18, 17, 17, 16, 18, 18, 18, 18, 19, 19, 22, 20,
        17, 24, 24, 24, 17, 17, 16, 18, 18, 22, 16, 18, 19, 20, 20,
        17, 17, 16, 16, 17, 17, 19, 18, 18, 18, 18, 16, 17, 21, 20,
        83, 17, 16, 16, 16, 16, 17, 19, 17, 19, 18, 18, 17, 17, 20,
        17, 19, 19, 17, 19, 17, 17, 17, 17, 17, 23, 16, 17, 21, 20,
        17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 21, 16, 17, 21, 22,
        17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 21, 16, 17, 29, 20,
        17, 17, 17, 17, 17, 16, 17, 17,153, 17, 21, 16, 16, 17, 20,
        17, 17, 17, 16, 17, 16, 17, 17, 17, 17, 21, 16, 25, 17, 20,
        17, 16, 16, 16, 17, 16, 16,273, 16, 16, 17, 16, 16, 16, 20,
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
            17, 16, 16, 16, 16, 16, 26, 26, 26, 26, 26, 24, 61, 20, 20,
            19, 18, 26, 26, 4122, 17, 25, 24, 24, 24, 16, 24, 24, 28, 20,
            9, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28 };
    private short[] Donnee;
    private Timer temps;
    int  seconde = 0;
    int a=0;
    Chrono_time heure= new Chrono_time();
    Pion obi= new Pion(10,10,50);
    Sith ana= new Sith(217,217);
    Sith ana1=new Sith(148,125);
    Sith ana2=new Sith(171,125);
    Sith ana3=new Sith (125,217);
    
    
    public Niveaux() {
        Initialisation();
        addKeyListener(new TAdapter());
        setFocusable(true);
        initJeu();
    }
    
    
    private void Verif() {
    	if(obi.getX()<=0 ) {
    			obi.setX(1);
    	}
    	if(obi.getX()>=341 ) {
			obi.setX(-1);
	}
    	if(obi.getY()>=341 ) {
			obi.setY(-1);
	}
    	if(obi.getY()<=0 ) {
			obi.setY(1);
	}
    	if(obi.getX()<=0 ||obi.getY()<=0 ) {
    		obi.setX(1);
			obi.setY(1);
	}
    	if(obi.getX()<=0 ||obi.getY()>=341 ) {
    		obi.setX(1);
			obi.setY(-1);
	}
    	if(obi.getX()>=341 ||obi.getY()<=0 ) {
    		obi.setX(-1);
			obi.setY(1);
	}
    	if(obi.getX()>=341 ||obi.getY()>=341 ) {
    		obi.setX(-1);
			obi.setY(-1);
	}
    }
    private void Verif2() {
    	if(ana.getX1()<=0 ) {
    			ana.setX1(1);
    	}
    	if(ana.getX1()>=341 ) {
    		ana.setX1(-1);
	}
    	if(ana.getY1()>=341 ) {
    		ana.setY1(-1);
	}
    	if(ana.getY1()<=0 ) {
    		ana.setY1(1);
	}
    	if(ana.getX1()<=0 ||ana.getY1()<=0 ) {
    		ana.setX1(1);
    		ana.setY1(1);
	}
    	if(ana.getX1()<=0 ||ana.getY1()>=341 ) {
    		ana.setX1(1);
    		ana.setY1(-1);
	}
    	if(ana.getX1()>=341 ||ana.getY1()<=0 ) {
    		ana.setX1(-1);
    		ana.setY1(1);
	}
    	if(ana.getX1()>=341 ||ana.getY1()>=341 ) {
    		ana.setX1(-1);
    		ana.setY1(-1);
	}
    }
    private void Teleportation() 
    {
    	if(obi.getX()==102 && obi.getY()==33) 
    	{
    		obi.setX(-4);
    		obi.setY(6);
    		//Evite problème
    		//obi.setY(7);
    	}
    }
    private void Dessine_Teleportation(Graphics2D g2d) {
    	this.TP=this.TP1.getImage();
		g2d.drawImage(this.TP, 102-7, 33-7, 18, 18, null);
		g2d.drawImage(this.TP, 10-7, 169-7, 18, 18, null);
    	
    }
    private void Dessine_Chrono(Graphics2D g2d) {
    	g2d.setFont(smallFont);
        g2d.setColor(new Color(5, 181, 79));
        String time = "Temps " + seconde;
        g2d.drawString(time, -Taille_ecran / 4 + 175, Taille_ecran + 16);
    }
    private void Dessine_Vie(Graphics2D g2d) {
    	g2d.setFont(smallFont);
        g2d.setColor(new Color(5, 181, 79));
        String Vie = "Vie " + obi.getV();
        g2d.drawString(Vie, -Taille_ecran / 4 + 275 , Taille_ecran + 16);
    }
    private void perdVie() 
	{
		//Perd Vie si il est sur le noir
    	if(obi.getX()==171 && obi.getY()==309) {
    		obi.setV(-10);
    	}
    	//gagne de la vie si il est sur la case rouge 
    	if((obi.getX()==194 && obi.getY()==263 && obi.getV()<100)&& artillerie<10 && regen==true) {
    		obi.setV(10);
    		artillerie++;
    		regen=false;
    	}
    }
    private void Mouvement1D() {
    	System.out.println(obi.getX() + " / " + obi.getY());
    	if(((obi.getX()==33 || obi.getX()==56 || obi.getX()==79 ) && obi.getY()==33)
    		||((obi.getX()==33 || obi.getX()==56 || obi.getX()==79 || obi.getX()==263) && obi.getY()==56)
    		||((obi.getX()==33 || obi.getX()==56 || obi.getX()==79 || obi.getX()==102 || obi.getX()==148) && obi.getY()==79)
    		||((obi.getX()==79 || obi.getX()==102 || obi.getX()==240 || obi.getX()==309 ) && obi.getY()==102)
    		||((obi.getX()==79 || obi.getX()==102 || obi.getX()==217 || obi.getX()==263 || obi.getX()==309) && obi.getY()==125)
    		||((obi.getX()==10 || obi.getX()==79 || obi.getX()==102 || obi.getX()==125 || obi.getX()==263 || obi.getX()==286 || obi.getX()==309) && obi.getY()==148)
    		||((obi.getX()==10 || obi.getX()==125 || obi.getX()==148 || obi.getX()==171 || obi.getX()==194 || obi.getX()==263 || obi.getX()==286) && obi.getY()==171)
    		||((obi.getX()==10 || obi.getX()==33 || obi.getX()==56 || obi.getX()==79 || obi.getX()==102 || obi.getX()==125 || obi.getX()==148 || obi.getX()==171 || obi.getX()==194 || obi.getX()==240 || obi.getX()==263 || obi.getX()==286 || obi.getX()==309) && obi.getY()==194)
    		||((obi.getX()==10 || obi.getX()==33 || obi.getX()==56 || obi.getX()==79 || obi.getX()==102 || obi.getX()==125 || obi.getX()==148 || obi.getX()==171 || obi.getX()==194 || obi.getX()==240 || obi.getX()==263 || obi.getX()==286 || obi.getX()==309) && obi.getY()==217)
    		||((obi.getX()==10 || obi.getX()==33 || obi.getX()==56 || obi.getX()==79 || obi.getX()==102 || obi.getX()==125 || obi.getX()==148 || obi.getX()==171 || obi.getX()==194 || obi.getX()==240 || obi.getX()==263 || obi.getX()==286 || obi.getX()==309) && obi.getY()==240)
    		||((obi.getX()==10 || obi.getX()==33 || obi.getX()==56 || obi.getX()==79 || obi.getX()==125 || obi.getX()==148 || obi.getX()==171 || obi.getX()==194 || obi.getX()==217 || obi.getX()==240 || obi.getX()==286) && obi.getY()==263 )
    		||((obi.getX()==10 || obi.getX()==33 || obi.getX()==263 || obi.getX()==79 || obi.getX()==125 || obi.getX()==148 || obi.getX()==171 || obi.getX()==194 || obi.getX()==217 || obi.getX()==240 || obi.getX()==286) && obi.getY()==286 )
    		||((obi.getX()==79 || obi.getX()==148 || obi.getX()==217) && obi.getY()==309 )
    		||((obi.getX()==79 || obi.getX()==171) && obi.getY()==332) ){
    		Mouv_XD=false;
    	}else {
    		Mouv_XD=true;
    	}
    }
    private void Mouvement1D_M() {
    	//System.out.println(obi.getX() + " / " + obi.getY());
    	if((((ana.getX1()==33 || ana.getX1()==56 || ana.getX1()==79 ) && ana.getY1()==33)
    		||((ana.getX1()==33 || ana.getX1()==56 || ana.getX1()==79 || ana.getX1()==263) && ana.getY1()==56)
    		||((ana.getX1()==33 || ana.getX1()==56 || ana.getX1()==79 || ana.getX1()==102 || ana.getX1()==148) && ana.getY1()==79)
    		||((ana.getX1()==79 || ana.getX1()==102 || ana.getX1()==240 || ana.getX1()==309 ) && ana.getY1()==102)
    		||((ana.getX1()==79 || ana.getX1()==102 || ana.getX1()==217 || ana.getX1()==263 || ana.getX1()==309) && ana.getY1()==125)
    		||((ana.getX1()==10 || ana.getX1()==79 || ana.getX1()==102 || ana.getX1()==125 || ana.getX1()==263 || ana.getX1()==286 || ana.getX1()==309) && ana.getY1()==148)
    		||((ana.getX1()==10 || ana.getX1()==33 || ana.getX1()==56 || ana.getX1()==79 || ana.getX1()==102 || ana.getX1()==125 || ana.getX1()==148 || ana.getX1()==171 || ana.getX1()==194 || obi.getX()==240 || ana.getX1()==263 || ana.getX1()==286 || ana.getX1()==309) && ana.getY1()==194)
    		||((ana.getX1()==10 || ana.getX1()==33 || ana.getX1()==56 || ana.getX1()==79 || ana.getX1()==102 || ana.getX1()==125 || ana.getX1()==148 || ana.getX1()==171 || ana.getX1()==194 || ana.getX1()==240 || ana.getX1()==263 || ana.getX1()==286 || ana.getX1()==309) && ana.getY1()==217)
    		||((ana.getX1()==10 || ana.getX1()==33 || ana.getX1()==56 || ana.getX1()==79 || ana.getX1()==102 || ana.getX1()==125 || ana.getX1()==148 || ana.getX1()==171 || ana.getX1()==194 || ana.getX1()==240 || ana.getX1()==263 || ana.getX1()==286 || ana.getX1()==309) && ana.getY1()==240)
    		||((ana.getX1()==10 || ana.getX1()==33 || ana.getX1()==56 || ana.getX1()==79 || ana.getX1()==125 || ana.getX1()==148 || ana.getX1()==171 ||ana.getX1()==194 || ana.getX1()==217 || ana.getX1()==240 || ana.getX1()==286) && ana.getY1()==263 )
    		||((ana.getX1()==10 || ana.getX1()==33 || ana.getX1()==263 || ana.getX1()==79 || ana.getX1()==125 || ana.getX1()==148 || ana.getX1()==171 || ana.getX1()==194 || ana.getX1()==217 || ana.getX1()==240 || ana.getX1()==286) && ana.getY1()==286 )
    		||((ana.getX1()==79 || ana.getX1()==148 || ana.getX1()==217) && ana.getY1()==309 )
    		||((ana.getX1()==79 || ana.getX1()==171) && ana.getY1()==332))&&CanDead==true ){
    		int a = ana.genererInt2(-20,20);//pour les y
    		int b = ana.genererInt(-20, 20);//pour les x
    		if(a>0 && b>0) {
    			ana.setY1(1);
        		ana.setX1(0);
    		}
    		if(a>0 && b<0) {
    			ana.setY1(1);
        		ana.setX1(0);
    		}
    		if(a<0 && b>0) {
    			ana.setY1(-1);
        		ana.setX1(0);
    		}
    		if(a<0 && b<0) {
    			ana.setY1(-1);
        		ana.setX1(0);
    		}
    	}
    	if(CanDead==false) {
    		ana.setX1(0);
    		ana.setY1(0);
    	}
    }
    private void Mouvement11D_M() {
    	//System.out.println(obi.getX() + " / " + obi.getY());
    	if((((ana1.getX1()==33 || ana1.getX1()==56 || ana1.getX1()==79 ) && ana1.getY1()==33)
    		||((ana1.getX1()==33 || ana1.getX1()==56 || ana1.getX1()==79 || ana1.getX1()==263) && ana1.getY1()==56)
    		||((ana1.getX1()==33 || ana1.getX1()==56 || ana1.getX1()==79 || ana1.getX1()==102 || ana1.getX1()==148) && ana1.getY1()==79)
    		||((ana1.getX1()==79 || ana1.getX1()==102 || ana1.getX1()==240 || ana1.getX1()==309 ) && ana1.getY1()==102)
    		||((ana1.getX1()==79 || ana1.getX1()==102 || ana1.getX1()==217 || ana1.getX1()==263 || ana1.getX1()==309) && ana1.getY1()==125)
    		||((ana1.getX1()==10 || ana1.getX1()==79 || ana1.getX1()==102 || ana1.getX1()==125 || ana1.getX1()==263 || ana1.getX1()==286 || ana1.getX1()==309) && ana1.getY1()==148)
    		||((ana1.getX1()==10 || ana1.getX1()==33 || ana1.getX1()==56 || ana1.getX1()==79 || ana1.getX1()==102 || ana1.getX1()==125 || ana1.getX1()==148 || ana1.getX1()==171 || ana1.getX1()==194 || ana1.getX1()==240 || ana1.getX1()==263 || ana1.getX1()==286 || ana1.getX1()==309) && ana1.getY1()==194)
    		||((ana1.getX1()==10 || ana1.getX1()==33 || ana1.getX1()==56 || ana1.getX1()==79 || ana1.getX1()==102 || ana1.getX1()==125 || ana1.getX1()==148 || ana1.getX1()==171 || ana1.getX1()==194 || ana1.getX1()==240 || ana1.getX1()==263 || ana1.getX1()==286 || ana1.getX1()==309) && ana1.getY1()==217)
    		||((ana1.getX1()==10 || ana1.getX1()==33 || ana1.getX1()==56 || ana1.getX1()==79 || ana1.getX1()==102 || ana1.getX1()==125 || ana1.getX1()==148 || ana1.getX1()==171 || ana1.getX1()==194 || ana1.getX1()==240 || ana1.getX1()==263 || ana1.getX1()==286 || ana1.getX1()==309) && ana1.getY1()==240)
    		||((ana1.getX1()==10 || ana1.getX1()==33 || ana1.getX1()==56 || ana1.getX1()==79 || ana1.getX1()==125 || ana1.getX1()==148 || ana1.getX1()==171 ||ana1.getX1()==194 || ana1.getX1()==217 || ana1.getX1()==240 || ana1.getX1()==286) && ana1.getY1()==263 )
    		||((ana1.getX1()==10 || ana1.getX1()==33 || ana1.getX1()==263 || ana1.getX1()==79 || ana1.getX1()==125 || ana1.getX1()==148 || ana1.getX1()==171 || ana1.getX1()==194 || ana1.getX1()==217 || ana1.getX1()==240 || ana1.getX1()==286) && ana1.getY1()==286 )
    		||((ana1.getX1()==79 || ana1.getX1()==148 || ana1.getX1()==217) && ana1.getY1()==309 )
    		||((ana1.getX1()==79 || ana1.getX1()==171) && ana1.getY1()==332))&&CanDead1==true ){
    		int a = ana1.genererInt2(-20,20);//pour les y
    		int b = ana1.genererInt(-20, 20);//pour les x
    		if(a>0 && b>0) {
    			ana1.setY1(1);
        		ana1.setX1(0);
    		}
    		if(a>0 && b<0) {
    			ana1.setY1(1);
        		ana1.setX1(0);
    		}
    		if(a<0 && b>0) {
    			ana1.setY1(-1);
        		ana1.setX1(0);
    		}
    		if(a<0 && b<0) {
    			ana1.setY1(-1);
        		ana1.setX1(0);
    		}
    	}
    	if(CanDead1==false) {
    		ana1.setX1(0);
    		ana1.setY1(0);
    	}
    }
    private void Mouvement12D_M() {
    	//System.out.println(obi.getX() + " / " + obi.getY());
    	if((((ana2.getX1()==33 || ana2.getX1()==56 || ana2.getX1()==79 ) && ana2.getY1()==33)
    		||((ana2.getX1()==33 || ana2.getX1()==56 || ana2.getX1()==79 || ana2.getX1()==263) && ana2.getY1()==56)
    		||((ana2.getX1()==33 || ana2.getX1()==56 || ana2.getX1()==79 || ana2.getX1()==102 || ana2.getX1()==148) && ana2.getY1()==79)
    		||((ana2.getX1()==79 || ana2.getX1()==102 || ana2.getX1()==240 || ana2.getX1()==309 ) && ana2.getY1()==102)
    		||((ana2.getX1()==79 || ana2.getX1()==102 || ana2.getX1()==217 || ana2.getX1()==263 || ana2.getX1()==309) && ana2.getY1()==125)
    		||((ana2.getX1()==10 || ana2.getX1()==79 || ana2.getX1()==102 || ana2.getX1()==125 || ana2.getX1()==263 || ana2.getX1()==286 || ana2.getX1()==309) && ana2.getY1()==148)
    		||((ana2.getX1()==10 || ana2.getX1()==33 || ana2.getX1()==56 || ana2.getX1()==79 || ana2.getX1()==102 || ana2.getX1()==125 || ana2.getX1()==148 || ana2.getX1()==171 || ana2.getX1()==194 || ana2.getX1()==240 || ana2.getX1()==263 || ana2.getX1()==286 || ana2.getX1()==309) && ana2.getY1()==194)
    		||((ana2.getX1()==10 || ana2.getX1()==33 || ana2.getX1()==56 || ana2.getX1()==79 || ana2.getX1()==102 || ana2.getX1()==125 || ana2.getX1()==148 || ana2.getX1()==171 || ana2.getX1()==194 || ana2.getX1()==240 || ana2.getX1()==263 || ana2.getX1()==286 || ana2.getX1()==309) && ana2.getY1()==217)
    		||((ana2.getX1()==10 || ana2.getX1()==33 || ana2.getX1()==56 || ana2.getX1()==79 || ana2.getX1()==102 || ana2.getX1()==125 || ana2.getX1()==148 || ana2.getX1()==171 || ana2.getX1()==194 || ana2.getX1()==240 || ana2.getX1()==263 || ana2.getX1()==286 || ana2.getX1()==309) && ana2.getY1()==240)
    		||((ana2.getX1()==10 || ana2.getX1()==33 || ana2.getX1()==56 || ana2.getX1()==79 || ana2.getX1()==125 || ana2.getX1()==148 || ana2.getX1()==171 ||ana2.getX1()==194 || ana2.getX1()==217 || ana2.getX1()==240 || ana2.getX1()==286) && ana2.getY1()==263 )
    		||((ana2.getX1()==10 || ana2.getX1()==33 || ana2.getX1()==263 || ana2.getX1()==79 || ana2.getX1()==125 || ana2.getX1()==148 || ana2.getX1()==171 || ana2.getX1()==194 || ana2.getX1()==217 || ana2.getX1()==240 || ana2.getX1()==286) && ana2.getY1()==286 )
    		||((ana2.getX1()==79 || ana2.getX1()==148 || ana2.getX1()==217) && ana2.getY1()==309 )
    		||((ana2.getX1()==79 || ana2.getX1()==171) && ana2.getY1()==332))&&CanDead2==true ){
    		int a = ana2.genererInt2(-20,20);//pour les y
    		int b = ana2.genererInt(-20, 20);//pour les x
    		if(a>0 && b>0) {
    			ana2.setY1(1);
        		ana2.setX1(0);
    		}
    		if(a>0 && b<0) {
    			ana2.setY1(1);
        		ana2.setX1(0);
    		}
    		if(a<0 && b>0) {
    			ana2.setY1(-1);
        		ana2.setX1(0);
    		}
    		if(a<0 && b<0) {
    			ana2.setY1(-1);
        		ana2.setX1(0);
    		}
    	}
    	if(CanDead2==false) {
    		ana2.setX1(0);
    		ana2.setY1(0);
    	}
    }
    private void Mouvement13D_M() {
    	//System.out.println(obi.getX() + " / " + obi.getY());
    	if((((ana3.getX1()==33 || ana3.getX1()==56 || ana3.getX1()==79 ) && ana3.getY1()==33)
    		||((ana3.getX1()==33 || ana3.getX1()==56 || ana3.getX1()==79 || ana3.getX1()==263) && ana3.getY1()==56)
    		||((ana3.getX1()==33 || ana3.getX1()==56 || ana3.getX1()==79 || ana3.getX1()==102 || ana3.getX1()==148) && ana3.getY1()==79)
    		||((ana3.getX1()==79 || ana3.getX1()==102 || ana3.getX1()==240 || ana3.getX1()==309 ) && ana3.getY1()==102)
    		||((ana3.getX1()==79 || ana3.getX1()==102 || ana3.getX1()==217 || ana3.getX1()==263 || ana3.getX1()==309) && ana3.getY1()==125)
    		||((ana3.getX1()==10 || ana3.getX1()==79 || ana3.getX1()==102 || ana3.getX1()==125 || ana3.getX1()==263 || ana3.getX1()==286 || ana3.getX1()==309) && ana3.getY1()==148)
    		||((ana3.getX1()==10 || ana3.getX1()==33 || ana3.getX1()==56 || ana3.getX1()==79 || ana3.getX1()==102 || ana3.getX1()==125 || ana3.getX1()==148 || ana3.getX1()==171 || ana3.getX1()==194 || ana3.getX1()==240 || ana3.getX1()==263 || ana3.getX1()==286 || ana3.getX1()==309) && ana3.getY1()==194)
    		||((ana3.getX1()==10 || ana3.getX1()==33 || ana3.getX1()==56 || ana3.getX1()==79 || ana3.getX1()==102 || ana3.getX1()==125 || ana3.getX1()==148 || ana3.getX1()==171 || ana3.getX1()==194 || ana3.getX1()==240 || ana3.getX1()==263 || ana3.getX1()==286 || ana3.getX1()==309) && ana3.getY1()==217)
    		||((ana3.getX1()==10 || ana3.getX1()==33 || ana3.getX1()==56 || ana3.getX1()==79 || ana3.getX1()==102 || ana3.getX1()==125 || ana3.getX1()==148 || ana3.getX1()==171 || ana3.getX1()==194 || ana3.getX1()==240 || ana3.getX1()==263 || ana3.getX1()==286 || ana3.getX1()==309) && ana3.getY1()==240)
    		||((ana3.getX1()==10 || ana3.getX1()==33 || ana3.getX1()==56 || ana3.getX1()==79 || ana3.getX1()==125 || ana3.getX1()==148 || ana3.getX1()==171 ||ana3.getX1()==194 || ana3.getX1()==217 || ana3.getX1()==240 || ana3.getX1()==286) && ana3.getY1()==263 )
    		||((ana3.getX1()==10 || ana3.getX1()==33 || ana3.getX1()==263 || ana3.getX1()==79 || ana3.getX1()==125 || ana3.getX1()==148 || ana3.getX1()==171 || ana3.getX1()==194 || ana3.getX1()==217 || ana3.getX1()==240 || ana3.getX1()==286) && ana3.getY1()==286 )
    		||((ana3.getX1()==79 || ana3.getX1()==148 || ana3.getX1()==217) && ana3.getY1()==309 )
    		||((ana3.getX1()==79 || ana3.getX1()==171) && ana3.getY1()==332))&&CanDead2==true ){
    		int a = ana3.genererInt2(-20,20);//pour les y
    		int b = ana3.genererInt(-20, 20);//pour les x
    		if(a>0 && b>0) {
    			ana3.setY1(1);
        		ana3.setX1(0);
    		}
    		if(a>0 && b<0) {
    			ana3.setY1(1);
        		ana3.setX1(0);
    		}
    		if(a<0 && b>0) {
    			ana3.setY1(-1);
        		ana3.setX1(0);
    		}
    		if(a<0 && b<0) {
    			ana3.setY1(-1);
        		ana3.setX1(0);
    		}
    	}
    	if(CanDead3==false) {
    		ana3.setX1(0);
    		ana3.setY1(0);
    	}
    }
    
    
    
    private void Mouvement1G_M() {
    	//System.out.println(obi.getX() + " / " + obi.getY());
    	if((((ana.getX1()==56 || ana.getX1()==79 || ana.getX1()==102) && ana.getY1()==33)
    		||((ana.getX1()==56 || ana.getX1()==79 ||ana.getX1()==102 || ana.getX1()==286) && ana.getY1()==56)
    		||((ana.getX1()==56 || ana.getX1()==79 || ana.getX1()==102 || ana.getX1()==125 || ana.getX1()==171) && ana.getY1()==79)
    		||((ana.getX1()==102 || ana.getX1()==125 || ana.getX1()==263 || ana.getX1()==332 || ana.getX1()-23==263) && ana.getY1()==102)
    		||((ana.getX1()==102 || ana.getX1()==125 || ana.getX1()==240 || ana.getX1()==286 || ana.getX1()==332) && ana.getY1()==125)
    		||((ana.getX1()==33 || ana.getX1()==102 || ana.getX1()==125 || ana.getX1()==148 || ana.getX1()==286 || ana.getX1()==309 || ana.getX1()==332) && ana.getY1()==148)
    		||((ana.getX1()==33 || ana.getX1()==148|| ana.getX1()==171 || ana.getX1()==194 || ana.getX1()==217 || ana.getX1()==286 || ana.getX1()==309 ) && ana.getY1()==171)
    		||((ana.getX1()==33 || ana.getX1()==56 || ana.getX1()==79 || ana.getX1()==102 || ana.getX1()==125 || ana.getX1()==148 || ana.getX1()==171 || ana.getX1()==194 || ana.getX1()==217 || ana.getX1()==263 || ana.getX1()==286 || ana.getX1()==309 || ana.getX1()==332 ) && ana.getY1()==194)
    		||((ana.getX1()==33 || ana.getX1()==56 || ana.getX1()==79 || ana.getX1()==102 || ana.getX1()==125 || ana.getX1()==148 || ana.getX1()==171 || ana.getX1()==194 || ana.getX1()==217 || ana.getX1()==263 || ana.getX1()==286 || ana.getX1()==309 || ana.getX1()==332 ) && ana.getY1()==217)
    		||((ana.getX1()==33 || ana.getX1()==56 || ana.getX1()==79 || ana.getX1()==102 || ana.getX1()==125 || ana.getX1()==148 || ana.getX1()==171 || ana.getX1()==194 || ana.getX1()==217 || ana.getX1()==263 || ana.getX1()==286 || ana.getX1()==309 || ana.getX1()==332 ) && ana.getY1()==240)
    		||((ana.getX1()==33 || ana.getX1()==56 || ana.getX1()==79 || ana.getX1()==102 || ana.getX1()==148 || ana.getX1()==171 || ana.getX1()==194 || ana.getX1()==217 || ana.getX1()==240 || ana.getX1()==263 || ana.getX1()==309  ) && ana.getY1()==263 )
    		||((ana.getX1()==33 || ana.getX1()==56 || ana.getX1()==286 || ana.getX1()==102 || ana.getX1()==148 || ana.getX1()==171 || ana.getX1()==194 || ana.getX1()==217 || ana.getX1()==240 || ana.getX1()==263 || ana.getX1()==309  ) && ana.getY1()==286 )
    		||((ana.getX1()==102 || ana.getX1()==171 || ana.getX1()==240  ) && ana.getY1()==309 )
    		||((ana.getX1()==102 || ana.getX1()==194  ) && ana.getY1()==332))&& CanDead==true ){
    		int a = ana.genererInt2(-20,20);//pour les y
    		int b = ana.genererInt(-20, 20);//pour les x 
    		if(a>0 && b>0) {
    			ana.setY1(1);
        		ana.setX1(1);
    		}
    		if(a>0 && b<0) {
    			ana.setY1(1);
        		ana.setX1(0);
    		}
    		if(a<0 && b>0) {
    			ana.setY1(-1);
        		ana.setX1(1);
    		}
    		if(a<0 && b<0) {
    			ana.setY1(-1);
        		ana.setX1(0);
    		}
    	}else {
    		int c = ana.genererInt2(-1,1);//x
    		int d = ana.genererInt(-1, 1);//y
    		ana.setY1(c);
    		ana.setX1(d);
    }
    	if(CanDead==false) {
    		ana.setX1(0);
    		ana.setY1(0);
    	}
  }
    private void Mouvement11G_M() {
    	//System.out.println(obi.getX() + " / " + obi.getY());
    	if((((ana1.getX1()==56 || ana1.getX1()==79 || ana1.getX1()==102) && ana1.getY1()==33)
    		||((ana1.getX1()==56 || ana1.getX1()==79 ||ana1.getX1()==102 || ana1.getX1()==286) && ana1.getY1()==56)
    		||((ana1.getX1()==56 || ana1.getX1()==79 || ana1.getX1()==102 || ana1.getX1()==125 || ana1.getX1()==171) && ana1.getY1()==79)
    		||((ana1.getX1()==102 || ana1.getX1()==125 || ana1.getX1()==263 || ana1.getX1()==332 || ana1.getX1()-23==263) && ana1.getY1()==102)
    		||((ana1.getX1()==102 || ana1.getX1()==125 || ana1.getX1()==240 || ana1.getX1()==286 || ana1.getX1()==332) && ana1.getY1()==125)
    		||((ana1.getX1()==33 || ana1.getX1()==102 || ana1.getX1()==125 || ana1.getX1()==148 || ana1.getX1()==286 || ana1.getX1()==309 || ana1.getX1()==332) && ana1.getY1()==148)
    		||((ana1.getX1()==33 || ana1.getX1()==148|| ana1.getX1()==171 || ana1.getX1()==194 || ana1.getX1()==217 || ana1.getX1()==286 || ana1.getX1()==309 ) && ana1.getY1()==171)
    		||((ana1.getX1()==33 || ana1.getX1()==56 || ana1.getX1()==79 || ana1.getX1()==102 || ana1.getX1()==125 || ana1.getX1()==148 || ana1.getX1()==171 || ana1.getX1()==194 || ana1.getX1()==217 || ana1.getX1()==263 || ana1.getX1()==286 || ana1.getX1()==309 || ana1.getX1()==332 ) && ana1.getY1()==194)
    		||((ana1.getX1()==33 || ana1.getX1()==56 || ana1.getX1()==79 || ana1.getX1()==102 || ana1.getX1()==125 || ana1.getX1()==148 || ana1.getX1()==171 || ana1.getX1()==194 || ana1.getX1()==217 || ana1.getX1()==263 || ana1.getX1()==286 || ana1.getX1()==309 || ana1.getX1()==332 ) && ana1.getY1()==217)
    		||((ana1.getX1()==33 || ana1.getX1()==56 || ana1.getX1()==79 || ana1.getX1()==102 || ana1.getX1()==125 || ana1.getX1()==148 || ana1.getX1()==171 || ana1.getX1()==194 || ana1.getX1()==217 || ana1.getX1()==263 || ana1.getX1()==286 || ana1.getX1()==309 || ana1.getX1()==332 ) && ana1.getY1()==240)
    		||((ana1.getX1()==33 || ana1.getX1()==56 || ana1.getX1()==79 || ana1.getX1()==102 || ana1.getX1()==148 || ana1.getX1()==171 || ana1.getX1()==194 || ana1.getX1()==217 || ana1.getX1()==240 || ana1.getX1()==263 || ana1.getX1()==309  ) && ana1.getY1()==263 )
    		||((ana1.getX1()==33 || ana1.getX1()==56 || ana1.getX1()==286 || ana1.getX1()==102 || ana1.getX1()==148 || ana1.getX1()==171 || ana1.getX1()==194 || ana1.getX1()==217 || ana1.getX1()==240 || ana1.getX1()==263 || ana1.getX1()==309  ) && ana1.getY1()==286 )
    		||((ana1.getX1()==102 || ana1.getX1()==171 || ana1.getX1()==240  ) && ana1.getY1()==309 )
    		||((ana1.getX1()==102 || ana1.getX1()==194  ) && ana1.getY1()==332))&& CanDead1==true ){
    		int a = ana1.genererInt2(-20,20);//pour les y
    		int b = ana1.genererInt(-20, 20);//pour les x 
    		if(a>0 && b>0) {
    			ana1.setY1(1);
        		ana1.setX1(1);
    		}
    		if(a>0 && b<0) {
    			ana1.setY1(1);
        		ana1.setX1(0);
    		}
    		if(a<0 && b>0) {
    			ana1.setY1(-1);
        		ana1.setX1(1);
    		}
    		if(a<0 && b<0) {
    			ana1.setY1(-1);
        		ana1.setX1(0);
    		}
    	}else {
    		int c = ana1.genererInt2(-1,1);//x
    		int d = ana1.genererInt(-1, 1);//y
    		ana1.setY1(c);
    		ana1.setX1(d);
    }
    	if(CanDead1==false) {
    		ana1.setX1(0);
    		ana1.setY1(0);
    	}
  }
    private void Mouvement12G_M() {
    	//System.out.println(obi.getX() + " / " + obi.getY());
    	if((((ana2.getX1()==56 || ana2.getX1()==79 || ana2.getX1()==102) && ana2.getY1()==33)
    		||((ana2.getX1()==56 || ana2.getX1()==79 ||ana2.getX1()==102 || ana2.getX1()==286) && ana2.getY1()==56)
    		||((ana2.getX1()==56 || ana2.getX1()==79 || ana2.getX1()==102 || ana2.getX1()==125 || ana2.getX1()==171) && ana2.getY1()==79)
    		||((ana2.getX1()==102 || ana2.getX1()==125 || ana2.getX1()==263 || ana2.getX1()==332 || ana2.getX1()-23==263) && ana2.getY1()==102)
    		||((ana2.getX1()==102 || ana2.getX1()==125 || ana2.getX1()==240 || ana2.getX1()==286 || ana2.getX1()==332) && ana2.getY1()==125)
    		||((ana2.getX1()==33 || ana2.getX1()==102 || ana2.getX1()==125 || ana2.getX1()==148 || ana2.getX1()==286 || ana2.getX1()==309 || ana2.getX1()==332) && ana2.getY1()==148)
    		||((ana2.getX1()==33 || ana2.getX1()==148|| ana2.getX1()==171 || ana2.getX1()==194 || ana2.getX1()==217 || ana2.getX1()==286 || ana2.getX1()==309 ) && ana2.getY1()==171)
    		||((ana2.getX1()==33 || ana2.getX1()==56 || ana2.getX1()==79 || ana2.getX1()==102 || ana2.getX1()==125 || ana2.getX1()==148 || ana2.getX1()==171 || ana2.getX1()==194 || ana2.getX1()==217 || ana2.getX1()==263 || ana2.getX1()==286 || ana2.getX1()==309 || ana2.getX1()==332 ) && ana2.getY1()==194)
    		||((ana2.getX1()==33 || ana2.getX1()==56 || ana2.getX1()==79 || ana2.getX1()==102 || ana2.getX1()==125 || ana2.getX1()==148 || ana2.getX1()==171 || ana2.getX1()==194 || ana2.getX1()==217 || ana2.getX1()==263 || ana2.getX1()==286 || ana2.getX1()==309 || ana2.getX1()==332 ) && ana2.getY1()==217)
    		||((ana2.getX1()==33 || ana2.getX1()==56 || ana2.getX1()==79 || ana2.getX1()==102 || ana2.getX1()==125 || ana2.getX1()==148 || ana2.getX1()==171 || ana2.getX1()==194 || ana2.getX1()==217 || ana2.getX1()==263 || ana2.getX1()==286 || ana2.getX1()==309 || ana2.getX1()==332 ) && ana2.getY1()==240)
    		||((ana2.getX1()==33 || ana2.getX1()==56 || ana2.getX1()==79 || ana2.getX1()==102 || ana2.getX1()==148 || ana2.getX1()==171 || ana2.getX1()==194 || ana2.getX1()==217 || ana2.getX1()==240 || ana2.getX1()==263 || ana2.getX1()==309  ) && ana2.getY1()==263 )
    		||((ana2.getX1()==33 || ana2.getX1()==56 || ana2.getX1()==286 || ana2.getX1()==102 || ana2.getX1()==148 || ana2.getX1()==171 || ana2.getX1()==194 || ana2.getX1()==217 || ana2.getX1()==240 || ana2.getX1()==263 || ana2.getX1()==309  ) && ana2.getY1()==286 )
    		||((ana2.getX1()==102 || ana2.getX1()==171 || ana2.getX1()==240  ) && ana2.getY1()==309 )
    		||((ana2.getX1()==102 || ana2.getX1()==194  ) && ana2.getY1()==332))&& CanDead2==true ){
    		int a = ana2.genererInt2(-20,20);//pour les y
    		int b = ana2.genererInt(-20, 20);//pour les x 
    		if(a>0 && b>0) {
    			ana2.setY1(1);
        		ana2.setX1(1);
    		}
    		if(a>0 && b<0) {
    			ana2.setY1(1);
        		ana2.setX1(0);
    		}
    		if(a<0 && b>0) {
    			ana2.setY1(-1);
        		ana2.setX1(1);
    		}
    		if(a<0 && b<0) {
    			ana2.setY1(-1);
        		ana2.setX1(0);
    		}
    	}else {
    		int c = ana2.genererInt2(-1,1);//x
    		int d = ana2.genererInt(-1, 1);//y
    		ana2.setY1(c);
    		ana2.setX1(d);
    }
    	if(CanDead2==false) {
    		ana2.setX1(0);
    		ana2.setY1(0);
    	}
  }
    private void Mouvement13G_M() {
    	//System.out.println(obi.getX() + " / " + obi.getY());
    	if((((ana3.getX1()==56 || ana3.getX1()==79 || ana3.getX1()==102) && ana3.getY1()==33)
    		||((ana3.getX1()==56 || ana3.getX1()==79 ||ana3.getX1()==102 || ana3.getX1()==286) && ana3.getY1()==56)
    		||((ana3.getX1()==56 || ana3.getX1()==79 || ana3.getX1()==102 || ana3.getX1()==125 || ana3.getX1()==171) && ana3.getY1()==79)
    		||((ana3.getX1()==102 || ana3.getX1()==125 || ana3.getX1()==263 || ana3.getX1()==332 || ana3.getX1()-23==263) && ana3.getY1()==102)
    		||((ana3.getX1()==102 || ana3.getX1()==125 || ana3.getX1()==240 || ana3.getX1()==286 || ana3.getX1()==332) && ana3.getY1()==125)
    		||((ana3.getX1()==33 || ana3.getX1()==102 || ana3.getX1()==125 || ana3.getX1()==148 || ana3.getX1()==286 || ana3.getX1()==309 || ana3.getX1()==332) && ana3.getY1()==148)
    		||((ana3.getX1()==33 || ana3.getX1()==148|| ana3.getX1()==171 || ana3.getX1()==194 || ana3.getX1()==217 || ana3.getX1()==286 || ana3.getX1()==309 ) && ana3.getY1()==171)
    		||((ana3.getX1()==33 || ana3.getX1()==56 || ana3.getX1()==79 || ana3.getX1()==102 || ana3.getX1()==125 || ana3.getX1()==148 || ana3.getX1()==171 || ana3.getX1()==194 || ana3.getX1()==217 || ana3.getX1()==263 || ana3.getX1()==286 || ana3.getX1()==309 || ana3.getX1()==332 ) && ana3.getY1()==194)
    		||((ana3.getX1()==33 || ana3.getX1()==56 || ana3.getX1()==79 || ana3.getX1()==102 || ana3.getX1()==125 || ana3.getX1()==148 || ana3.getX1()==171 || ana3.getX1()==194 || ana3.getX1()==217 || ana3.getX1()==263 || ana3.getX1()==286 || ana3.getX1()==309 || ana3.getX1()==332 ) && ana3.getY1()==217)
    		||((ana3.getX1()==33 || ana3.getX1()==56 || ana3.getX1()==79 || ana3.getX1()==102 || ana3.getX1()==125 || ana3.getX1()==148 || ana3.getX1()==171 || ana3.getX1()==194 || ana3.getX1()==217 || ana3.getX1()==263 || ana3.getX1()==286 || ana3.getX1()==309 || ana3.getX1()==332 ) && ana3.getY1()==240)
    		||((ana3.getX1()==33 || ana3.getX1()==56 || ana3.getX1()==79 || ana3.getX1()==102 || ana3.getX1()==148 || ana3.getX1()==171 || ana3.getX1()==194 || ana3.getX1()==217 || ana3.getX1()==240 || ana3.getX1()==263 || ana3.getX1()==309  ) && ana3.getY1()==263 )
    		||((ana3.getX1()==33 || ana3.getX1()==56 || ana3.getX1()==286 || ana3.getX1()==102 || ana3.getX1()==148 || ana3.getX1()==171 || ana3.getX1()==194 || ana3.getX1()==217 || ana3.getX1()==240 || ana3.getX1()==263 || ana3.getX1()==309  ) && ana3.getY1()==286 )
    		||((ana3.getX1()==102 || ana3.getX1()==171 || ana3.getX1()==240  ) && ana3.getY1()==309 )
    		||((ana3.getX1()==102 || ana3.getX1()==194  ) && ana3.getY1()==332))&& CanDead3==true ){
    		int a = ana3.genererInt2(-20,20);//pour les y
    		int b = ana3.genererInt(-20, 20);//pour les x 
    		if(a>0 && b>0) {
    			ana3.setY1(1);
        		ana3.setX1(1);
    		}
    		if(a>0 && b<0) {
    			ana3.setY1(1);
        		ana3.setX1(0);
    		}
    		if(a<0 && b>0) {
    			ana3.setY1(-1);
        		ana3.setX1(1);
    		}
    		if(a<0 && b<0) {
    			ana3.setY1(-1);
        		ana3.setX1(0);
    		}
    	}else {
    		int c = ana3.genererInt2(-1,1);//x
    		int d = ana3.genererInt(-1, 1);//y
    		ana3.setY1(c);
    		ana3.setX1(d);
    }
    	if(CanDead3==false) {
    		ana3.setX1(0);
    		ana3.setY1(0);
    	}
  }
    private void Mouvement1G() {
    	//System.out.println(obi.getX() + " / " + obi.getY());
    	if(((obi.getX()==56 || obi.getX()==79 || obi.getX()==102) && obi.getY()==33)
    		||((obi.getX()==56 || obi.getX()==79 || obi.getX()==102 || obi.getX()==286) && obi.getY()==56)
    		||((obi.getX()==56 || obi.getX()==79 || obi.getX()==102 || obi.getX()==125 || obi.getX()==171) && obi.getY()==79)
    		||((obi.getX()==102 || obi.getX()==125 || obi.getX()==263 || obi.getX()==332 || obi.getX()-23==263) && obi.getY()==102)
    		||((obi.getX()==102 || obi.getX()==125 || obi.getX()==240 || obi.getX()==286 || obi.getX()==332) && obi.getY()==125)
    		||((obi.getX()==33 || obi.getX()==102 || obi.getX()==125 || obi.getX()==148 || obi.getX()==286 || obi.getX()==309 || obi.getX()==332) && obi.getY()==148)
    		||((obi.getX()==33 || obi.getX()==148|| obi.getX()==171 || obi.getX()==194 || obi.getX()==217 || obi.getX()==286 || obi.getX()==309 ) && obi.getY()==171)
    		||((obi.getX()==33 || obi.getX()==56 || obi.getX()==79 || obi.getX()==102 || obi.getX()==125 || obi.getX()==148 || obi.getX()==171 || obi.getX()==194 || obi.getX()==217 || obi.getX()==263 || obi.getX()==286 || obi.getX()==309 || obi.getX()==332 ) && obi.getY()==194)
    		||((obi.getX()==33 || obi.getX()==56 || obi.getX()==79 || obi.getX()==102 || obi.getX()==125 || obi.getX()==148 || obi.getX()==171 || obi.getX()==194 || obi.getX()==217 || obi.getX()==263 || obi.getX()==286 || obi.getX()==309 || obi.getX()==332 ) && obi.getY()==217)
    		||((obi.getX()==33 || obi.getX()==56 || obi.getX()==79 || obi.getX()==102 || obi.getX()==125 || obi.getX()==148 || obi.getX()==171 || obi.getX()==194 || obi.getX()==217 || obi.getX()==263 || obi.getX()==286 || obi.getX()==309 || obi.getX()==332 ) && obi.getY()==240)
    		||((obi.getX()==33 || obi.getX()==56 || obi.getX()==79 || obi.getX()==102 || obi.getX()==148 || obi.getX()==171 || obi.getX()==194 || obi.getX()==217 || obi.getX()==240 || obi.getX()==263 || obi.getX()==309  ) && obi.getY()==263 )
    		||((obi.getX()==33 || obi.getX()==56 || obi.getX()==286 || obi.getX()==102 || obi.getX()==148 || obi.getX()==171 || obi.getX()==194 || obi.getX()==217 || obi.getX()==240 || obi.getX()==263 || obi.getX()==309  ) && obi.getY()==286 )
    		||((obi.getX()==102 || obi.getX()==171 || obi.getX()==240  ) && obi.getY()==309 )
    		||((obi.getX()==102 || obi.getX()==194  ) && obi.getY()==332) ){
    		Mouv_XG=false;
    	}else {
    		Mouv_XG=true;
    	}
    }
    
    private void Mouvement1B() {
    	if((obi.getX()==10 && (obi.getY()==148))
    	   || (obi.getX()==33 &&(obi.getY()==125 ||obi.getY()==171))
    	   || (obi.getX()==56 &&(obi.getY()==79 || obi.getY()==125 || obi.getY()==171))
    	   || (obi.getX()==79 &&(obi.getY()==79 || obi.getY()==125))
    	   || (obi.getX()== 102 &&(obi.getY()==10 || obi.getY()==33 || obi.getY()==171))
    	   || (obi.getX()== 125 &&(obi.getY()==10 || obi.getY()==33 || obi.getY()==56))
    	   || (obi.getX()==148 && (obi.getY()==10 ||obi.getY()==56 || obi.getY()==33 || obi.getY()==56 || obi.getY()==125))
    	   || (obi.getX()==171 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==79 || obi.getY()==102 || obi.getY()==125 || obi.getY()==148))
    	   || (obi.getX()==194 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==79 || obi.getY()==102 || obi.getY()==125 || obi.getY()==263))
    	   || (obi.getX()==217 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==79 || obi.getY()==102 || obi.getY()==125 || obi.getY()==148 || obi.getY()== 309))
    	   || (obi.getX()==240 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==79 || obi.getY()==125 || obi.getY()==148 || obi.getY()==171 || obi.getY()== 309))
    	   || (obi.getX()==263 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==79 || obi.getY()==102 || obi.getY()==148 ||  obi.getY()== 309))
    	   || (obi.getX()==286 && (obi.getY()==79 || obi.getY()==102 || obi.getY()==286 || obi.getY()==309))
    	   || (obi.getX()==309 && (obi.getY()==79 || obi.getY()== 240 || obi.getY()==309))
    	   || (obi.getX()==332 && (obi.getY()==194 || obi.getY()==309))) {
    		Mouv_XB=false;
    	}else {
    		Mouv_XB=true;
    	}
    	
    }
    private void Mouvement1B_M() {
    	if(((ana.getX1()==10 && (ana.getY1()==148))
    	   || (ana.getX1()==33 &&(ana.getY1()==125 ||ana.getY1()==171))
    	   || (ana.getX1()==56 &&(ana.getY1()==79 || ana.getY1()==125 || ana.getY1()==171))
    	   || (ana.getX1()==79 &&(ana.getY1()==79 || ana.getY1()==125))
    	   || (ana.getX1()== 102 &&(ana.getY1()==10 || ana.getY1()==33 || ana.getY1()==171))
    	   || (ana.getX1()== 125 &&(ana.getY1()==10 || ana.getY1()==33 || ana.getY1()==56))
    	   || (ana.getX1()==148 && (ana.getY1()==10 ||ana.getY1()==56 || ana.getY1()==33 || ana.getY1()==56 || ana.getY1()==125))
    	   || (ana.getX1()==171 && (ana.getY1()==10 || ana.getY1()==33 || ana.getY1()==79 || ana.getY1()==102 || ana.getY1()==125 || ana.getY1()==148))
    	   || (ana.getX1()==194 && (ana.getY1()==10 || ana.getY1()==33 || ana.getY1()==79 || ana.getY1()==102 || ana.getY1()==125 || ana.getY1()==263))
    	   || (ana.getX1()==217 && (ana.getY1()==10 || ana.getY1()==33 || ana.getY1()==79 || ana.getY1()==102 || ana.getY1()==125 || ana.getY1()==148 || ana.getY1()== 309))
    	   || (ana.getX1()==240 && (ana.getY1()==10 || ana.getY1()==33 || ana.getY1()==79 || ana.getY1()==125 || ana.getY1()==148 || ana.getY1()==171 || ana.getY1()== 309))
    	   || (ana.getX1()==263 && (ana.getY1()==10 || ana.getY1()==33 || ana.getY1()==79 || ana.getY1()==102 || ana.getY1()==148 ||  ana.getY1()== 309))
    	   || (ana.getX1()==286 && (ana.getY1()==79 || ana.getY1()==102 || ana.getY1()==286 || ana.getY1()==309))
    	   || (ana.getX1()==309 && (ana.getY1()==79 || ana.getY1()== 240 || ana.getY1()==309))
    	   || (ana.getX1()==332 && (ana.getY1()==194 || ana.getY1()==309)))&&CanDead==true) {
    		int a = ana.genererInt2(-20,20);//pour les y
    		int b = ana.genererInt(-20, 20);//pour les x 
    		if(a>0 && b>0) {
    			ana.setY1(0);
        		ana.setX1(1);
    		}
    		if(a>0 && b<0) {
    			ana.setY1(0);
        		ana.setX1(-1);
    		}
    		if(a<0 && b>0) {
    			ana.setY1(-1);
        		ana.setX1(1);
    		}
    		if(a<0 && b<0) {
    			ana.setY1(-1);
        		ana.setX1(-1);
    		}
    	}
    	if(CanDead==false) {
    		ana.setX1(0);
    		ana.setY1(0);
    	}
    	
    }
    private void Mouvement11B_M() {
    	if(((ana1.getX1()==10 && (ana1.getY1()==148))
    	   || (ana1.getX1()==33 &&(ana1.getY1()==125 ||ana1.getY1()==171))
    	   || (ana1.getX1()==56 &&(ana1.getY1()==79 || ana1.getY1()==125 || ana1.getY1()==171))
    	   || (ana1.getX1()==79 &&(ana1.getY1()==79 || ana1.getY1()==125))
    	   || (ana1.getX1()== 102 &&(ana1.getY1()==10 || ana1.getY1()==33 || ana1.getY1()==171))
    	   || (ana1.getX1()== 125 &&(ana1.getY1()==10 || ana1.getY1()==33 || ana1.getY1()==56))
    	   || (ana1.getX1()==148 && (ana1.getY1()==10 ||ana1.getY1()==56 || ana1.getY1()==33 || ana1.getY1()==56 || ana1.getY1()==125))
    	   || (ana1.getX1()==171 && (ana1.getY1()==10 || ana1.getY1()==33 || ana1.getY1()==79 || ana1.getY1()==102 || ana1.getY1()==125 || ana1.getY1()==148))
    	   || (ana1.getX1()==194 && (ana1.getY1()==10 || ana1.getY1()==33 || ana1.getY1()==79 || ana1.getY1()==102 || ana1.getY1()==125 || ana1.getY1()==263))
    	   || (ana1.getX1()==217 && (ana1.getY1()==10 || ana1.getY1()==33 || ana1.getY1()==79 || ana1.getY1()==102 || ana1.getY1()==125 || ana1.getY1()==148 || ana1.getY1()== 309))
    	   || (ana1.getX1()==240 && (ana1.getY1()==10 || ana1.getY1()==33 || ana1.getY1()==79 || ana1.getY1()==125 || ana1.getY1()==148 || ana1.getY1()==171 || ana1.getY1()== 309))
    	   || (ana1.getX1()==263 && (ana1.getY1()==10 || ana1.getY1()==33 || ana1.getY1()==79 || ana1.getY1()==102 || ana1.getY1()==148 ||  ana1.getY1()== 309))
    	   || (ana1.getX1()==286 && (ana1.getY1()==79 || ana1.getY1()==102 || ana1.getY1()==286 || ana1.getY1()==309))
    	   || (ana1.getX1()==309 && (ana1.getY1()==79 || ana1.getY1()== 240 || ana1.getY1()==309))
    	   || (ana1.getX1()==332 && (ana1.getY1()==194 || ana1.getY1()==309)))&&CanDead1==true) {
    		int a = ana1.genererInt2(-20,20);//pour les y
    		int b = ana1.genererInt(-20, 20);//pour les x 
    		if(a>0 && b>0) {
    			ana1.setY1(0);
        		ana1.setX1(1);
    		}
    		if(a>0 && b<0) {
    			ana1.setY1(0);
        		ana1.setX1(-1);
    		}
    		if(a<0 && b>0) {
    			ana1.setY1(-1);
        		ana1.setX1(1);
    		}
    		if(a<0 && b<0) {
    			ana1.setY1(-1);
        		ana1.setX1(-1);
    		}
    	}
    	if(CanDead1==false) {
    		ana1.setX1(0);
    		ana1.setY1(0);
    	}
    	
    }
    private void Mouvement12B_M() {
    	if(((ana2.getX1()==10 && (ana2.getY1()==148))
    	   || (ana2.getX1()==33 &&(ana2.getY1()==125 ||ana2.getY1()==171))
    	   || (ana2.getX1()==56 &&(ana2.getY1()==79 || ana2.getY1()==125 || ana2.getY1()==171))
    	   || (ana2.getX1()==79 &&(ana2.getY1()==79 || ana2.getY1()==125))
    	   || (ana2.getX1()== 102 &&(ana2.getY1()==10 || ana2.getY1()==33 || ana2.getY1()==171))
    	   || (ana2.getX1()== 125 &&(ana2.getY1()==10 || ana2.getY1()==33 || ana2.getY1()==56))
    	   || (ana2.getX1()==148 && (ana2.getY1()==10 ||ana2.getY1()==56 || ana2.getY1()==33 || ana2.getY1()==56 || ana2.getY1()==125))
    	   || (ana2.getX1()==171 && (ana2.getY1()==10 || ana2.getY1()==33 || ana2.getY1()==79 || ana2.getY1()==102 || ana2.getY1()==125 || ana2.getY1()==148))
    	   || (ana2.getX1()==194 && (ana2.getY1()==10 || ana2.getY1()==33 || ana2.getY1()==79 || ana2.getY1()==102 || ana2.getY1()==125 || ana2.getY1()==263))
    	   || (ana2.getX1()==217 && (ana2.getY1()==10 || ana2.getY1()==33 || ana2.getY1()==79 || ana2.getY1()==102 || ana2.getY1()==125 || ana2.getY1()==148 || ana2.getY1()== 309))
    	   || (ana2.getX1()==240 && (ana2.getY1()==10 || ana2.getY1()==33 || ana2.getY1()==79 || ana2.getY1()==125 || ana2.getY1()==148 || ana2.getY1()==171 || ana2.getY1()== 309))
    	   || (ana2.getX1()==263 && (ana2.getY1()==10 || ana2.getY1()==33 || ana2.getY1()==79 || ana2.getY1()==102 || ana2.getY1()==148 ||  ana2.getY1()== 309))
    	   || (ana2.getX1()==286 && (ana2.getY1()==79 || ana2.getY1()==102 || ana2.getY1()==286 || ana2.getY1()==309))
    	   || (ana2.getX1()==309 && (ana2.getY1()==79 || ana2.getY1()== 240 || ana2.getY1()==309))
    	   || (ana2.getX1()==332 && (ana2.getY1()==194 || ana2.getY1()==309)))&&CanDead2==true) {
    		int a = ana2.genererInt2(-20,20);//pour les y
    		int b = ana2.genererInt(-20, 20);//pour les x 
    		if(a>0 && b>0) {
    			ana2.setY1(0);
        		ana2.setX1(1);
    		}
    		if(a>0 && b<0) {
    			ana2.setY1(0);
        		ana2.setX1(-1);
    		}
    		if(a<0 && b>0) {
    			ana2.setY1(-1);
        		ana2.setX1(1);
    		}
    		if(a<0 && b<0) {
    			ana2.setY1(-1);
        		ana2.setX1(-1);
    		}
    	}
    	if(CanDead2==false) {
    		ana2.setX1(0);
    		ana2.setY1(0);
    	}
    	
    }
    private void Mouvement13B_M() {
    	if(((ana3.getX1()==10 && (ana3.getY1()==148))
    	   || (ana3.getX1()==33 &&(ana3.getY1()==125 ||ana3.getY1()==171))
    	   || (ana3.getX1()==56 &&(ana3.getY1()==79 || ana3.getY1()==125 || ana3.getY1()==171))
    	   || (ana3.getX1()==79 &&(ana3.getY1()==79 || ana3.getY1()==125))
    	   || (ana3.getX1()== 102 &&(ana3.getY1()==10 || ana3.getY1()==33 || ana3.getY1()==171))
    	   || (ana3.getX1()== 125 &&(ana3.getY1()==10 || ana3.getY1()==33 || ana3.getY1()==56))
    	   || (ana3.getX1()==148 && (ana3.getY1()==10 ||ana3.getY1()==56 || ana3.getY1()==33 || ana3.getY1()==56 || ana3.getY1()==125))
    	   || (ana3.getX1()==171 && (ana3.getY1()==10 || ana3.getY1()==33 || ana3.getY1()==79 || ana3.getY1()==102 || ana3.getY1()==125 || ana3.getY1()==148))
    	   || (ana3.getX1()==194 && (ana3.getY1()==10 || ana3.getY1()==33 || ana3.getY1()==79 || ana3.getY1()==102 || ana3.getY1()==125 || ana3.getY1()==263))
    	   || (ana3.getX1()==217 && (ana3.getY1()==10 || ana3.getY1()==33 || ana3.getY1()==79 || ana3.getY1()==102 || ana3.getY1()==125 || ana3.getY1()==148 || ana3.getY1()== 309))
    	   || (ana3.getX1()==240 && (ana3.getY1()==10 || ana3.getY1()==33 || ana3.getY1()==79 || ana3.getY1()==125 || ana3.getY1()==148 || ana3.getY1()==171 || ana3.getY1()== 309))
    	   || (ana3.getX1()==263 && (ana3.getY1()==10 || ana3.getY1()==33 || ana3.getY1()==79 || ana3.getY1()==102 || ana3.getY1()==148 ||  ana3.getY1()== 309))
    	   || (ana3.getX1()==286 && (ana3.getY1()==79 || ana3.getY1()==102 || ana3.getY1()==286 || ana3.getY1()==309))
    	   || (ana3.getX1()==309 && (ana3.getY1()==79 || ana3.getY1()== 240 || ana3.getY1()==309))
    	   || (ana3.getX1()==332 && (ana3.getY1()==194 || ana3.getY1()==309)))&&CanDead3==true) {
    		int a = ana3.genererInt2(-20,20);//pour les y
    		int b = ana3.genererInt(-20, 20);//pour les x 
    		if(a>0 && b>0) {
    			ana3.setY1(0);
        		ana3.setX1(1);
    		}
    		if(a>0 && b<0) {
    			ana3.setY1(0);
        		ana3.setX1(-1);
    		}
    		if(a<0 && b>0) {
    			ana3.setY1(-1);
        		ana3.setX1(1);
    		}
    		if(a<0 && b<0) {
    			ana3.setY1(-1);
        		ana3.setX1(-1);
    		}
    	}
    	if(CanDead3==false) {
    		ana3.setX1(0);
    		ana3.setY1(0);
    	}
    	
    }
    private void Mouvement1H() {
    	if((obi.getX()==10 && (obi.getY()==171))
    	    	   || (obi.getX()==33 &&(obi.getY()==148 || obi.getY()==194))
    	    	   || (obi.getX()==56 &&(obi.getY()==102 || obi.getY()==148 || obi.getY()==194))
    	    	   || (obi.getX()==79 &&(obi.getY()==102 || obi.getY()==148))
    	    	   || (obi.getX()== 102 &&(obi.getY()==33 || obi.getY()==56 || obi.getY()==194))
    	    	   || (obi.getX()== 125 &&(obi.getY()==33 || obi.getY()==56 || obi.getY()==79))
    	    	   || (obi.getX()==148 && (obi.getY()==33 || obi.getY()==79 || obi.getY()==56 || obi.getY()==79 || obi.getY()==148))
    	    	   || (obi.getX()==171 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==102 || obi.getY()==125 || obi.getY()==148 || obi.getY()==171))
    	    	   || (obi.getX()==194 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==102 || obi.getY()==125 || obi.getY()==148 || obi.getY()==286))
    	    	   || (obi.getX()==217 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==102 || obi.getY()==125 || obi.getY()==148 || obi.getY()==171 || obi.getY()==332))
    	    	   || (obi.getX()==240 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==102 || obi.getY()==148 || obi.getY()==171 || obi.getY()==194 || obi.getY()==332))
    	    	   || (obi.getX()==263 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==102 || obi.getY()==125 || obi.getY()==171 || obi.getY()==332))
    	    	   || (obi.getX()==286 && (obi.getY()==102 || obi.getY()==125 || obi.getY()==309 || obi.getY()==332))
    	    	   || (obi.getX()==309 && (obi.getY()==102 || obi.getY()==263 || obi.getY()==332))
    	    	   || (obi.getX()==332 && (obi.getY()==217 || obi.getY()==332 ))) {
    	    		Mouv_XH=false;
    	    	}else {
    	    		Mouv_XH=true;
    	    	}
    }
    private void Mouvement1H_M() {
    	if(		   ((ana.getX1()==10 && (ana.getY1()==171))
    	    	   || (ana.getX1()==33 &&(ana.getY1()==148 || ana.getY1()==194))
    	    	   || (ana.getX1()==56 &&(ana.getY1()==102 ||ana.getY1()==148 || ana.getY1()==194))
    	    	   || (ana.getX1()==79 &&(ana.getY1()==102 || ana.getY1()==148))
    	    	   || (ana.getX1()== 102 &&(ana.getY1()==33 || ana.getY1()==56 || ana.getY1()==194))
    	    	   || (ana.getX1()== 125 &&(ana.getY1()==33 || ana.getY1()==56 || ana.getY1()==79))
    	    	   || (ana.getX1()==148 && (ana.getY1()==33 || ana.getY1()==79 || ana.getY1()==56 || ana.getY1()==79 || ana.getY1()==148))
    	    	   || (ana.getX1()==171 && (ana.getY1()==33 ||ana.getY1()==56 || ana.getY1()==102 || ana.getY1()==125 || ana.getY1()==148 || ana.getY1()==171))
    	    	   || (ana.getX1()==194 && (ana.getY1()==33 || ana.getY1()==56 || ana.getY1()==102 || ana.getY1()==125 || ana.getY1()==148 || ana.getY1()==286))
    	    	   || (ana.getX1()==217 && (ana.getY1()==33 || ana.getY1()==56 || ana.getY1()==102 || ana.getY1()==125 || ana.getY1()==148 || ana.getY1()==171 || ana.getY1()==332))
    	    	   || (ana.getX1()==240 && (ana.getY1()==33 || ana.getY1()==56 || ana.getY1()==102 || ana.getY1()==148 || ana.getY1()==171 || ana.getY1()==194 || ana.getY1()==332))
    	    	   || (ana.getX1()==263 && (ana.getY1()==33 || ana.getY1()==56 || ana.getY1()==102 || ana.getY1()==125 || ana.getY1()==171 || ana.getY1()==332))
    	    	   || (ana.getX1()==286 && (ana.getY1()==102 || ana.getY1()==125 || ana.getY1()==309 || ana.getY1()==332))
    	    	   || (ana.getX1()==309 && (ana.getY1()==102 || ana.getY1()==263 || ana.getY1()==332))
    	    	   || (ana.getX1()==332 && (ana.getY1()==217 || ana.getY1()==332 )))&&CanDead==true) {
    			int a = ana.genererInt2(-20,20);//pour les y
    			int b = ana.genererInt(-20, 20);//pour les x 
    			if(a>0 && b>0) {
    			ana.setY1(1);
        		ana.setX1(1);
    			}
    			if(a>0 && b<0) {
    			ana.setY1(1);
        		ana.setX1(-1);
    			}
    			if(a<0 && b>0) {
    			ana.setY1(0);
        		ana.setX1(1);
    			}
    			if(a<0 && b<0) {
    			ana.setY1(0);
        		ana.setX1(-1);
    			}
    		}
    	if(CanDead==false) {
    		ana.setX1(0);
    		ana.setY1(0);
    	}
    }
    private void Mouvement11H_M() {
    	if(		   ((ana1.getX1()==10 && (ana1.getY1()==171))
    	    	   || (ana1.getX1()==33 &&(ana1.getY1()==148 || ana1.getY1()==194))
    	    	   || (ana1.getX1()==56 &&(ana1.getY1()==102 ||ana1.getY1()==148 || ana1.getY1()==194))
    	    	   || (ana1.getX1()==79 &&(ana1.getY1()==102 || ana1.getY1()==148))
    	    	   || (ana1.getX1()== 102 &&(ana1.getY1()==33 || ana1.getY1()==56 || ana1.getY1()==194))
    	    	   || (ana1.getX1()== 125 &&(ana1.getY1()==33 || ana1.getY1()==56 || ana1.getY1()==79))
    	    	   || (ana1.getX1()==148 && (ana1.getY1()==33 || ana1.getY1()==79 || ana1.getY1()==56 || ana1.getY1()==79 || ana1.getY1()==148))
    	    	   || (ana1.getX1()==171 && (ana1.getY1()==33 ||ana1.getY1()==56 || ana1.getY1()==102 || ana1.getY1()==125 || ana1.getY1()==148 || ana1.getY1()==171))
    	    	   || (ana1.getX1()==194 && (ana1.getY1()==33 || ana1.getY1()==56 || ana1.getY1()==102 || ana1.getY1()==125 || ana1.getY1()==148 || ana1.getY1()==286))
    	    	   || (ana1.getX1()==217 && (ana1.getY1()==33 || ana1.getY1()==56 || ana1.getY1()==102 || ana1.getY1()==125 || ana1.getY1()==148 || ana1.getY1()==171 || ana1.getY1()==332))
    	    	   || (ana1.getX1()==240 && (ana1.getY1()==33 || ana1.getY1()==56 || ana1.getY1()==102 || ana1.getY1()==148 || ana1.getY1()==171 || ana1.getY1()==194 || ana1.getY1()==332))
    	    	   || (ana1.getX1()==263 && (ana1.getY1()==33 || ana1.getY1()==56 || ana1.getY1()==102 || ana1.getY1()==125 || ana1.getY1()==171 || ana1.getY1()==332))
    	    	   || (ana1.getX1()==286 && (ana1.getY1()==102 || ana1.getY1()==125 || ana1.getY1()==309 || ana1.getY1()==332))
    	    	   || (ana1.getX1()==309 && (ana1.getY1()==102 || ana1.getY1()==263 || ana1.getY1()==332))
    	    	   || (ana1.getX1()==332 && (ana1.getY1()==217 || ana1.getY1()==332 )))&&CanDead1==true) {
    			int a = ana1.genererInt2(-20,20);//pour les y
    			int b = ana1.genererInt(-20, 20);//pour les x 
    			if(a>0 && b>0) {
    			ana1.setY1(1);
        		ana1.setX1(1);
    			}
    			if(a>0 && b<0) {
    			ana1.setY1(1);
        		ana1.setX1(-1);
    			}
    			if(a<0 && b>0) {
    			ana1.setY1(0);
        		ana1.setX1(1);
    			}
    			if(a<0 && b<0) {
    			ana1.setY1(0);
        		ana1.setX1(-1);
    			}
    		}
    	if(CanDead1==false) {
    		ana1.setX1(0);
    		ana1.setY1(0);
    	}
    }
    private void Mouvement12H_M() {
    	if(		   ((ana2.getX1()==10 && (ana2.getY1()==171))
    	    	   || (ana2.getX1()==33 &&(ana2.getY1()==148 || ana2.getY1()==194))
    	    	   || (ana2.getX1()==56 &&(ana2.getY1()==102 ||ana2.getY1()==148 || ana2.getY1()==194))
    	    	   || (ana2.getX1()==79 &&(ana2.getY1()==102 || ana2.getY1()==148))
    	    	   || (ana2.getX1()== 102 &&(ana2.getY1()==33 || ana2.getY1()==56 || ana2.getY1()==194))
    	    	   || (ana2.getX1()== 125 &&(ana2.getY1()==33 || ana2.getY1()==56 || ana2.getY1()==79))
    	    	   || (ana2.getX1()==148 && (ana2.getY1()==33 || ana2.getY1()==79 || ana2.getY1()==56 || ana2.getY1()==79 || ana2.getY1()==148))
    	    	   || (ana2.getX1()==171 && (ana2.getY1()==33 ||ana2.getY1()==56 || ana2.getY1()==102 || ana2.getY1()==125 || ana2.getY1()==148 || ana2.getY1()==171))
    	    	   || (ana2.getX1()==194 && (ana2.getY1()==33 || ana2.getY1()==56 || ana2.getY1()==102 || ana2.getY1()==125 || ana2.getY1()==148 || ana2.getY1()==286))
    	    	   || (ana2.getX1()==217 && (ana2.getY1()==33 || ana2.getY1()==56 || ana2.getY1()==102 || ana2.getY1()==125 || ana2.getY1()==148 || ana2.getY1()==171 || ana2.getY1()==332))
    	    	   || (ana2.getX1()==240 && (ana2.getY1()==33 || ana2.getY1()==56 || ana2.getY1()==102 || ana2.getY1()==148 || ana2.getY1()==171 || ana2.getY1()==194 || ana2.getY1()==332))
    	    	   || (ana2.getX1()==263 && (ana2.getY1()==33 || ana2.getY1()==56 || ana2.getY1()==102 || ana2.getY1()==125 || ana2.getY1()==171 || ana2.getY1()==332))
    	    	   || (ana2.getX1()==286 && (ana2.getY1()==102 || ana2.getY1()==125 || ana2.getY1()==309 || ana2.getY1()==332))
    	    	   || (ana2.getX1()==309 && (ana2.getY1()==102 || ana2.getY1()==263 || ana2.getY1()==332))
    	    	   || (ana2.getX1()==332 && (ana2.getY1()==217 || ana2.getY1()==332 )))&&CanDead2==true) {
    			int a = ana2.genererInt2(-20,20);//pour les y
    			int b = ana2.genererInt(-20, 20);//pour les x 
    			if(a>0 && b>0) {
    			ana2.setY1(1);
        		ana2.setX1(1);
    			}
    			if(a>0 && b<0) {
    			ana2.setY1(1);
        		ana2.setX1(-1);
    			}
    			if(a<0 && b>0) {
    			ana2.setY1(0);
        		ana2.setX1(1);
    			}
    			if(a<0 && b<0) {
    			ana2.setY1(0);
        		ana2.setX1(-1);
    			}
    		}
    	if(CanDead2==false) {
    		ana2.setX1(0);
    		ana2.setY1(0);
    	}
    }
    private void Mouvement13H_M() {
    	if(		   ((ana3.getX1()==10 && (ana3.getY1()==171))
    	    	   || (ana3.getX1()==33 &&(ana3.getY1()==148 || ana3.getY1()==194))
    	    	   || (ana3.getX1()==56 &&(ana3.getY1()==102 ||ana3.getY1()==148 || ana3.getY1()==194))
    	    	   || (ana3.getX1()==79 &&(ana3.getY1()==102 || ana3.getY1()==148))
    	    	   || (ana3.getX1()== 102 &&(ana3.getY1()==33 || ana3.getY1()==56 || ana3.getY1()==194))
    	    	   || (ana3.getX1()== 125 &&(ana3.getY1()==33 || ana3.getY1()==56 || ana3.getY1()==79))
    	    	   || (ana3.getX1()==148 && (ana3.getY1()==33 || ana3.getY1()==79 || ana3.getY1()==56 || ana3.getY1()==79 || ana3.getY1()==148))
    	    	   || (ana3.getX1()==171 && (ana3.getY1()==33 ||ana3.getY1()==56 || ana3.getY1()==102 || ana3.getY1()==125 || ana3.getY1()==148 || ana3.getY1()==171))
    	    	   || (ana3.getX1()==194 && (ana3.getY1()==33 || ana3.getY1()==56 || ana3.getY1()==102 || ana3.getY1()==125 || ana3.getY1()==148 || ana3.getY1()==286))
    	    	   || (ana3.getX1()==217 && (ana3.getY1()==33 || ana3.getY1()==56 || ana3.getY1()==102 || ana3.getY1()==125 || ana3.getY1()==148 || ana3.getY1()==171 || ana3.getY1()==332))
    	    	   || (ana3.getX1()==240 && (ana3.getY1()==33 || ana3.getY1()==56 || ana3.getY1()==102 || ana3.getY1()==148 || ana3.getY1()==171 || ana3.getY1()==194 || ana3.getY1()==332))
    	    	   || (ana3.getX1()==263 && (ana3.getY1()==33 || ana3.getY1()==56 || ana3.getY1()==102 || ana3.getY1()==125 || ana3.getY1()==171 || ana3.getY1()==332))
    	    	   || (ana3.getX1()==286 && (ana3.getY1()==102 || ana3.getY1()==125 || ana3.getY1()==309 || ana3.getY1()==332))
    	    	   || (ana3.getX1()==309 && (ana3.getY1()==102 || ana3.getY1()==263 || ana3.getY1()==332))
    	    	   || (ana3.getX1()==332 && (ana3.getY1()==217 || ana3.getY1()==332 )))&&CanDead3==true) {
    			int a = ana3.genererInt2(-20,20);//pour les y
    			int b = ana3.genererInt(-20, 20);//pour les x 
    			if(a>0 && b>0) {
    			ana3.setY1(1);
        		ana3.setX1(1);
    			}
    			if(a>0 && b<0) {
    			ana3.setY1(1);
        		ana3.setX1(-1);
    			}
    			if(a<0 && b>0) {
    			ana3.setY1(0);
        		ana3.setX1(1);
    			}
    			if(a<0 && b<0) {
    			ana3.setY1(0);
        		ana3.setX1(-1);
    			}
    		}
    	if(CanDead3==false) {
    		ana3.setX1(0);
    		ana3.setY1(0);
    	}
    }
    
    private void Mouvement2D() {
    	//System.out.println(obi.getX() + " / " + obi.getY());
    	if(((obi.getX()==286 || obi.getX()==309) && obi.getY()==56)
    		||((obi.getX()==10 || obi.getX()==309) && obi.getY()==79)
    		||((obi.getX()==10 || obi.getX()==286 || obi.getX()==309) && obi.getY()==102)
    		||((obi.getX()==10 || obi.getX()==33 || obi.getX()==309) && obi.getY()==125)
    		||((obi.getX()==79 || obi.getX()==102 || obi.getX()==125 || obi.getX()==286 || obi.getX()==309) && obi.getY()==148)
    		||((obi.getX()==79 || obi.getX()==102 || obi.getX()==125 || obi.getX()==309) && obi.getY()==171)
    		||((obi.getX()==79 || obi.getX()==102 || obi.getX()==125) && obi.getY()==194)
    		||((obi.getX()==79 || obi.getX()==102) && obi.getY()==217)
    		||((obi.getX()==102 || obi.getX()==263 || obi.getX()==286 || obi.getX()==309) && obi.getY()==240)
    		||((obi.getX()==125 || obi.getX()==263 || obi.getX()==286 || obi.getX()==309) && obi.getY()==263 )
    		||((obi.getX()==263 || obi.getX()==286 || obi.getX()==309) && obi.getY()==286 )
    		||((obi.getX()==102 || obi.getX()==125 || obi.getX()==309) && obi.getY()==309 ) ){
    		Mouv_XD=false;
    	}else {
    		Mouv_XD=true;
    	}
    }
 
    private void Mouvement2G() {
    	//System.out.println(obi.getX() + " / " + obi.getY());
    	if(((obi.getX()==309 || obi.getX()==332) && obi.getY()==56)
    		||((obi.getX()==33 || obi.getX()==332) && obi.getY()==79)
    		||((obi.getX()==33 || obi.getX()==309 || obi.getX()==332) && obi.getY()==102)
    		||((obi.getX()==33 || obi.getX()==56 || obi.getX()==332) && obi.getY()==125)
    		||((obi.getX()==102 || obi.getX()==125 || obi.getX()==148 || obi.getX()==309 || obi.getX()==332) && obi.getY()==148)
    		||((obi.getX()==102 || obi.getX()==125 || obi.getX()==148 || obi.getX()==332) && obi.getY()==171)
    		||((obi.getX()==102 || obi.getX()==125 || obi.getX()==148) && obi.getY()==194)
    		||((obi.getX()==102 || obi.getX()==125) && obi.getY()==217)
    		||((obi.getX()==125 || obi.getX()==286 || obi.getX()==309 || obi.getX()==332) && obi.getY()==240)
    		||((obi.getX()==148 || obi.getX()==286 || obi.getX()==309 || obi.getX()==332) && obi.getY()==263 )
    		||((obi.getX()==286 || obi.getX()==309 || obi.getX()==332) && obi.getY()==286 )
    		||((obi.getX()==125 || obi.getX()==148 || obi.getX()==332) && obi.getY()==309 ) ){
    		Mouv_XG=false;
    	}else {
    		Mouv_XG=true;
    	}
    }
    private void Mouvement2H() {
    	if((obi.getX()==10 && (obi.getY()==56 || obi.getY()==217 ||obi.getY()==263 ||obi.getY()==309))
    	   || (obi.getX()==33 && (obi.getY()==56 ||obi.getY()==79 || obi.getY()==217 ||obi.getY()==263 ||obi.getY()==309))
    	   || (obi.getX()==56 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==79 || obi.getY()==125 ||obi.getY()==148 || obi.getY()==217 || obi.getY()==263 || obi.getY()==309 || obi.getY()==332))
    	   || (obi.getX()==79 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==79 || obi.getY()==102 ||obi.getY()==125 || obi.getY()==148 || obi.getY()==217 || obi.getY()==263 || obi.getY()==309 ||obi.getY()==332))
    	   || (obi.getX()==102 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==79 || obi.getY()==102 ||obi.getY()==125 || obi.getY()==263 || obi.getY()==309 || obi.getY()==332))
    	   || (obi.getX()==125 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==102 ||obi.getY()==125 || obi.getY()==240))
    	   || (obi.getX()==148 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==79 || obi.getY()==102 ||obi.getY()==125 || obi.getY()==148 || obi.getY()==194 ||obi.getY()==240 || obi.getY()==263 || obi.getY()==286 || obi.getY()==309 || obi.getY()==332))
    	   || (obi.getX()==171 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==79 || obi.getY()==102 ||obi.getY()==125 || obi.getY()==148 || obi.getY()==171 ||obi.getY()==194 || obi.getY()==240 || obi.getY()==263 || obi.getY()==286 || obi.getY()==309 || obi.getY()==332))
    	   || (obi.getX()==194 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==79 || obi.getY()==102 ||obi.getY()==125 || obi.getY()==148 || obi.getY()==171 ||obi.getY()==194 || obi.getY()==240 || obi.getY()==263 || obi.getY()==286 || obi.getY()==309 || obi.getY()==332))
    	   || (obi.getX()==217 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==79 || obi.getY()==102 ||obi.getY()==125 || obi.getY()==148 || obi.getY()==171 ||obi.getY()==194 || obi.getY()==240 || obi.getY()==263 || obi.getY()==286 || obi.getY()==309 || obi.getY()==332))
    	   || (obi.getX()==240 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==79 || obi.getY()==102 ||obi.getY()==125 || obi.getY()==148 || obi.getY()==171 ||obi.getY()==194 || obi.getY()==240 || obi.getY()==263 || obi.getY()==286 || obi.getY()==309))
    	   || (obi.getX()==263 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==79 || obi.getY()==102 ||obi.getY()==125 || obi.getY()==148 || obi.getY()==171 ||obi.getY()==194 || obi.getY()==240 || obi.getY()==309 || obi.getY()==332))
    	   || (obi.getX()==286 && (obi.getY()==33 || obi.getY()==56 || obi.getY()==79 || obi.getY()==102 ||obi.getY()==125 || obi.getY()==148 || obi.getY()==171 ||obi.getY()==194 || obi.getY()==309 ||obi.getY()==332))
    	   || (obi.getX()==309 && (obi.getY()==33 || obi.getY()==171 ||obi.getY()==194 ||obi.getY()==240 || obi.getY()==332))
    	   || (obi.getX()==332 && (obi.getY()==33 ||obi.getY()==194)) ) {
    		Mouv_XH=false;
    	}else {
    		Mouv_XH=true;
    	}
    	
    }
    private void Mouvement2B() {
    	if((obi.getX()==10 && (obi.getY()==33 || obi.getY()==194 ||obi.getY()==240 ||obi.getY()==286))
    	   || (obi.getX()==33 && (obi.getY()==33 ||obi.getY()==56 || obi.getY()==194 ||obi.getY()==240 ||obi.getY()==286))
    	   || (obi.getX()==56 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==56 || obi.getY()==102 ||obi.getY()==125 || obi.getY()==194 || obi.getY()==240 || obi.getY()==286 || obi.getY()==309))
    	   || (obi.getX()==79 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==56 || obi.getY()==79 ||obi.getY()==102 || obi.getY()==125 || obi.getY()==194 || obi.getY()==240 || obi.getY()==286 ||obi.getY()==309))
    	   || (obi.getX()==102 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==56 || obi.getY()==79 ||obi.getY()==102 || obi.getY()==240 || obi.getY()==286 || obi.getY()==309))
    	   || (obi.getX()==125 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==79 ||obi.getY()==102 || obi.getY()==217))
    	   || (obi.getX()==148 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==56 || obi.getY()==79 ||obi.getY()==102 || obi.getY()==125 || obi.getY()==171 ||obi.getY()==217 || obi.getY()==240 || obi.getY()==263 || obi.getY()==286 || obi.getY()==309))
    	   || (obi.getX()==171 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==56 || obi.getY()==79 ||obi.getY()==102 || obi.getY()==125 || obi.getY()==148 ||obi.getY()==171 || obi.getY()==217 || obi.getY()==240 || obi.getY()==263 || obi.getY()==286 || obi.getY()==309))
    	   || (obi.getX()==194 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==56 || obi.getY()==79 ||obi.getY()==102 || obi.getY()==125 || obi.getY()==148 ||obi.getY()==171 || obi.getY()==217 || obi.getY()==240 || obi.getY()==263 || obi.getY()==286 || obi.getY()==309))
    	   || (obi.getX()==217 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==56 || obi.getY()==79 ||obi.getY()==102 || obi.getY()==125 || obi.getY()==148 ||obi.getY()==171 || obi.getY()==217 || obi.getY()==240 || obi.getY()==263 || obi.getY()==286 || obi.getY()==309))
    	   || (obi.getX()==240 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==56 || obi.getY()==79 ||obi.getY()==102 || obi.getY()==125 || obi.getY()==148 ||obi.getY()==171 || obi.getY()==217 || obi.getY()==240 || obi.getY()==263 || obi.getY()==286))
    	   || (obi.getX()==263 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==56 || obi.getY()==79 ||obi.getY()==102 || obi.getY()==125 || obi.getY()==148 ||obi.getY()==171 || obi.getY()==217 || obi.getY()==286 || obi.getY()==309))
    	   || (obi.getX()==286 && (obi.getY()==10 || obi.getY()==33 || obi.getY()==56 || obi.getY()==79 ||obi.getY()==102 || obi.getY()==125 || obi.getY()==148 ||obi.getY()==171 || obi.getY()==286 ||obi.getY()==309))
    	   || (obi.getX()==309 && (obi.getY()==10 || obi.getY()==148 ||obi.getY()==171 ||obi.getY()==217 || obi.getY()==309))
    	   || (obi.getX()==332 && (obi.getY()==10 ||obi.getY()==171)) ) {
    	    		Mouv_XB=false;
    	    	}else {
    	    		Mouv_XB=true;
    	    	}
    }
    
       private void Initialisation() {

    	Donnee = new short[Nbre_block * Nbre_block];
        d = new Dimension(400, 400);
        temps = new Timer(40, this);
        temps.start();
    }

    private void Jouer(Graphics2D g2d) {
    	if(compteur==1) {
    	if(((obi.getX()==ana.getX1() && obi.getY()==ana.getY1())&&CanDead==true||(obi.getX()==ana1.getX1() && obi.getY()==ana1.getY1())&&CanDead1==true||(obi.getX()==ana2.getX1() && obi.getY()==ana2.getY1())&&CanDead2==true||(obi.getX()==ana3.getX1() && obi.getY()==ana3.getY1() && CanDead3==true))) {
    		obi.setV(-1);
    	}
    else if (obi.getV()<=0) {
    		Enjeu=false;
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
            compteur++;
            obi.setX(-14);
            obi.setY(-14);
        }
    	else if(seconde >=3600) {
    		Enjeu=false;
    		String Victoire = "Vous avez manqué de temps";
            g2d.setColor(Color.YELLOW);
            g2d.drawString(Victoire, (Taille_ecran)/4, 175);
    		
    	}
         else {
        	Teleportation();
        	Verif();
        	Dessine_jedi(g2d); 
        	Dessine_mechant(g2d);
        	perdVie();
        	Dessine_Chrono(g2d);
        	Dessine_mort(g2d);
        	Coeur(g2d);
        	Dessine_Teleportation(g2d);
        	//G
        	Mouvement1D();
        	Mouvement1G();
        	Dessine_mortbis(g2d);
        	Mouvement1B();
        	Dessine_cle(g2d);
        	Mouvement1H();
        	Affiche_Artillerie(g2d);
        	//System.out.println(cmp +" " + a1+ " " + seconde);
        	if(cmp<2 && a1==seconde-1 && CanDead==true) {
        	cmp++;
        	a1 = heure.getTime();
        	Mouvement1D_M();
        	Mouvement11D_M();
        	Mouvement12D_M();
        	Mouvement13D_M();
        	Mouvement1G_M();
        	Mouvement11G_M();
        	Mouvement12G_M();
        	Mouvement13G_M();
        	Mouvement1B_M();
        	Mouvement12B_M();
        	Mouvement11B_M();
        	Mouvement13B_M();
        	Mouvement1H_M();
        	Mouvement11H_M();
        	Mouvement12H_M();
        	Mouvement13H_M();
        	//System.out.println("ta");
        	}
        	else if (a1!=seconde) {
        		cmp=1;
        	}
        	
        	
        	
        	Dessine_Vie(g2d);
        	Verif2();
         }
    	}
    	else if( compteur ==2) 
    	{
    		if(obi.getV()<=0) {
    			Enjeu=false;
        		//System.out.println("Defaite");
            	String Victoire = "Vous avez perdu";
                g2d.setColor(Color.RED);
                g2d.drawString(Victoire, (Taille_ecran)/4, 175);
    		}
    		if( obi.getX()==286 && obi.getY()==286 && ok==false)
    		{
    			Enjeu=true;
            	//System.out.println("Victoire");
            	String Victoire = "Vous devez aller chercher la clé ";
                g2d.setColor(Color.RED);
                g2d.drawString(Victoire, (Taille_ecran)/4, 175);
               }
    		else if(seconde >=3600) {
        		Enjeu=false;
        		String Victoire = "Vous avez manqué de temps";
                g2d.setColor(Color.YELLOW);
                g2d.drawString(Victoire, (Taille_ecran)/4, 175);
        		
        	}
    		else if( obi.getX()==286 && obi.getY()==286 && ok==true) {
    			Enjeu=false;
            	//System.out.println("Victoire");
            	String Victoire = "Vous avez gagné";
                g2d.setColor(Color.YELLOW);
                g2d.drawString(Victoire, (Taille_ecran)/4, 175);
    		}else 
    		{
    		initJeu2();
    		initNiveau2();
    		Affiche_Niveau2(g2d);
    		Mouvement2D();
    		Mouvement2H();
    		Mouvement2G();
    		Mouvement2B();
    		Verif();
    		perdVie2();
    		Teleportation2();
    		Dessine_jedi(g2d);
    		Dessine_Vie(g2d);
    		Dessine_Chrono(g2d);
    		cle2(g2d);
    		}
    	}
    }
    private void Dessine_mechant(Graphics2D g2d) {
    	this.Mechant=this.Mechant1.getImage();
    	g2d.drawImage(this.Mechant, ana.getX1()-7, ana.getY1()-7, 18, 18, null);
    	g2d.drawImage(this.Mechant, ana1.getX1()-7, ana1.getY1()-7, 18, 18, null);
    	g2d.drawImage(this.Mechant, ana2.getX1()-7, ana2.getY1()-7, 18, 18, null);
    	g2d.drawImage(this.Mechant, ana3.getX1()-7, ana3.getY1()-7, 18, 18, null);
    	//g2d.drawImage(heros,ana.getX1()-7, ana.getY1()-7,this);
    	//System.out.println(ana.getX1()+"/ "+ ana.getY1());
    }
     
    private void Dessine_jedi(Graphics2D g2d) {
    	this.heros=this.heros1.getImage();
    	g2d.drawImage(this.heros, obi.getX()-7, obi.getY()-7, 18, 18, null);
    	//g2d.fillOval(obi.getX(), obi.getY(), 6, 6);
    	//System.out.println("ObiX = "+obi.getX()+" / ObiY = "+ obi.getY() + " / ObiVie =" + obi.Vie);
    }
    private void Coeur(Graphics2D g2d) {
    	this.coeur=this.coeur1.getImage();
    	g2d.drawImage(this.coeur, 194-7, 263-7, 18, 18, null);
    	//g2d.fillOval(obi.getX(), obi.getY(), 6, 6);
    	//System.out.println("ObiX = "+obi.getX()+" / ObiY = "+ obi.getY() + " / ObiVie =" + obi.Vie);
    }
    private void Affiche_Ecran(Graphics2D g2d) 
    {
    	String start = "Espace pour commencer";
        g2d.setColor(Color.BLUE);
        g2d.drawString(start, (Taille_ecran)/4, 175);
    }
  //  private void Affiche_Ecran2(Graphics2D g2d) 
    //{
    //	String start = "Espace pour commencer";
      //  g2d.setColor(Color.BLUE);
        //g2d.drawString(start, (Taille_ecran)/4, 175);
    //}

    private void Affiche_Niveau(Graphics2D g) {
        g.setFont(smallFont);
        g.setColor(new Color(5, 181, 79));
        String s = "Niveau " + Niveau;
        g.drawString(s, -Taille_ecran / 4 + 96, Taille_ecran + 16);
    }
    private void Affiche_Artillerie(Graphics2D g) {
        g.setFont(smallFont);
        g.setColor(new Color(5, 181, 79));
        String s = "Kalash " + artillerie;
        g.drawString(s, -Taille_ecran / 4 + 328, Taille_ecran + 16);
    }

    private void DessineMap(Graphics2D g2d) {
        short i = 0;
        for (int y = 0; y < Taille_ecran; y += Taille_block) {
            for (int x = 0; x < Taille_ecran; x += Taille_block) {

                g2d.setColor(new Color(0,72,47));
                g2d.setStroke(new BasicStroke(5));
                
                if ((Niveau1[i] == 0)) { 
                	g2d.fillRect(x, y, Taille_block, Taille_block);
                 }

                if ((Donnee[i] & 1) != 0) { 
                    g2d.drawLine(x, y, x, y + Taille_block - 1);
                    //System.out.println("x : " + x + " / y : +  "+ y );
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
    private void Dessine_cle(Graphics2D g2d) {
    	this.cle=this.cle1.getImage();
		g2d.drawImage(this.cle, 332-7, 332-7, 18, 18, null);
    }
    private void Dessine_mortbis(Graphics2D g2d) {
    	this.mortbis=this.mortbis1.getImage();
		g2d.drawImage(this.mortbis, 171-7, 309-7, 18, 18, null);
    }
    private void Dessine_mort(Graphics2D g2d) {
    	if(CanDead==false) {
    		this.mort=this.mort1.getImage();
    		g2d.drawImage(this.mort, ana.getX1()-7, ana.getY1()-7, 18, 18, null);
    	}
    	if(CanDead1==false) {
    		this.mort=this.mort1.getImage();
    		g2d.drawImage(this.mort, ana1.getX1()-7, ana1.getY1()-7, 18, 18, null);
    	}
    	if(CanDead2==false) {
    		this.mort=this.mort1.getImage();
    		g2d.drawImage(this.mort, ana2.getX1()-7, ana2.getY1()-7, 18, 18, null);
    	}
    	if(CanDead3==false) {
    		this.mort=this.mort1.getImage();
    		g2d.drawImage(this.mort, ana3.getX1()-7, ana3.getY1()-7, 18, 18, null);
    	}
    }
    private void initNiveau() {
        for (int i = 0; i < Nbre_block * Nbre_block; i++) {
            Donnee[i] = Niveau1[i];
        }

        Continue();
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
        if(compteur==1) {
        seconde = heure.getTime();
        }
        if(compteur==2) 
        {
        	seconde=0;
        	seconde=heure.getTime();
        	}
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.green);
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
            	if(key==KeyEvent.VK_Z && artillerie>=1) {
            		artillerie--;
            		Munition munition = new Munition(obi.getX(),obi.getY());
            		if(munition.GetX2()==ana.getX1()) {
            			CanDead=false;
            		} 
            		if(munition.GetX2()==ana1.getX1()) {
            			CanDead1=false;
            		}
            		if(munition.GetX2()==ana2.getX1()) {
            			CanDead2=false;
            		}
            		if(munition.GetX2()==ana3.getX1()) {
            			CanDead3=false;
            		}
            	}
            	if(key==KeyEvent.VK_D  && artillerie>=0) {
            		artillerie--;
            		Munition munition = new Munition(obi.getX(),obi.getY());
            		if(munition.GetY2()==ana.getY1()) {
            			CanDead=false;
            		}
            		if(munition.GetY2()==ana1.getY1()) {
            			CanDead1=false;
            		}
            		if(munition.GetY2()==ana2.getY1()) {
            			CanDead2=false;
            		}
            		if(munition.GetY2()==ana3.getY1()) {
            			CanDead3=false;
            		}
            	}
                if (key == KeyEvent.VK_LEFT) {
                	if (Mouv_XG==true) {
                		obi.setX(-1);
                	}else {
                   obi.setX(0);
                	}
                }
                	else if (key == KeyEvent.VK_RIGHT) {
                	if(Mouv_XD==true) {
                		obi.setX(1);
                	}else {
                		obi.setX(0);
                	}
                } else if (key == KeyEvent.VK_UP) {
                	if(Mouv_XH==true) {
                		obi.setY(-1);
                	}else {
                		obi.setY(0);
                	}
                	
                } else if (key == KeyEvent.VK_DOWN) {
                	if(Mouv_XB==true) {
                		obi.setY(1);
                	}else {
                		obi.setY(0);
                	}
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



// Niveau 2 


private void initJeu2() {
	Niveau = 1;
    initNiveau();
    }

private void initNiveau2() {
    for (int i = 0; i < Nbre_block * Nbre_block; i++) {
        Donnee[i] = Niveau2[i];
    }
    Continue();
}
private void Affiche_Niveau2(Graphics2D g) {
    g.setFont(smallFont);
    g.setColor(new Color(5, 181, 79));
    String s = "Niveau " + 2;
    g.drawString(s, -Taille_ecran / 4 + 96, Taille_ecran + 16);
}
private void perdVie2() 
{
	//Perd Vie si il est sur le noir
	if(obi.getX()==102 && obi.getY()==148) {
		obi.setV(-10);
	}
	//gagne de la vie si il est sur la case rouge 
	if(obi.getX()==148 && obi.getY()==263) {
		obi.setV(10);
	}
}
private void Teleportation2() 
{
	if(obi.getX()==332 && obi.getY()==10) 
	{
		obi.setX(-14);
		obi.setY(9);
		//Evite problème
		//obi.setY(7);
	}
}
private void cle2(Graphics2D g2d) 
	{
	if(obi.getX()==102 && obi.getY()==309) 
		{
		ok=true;
		String cle="La clé est récupéré vous pouvez sortir";
		g2d.setColor(Color.red);
		g2d.drawString(cle, (Taille_ecran)/4, 175);
		}
	}
}