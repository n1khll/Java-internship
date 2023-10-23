import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PwdChecker extends JFrame {

    private JPasswordField pwdField;
    private JCheckBox showPwdBox;
    private JLabel strengthLbl;

    public PwdChecker() {
        setTitle("Pwd Checker");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        pwdField = new JPasswordField();
        showPwdBox = new JCheckBox("Show Password");
        JButton checkBtn = new JButton("Check Strength");
        strengthLbl = new JLabel("Your Password is: ");

        setLayout(new GridLayout(4, 1));

        add(pwdField);
        add(showPwdBox);
        add(checkBtn);
        add(strengthLbl);

        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pwd = new String(pwdField.getPassword());
                int strength = checkStrength(pwd);
                displayStrength(strength);
            }
        });

        showPwdBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char echoChar = showPwdBox.isSelected() ? (char) 0 : '\u2022';
                pwdField.setEchoChar(echoChar);
            }
        });
    }

    private int checkStrength(String pwd) {
        int strength = 0;

        if (pwd.length() >= 8) {
            strength++;
        }

        if (pwd.matches(".*\\d.*")) {
            strength++;
        }

        if (pwd.matches(".*[A-Z].*")) {
            strength++;
        }

        if (pwd.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            strength++;
        }

        return strength;
    }

    private void displayStrength(int strength) {
        String strengthText;
        switch (strength) {
            case 0:
                strengthText = "Very Weak";
                break;
            case 1:
                strengthText = "Weak";
                break;
            case 2:
                strengthText = "Moderate";
                break;
            case 3:
                strengthText = "Strong";
                break;
            case 4:
                strengthText = "Very Strong";
                break;
            default:
                strengthText = "Invalid";
        }
        strengthLbl.setText("Your Password is: " + strengthText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PwdChecker().setVisible(true);
            }
        });
    }
}
