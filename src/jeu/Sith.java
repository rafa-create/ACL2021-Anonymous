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
	public void setX1() {
		this.X=this.X+genererInt(-1,1)*23;
	}
	public void setY1() {
		this.Y=this.Y+genererInt(-1,1)*23;
	}
	public int genererInt(int borneInf, int borneSup){
		   Random random = new Random();
		   int nb;
		   nb = borneInf+random.nextInt(borneSup-borneInf);
		   return nb;
		}
}