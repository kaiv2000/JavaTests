package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI_FlowLayout
{
    public static void main(String[] args) {
        GUI_FlowLayout test = new GUI_FlowLayout();
        test.run();
    }

    void run()
    {
        JFrame frame = new JFrame();	// створення вікна

        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button = new JButton("click me!");
        JButton button2 = new JButton("click me too!");

        panel.add(button);
        panel.add(button2);

        //Font bigFont = new Font("serif", Font.BOLD, 28);
        //button.setFont(bigFont);
        //frame .getContentPane().add(BorderLayout.NORTH, button);	// добавлення об'єкту на вікно

        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(250,200);		// вказати розмір вікна - 1й пункт для активації вікна
        frame.setVisible(true);		// зробити видимим	- 2й пункт для активації вікна
    }
}