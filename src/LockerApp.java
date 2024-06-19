import javax.swing.*;
import java.awt.*;

public class LockerApp extends JFrame {
    private String password = null;
    private JTextField statusField;

    public LockerApp() {
        setTitle("Lock Class");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(4, 3));

        // Create the number buttons
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(e -> updatePasswordField(e.getActionCommand()));
            add(button);
        }

        // Create the "Clear" and "Enter" buttons
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> statusField.setText(""));
        add(clearButton);

        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(e -> handleEnter());
        add(enterButton);

        // Create the "Password Set" text field
        statusField = new JTextField("Password Set");
        statusField.setEditable(false);
        add(statusField);
    }

    private void updatePasswordField(String digit) {
        if (statusField.getText().equals("Password Set")) {
            statusField.setText(digit);
        } else {
            statusField.setText(statusField.getText() + digit);
        }
    }

    private void handleEnter() {
        String enteredPassword = statusField.getText();
        if (password == null) {
            password = enteredPassword;
            statusField.setText("Password Set");
        } else if (enteredPassword.equals(password)) {
            statusField.setText("Correct Password");
        } else {
            statusField.setText("Incorrect Password");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LockerApp app = new LockerApp();
            app.setVisible(true);
        });
    }
}
