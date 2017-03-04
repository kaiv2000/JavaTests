package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_TextArea implements ActionListener
{
    JTextArea text;

    public static void main(String[] args) {
        GUI_TextArea test = new GUI_TextArea();
        test.go();
    }

    public void go()
    {
        JFrame frame = new JFrame();	// створення вікна
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(250,200);		// вказати розмір вікна - 1й пункт для активації вікна

        text = new JTextArea(5,5);

        JButton button = new JButton("Just click me =)");
        button.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane(text);
        //text.setLineWrap(true); //перенос строки

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);       // включаємо вертикальну прокрутк
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);   // включаємо горизонтальну прокрутк

        text.setText("My text");
        text.append(" adding text");
        text.selectAll();
        text.requestFocus();

        frame .getContentPane().add(BorderLayout.NORTH, scrollPane);
        frame .getContentPane().add(BorderLayout.SOUTH, button);

        frame.setVisible(true);		// зробити видимим	- 2й пункт для активації вікна
    }

    public void actionPerformed(ActionEvent ev)
    {
        text.append("happy button clicked! \n");
    }

}
