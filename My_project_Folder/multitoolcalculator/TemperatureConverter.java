package multitoolcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame implements ActionListener {

    private JComboBox<String> fromUnit, toUnit;
    private JTextField inputValue;
    private JLabel resultLabel;
    private JButton convertButton;

    private final String[] units = {"Celsius", "Fahrenheit", "Kelvin"};

    public TemperatureConverter() {
        setTitle("Temperature Converter");
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

            // Base unit: Celsius
            double valueInCelsius = 0;
            switch (from) {
                case "Celsius": valueInCelsius = input; break;
                case "Fahrenheit": valueInCelsius = (input - 32) * 5.0/9.0; break;
                case "Kelvin": valueInCelsius = input - 273.15; break;
            }
            
            double result = 0;
            switch (to) {
                case "Celsius": result = valueInCelsius; break;
                case "Fahrenheit": result = (valueInCelsius * 9.0/5.0) + 32; break;
                case "Kelvin": result = valueInCelsius + 273.15; break;
            }

            resultLabel.setText(String.format("Result: %.2f %s", result, to));

        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Invalid Input");
        }
    }
}
