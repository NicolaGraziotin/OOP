package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private static final String TITLE = "Simple GUI with file chooser";
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller;

    public SimpleGUIWithFileChooser() {
        controller = new Controller();
        // General panel
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        // Top panel
        final JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        // Text field
        final JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setText(controller.getPATH());
        topPanel.add(textField, BorderLayout.CENTER);
        // Browse button
        final JButton browse = new JButton("Browse...");
        topPanel.add(browse, BorderLayout.LINE_END);
        // Text area
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        // Save button
        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);

        canvas.add(topPanel, BorderLayout.NORTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser("Choose where to save");
                fileChooser.setSelectedFile(controller.getCurrentFile());
                final int result = fileChooser.showSaveDialog(frame);
                switch (result) {
                    case JFileChooser.APPROVE_OPTION:
                        final File newDest = fileChooser.getSelectedFile();
                        controller.setCurrentFile(newDest);
                        textField.setText(newDest.getPath());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, result, "Meh!", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        });
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    controller.saveOnCurrentFile(textArea.getText());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int)screen.getWidth() / PROPORTION, (int)screen.getHeight() / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }
}
