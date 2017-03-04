package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI_TextField
{
    public static void main(String[] args) {
        GUI_TextField test = new GUI_TextField();
        test.go();
    }

    void go()
    {
        JFrame frame = new JFrame();	// створення вікна
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(250,200);		// вказати розмір вікна - 1й пункт для активації вікна

        JTextField textField = new JTextField("test test");
        frame .getContentPane().add(BorderLayout.NORTH, textField);

        System.out.println(textField.getText());

        //textField.selectAll();
        //textField.requestFocus();


        frame.setVisible(true);		// зробити видимим	- 2й пункт для активації вікна
    }
}
