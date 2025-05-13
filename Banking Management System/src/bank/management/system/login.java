package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField usernamefield2;
    JPasswordField passwordField3;
    JButton signinButton, clearButton, signupButton;

    login() {
        super("Summer's Bank");


        ImageIcon backgroundimg1 = new ImageIcon(ClassLoader.getSystemResource("icon/gradient.png"));
        Image backgroundimg2 = backgroundimg1.getImage().getScaledInstance(850, 450, Image.SCALE_DEFAULT);
        ImageIcon backgroundimg3 = new ImageIcon(backgroundimg2);
        JLabel backgroundimg = new JLabel(backgroundimg3);
        backgroundimg.setBounds(0, 0, 850, 450);
        add(backgroundimg);


        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(193, 80, 109));

        leftPanel.setBounds(0, 0, 210, 450);
        leftPanel.setLayout(null);
        backgroundimg.add(leftPanel);

        ImageIcon leftBankIcon = new ImageIcon(getClass().getResource("/icon/bank.png"));
        Image leftBankImage = leftBankIcon.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        JLabel leftBankIconLabel = new JLabel(new ImageIcon(leftBankImage));
        leftBankIconLabel.setBounds(65, 30, 80, 80);
        leftPanel.add(leftBankIconLabel);

        JLabel leftBankName = new JLabel("Summer's Bank");
        leftBankName.setForeground(Color.WHITE);
        leftBankName.setFont(new Font("Helvetica", Font.BOLD, 17));
        leftBankName.setBounds(40, 120, 140, 30);
        leftPanel.add(leftBankName);

        JLabel leftBankSlogan = new JLabel("Unlock your Financial Potential :(");
        leftBankSlogan.setForeground(Color.WHITE);
        leftBankSlogan.setFont(new Font("Helvetica", Font.PLAIN, 13));
        leftBankSlogan.setBounds(16, 150, 210, 20);
        leftPanel.add(leftBankSlogan);

        // Buttons on the left panel
        signinButton = new JButton("Sign in");
        signinButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        signinButton.setForeground(Color.WHITE);
        signinButton.setBackground(Color.BLACK);
        signinButton.setBounds(55, 200, 100, 30);
        signinButton.addActionListener(this);
        leftPanel.add(signinButton);

        signupButton = new JButton("Sign up");
        signupButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        signupButton.setForeground(Color.WHITE);
        signupButton.setBackground(Color.BLACK);
        signupButton.setBounds(55, 250, 100, 30);
        signupButton.addActionListener(this);
        leftPanel.add(signupButton);


        ImageIcon banking1 = new ImageIcon(ClassLoader.getSystemResource("icon/black.png" ));
        Image bankimg2 = banking1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel banking = new JLabel(new ImageIcon(bankimg2));
        banking.setBounds(500, 15, 100, 100);
        backgroundimg.add(banking);


        label1 = new JLabel("Welcome to Our Bank :(");
        label1.setForeground(Color.WHITE);
        label1.setBounds(400, 125, 450, 40);
        label1.setFont(new Font("Helvetica", Font.BOLD, 30));
        backgroundimg.add(label1);

        label2 = new JLabel("Card number:");
        label2.setFont(new Font("Helvetica", Font.BOLD, 20));
        label2.setForeground(Color.WHITE);
        label2.setBounds(300, 190, 375, 30);
        backgroundimg.add(label2);

        usernamefield2 = new JTextField(15);
        usernamefield2.setBounds(450, 195, 230, 30);
        usernamefield2.setForeground(Color.WHITE);
        usernamefield2.setBackground(Color.BLACK);
        usernamefield2.setFont(new Font("Arial", Font.BOLD, 14));
        backgroundimg.add(usernamefield2);

        label3 = new JLabel("Enter PIN:");
        label3.setFont(new Font("Helvetica", Font.BOLD, 20));
        label3.setForeground(Color.WHITE);
        label3.setBounds(300, 250, 375, 30);
        backgroundimg.add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(450, 250, 230, 30);
        passwordField3.setForeground(Color.WHITE);
        passwordField3.setBackground(Color.BLACK);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        backgroundimg.add(passwordField3);


        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.BLACK);
        clearButton.setBounds(510, 300, 100, 30);
        clearButton.addActionListener(this);
        backgroundimg.add(clearButton);


        setLayout(null);
        setSize(850, 450);
        setLocation(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == signupButton) {
                new Signup();
                setVisible(false);
            } else if (e.getSource() == clearButton) {
                usernamefield2.setText("");
                passwordField3.setText("");
            } else if (e.getSource() == signinButton) {
                Conn c = new Conn();
                String cardno = usernamefield2.getText();
                String pin = passwordField3.getText();
                String q = "select * from login where cardnumber = '"+cardno+"'and pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    setVisible(false);
                    new main_screen(pin);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Credentials Entered.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
