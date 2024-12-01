package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;

    JButton button1, button2, button3;
    Login()
    {
        super("Bank Management System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);


        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/card.jpg"));
        Image i12 = i11.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel image1 = new JLabel(i13);
        image1.setBounds(630,350,100,100);
        add(image1);

        label1 = new JLabel("Welcome to ATM");
        label1.setForeground(Color.BLACK);                                  // Optional Bydefault text color is black
        label1.setFont(new Font("Calligrapher",Font.BOLD,38));
        label1.setBounds(250,125,450,40);
        add(label1);

        label2 = new JLabel("Card No: ");
        label2.setForeground(Color.BLACK);                                    // Optional Bydefault text color is black
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setBounds(150,188,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        add(textField2);

        label3 = new JLabel("Pin: ");
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325,250,230,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField3);

        button1 = new JButton("Sign In");
        button1.setFont(new Font("Arial", Font.BOLD,14));
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.DARK_GRAY);
        button1.setBounds(340,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Clear");
        button2.setFont(new Font("Arial", Font.BOLD,14));
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.DARK_GRAY);
        button2.setBounds(440,300,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Sign Up");
        button3.setFont(new Font("Arial", Font.BOLD,14));
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.DARK_GRAY);
        button3.setBounds(390,335,100,30);
        button3.addActionListener(this);
        add(button3);


        ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.jpg"));
        Image i22 = i21.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon i23 = new ImageIcon(i22);
        JLabel image2 = new JLabel(i23);
        image2.setBounds(0,0,850,480);
        add(image2);


        setLayout(null);
        setSize(850, 480);
        setLocation(450,200);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if(e.getSource()==button1){
                Con c = new Con();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String q = "select * from login where card_no = '"+cardno+"' and pin = '"+pin+"' ";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    setVisible(false);
                    new Main_Class(pin);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Card No or Pin");
                }

            } else if (e.getSource()==button2) {
                textField2.setText("");
                passwordField3.setText("");
                
            } else if (e.getSource()==button3) {
                new Signup();
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        Login log = new Login();
    }

}
