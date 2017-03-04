package GUI;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class GUI_JList implements ListSelectionListener
{
    public static void main(String[] args) {
        GUI_JList test = new GUI_JList();
        test.go();
    }

    JList jlist;

    void go()
    {
        JFrame frame = new JFrame();	// створення вікна
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(250,200);		// вказати розмір вікна - 1й пункт для активації вікна

        String[] listEnires = {"one", "second", "third", "fourth", "other", "one", "second", "third", "fourth", "other"};
        jlist = new JList(listEnires);
        jlist.setVisibleRowCount(4); // к-ть видимих строк до прокрутки

        JScrollPane scroller = new JScrollPane(jlist);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // обмеження вибору до одної строки
        jlist.addListSelectionListener(this);

        frame .getContentPane().add(BorderLayout.NORTH, scroller);
        frame.setVisible(true);		// зробити видимим	- 2й пункт для активації вікна
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting())
        {
            String Selection = (String) jlist.getSelectedValue();
            System.out.println(Selection);
        }
    }
}
