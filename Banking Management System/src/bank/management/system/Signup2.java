package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    JComboBox comboBox, comboBox2, comboBox3, comboBox4;
    JTextField texttin, textpini;
    JRadioButton yesbutton, nobutton, existbutton, notexistbutton;
    JButton next;


    String formno;
    Signup2(String formno){
        super("Bank Account Registration Form");

        ImageIcon bankimg1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bankimg2 = bankimg1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon bankimg3 = new ImageIcon(bankimg2);
        JLabel bankimg = new JLabel(bankimg3);
        bankimg.setBounds(30,5,100,100);
        add(bankimg);
        this.formno = formno;
        JLabel pagelabel = new JLabel("Page 2");
        pagelabel.setFont(new Font("Helvetica", Font.BOLD, 22));
        pagelabel.setBounds(300,30,600,40);
        add(pagelabel);
        JLabel addlabel = new JLabel("Additonal Information");
        addlabel.setFont(new Font("Helvetica", Font.BOLD,22));
        addlabel.setBounds(300,60,600,40);
        add(addlabel);

        JLabel religionlabel = new JLabel("Religion");
        religionlabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        religionlabel.setBounds(100,120,100,30);
        add(religionlabel);
        String religion[]={"Muslim", "Christian", "Jew", "Buddhist", "Hindu", "Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(193, 80, 109));
        comboBox.setFont(new Font("Helvetica", Font.BOLD, 14));
        comboBox.setBounds(350, 120, 320, 30);
        add(comboBox);

        JLabel incomelabel = new JLabel("Income: ");
        incomelabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        incomelabel.setBounds(100,170,100,30);
        add(incomelabel);
        String income[]={"Null", "<100,000", "<300,000", "<1,000,000", ">1,000,000"};

        comboBox2 = new JComboBox(income);
        comboBox2.setBackground(new Color(193, 80, 109));
        comboBox2.setFont(new Font("Helvetica", Font.BOLD, 14));
        comboBox2.setBounds(350, 170, 320, 30);
        add(comboBox2);
        JLabel educationlabel = new JLabel("Education: ");
        educationlabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        educationlabel.setBounds(100,220,150,30);
        add(educationlabel);
        String education[]={"Non-graduate" , "Bachelor's degree", "Master's degree", "Doctorate degree", "postgraduate diplomas"};
        comboBox3 = new JComboBox(education);
        comboBox3.setBackground(new Color(193, 80, 109));
        comboBox3.setFont(new Font("Helvetica", Font.BOLD, 14));
        comboBox3.setBounds(350, 220, 320, 30);
        add(comboBox3);
        JLabel occupationlabel = new JLabel("Occupation: ");
        occupationlabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        occupationlabel.setBounds(100,270,150,30);
        add(occupationlabel);
        String occupation[]={"Salaried Employee" , "Self-Employed", "Entrepreneur", "Student", "Retired", "Unemployed"};
        comboBox4 = new JComboBox(occupation);
        comboBox4.setBackground(new Color(193, 80, 109));
        comboBox4.setFont(new Font("Helvetica", Font.BOLD, 14));
        comboBox4.setBounds(350, 270, 320, 30);
        add(comboBox4);
        JLabel tinlabel = new JLabel("TIN: ");
        tinlabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        tinlabel.setBounds(100,320,150,30);
        add(tinlabel);

        texttin = new JTextField();
        texttin.setFont(new Font("Helvetica", Font.BOLD, 14));
        texttin.setBounds(350,320,320,30);
        texttin.setBackground(new Color(193, 80, 109));
        add(texttin);
        JLabel piniLabel = new JLabel("PINI: ");
        piniLabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        piniLabel.setBounds(100,370,150,30);
        add(piniLabel);

        textpini = new JTextField();
        textpini.setFont(new Font("Helvetica", Font.BOLD, 14));
        textpini.setBounds(350,370,320,30);
        textpini.setBackground(new Color(193, 80, 109));
        add(textpini);

        JLabel seniorlabel = new JLabel("Senior Citizen: ");
        seniorlabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        seniorlabel.setBounds(100,420,250,30);
        add(seniorlabel);

        yesbutton = new JRadioButton("Yes");
        yesbutton.setFont(new Font("Helvetica", Font.BOLD, 14));
        yesbutton.setBackground(new Color(193, 80, 109));
        yesbutton.setBounds(350,420,100,30);
        add(yesbutton);
        nobutton = new JRadioButton("No");
        nobutton.setFont(new Font("Helvetica", Font.BOLD, 14));
        nobutton.setBackground(new Color(193, 80, 109));
        nobutton.setBounds(460,420,100,30);
        add(nobutton);
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(yesbutton);
        seniorgroup.add(nobutton);


        JLabel existingacclabel = new JLabel("Existing Account: ");
        existingacclabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        existingacclabel.setBounds(100,470,250,30);
        add(existingacclabel);

        existbutton = new JRadioButton("Yes");
        existbutton.setFont(new Font("Helvetica", Font.BOLD, 14));
        existbutton.setBackground(new Color(193, 80, 109));
        existbutton.setBounds(350,470,100,30);
        add(existbutton);
        notexistbutton = new JRadioButton("No");
        notexistbutton.setFont(new Font("Helvetica", Font.BOLD, 14));
        notexistbutton.setBackground(new Color(193, 80, 109));
        notexistbutton.setBounds(460,470,100,30);
        add(notexistbutton);

        ButtonGroup existgroup = new ButtonGroup();
        existgroup.add(existbutton);
        existgroup.add(notexistbutton);
        JLabel formnumlabel = new JLabel("Form No: ");
        formnumlabel.setFont(new Font("Helvetica", Font.BOLD, 18));
        formnumlabel.setBounds(700,10,100,30);
        add(formnumlabel);

        JLabel formlabel = new JLabel(formno);
        formlabel.setFont(new Font("Helvetica", Font.BOLD, 16));
        formlabel.setBounds(780,10,150,30);
        add(formlabel);
        next = new JButton("Next");
        next.setFont(new Font("Helvetica", Font.BOLD, 14));
        next.setForeground(Color.WHITE);
        next.setBackground(new Color(2, 14, 28));
        next.setBounds(570, 640, 100, 30);
        next.addActionListener(this);
        add(next);
        setLayout(null);
        setSize(850,750);
        setLocation(450,80);
        getContentPane().setBackground(new Color(193, 80, 109));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();
        String inc = (String) comboBox2.getSelectedItem();
        String edu = ((String) comboBox3.getSelectedItem()).replace("'", "''");

        String occ = (String) comboBox4.getSelectedItem();
        String ti = texttin.getText();
        String pi = textpini.getText();
        String citizen = " ";
        if((yesbutton.isSelected())){
            citizen = "Yes";

        }
        else if(nobutton.isSelected()){
            citizen = "No";

        }

        String exists = " ";
        if((existbutton.isSelected())){
            exists = "Yes";

        }
        else if(notexistbutton.isSelected()){
            exists = "No";

        }

        try{
            if(texttin.getText().equals("")||textpini.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please provide the required data.");
            }
            else{
              Conn c1 = new Conn();
              String q = "insert into signuptwo values('" + formno + "', '" + rel + "', '" + inc + "', '" + edu + "', '" + occ + "', '" + ti + "', '" + pi + "', '" + citizen + "', '" + exists + "')";
              c1.statement.executeUpdate(q);
              new Signup3(formno);
              setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Signup2("");

    }
}
