package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller controller;

    public SimpleGUI() {
        controller = new SimpleController();
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        canvas.add(textField, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        final JPanel bottom = new JPanel();
        final JButton print = new JButton("Print");
        bottom.add(print, BorderLayout.EAST);
        final JButton history = new JButton("Show history");
        bottom.add(history, BorderLayout.WEST);
        canvas.add(bottom, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         * Handlers
         */
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setNextStringToPrint(textField.getText());
                controller.printCurrentString();
            }
            
        });
        history.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(controller.getPrintedStringHistory().toString());
            }
            
        });
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int)screen.getWidth() / PROPORTION, (int)screen.getHeight() / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

}
