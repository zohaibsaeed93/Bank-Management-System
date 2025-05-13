package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    JRadioButton malebutton, femalebutton, married, unmarried, other;
    JButton next;
    JTextField textclientname, textfathername, textemail, textaddress, textcity, textpin, textstate;
    JDateChooser dateChooser;
    Random rand = new Random();
    long num = (rand.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(num);

    Signup() {
        super("Bank Account Registration Form");

        // Set the icon and header
        ImageIcon banking1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bankimg2 = banking1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon bankimg3 = new ImageIcon(bankimg2);
        JLabel banking = new JLabel(bankimg3);
        banking.setBounds(40, 10, 80, 80);
        add(banking);

        JLabel label1 = new JLabel("Application Form No." + first);
        label1.setBounds(140, 30, 600, 40);
        label1.setFont(new Font("Helvetica", Font.BOLD, 24));
        add(label1);

        JLabel label2 = new JLabel("Personal Information");
        label2.setFont(new Font("Helvetica", Font.BOLD, 18));
        label2.setBounds(40, 100, 400, 30);
        add(label2);

        // Labels and Fields
        JLabel labelclientname = new JLabel("Full Name:");
        labelclientname.setFont(new Font("Helvetica", Font.BOLD, 16));
        labelclientname.setBounds(40, 150, 120, 30);
        add(labelclientname);
        textclientname = new JTextField();
        textclientname.setFont(new Font("Helvetica", Font.BOLD, 14));
        textclientname.setBounds(170, 150, 250, 30);
        add(textclientname);

        JLabel labelfathername = new JLabel("Father's Name:");
        labelfathername.setFont(new Font("Helvetica", Font.BOLD, 16));
        labelfathername.setBounds(40, 200, 120, 30);
        add(labelfathername);
        textfathername = new JTextField();
        textfathername.setFont(new Font("Helvetica", Font.BOLD, 14));
        textfathername.setBounds(170, 200, 250, 30);
        add(textfathername);

        JLabel dateOfBirth = new JLabel("Date of Birth:");
        dateOfBirth.setFont(new Font("Helvetica", Font.BOLD, 16));
        dateOfBirth.setBounds(40, 250, 120, 30);
        add(dateOfBirth);

        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("Helvetica", Font.BOLD, 14));
        dateChooser.setBounds(170, 250, 250, 30);
        add(dateChooser);

        JLabel genderlabel = new JLabel("Gender:");
        genderlabel.setFont(new Font("Helvetica", Font.BOLD, 16));
        genderlabel.setBounds(40, 300, 120, 30);
        add(genderlabel);

        malebutton = new JRadioButton("Male");
        malebutton.setFont(new Font("Helvetica", Font.BOLD, 14));
        malebutton.setBackground(new Color(193, 80, 109));
        malebutton.setBounds(170, 300, 80, 30);
        add(malebutton);

        femalebutton = new JRadioButton("Female");
        femalebutton.setFont(new Font("Helvetica", Font.BOLD, 14));
        femalebutton.setBackground(new Color(193, 80, 109));
        femalebutton.setBounds(260, 300, 100, 30);
        add(femalebutton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(malebutton);
        genderGroup.add(femalebutton);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
        emailLabel.setBounds(40, 350, 120, 30);
        add(emailLabel);

        textemail = new JTextField();
        textemail.setFont(new Font("Helvetica", Font.BOLD, 14));
        textemail.setBounds(170, 350, 250, 30);
        add(textemail);

        JLabel marriagelabel = new JLabel("Marital Status:");
        marriagelabel.setFont(new Font("Helvetica", Font.BOLD, 16));
        marriagelabel.setBounds(40, 400, 120, 30);
        add(marriagelabel);

        married = new JRadioButton("Married");
        married.setFont(new Font("Helvetica", Font.BOLD, 14));
        married.setBackground(new Color(193, 80, 109));
        married.setBounds(170, 400, 100, 30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Helvetica", Font.BOLD, 14));
        unmarried.setBackground(new Color(193, 80, 109));
        unmarried.setBounds(265, 400, 100, 30);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setFont(new Font("Helvetica", Font.BOLD, 14));
        other.setBackground(new Color(193, 80, 109));
        other.setBounds(370, 400, 100, 30);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel labeladdress = new JLabel("Address:");
        labeladdress.setFont(new Font("Helvetica", Font.BOLD, 16));
        labeladdress.setBounds(40, 450, 120, 30);
        add(labeladdress);

        textaddress = new JTextField();
        textaddress.setFont(new Font("Helvetica", Font.BOLD, 14));
        textaddress.setBounds(170, 450, 250, 30);
        add(textaddress);

        JLabel labelcity = new JLabel("City:");
        labelcity.setFont(new Font("Helvetica", Font.BOLD, 16));
        labelcity.setBounds(40, 500, 120, 30);
        add(labelcity);

        textcity = new JTextField();
        textcity.setFont(new Font("Helvetica", Font.BOLD, 14));
        textcity.setBounds(170, 500, 250, 30);
        add(textcity);

        JLabel labelpin = new JLabel("Pin Code:");
        labelpin.setFont(new Font("Helvetica", Font.BOLD, 16));
        labelpin.setBounds(40, 550, 120, 30);
        add(labelpin);

        textpin = new JTextField();
        textpin.setFont(new Font("Helvetica", Font.BOLD, 14));
        textpin.setBounds(170, 550, 250, 30);
        add(textpin);

        JLabel labelstate = new JLabel("State:");
        labelstate.setFont(new Font("Helvetica", Font.BOLD, 16));
        labelstate.setBounds(40, 600, 120, 30);
        add(labelstate);

        textstate = new JTextField();
        textstate.setFont(new Font("Helvetica", Font.BOLD, 14));
        textstate.setBounds(170, 600, 250, 30);
        add(textstate);


        next = new JButton("Next");
        next.setFont(new Font("Helvetica", Font.BOLD, 14));
        next.setForeground(Color.WHITE);
        next.setBackground(new Color(2, 14, 28));
        next.setBounds(410, 670, 100, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(new Color(193, 80, 109));
        setLayout(null);
        setSize(600, 800);
        setLocation(350, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textclientname.getText();
        String fathername = textfathername.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (malebutton.isSelected()){
            gender = "Male";
        }
        else if (femalebutton.isSelected()){
            gender = "Female";
        }
        String email = textemail.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "married";

        }
        else if(unmarried.isSelected()){
            marital = "Unmarried";

        }
        else if(other.isSelected()){
            marital = "Other";

        }
        String address = textaddress.getText();
        String city = textcity.getText();
        String pin = textpin.getText();
        String state = textstate.getText();
        try{
            if(textclientname.getText().equals("")){
                JOptionPane.showMessageDialog(null,"You have left the field empty. Try again.");
            }
            else{
                Conn con1 = new Conn();
                String q = "insert into signup values('"+formno+"','"+name+"', '"+fathername+"', '"+dob+"', '"+gender+"','"+email+"', '"+marital+"', '"+address+"','"+city+"','"+pin+"','"+state+"')";
                con1.statement.executeUpdate(q);
                new Signup2(formno);
                setVisible(false);


            }
        }
        catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
