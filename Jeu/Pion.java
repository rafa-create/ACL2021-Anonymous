package jeu;

public class Pion {
	int X;
	int Y;
	int Vie;
	int NRJ;
	
	public Pion(int X, int Y,int Vie,int N) {
		this.X=X;
		this.Y=Y;
		this.Vie=Vie;
		this.NRJ=N;
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
	public int getNRJ() {
		return(this.NRJ);
	}
	public void setN(int n) {
		this.NRJ=this.NRJ+n;
	}
}