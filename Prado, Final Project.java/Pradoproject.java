import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VolumeConverterGUI extends JFrame {
    private JTextField volumeTextField;
    private JComboBox<String> conversionComboBox;
    private JLabel resultLabel;

    public VolumeConverterGUI() {
        setTitle("Volume Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Volume input
        JLabel volumeLabel = new JLabel("Enter the volume: ");
        volumeTextField = new JTextField(10);
        add(volumeLabel);
        add(volumeTextField);

        // Conversion type selection
        JLabel conversionLabel = new JLabel("Choose the volume type to convert: ");
        String[] conversionOptions = {"Milliliters to Microliters", "Microliters to Milliliters",
                                      "Quarts to Gallons", "Gallons to Quarts"};
        conversionComboBox = new JComboBox<>(conversionOptions);
        add(conversionLabel);
        add(conversionComboBox);

        // Convert button
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ConvertButtonListener());
        add(convertButton);

        // Result
        resultLabel = new JLabel();
        add(resultLabel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ConvertButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double volume = Double.parseDouble(volumeTextField.getText());
            int choice = conversionComboBox.getSelectedIndex() + 1;
            double convertedVolume;

            switch (choice) {
                case 1:
                    convertedVolume = volume * 1000;
                    resultLabel.setText(String.format("%.2f milliliters is equal to %.2f microliters", volume, convertedVolume));
                    break;
                case 2:
                    convertedVolume = volume / 1000;
                    resultLabel.setText(String.format("%.2f microliters is equal to %.2f milliliters", volume, convertedVolume));
                    break;
                case 3:
                    convertedVolume = volume / 4;
                    resultLabel.setText(String.format("%.2f quarts is equal to %.2f gallons", volume, convertedVolume));
                    break;
                case 4:
                    convertedVolume = volume * 4;
                    resultLabel.setText(String.format("%.2f gallons is equal to %.2f quarts", volume, convertedVolume));
                    break;
                default:
                    resultLabel.setText("Invalid choice");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VolumeConverterGUI());
    }
}