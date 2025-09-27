package multitoolcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LengthConverter extends JFrame implements ActionListener {

    private JComboBox<String> fromUnit, toUnit;
    private JTextField inputValue;
    private JLabel resultLabel;
    private JButton convertButton;

    private final String[] units = {"Meters", "Kilometers", "Miles", "Feet", "Inches"};

    public LengthConverter() {
        setTitle("Length Converter");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center window

        // --- UI Components ---
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

            // 1. Convert input value to a base unit (Meters)
            double valueInMeters = 0;
            switch (from) {
                case "Meters": valueInMeters = input; break;
                case "Kilometers": valueInMeters = input * 1000; break;
                case "Miles": valueInMeters = input * 1609.34; break;
                case "Feet": valueInMeters = input * 0.3048; break;
                case "Inches": valueInMeters = input * 0.0254; break;
            }

            // 2. Convert from base unit (Meters) to the target unit
            double result = 0;
            switch (to) {
                case "Meters": result = valueInMeters; break;
                case "Kilometers": result = valueInMeters / 1000; break;
                case "Miles": result = valueInMeters / 1609.34; break;
                case "Feet": result = valueInMeters / 0.3048; break;
                case "Inches": result = valueInMeters / 0.0254; break;
            }

            resultLabel.setText(String.format("Result: %.4f %s", result, to));

        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Invalid Input");
        }
    }
}
