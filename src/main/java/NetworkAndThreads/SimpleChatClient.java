package NetworkAndThreads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClient {

    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;

    public static void main(String[] args) {
        SimpleChatClient client = new SimpleChatClient();
        client.go();
    }

    public void go(){

        JFrame frame = new JFrame("Simple Chat Client");
        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());

        frame .getContentPane().add(BorderLayout.NORTH, qScroller);

         mainPanel.add(outgoing);
        mainPanel.add(sendButton);
       setUpNetworking();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setUpNetworking() {
        try{

            sock = new Socket("wsua1855", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        }
        catch (Exception e) {e.printStackTrace();}
    }

    public class SendButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent ev) {

            try{

                writer.println(outgoing.getText());
                writer.flush();

            }
            catch (Exception e) {e.printStackTrace();}

            outgoing.setText("");
            outgoing.requestFocus();
        }
    }



    public class IncomingReader implements Runnable{
        public void run(){
            String message;
            try {
                while ((message = reader.readLine()) != null)
                {
                    System.out.println("read " + message);
                    incoming.append(message + "\n");
                }
            }
            catch (Exception e) {e.printStackTrace();}
        }
    }

}
