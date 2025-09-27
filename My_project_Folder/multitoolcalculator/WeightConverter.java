package multitoolcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeightConverter extends JFrame implements ActionListener {
    
    private JComboBox<String> fromUnit, toUnit;
    private JTextField inputValue;
    private JLabel resultLabel;
    private JButton convertButton;

    private final String[] units = {"Kilograms", "Grams", "Pounds", "Ounces"};

    public WeightConverter() {
        setTitle("Weight Converter");
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

            // Base unit: Kilograms
            double valueInKg = 0;
            switch (from) {
                case "Kilograms": valueInKg = input; break;
                case "Grams": valueInKg = input / 1000; break;
                case "Pounds": valueInKg = input / 2.205; break;
                case "Ounces": valueInKg = input / 35.274; break;
            }

            double result = 0;
            switch (to) {
                case "Kilograms": result = valueInKg; break;
                case "Grams": result = valueInKg * 1000; break;
                case "Pounds": result = valueInKg * 2.205; break;
                case "Ounces": result = valueInKg * 35.274; break;
            }

            resultLabel.setText(String.format("Result: %.4f %s", result, to));
            
        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Invalid Input");
        }
    }
}
