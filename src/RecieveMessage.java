import java.io.*;

import static java.lang.Thread.sleep;

public class RecieveMessage {
    public static int ackIndex=0;
    public static final Object lock = new Object();
    public void recieveMessage() throws IOException {

        synchronized (lock) {

            BufferedReader reader = new BufferedReader(new FileReader("trans.mxt"));
            String line, lastLine = "";
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
            reader.close();
            try {
                String message = "";
                int count = 0;
                for (int i = lastLine.length() - 1; i >= 0; i--) {
                    if (count == 4) break;
                    message += (lastLine.charAt(i) + ".");
                    count++;
                }

                BufferedWriter writer = new BufferedWriter(new FileWriter("recvrs.mxt", true));
                ackIndex++;
                writer.write(Integer.toString(ackIndex) + " : " + message + "\n");
                writer.newLine();
                System.out.println("Sending Ack : "+message);
                writer.close();

                sleep(500);

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
