import java.io.IOException;

public class InterPlanetCommunication extends Thread{
    private int id;
    InterPlanetCommunication(int id){
        this.id=id;
    }
    public void run(){
        if(id==0){
            SendMessage msg=new SendMessage();
            try {
                msg.sendMessage("><>><</<<>>/");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            RecieveMessage rcv=new RecieveMessage();
            try {
                rcv.recieveMessage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
