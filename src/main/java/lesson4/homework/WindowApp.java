package lesson4.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Java Swing
public class WindowApp extends JFrame {

    public WindowApp() {
        setTitle("My new Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setLayout(new GridLayout(3, 3));

        setLayout(null);
        JTextField textField = new JTextField();
        textField.setBounds(90, 250, 200, 32);
        add(textField);
        JButton button = new JButton("Press here");
        button.setBounds(130, 300, 120, 32);
        add(button);
        JTextArea textArea = new JTextArea();
        textArea.setBounds(10,10,360,150);
        add(textArea);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(textField.getText());
            }
        });

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField.getText());
                button.setText(textField.getText());
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window is closing");;
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new WindowApp();
    }

}
