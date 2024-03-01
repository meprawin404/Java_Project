package employee.management.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import employee.management.system.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JLabel labelempid1;
    JTextField  tfname, tffname, tfsalary, tAddress, tphone, temail, tdesignation, tcitizen;
    JDateChooser dcdob;
    JComboBox ceducation;
    JButton Add, Back;
    public AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("Add New Employee");
        heading.setBounds(300,20,500,40);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(170,100,150,30);
        add(tfname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,100,120,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(550,100,150,30);
        add(tffname);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,150,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(170,150,150,30);
        add(dcdob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,150,120,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(550,150,150,30);
        add(tfsalary);

        JLabel labelAddress = new JLabel("Address");
        labelAddress.setBounds(50,200,120,30);
        labelAddress.setFont(new Font("serif",Font.PLAIN,20));
        add(labelAddress);

        tAddress = new JTextField();
        tAddress.setBounds(170,200,150,30);
        add(tAddress);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(400,200,120,30);
        labelPhone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelPhone);

        tphone = new JTextField();
        tphone.setBounds(550,200,150,30);
        add(tphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,250,120,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        temail= new JTextField();
        temail.setBounds(170,250,150,30);
        add(temail);

        JLabel labeleducation = new JLabel("education");
        labeleducation.setBounds(400,250,120,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleducation);
        String[] courses = {"BBA","BCA","BA","BSC","B.COM","BTech","BESE","BECE","BEIT","MCA","MA","MBA","PHD"};
        ceducation = new JComboBox(courses);
        ceducation.setBounds(550,250,150,30);
        ceducation.setBackground(Color.WHITE);
        add(ceducation);

        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,300,120,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        tdesignation= new JTextField();
        tdesignation.setBounds(170,300,150,30);
        add(tdesignation);

        JLabel labelcitizen = new JLabel("Citizenship Card.No");
        labelcitizen.setBounds(400,300,120,30);
        labelcitizen.setFont(new Font("serif",Font.PLAIN,20));
        add(labelcitizen);
        tcitizen = new JTextField();
        tcitizen.setBounds(550,300,150,30);
        add(tcitizen);

        JLabel labelempid = new JLabel("Employee ID");
        labelempid.setBounds(50,350,120,30);
        labelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid);
        labelempid1 = new JLabel(""+number);
        labelempid1.setBounds(170,350,120,30);
        labelempid1.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid1);

        Add = new JButton("Add Details");
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.setBounds(250,410,120,30);
        Add.addActionListener(this);
        add(Add);

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(400,410,120,30);
        Back.addActionListener(this);
        add(Back);


        setLocation(150,30);
        setSize(900,550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == Add){
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tAddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education =(String) ceducation.getSelectedItem();
            String designation = tdesignation.getText();
            String citizenNO = tcitizen.getText();
            String empId = labelempid1.getText();

            try {
                    Conn conn = new employee.management.system.Conn();
                    String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+citizenNO+"', '"+empId+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Details added successfully");
                    setVisible(false);
                    new Home();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args){
        new AddEmployee();
    }
}
