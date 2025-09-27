package multitoolcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main class for the calculator application
public class MultiToolCalculator extends JFrame implements ActionListener {

    // Calculator display field
    private JTextField display;

    // Panels for layout
    private JPanel buttonPanel;

    // Calculator buttons
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[8];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;

    // Menu bar components
    private JMenuBar menuBar;
    private JMenu toolsMenu;
    private JMenuItem lengthConverter, speedConverter, tempConverter, dataConverter, weightConverter, timeConverter;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public MultiToolCalculator() {
        // --- Frame Setup ---
        setTitle("Multi-tool Calculator");
        setSize(420, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null); // Center the window

        // --- Menu Bar Setup ---
        menuBar = new JMenuBar();
        toolsMenu = new JMenu("Calculation Tools");
        
        lengthConverter = new JMenuItem("Length Converter");
        speedConverter = new JMenuItem("Speed Converter");
        tempConverter = new JMenuItem("Temperature Converter");
        dataConverter = new JMenuItem("Data Converter");
        weightConverter = new JMenuItem("Weight Converter");
        timeConverter = new JMenuItem("Time Converter");

        // Add action listeners to menu items
        lengthConverter.addActionListener(this);
        speedConverter.addActionListener(this);
        tempConverter.addActionListener(this);
        dataConverter.addActionListener(this);
        weightConverter.addActionListener(this);
        timeConverter.addActionListener(this);

        toolsMenu.add(lengthConverter);
        toolsMenu.add(speedConverter);
        toolsMenu.add(tempConverter);
        toolsMenu.add(dataConverter);
        toolsMenu.add(weightConverter);
        toolsMenu.add(timeConverter);
        
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // --- Calculator Display ---
        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display);

        // --- Calculator Buttons ---
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].setFocusable(false);
        }
        
        // Position the delete and clear buttons
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);
        add(delButton);
        add(clrButton);

        // --- Button Panel ---
        buttonPanel = new JPanel();
        buttonPanel.setBounds(50, 100, 300, 300);
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel in order
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(addButton);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(subButton);
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(mulButton);
        buttonPanel.add(decButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equButton);
        buttonPanel.add(divButton);
        
        add(buttonPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // --- Menu Item Actions ---
        if (e.getSource() == lengthConverter) {
            new LengthConverter();
        } else if (e.getSource() == speedConverter) {
            new SpeedConverter();
        } else if (e.getSource() == tempConverter) {
            new TemperatureConverter();
        } else if (e.getSource() == dataConverter) {
            new DataConverter();
        } else if (e.getSource() == weightConverter) {
            new WeightConverter();
        } else if (e.getSource() == timeConverter) {
            new TimeConverter();
        }

        // --- Calculator Logic ---
        // Number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        // Decimal button
        if (e.getSource() == decButton) {
            if (!display.getText().contains(".")) {
                display.setText(display.getText().concat("."));
            }
        }
        // Operator buttons
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        // Equals button
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        }
        // Clear button
        if (e.getSource() == clrButton) {
            display.setText("");
        }
        // Delete button
        if (e.getSource() == delButton) {
            String string = display.getText();
            display.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                display.setText(display.getText() + string.charAt(i));
            }
        }
    }
    
    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MultiToolCalculator());
    }
}
