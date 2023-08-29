import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton submitButton;

    public MyFrame() {
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        // Add label and text field for First Name
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("First Name:"), constraints);

        constraints.gridx = 1;
        panel.add(firstNameField, constraints);

        // Add label and text field for Last Name
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Last Name:"), constraints);

        constraints.gridx = 1;
        panel.add(lastNameField, constraints);

        // Add the Submit button
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(submitButton, constraints);

        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
