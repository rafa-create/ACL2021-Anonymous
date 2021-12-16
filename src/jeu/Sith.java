package jeu;

import java.util.Random;

public class Sith 
{
	int X;
	int Y;
	public Sith(int X, int Y) {
		this.X=X;
		this.Y=Y;
	}
	public int getX1() {
		return(this.X);
	}
	public int getY1() {
		return(this.Y);
	}
	public void setX1(int x ) {
		this.X=this.X+x*23;
	}
	public void setY1(int y ) {
		this.Y=this.Y+y*23;
	}
	public int genererInt(int borneInf, int borneSup){
		   Random random = new Random();
		   int nb;
		   nb = borneInf+random.nextInt(borneSup-borneInf);
		   return nb;
		}
	public int genererInt2(int borneInf, int borneSup){
		   Random random = new Random();
		   int nb;
		   nb = borneInf+random.nextInt(borneSup-borneInf);
		   return nb;
		}
}