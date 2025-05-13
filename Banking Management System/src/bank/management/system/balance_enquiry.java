package bank.management.system;


import com.mysql.cj.jdbc.ha.BalanceStrategy;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balance_enquiry extends JFrame implements ActionListener {
    String pin;

    JLabel label2;
    JButton depositbutton;
    balance_enquiry(String pin){
        this.pin = pin;
        ImageIcon atmimg1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atmimg2 = atmimg1.getImage().getScaledInstance(1000,997, Image.SCALE_DEFAULT);
        ImageIcon atmim3 = new ImageIcon(atmimg2);
        JLabel imglabel = new JLabel(atmim3);
        imglabel.setBounds(250,0,1000,997);
        add(imglabel);

        JLabel infolabel = new JLabel("Your current balance is £ ");
        infolabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        infolabel.setBounds(210,260,700,35);
        infolabel.setForeground(Color.WHITE);
        imglabel.add(infolabel);

        label2 = new JLabel();
        label2.setFont(new Font("Helvetica", Font.BOLD, 14));
        label2.setBounds(210,280,700,35);
        label2.setForeground(Color.WHITE);
        imglabel.add(label2);

        depositbutton = new JButton("RETURN");
        depositbutton.setBounds(450,445,120,30);
        depositbutton.setBackground(new Color(193, 80, 109));
        depositbutton.setForeground(Color.WHITE);
        depositbutton.addActionListener(this);
        imglabel.add(depositbutton);
        int balance =0;
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin = '"+pin+"'");
            while(resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        label2.setText(""+balance);


        setLayout(null);
        setSize(1920,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_screen(pin);
    }

    public static void main(String[] args) {
        new balance_enquiry("");
    }
}
