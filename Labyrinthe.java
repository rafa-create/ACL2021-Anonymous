public class Labyrinthe{
    int n;
    int x;// Abscisse de la case
    int y;// Ordonnée de la case
    String [] possibilite={"t","pi","m","pa","v"};// Tableau initialisé avec les effetes des cases 
    public Labyrinthe(int n,int x,int y){
        this.x=x;
        this.n=n;
        this.y=y;
    }
    public String [][] Creation_labyrinthe(int n){
        String [][]tab= String [this.n][this.n];
        return tab;
    }
    public boolean Case_Tresor(int x , int y ){
        String [][] tab=Creation_labyrinthe(this.n);
        if (tab[this.x][this.y]=="t")
        {
            return true;
        }
        return false;
    }
    public boolean Case_Piege(int x , int y ){
        String [][] tab=Creation_labyrinthe(this.n);
        if (tab[this.x][this.y]=="pi")
        {
            return true;
        }
        return false;
    }
    public boolean Case_magique(int x , int y ){
        String [][] tab=Creation_labyrinthe(this.n);
        if (tab[this.x][this.y]=="ma")
        {
            return true;
        }
        return false;
    }
    public boolean Case_passage(int x , int y ){
        String [][] tab=Creation_labyrinthe(this.n);
        if (tab[this.x][this.y]=="pa")
        {
            return true;
        }
        return false;
    }
    public boolean Case_Valide(int x , int y ){
        String [][] tab=Creation_labyrinthe(this.n);
        if (tab[this.x][this.y]=="v")
        {
            return true;
        }
        return false;
    }
}