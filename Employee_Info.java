package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_Info extends JFrame {

    Employee_Info(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990, 590);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);



        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(table);



        try{
            conn c = new conn();
            String q = "SELECT * FROM Emp_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch(Exception e){
            e.printStackTrace();
        }


        JLabel label1 = new JLabel("NAME");
        label1.setBounds(12, 11, 70, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);



        JLabel label2 = new JLabel("AGE");
        label2.setBounds(175, 11, 70, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);



        JLabel label3 = new JLabel("PHONE NUMBER");
        label3.setBounds(338, 11, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);



        JLabel label4 = new JLabel("SALARY");
        label4.setBounds(500, 11, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);



        JLabel label5 = new JLabel("GMAIL");
        label5.setBounds(665, 11, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);



        JLabel label6 = new JLabel("AADHAR NUMBER");
        label6.setBounds(828, 11, 150, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label6);


        JButton button = new JButton("BACK");
        button.setBounds(435, 500, 120, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(1000, 600);
        setLocation(350, 230);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String args[]){
        new Employee_Info();
    }
}
