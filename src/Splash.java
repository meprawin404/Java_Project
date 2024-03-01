package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {

    Splash(){
        setTitle("Employee Management System");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("Employee Management System");
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.BLUE);
        heading.setBounds(80,30,1200,60);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("front.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(40,100,900,510);
        add(image);

        JButton clickhere = new JButton("Click Here To Continue");
        clickhere.setBounds(350,350,150,30);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);

        setLocation(150,30);
        setSize(1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args){
        new Splash();
    }
}