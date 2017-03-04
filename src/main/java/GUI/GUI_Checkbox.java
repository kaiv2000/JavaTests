package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GUI_Checkbox implements ItemListener {
    JCheckBox check;

    public static void main(String[] args) {
        GUI_Checkbox test = new GUI_Checkbox();
        test.run();
    }

    public void run()
    {
        JFrame frame = new JFrame();	// створення вікна
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(250,200);		// вказати розмір вікна - 1й пункт для активації вікна

        check = new JCheckBox("please check");

        check.addItemListener(this);

        frame .getContentPane().add(BorderLayout.NORTH, check);


        frame.setVisible(true);		// зробити видимим	- 2й пункт для активації вікна
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        String onOroff = "off";
        if (check.isSelected()) onOroff = "on";
        System.out.println("checkbox is " + onOroff);
    }
}
