import java.io.*;

public class SendMessage {
    public static int messageIndex=0;
    public static final Object lock = new Object();
    public void sendMessage(String message) throws IOException {
        synchronized (lock) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("trans.mxt", true))) {
                messageIndex++;
                writer.newLine();
                writer.write(Integer.toString(messageIndex) + " : " + message + "\n");
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
