package bank.management.system;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class cash_withdrawal_class extends JFrame implements ActionListener {
    String pin;

    TextField textField;
    JButton depositbutton, backbutton;
    cash_withdrawal_class(String pin){
        this.pin = pin;

        ImageIcon atmimg1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atmimg2 = atmimg1.getImage().getScaledInstance(1000,997, Image.SCALE_DEFAULT);
        ImageIcon atmim3 = new ImageIcon(atmimg2);
        JLabel imglabel = new JLabel(atmim3);
        imglabel.setBounds(250,0,1000,997);
        add(imglabel);

        JLabel infolabel = new JLabel("Enter the amount you wish to withdraw. (MAX 5000)");
        infolabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        infolabel.setBounds(205,260,700,35);
        infolabel.setForeground(Color.WHITE);
        imglabel.add(infolabel);



        textField = new TextField();
        textField.setBackground(new Color(193, 80, 109));
        textField.setBounds(225,300, 320,20);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Helvetica", Font.BOLD,16));
        imglabel.add(textField);

        depositbutton = new JButton("WITHDRAW");
        depositbutton.setBounds(450,445,120,30);
        depositbutton.setBackground(new Color(193, 80, 109));
        depositbutton.setForeground(Color.WHITE);
        depositbutton.addActionListener(this);
        imglabel.add(depositbutton);

        backbutton = new JButton("RETURN");
        backbutton.setBounds(450,485,120,30);
        backbutton.setBackground(new Color(193, 80, 109));
        backbutton.setForeground(Color.WHITE);
        backbutton.addActionListener(this);

        imglabel.add(backbutton);



        setLayout(null);
        setSize(1920,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==depositbutton) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "You haven't entered an amount for withdrawal. Retry.");
                } else {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));

                        } else {
                            balance = Integer.parseInt(resultSet.getString("amount"));

                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Funds");
                        return;


                    }
                    c.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "','Withdrawal', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "£. " + amount + " withdrawn successfully");
                    setVisible(false);
                    new main_screen(pin);
                }
            } catch (Exception E) {

            }
        }else if(e.getSource()==backbutton){
            setVisible(false);
            new main_screen(pin);

        }
    }

    public static void main(String[] args) {
        new cash_withdrawal_class("");
    }
}
