import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        int akkarisRevolution = 12;
        int giediPrimeRevolution=60;
        // theta = ((360/oribtal Period)*t ) Mod 360;
        int angularPositonAkkaris=((360)/ akkarisRevolution);
        int angularPositionGiedi=((360)/ giediPrimeRevolution);
        // angular separation = | theta_1*t mod 360 - theta_2*t mod 360|

        // angular separation must be above 350 and below 10
        for(int t=0;t<90;t++){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int deltaPositionAkkaris=(angularPositonAkkaris * t)%360;
            int deltaPositionGiedi=(angularPositionGiedi * t)%360;
            int delta=Math.abs(deltaPositionGiedi-deltaPositionAkkaris);
            if( delta>=350 || delta<=10){
                InterPlanetCommunication thread1=new InterPlanetCommunication(0);
                InterPlanetCommunication thread2=new InterPlanetCommunication(1);
                thread1.start();
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                thread2.start();
                try {
                    thread1.join();
                    thread2.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}