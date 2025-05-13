package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinchange extends JFrame implements ActionListener {
    JButton depositbutton,backbutton;
    JPasswordField p1,p2;
    String pin;
    pinchange(String pin){
        this.pin = pin;
        ImageIcon atmimg1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atmimg2 = atmimg1.getImage().getScaledInstance(1000,997, Image.SCALE_DEFAULT);
        ImageIcon atmim3 = new ImageIcon(atmimg2);
        JLabel imglabel = new JLabel(atmim3);
        imglabel.setBounds(250,0,1000,997);
        add(imglabel);

        JLabel infolabel = new JLabel("CHANGE YOUR PIN");
        infolabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        infolabel.setBounds(320,260,700,35);
        infolabel.setForeground(Color.WHITE);
        imglabel.add(infolabel);
        JLabel label2 = new JLabel("New Pin: ");
        label2.setFont(new Font("Helvetica", Font.BOLD, 14));
        label2.setBounds(210,300,700,25);
        label2.setForeground(Color.WHITE);
        imglabel.add(label2);


        p1 = new JPasswordField();
        p1.setBackground(new Color(193, 80, 109));
        p1.setBounds(210,330, 200,25);
        p1.setForeground(Color.WHITE);
        p1.setFont(new Font("Helvetica", Font.BOLD,16));
        imglabel.add(p1);
        JLabel label3 = new JLabel("Re-Enter Pin: ");
        label3.setFont(new Font("Helvetica", Font.BOLD, 14));
        label3.setBounds(210,370,400,35);
        label3.setForeground(Color.WHITE);
        imglabel.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(193, 80, 109));
        p2.setBounds(210,400, 200,25);
        p2.setForeground(Color.WHITE);
        p2.setFont(new Font("Helvetica", Font.BOLD,16));
        imglabel.add(p2);

        depositbutton = new JButton("CHANGE");
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
            String pin1 = p1.getText();
            String pin2 = p2.getText();
            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null, "Pins do not match.Retry.");
                return;

            }
            if(e.getSource()==depositbutton){
                if(p1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter new pin");
                    return;
                }
                if(p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-enter new pin");
                    return;

                }
                Conn c = new Conn();
                String q1 = "update bank set pin = '"+pin1+"'where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"'where pin = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+pin1+"'where pin = '"+pin+"'";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);
                JOptionPane.showMessageDialog(null, "pin changed successfully");
                setVisible(false);
                new main_screen(pin);

            }
            else if (e.getSource() == backbutton){
                new main_screen(pin);
                setVisible(false);
            }
        }
        catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new pinchange("");

    }
}
