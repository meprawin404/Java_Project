package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton Add,View,Update,Delete;
    public Home(){
        setTitle("Employee Management System");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Home.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1000,600);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(500,20,400,40);
        heading.setFont(new Font("TAHOMA",Font.BOLD,25));
        image.add(heading);

        Add = new JButton("Add Employee");
        Add.setBounds(500,80,150,30);
        Add.addActionListener(this);
        image.add(Add);

        View= new JButton("View Employee");
        View.setBounds(700,80,150,30);
        View.addActionListener(this);
        image.add(View);

        Update = new JButton("Update Employee");
        Update.setBounds(500,140,150,30);
        Update.addActionListener(this);
        image.add(Update);

        Delete = new JButton("Remove Employee");
        Delete.setBounds(700,140,150,30);
        Delete.addActionListener(this);
        image.add(Delete);

        setLocation(150,30);
        setSize(1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == Add){
            setVisible(false);
            new employee.management.system.AddEmployee();

        } else if (ae.getSource() == Update) {
            setVisible(false);
            new employee.management.system.ViewEmployee();

        } else if (ae.getSource() == View) {
            setVisible(false);
            new employee.management.system.ViewEmployee();

        }else {
                setVisible(false);
                new employee.management.system.RemoveEmployee();
        }
    }
    public static void main(String[] args){
        new Home();
    }
}
