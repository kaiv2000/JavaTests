package Files;

import javax.swing.*;

public class Frame
{
    public static void main(String[] args) {
        Frame start = new Frame();
        start.GUI();
    }

    void GUI()
    {
        JFrame frame = new JFrame();
        JButton button = new JButton("click here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

}
