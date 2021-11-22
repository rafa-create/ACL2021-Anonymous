package jeu;

public class Chrono_time extends Thread 
{
    private int startTime;
    private boolean started;
    public Chrono_time()
    {
        this.startTime = (int) System.currentTimeMillis();
        this.started = true;
        this.start();
    }

    public void run()
    {
        while (started)
        {
            //empty code since currentTimeMillis increases by itself
        }
    }


    public int getTime()
    {
        int milliTime = (int) (System.currentTimeMillis() - this.startTime);
        int[] out = new int[]{0, 0, 0, 0};
        out[0] = (int)(milliTime / 3600000      );
        out[1] = (int)(milliTime / 60000        ) % 60;
        out[2] = (int)(milliTime / 1000         ) % 60;
        out[3] = ((int)(milliTime)/ 1000);
        String s ="";
        s=s+out[3];
        s.substring(0, s.length()-1);
        //System.out.print(" Milli " + milliTime + " out " +out[3]+ " taille s " + s );
        return out[3];
    }

    public void stopThread()
    {
        this.started = false;
    }
}