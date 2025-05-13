package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;

    TextField textField;
    JButton depositbutton, backbutton;

    Deposit(String pin){
        this.pin = pin;
        ImageIcon atmimg1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atmimg2 = atmimg1.getImage().getScaledInstance(1000,997, Image.SCALE_DEFAULT);
        ImageIcon atmim3 = new ImageIcon(atmimg2);
        JLabel imglabel = new JLabel(atmim3);
        imglabel.setBounds(250,0,1000,997);
        add(imglabel);

        JLabel infolabel = new JLabel("Please enter the amount you wish to deposit.");
        infolabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        infolabel.setBounds(225,260,400,35);
        infolabel.setForeground(Color.WHITE);
        imglabel.add(infolabel);

        textField = new TextField();
        textField.setBackground(new Color(193, 80, 109));
        textField.setBounds(225,300, 320,20);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Helvetica", Font.BOLD,16));
        imglabel.add(textField);

        depositbutton = new JButton("DEPOSIT");
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
        try{


            String amount = textField.getText();
            Date date = new Date();
            if(e.getSource()==depositbutton){
                if(textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Amount has not been provided. Retry.");
                }else {
                    Conn c = new Conn();
                    c.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "','Deposit','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "£. " + amount + " has been added to your account.");
                    setVisible(false);
                    new main_screen(pin);
                }

            }
            else if(e.getSource()==backbutton){
                setVisible(false);
                new main_screen(pin);

            }

        }
        catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");

    }
}
