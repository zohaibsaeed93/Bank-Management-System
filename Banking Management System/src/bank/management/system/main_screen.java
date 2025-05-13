package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_screen extends JFrame implements ActionListener {

    JButton button1,button2, button3, button4,button5,button6,button7;
    String pin;
    main_screen(String pin){
        this.pin = pin;
        ImageIcon atmimg1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atmimg2 = atmimg1.getImage().getScaledInstance(1000,997, Image.SCALE_DEFAULT);
        ImageIcon atmim3 = new ImageIcon(atmimg2);
        JLabel imglabel = new JLabel(atmim3);
        imglabel.setBounds(250,0,1000,997);
        add(imglabel);

        button1 = new JButton("Deposit");
        button1.setForeground(Color.WHITE);
        button1.setBackground(new Color(193, 80, 109));
        button1.setBounds(200,350,150,30);
        button1.addActionListener(this);
        imglabel.add(button1);
        button2 = new JButton("Cash Withdrawal");
        button2.setForeground(Color.WHITE);
        button2.setBackground(new Color(193, 80, 109));
        button2.setBounds(420,350,150,30);
        button2.addActionListener(this);
        imglabel.add(button2);
        button3 = new JButton("Fast Cash");
        button3.setForeground(Color.WHITE);
        button3.setBackground(new Color(193, 80, 109));
        button3.setBounds(200,395,150,30);
        button3.addActionListener(this);
        imglabel.add(button3);
        button4 = new JButton("Account Statement");
        button4.setForeground(Color.WHITE);
        button4.setBackground(new Color(193, 80, 109));
        button4.setBounds(420,395,150,30);
        button4.addActionListener(this);
        imglabel.add(button4);
        button5 = new JButton("Pin Change");
        button5.setForeground(Color.WHITE);
        button5.setBackground(new Color(193, 80, 109));
        button5.setBounds(200,440,150,30);
        button5.addActionListener(this);
        imglabel.add(button5);
        button6 = new JButton("Balance Enquiry");
        button6.setForeground(Color.WHITE);
        button6.setBackground(new Color(193, 80, 109));
        button6.setBounds(420,440,150,30);
        button6.addActionListener(this);
        imglabel.add(button6);
        button7 = new JButton("Exit");
        button7.setForeground(Color.WHITE);
        button7.setBackground(new Color(193, 80, 109));
        button7.setBounds(420,485,150,30);
        button7.addActionListener(this);
        imglabel.add(button7);







        JLabel label = new JLabel("Welcome! Please select an option.");
        label.setBounds(220,260,400,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Helvetica", Font.BOLD,20));
        imglabel.add(label);
        setLayout(null);
        setSize(1920,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            new Deposit(pin);
            setVisible(false);
        }
        else if(e.getSource()==button7) {
            System.exit(0);
        }
        else if (e.getSource()==button2){
            new cash_withdrawal_class(pin);
            setVisible(false);
        }
        else if(e.getSource()==button6){
            new balance_enquiry(pin);
            setVisible(false);

        }
        else if (e.getSource()==button3){
            new Fast_Cash(pin);
            setVisible(false);
        }
        else if (e.getSource()==button5){
            new pinchange(pin);
            setVisible(false);
        }
        else if (e.getSource()== button4){
            new accstatement(pin);
        }
    }


    public static void main(String[] args) {
        new main_screen("");
    }
}

