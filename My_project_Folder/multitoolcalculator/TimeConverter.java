package multitoolcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeConverter extends JFrame implements ActionListener {
    
    private JComboBox<String> fromUnit, toUnit;
    private JTextField inputValue;
    private JLabel resultLabel;
    private JButton convertButton;

    private final String[] units = {"Seconds", "Minutes", "Hours", "Days"};

    public TimeConverter() {
        setTitle("Time Converter");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JLabel("From:"));
        fromUnit = new JComboBox<>(units);
        add(fromUnit);

        add(new JLabel("To:"));
        toUnit = new JComboBox<>(units);
        add(toUnit);

        add(new JLabel("Enter Value:"));
        inputValue = new JTextField();
        add(inputValue);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        add(convertButton);

        resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double input = Double.parseDouble(inputValue.getText());
            String from = (String) fromUnit.getSelectedItem();
            String to = (String) toUnit.getSelectedItem();

            // Base unit: Seconds
            double valueInSeconds = 0;
            switch (from) {
                case "Seconds": valueInSeconds = input; break;
                case "Minutes": valueInSeconds = input * 60; break;
                case "Hours": valueInSeconds = input * 3600; break;
                case "Days": valueInSeconds = input * 86400; break;
            }

            double result = 0;
            switch (to) {
                case "Seconds": result = valueInSeconds; break;
                case "Minutes": result = valueInSeconds / 60; break;
                case "Hours": result = valueInSeconds / 3600; break;
                case "Days": result = valueInSeconds / 86400; break;
            }

            resultLabel.setText(String.format("Result: %.4f %s", result, to));

        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Invalid Input");
        }
    }
}
