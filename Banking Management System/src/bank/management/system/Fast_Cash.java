package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fast_Cash extends JFrame implements ActionListener {
    JButton button1, button2, button3, button4, button5, button6, button7;
    String pin;

    Fast_Cash(String pin) {
        this.pin = pin;

        ImageIcon atmimg1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atmimg2 = atmimg1.getImage().getScaledInstance(1000, 997, Image.SCALE_DEFAULT);
        ImageIcon atmim3 = new ImageIcon(atmimg2);
        JLabel imglabel = new JLabel(atmim3);
        imglabel.setBounds(250, 0, 1000, 997);
        add(imglabel);

        button1 = new JButton("£100");
        button1.setForeground(Color.WHITE);
        button1.setBackground(new Color(193, 80, 109));
        button1.setBounds(200, 350, 150, 30);
        button1.addActionListener(this);
        imglabel.add(button1);

        button2 = new JButton("£300");
        button2.setForeground(Color.WHITE);
        button2.setBackground(new Color(193, 80, 109));
        button2.setBounds(420, 350, 150, 30);
        button2.addActionListener(this);
        imglabel.add(button2);

        button3 = new JButton("£700");
        button3.setForeground(Color.WHITE);
        button3.setBackground(new Color(193, 80, 109));
        button3.setBounds(200, 395, 150, 30);
        button3.addActionListener(this);
        imglabel.add(button3);

        button4 = new JButton("£1000");
        button4.setForeground(Color.WHITE);
        button4.setBackground(new Color(193, 80, 109));
        button4.setBounds(420, 395, 150, 30);
        button4.addActionListener(this);
        imglabel.add(button4);

        button5 = new JButton("£1500");
        button5.setForeground(Color.WHITE);
        button5.setBackground(new Color(193, 80, 109));
        button5.setBounds(200, 440, 150, 30);
        button5.addActionListener(this);
        imglabel.add(button5);

        button6 = new JButton("£2000");
        button6.setForeground(Color.WHITE);
        button6.setBackground(new Color(193, 80, 109));
        button6.setBounds(420, 440, 150, 30);
        button6.addActionListener(this);
        imglabel.add(button6);

        button7 = new JButton("RETURN");
        button7.setForeground(Color.WHITE);
        button7.setBackground(new Color(193, 80, 109));
        button7.setBounds(420, 485, 150, 30);
        button7.addActionListener(this);
        imglabel.add(button7);

        JLabel label = new JLabel("Select Withdrawal Amount");
        label.setBounds(265, 260, 400, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Helvetica", Font.BOLD, 20));
        imglabel.add(label);

        setLayout(null);
        setSize(1920, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button7) {
            setVisible(false);
            new main_screen(pin);
        } else {
            String amount = ((JButton) e.getSource()).getText().substring(1).trim(); // Fix the substring for amount
            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Invalid amount selected!");
                return;
            }
            Conn c = new Conn();
            Date date = new Date();
            try {
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                int balance = 0;
                while (resultSet.next()) {
                    if (resultSet.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Funds");
                    return;
                }

                c.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "', 'withdrawal', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "£" + amount + " withdrawn Successfully");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            setVisible(false);
            new main_screen(pin);
        }
    }

    public static void main(String[] args) {
        new Fast_Cash("");
    }
}
