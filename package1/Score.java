package package1;
import java.io.*;
import java.util.ArrayList;


/**
 * Cette classe permet, à partir d'un fichier .map, de créer toutes les figures d'un niveau
 *
 * @author RGM
 * @version 03/03/2014
 *
 * @inv SCOREFILE == "./doc/score.score"
 */
public class Score {

  /** Le fichire contenant le score */
  private static final String SCOREFILE = "./doc/score.score";

  public static String getScore(){
    String str = "0";
    try {
      InputStream ips = new FileInputStream(SCOREFILE);
      InputStreamReader ipsr = new InputStreamReader(ips);
      BufferedReader br = new BufferedReader(ipsr);
      str = br.readLine();
    }
    catch (IOException exception) {
      System.out.println ("Erreur lors de l'ecriture du score : " + exception.getMessage());
    }
    return str;
  }

  public static void setScore(String score){
    try {
      FileWriter fw = new FileWriter(SCOREFILE);
      fw.write(score);
      fw.close();
    }
    catch (IOException exception) {
      System.out.println ("Erreur lors de l'ecriture du score : " + exception.getMessage());
    }
  }

  protected void invariant() {
    
  }

}
