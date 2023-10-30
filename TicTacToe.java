import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private boolean playerXTurn;
    private JLabel statusLabel;
    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new BorderLayout());

        buttons = new JButton[3][3];
        playerXTurn = true;

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                buttonPanel.add(buttons[i][j]);
            }

        statusLabel = new JLabel("Player X's turn", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));

        add(buttonPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton.getText().equals("")) {
            if (playerXTurn) {
                clickedButton.setText("X");
                clickedButton.setForeground(Color.RED);
                statusLabel.setText("Player O's turn");
            } else {
                clickedButton.setText("O");
                clickedButton.setForeground(Color.BLUE);
                statusLabel.setText("Player X's turn");
            }

            if (checkWin()) {
                String winner = playerXTurn ? "Player X" : "Player O";
                statusLabel.setText(winner + " wins!");
                disableAllButtons();
            } else if (checkDraw()) {
                statusLabel.setText("It's a draw!");
                disableAllButtons();
            } else {
                playerXTurn = !playerXTurn;
            }
        }
    }
    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][1].getText().equals(buttons[i][2].getText())
                    && !buttons[i][0].getText().equals(""))
                return true;
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[1][i].getText().equals(buttons[2][i].getText())
                    && !buttons[0][i].getText().equals(""))
                return true;
        }

        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText())
                && !buttons[0][0].getText().equals(""))
            return true;

        return buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText())
                && !buttons[0][2].getText().equals("");
    }
    private boolean checkDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (buttons[i][j].getText().equals(""))
                    return false;
        return true;
    }
    private void disableAllButtons() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j].setEnabled(false);
    }
}
