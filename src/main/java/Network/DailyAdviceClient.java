package Network;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {
    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

    public void go()
    {
        try {

            Socket socket = new Socket("127.0.0.1", 5000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String advice = reader.readLine();
            System.out.println("You have to do today: " + advice);
            reader.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
