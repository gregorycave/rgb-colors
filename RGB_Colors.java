package rgb_colors;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class RGB_Colors {

    // Class declaration for Exercise 1.

    private JTextField redTextField;
    private JTextField greenTextField;
    private JTextField blueTextField;
    private JButton regNumberButton;
    private JButton resetButton;
    private JLabel welcomeMessage;
    private JLabel errorMessage;
    private int notNumbers = 0;



    private void initUi(){

        // Method to create and position GUI elements:
        // - Buttons
        // - JPanels
        // - Labels
        // - Text Fields

        JFrame window = new JFrame("RGB Colors");
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        window.setSize(800,200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(2,3,5,5);
        southPanel.setLayout(gridLayout);
        BoxLayout boxLayout = new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS);
        window.setLayout(boxLayout);
        window.add(northPanel);
        window.add(southPanel);

        // Text Fields & Welcome Message.

        redTextField = new JTextField();
        greenTextField = new JTextField();
        blueTextField = new JTextField();
        errorMessage = new JLabel("");
        errorMessage.setPreferredSize(new Dimension(50,20));
        welcomeMessage = new JLabel("The color of this text changes with RGB values");
        welcomeMessage.setPreferredSize(new Dimension(50,20));
        welcomeMessage.setForeground(Color.BLUE);
        regNumberButton = new JButton("Change Color");
        resetButton = new JButton("Reset");

        // GUI elements (top panel)

        northPanel.setAlignmentX((float)0.5);
        northPanel.setAlignmentY((float)0.5);
        resetButton.setAlignmentX((float) 0.5);
        welcomeMessage.setAlignmentX((float)0.5);
        northPanel.add(resetButton);
        northPanel.add(welcomeMessage);
        northPanel.add(new JPanel());
        northPanel.add(errorMessage);

        // GUI elements (bottom panel)

        southPanel.add(redTextField);
        southPanel.add(greenTextField);
        southPanel.add(blueTextField);
        southPanel.add(new JPanel());
        southPanel.add(regNumberButton);

        window.setVisible(true);
        window.repaint();
    }



    private int checkValue(String value,JTextField textField){
        // Method to declare parameters:
        // - String (from textField object)
        // - JTextField (textField object to be validated)
        // - returns - an integer which represents the integer input into the text field, the integer equals -1 if the number input in the textfield is not an integer

        int newValue = -1;

        try {
            // Prevents program crashing if user provides an invalid input.

            newValue = Integer.parseInt(value);

            if (newValue > 255){
                newValue = 255;
            }
            else if (newValue < 0){
                newValue= 200;
            }

            // Sets the TextField to the color code input by the user.

            textField.setText(Integer.toString(newValue));
            errorMessage.setText("");

        }

        catch(NumberFormatException e) {
            // If the user does not enter an integer...
            if (!textField.getText().equals("")) {
                notNumbers += 1;
            }
            textField.setText("");
        }
        finally {
            return newValue;
        }
    }



    public RGB_Colors() {
        // Constructor for the GUI.

        initUi();
        regNumberButton.addActionListener(e -> {
            int red = checkValue(redTextField.getText(),redTextField);
            int green = checkValue(greenTextField.getText(),greenTextField);
            int blue = checkValue(blueTextField.getText(),blueTextField);

            if (red != -1 && green != -1 && blue != -1) {
                Color textColor = new Color(red, green, blue);
                welcomeMessage.setForeground(textColor);
                welcomeMessage.setText("The color of this text changes with RGB values");            
			}
			
			welcomeMessage.repaint();

            if (notNumbers == 0){
                errorMessage.setText("");
            }
            else {
                errorMessage.setText("You must enter an integer!");
            }

            notNumbers = 0;
        });

        resetButton.addActionListener(e-> {
            redTextField.setText("");
            greenTextField.setText("");
            blueTextField.setText("");
            welcomeMessage.setForeground(Color.BLUE);
            errorMessage.setText("");
        });
    }
}
