package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {

    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Pin(String pin)
    {
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("Change Pin");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD,16));
        label1.setBounds(600,180,400,35);
        l3.add(label1);

        JLabel label2 = new JLabel("New Pin");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD,16));
        label2.setBounds(430,230,150,35);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(600,230,180,25);
        p1.setFont(new Font("Ralwey",Font.BOLD,22));
        l3.add(p1);

        JLabel label3 = new JLabel("Re-Enter New Pin");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD,16));
        label3.setBounds(430,265,400,35);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(600,265,180,25);
        p2.setFont(new Font("Ralwey",Font.BOLD,22));
        l3.add(p2);


        b1 = new JButton("Change");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.DARK_GRAY);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.DARK_GRAY);
        b2.addActionListener(this);
        l3.add(b2);

        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
                String pin1 = p1.getText();
                String pin2 = p2.getText();

                if(!pin1.equals(pin2)){
                    JOptionPane.showMessageDialog(null,"Entered Pin Does Not Match");
                    return;
                }

                if(e.getSource()==b1){
                    if(p1.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Enter New Pin");
                        return;
                    }

                    if(p2.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Enter New Pin");
                        return;
                    }

                    Con c = new Con();
                    String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                    String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                    String q3 = "update signup_three set pin = '"+pin1+"' where pin = '"+pin+"'";

                    c.statement.executeUpdate(q1);
                    c.statement.executeUpdate(q2);
                    c.statement.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null, "Pin Change Successfully");
                    setVisible(false);
                    new Main_Class(pin);
                } else if (e.getSource()==b2) {

                    new Main_Class(pin);
                    setVisible(false);
                }


        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        new Pin("");

    }
}
