package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername,tfpassword;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel lblusername = new JLabel("username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150,20,120,30);
        add(tfusername);

        JLabel lblpassword = new JLabel("password");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(150,70,120,30);
        add(tfpassword);

        JButton login = new JButton("Login");
        login.setBounds(150,140,120,30);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            String query = "select * from login where username ='"+username+"' and password = '"+password+"'";
            Conn c = new employee.management.system.Conn();
            ResultSet re =c.s.executeQuery(query);
            if (re.next()){
                setVisible(false);
                new Home();
            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Login();
    }

}
