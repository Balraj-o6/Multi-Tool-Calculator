package multitoolcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class DataConverter extends JFrame implements ActionListener {

    private JComboBox<String> fromUnit, toUnit;
    private JTextField inputValue;
    private JLabel resultLabel;
    private JButton convertButton;

    private final String[] units = {"Bytes", "Kilobytes (KB)", "Megabytes (MB)", "Gigabytes (GB)", "Terabytes (TB)"};

    public DataConverter() {
        setTitle("Data Storage Converter");
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
            BigDecimal input = new BigDecimal(inputValue.getText());
            int fromIndex = fromUnit.getSelectedIndex();
            int toIndex = toUnit.getSelectedIndex();

            int difference = fromIndex - toIndex;
            BigDecimal result;

            if (difference > 0) { // Converting to a larger unit
                result = input.multiply(BigDecimal.valueOf(Math.pow(1024, difference)));
            } else { // Converting to a smaller unit
                result = input.divide(BigDecimal.valueOf(Math.pow(1024, -difference)), 10, RoundingMode.HALF_UP);
            }
            
            resultLabel.setText("Result: " + result.toPlainString() + " " + units[toIndex]);

        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Invalid Input");
        }
    }
}
