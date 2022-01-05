package jeu;

public class Pion {
	int X;
	int Y;
	int Vie;
	public Pion(int X, int Y,int Vie) {
		this.X=X;
		this.Y=Y;
		this.Vie=Vie;
	}
	public int getX() {
		return(this.X);
	}
	public int getY() {
		return(this.Y);
	}
	public void setX(int x) {
		this.X=this.X+x*23;
	}
	public void setY(int y) {
		this.Y=this.Y+y*23;
	}
	public int getV() {
		return(this.Vie);
	}
	public void setV(int v) {
		this.Vie=this.Vie+v;
	}
}