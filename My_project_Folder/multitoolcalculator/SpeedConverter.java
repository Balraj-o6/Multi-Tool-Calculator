package multitoolcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpeedConverter extends JFrame implements ActionListener {
    
    private JComboBox<String> fromUnit, toUnit;
    private JTextField inputValue;
    private JLabel resultLabel;
    private JButton convertButton;

    private final String[] units = {"m/s", "km/h", "mph", "knots"};

    public SpeedConverter() {
        setTitle("Speed Converter");
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

            // Base unit: meters per second (m/s)
            double valueInMps = 0;
            switch (from) {
                case "m/s": valueInMps = input; break;
                case "km/h": valueInMps = input / 3.6; break;
                case "mph": valueInMps = input / 2.237; break;
                case "knots": valueInMps = input / 1.944; break;
            }

            double result = 0;
            switch (to) {
                case "m/s": result = valueInMps; break;
                case "km/h": result = valueInMps * 3.6; break;
                case "mph": result = valueInMps * 2.237; break;
                case "knots": result = valueInMps * 1.944; break;
            }
            
            resultLabel.setText(String.format("Result: %.4f %s", result, to));

        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Invalid Input");
        }
    }
}
