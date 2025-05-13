package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton savingbutton, fixbutton, depositbutton, currentbutton;
    JCheckBox atmbutton,onlinebutton, appbutton, emailbutton,chequebutton,statementbutton;
    JButton submitbutton, cancelbutton;
    String formno;
    Signup3(String formno){
        this.formno = formno;

        ImageIcon bankimg1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bankimg2 = bankimg1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon bankimg3 = new ImageIcon(bankimg2);
        JLabel bankimg = new JLabel(bankimg3);
        bankimg.setBounds(30,5,100,100);
        add(bankimg);

        JLabel pagelabel = new JLabel("Page 3: ");
        pagelabel.setFont(new Font("Helvetica", Font.BOLD,22));
        pagelabel.setBounds(150,40,400,40);
        add(pagelabel);
        JLabel accountlabel = new JLabel("Account Details ");
        accountlabel.setFont(new Font("Helvetica", Font.BOLD,22));
        accountlabel.setBounds(150,70,400,40);
        add(accountlabel);

        JLabel typelabel = new JLabel("Account Type: ");
        typelabel.setFont(new Font("Helvetica", Font.BOLD,16));
        typelabel.setBounds(100,140,200,30);
        add(typelabel);

        savingbutton = new JRadioButton("Savings Account");
        savingbutton.setFont(new Font("Helvetica", Font.BOLD,14));
        savingbutton.setBounds(100,180,150,30);
        savingbutton.setBackground(new Color(193, 80, 109));
        add(savingbutton);
        fixbutton = new JRadioButton("Fixed Deposit Account");
        fixbutton.setFont(new Font("Helvetica", Font.BOLD,14));
        fixbutton.setBounds(350,180,300,30);
        fixbutton.setBackground(new Color(193, 80, 109));
        add(fixbutton);

        currentbutton = new JRadioButton("Current Account");
        currentbutton.setFont(new Font("Helvetica", Font.BOLD,14));
        currentbutton.setBounds(100,220,250,30);
        currentbutton.setBackground(new Color(193, 80, 109));
        add(currentbutton);

        depositbutton = new JRadioButton("Recurring Deposit Account");
        depositbutton.setFont(new Font("Helvetica", Font.BOLD,14));
        depositbutton.setBounds(350,220,250,30);
        depositbutton.setBackground(new Color(193, 80, 109));
        add(depositbutton);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(savingbutton);
        accountgroup.add(depositbutton);
        accountgroup.add(currentbutton);
        accountgroup.add(fixbutton);

        JLabel cardlabel = new JLabel("Card Number: ");
        cardlabel.setFont(new Font ("Helvetica", Font.BOLD, 16));
        cardlabel.setBounds(100,300,200,30);
        add(cardlabel);

        JLabel digitlabel = new JLabel("(Your 16-digit Card Number)");

        digitlabel.setFont(new Font ("Helvetica", Font.BOLD, 10));
        digitlabel.setBounds(100,320,200,20);
        add(digitlabel);

        JLabel numlabel = new JLabel("XXXX-XXXX-XXXX-1111");
        numlabel.setFont(new Font ("Helvetica", Font.BOLD, 16));
        numlabel.setBounds(330,300,250,30);
        add(numlabel);

        JLabel pinnerlabel = new JLabel("PIN: ");
        pinnerlabel.setFont(new Font ("Helvetica", Font.BOLD, 16));
        pinnerlabel.setBounds(100,370,200,30);
        add(pinnerlabel);

        JLabel hiddenpinlabel = new JLabel("XXXX");
        hiddenpinlabel.setFont(new Font ("Helvetica", Font.BOLD, 16));
        hiddenpinlabel.setBounds(330,370,200,30);
        add(hiddenpinlabel);

        JLabel digitpasslabel = new JLabel("(4-digit Password)");
        digitpasslabel.setFont(new Font ("Helvetica", Font.BOLD, 10));
        digitpasslabel.setBounds(100,390,200,20);
        add(digitpasslabel);

        JLabel servicelabel = new JLabel("Available Services:");
        servicelabel.setFont(new Font("Helvetica", Font.BOLD, 16));
        servicelabel.setBounds(100,450,200,30);
        add(servicelabel);
        atmbutton = new JCheckBox("ATM CARD");
        atmbutton.setBackground(new Color(193, 80, 109));
        atmbutton.setFont(new Font("Helvetica", Font.BOLD,14));
        atmbutton.setBounds(100,500,200,30);
        add(atmbutton);
        onlinebutton = new JCheckBox("Online Banking");
        onlinebutton.setBackground(new Color(193, 80, 109));
        onlinebutton.setFont(new Font("Helvetica", Font.BOLD,14));
        onlinebutton.setBounds(350,500,200,30);
        add(onlinebutton);
        appbutton = new JCheckBox("Mobile App");
        appbutton.setBackground(new Color(193, 80, 109));
        appbutton.setFont(new Font("Helvetica", Font.BOLD,14));
        appbutton.setBounds(100,550,200,30);
        add(appbutton);
        emailbutton = new JCheckBox("Email Notifications");
        emailbutton.setBackground(new Color(193, 80, 109));
        emailbutton.setFont(new Font("Helvetica", Font.BOLD,14));
        emailbutton.setBounds(350,550,200,30);
        add(emailbutton);
        chequebutton = new JCheckBox("Cheque Book");
        chequebutton.setBackground(new Color(193, 80, 109));
        chequebutton.setFont(new Font("Helvetica", Font.BOLD,14));
        chequebutton.setBounds(100,600,200,30);
        add(chequebutton);
        statementbutton = new JCheckBox("Account Statement");
        statementbutton.setBackground(new Color(193, 80, 109));
        statementbutton.setFont(new Font("Helvetica", Font.BOLD,14));
        statementbutton.setBounds(350,600,200,30);
        add(statementbutton);

        JCheckBox agreebutton = new JCheckBox("I hereby agree to the Terms of Service and the conditions outlined by the bank. I understand and accept all the policies mentioned therein.", true);
        agreebutton.setBackground(new Color(193, 80, 109));
        agreebutton.setFont(new Font("Helvetica", Font.BOLD,10));
        agreebutton.setBounds(50,660,800,30);
        add(agreebutton);


        JLabel formnumlabel = new JLabel("Form No: ");
        formnumlabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        formnumlabel.setBounds(650,10,100,30);
        add(formnumlabel);

        JLabel formlabel = new JLabel(formno);
        formlabel.setFont(new Font("Helvetica", Font.BOLD, 16));
        formlabel.setBounds(730,10,150,30);
        add(formlabel);

        submitbutton = new JButton("Submit");
        submitbutton.setFont(new Font("Helvetica", Font.BOLD, 14));
        submitbutton.setForeground(Color.WHITE);
        submitbutton.setBackground(new Color(2, 14, 28));
        submitbutton.setBounds(500, 700, 100, 30);
        submitbutton.addActionListener(this);
        add(submitbutton);
        cancelbutton = new JButton("Cancel");
        cancelbutton.setFont(new Font("Helvetica", Font.BOLD, 14));
        cancelbutton.setForeground(Color.WHITE);
        cancelbutton.setBackground(new Color(2, 14, 28));
        cancelbutton.setBounds(650, 700, 100, 30);
        cancelbutton.addActionListener(this);
        add(cancelbutton);


        getContentPane().setBackground(new Color(193, 80, 109));
        setSize(850,800);
        setLayout(null);
        setLocation(400,20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String atype = null;
        if(savingbutton.isSelected()){
            atype = "Savings Account";
        }
        else if (fixbutton.isSelected()){
            atype = "Fixed Deposit Account";
        }
        else if(currentbutton.isSelected()){
            atype = "Current Account";

        }
        else if(depositbutton.isSelected()){
            atype = "Recurring Deposit Account";

        }
        Random rand = new Random();
        long first7 = (rand.nextLong() % 90000000L) + 4278323000000000L;
        String cardno = "" + Math.abs(first7);
        long first3 = (rand.nextLong()%9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String serv = "";
        if(atmbutton.isSelected()){
            serv += "ATM CARD";
        }
        else if (onlinebutton.isSelected()) {
            serv += "Online Banking";

        }
        else if(appbutton.isSelected()){
            serv += "Mobile App";

        }
        else if (emailbutton.isSelected()){
            serv += "Email Notifications";

        }
        else if(chequebutton.isSelected()){
            serv +="Cheque Book";
        }
        else if(statementbutton.isSelected()){
            serv += "Account Statement";
        }
        try{
            if(e.getSource()==submitbutton){
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Please provide the required information.");

                }
                else{
                    Conn c1 = new Conn();
                    String q1 = "insert into signupthree values('"+formno+"', '"+atype+"', '"+cardno+"', '"+pin+"','"+serv+"')";

                    String q2 = "INSERT INTO login (form_no, cardnumber, pin) VALUES ('"+formno+"', '"+cardno+"', '"+pin+"')";

                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: "+cardno+ "\n Pin: "+pin);
                    new Deposit(pin);
                    setVisible(false);
                }

            }
            else if (e.getSource()== cancelbutton){
                System.exit(0);
            }
        }
        catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Signup3("");
    }
}
