package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_Discharge extends JFrame {

    Patient_Discharge(){


        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);



        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(100, 20, 150, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setForeground(Color.white);
        panel.add(label);



        JLabel label2 = new JLabel("CUSTOMER ID");
        label2.setBounds(30, 80, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        panel.add(label2);



        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        panel.add(choice);



        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("NUMBER"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }



        JLabel label3 = new JLabel("ROOM NUMBER");
        label3.setBounds(30, 130, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.white);
        panel.add(label3);



        JLabel RNo = new JLabel();
        RNo.setBounds(200, 130, 150, 20);
        RNo.setFont(new Font("Tahoma", Font.BOLD, 14));
        RNo.setForeground(Color.white);
        panel.add(RNo);



        JLabel label4 = new JLabel("IN TIME");
        label4.setBounds(30, 180, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.white);
        panel.add(label4);




        JLabel INTime = new JLabel();
        INTime .setBounds(200, 180, 250, 20);
        INTime .setFont(new Font("Tahoma", Font.BOLD, 14));
        INTime .setForeground(Color.white);
        panel.add(INTime);



        JLabel label5 = new JLabel("OUT TIME");
        label5.setBounds(30, 230, 250, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.white);
        panel.add(label5);



        Date date = new Date();

        JLabel OUTime = new JLabel(""+date);
        OUTime .setBounds(200, 230, 250, 20);
        OUTime .setFont(new Font("Tahoma", Font.BOLD, 14));
        OUTime .setForeground(Color.white);
        panel.add(OUTime);



        JButton discharge = new JButton("DISCHARGE");
        discharge.setBounds(30, 300, 120, 30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.white);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    c.statement.executeUpdate("DELETE FROM patient_info where NUMBER = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("UPDATE ROOM SET AVAILABILITY = 'Available' where ROOM_NO = '"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                }
                catch(Exception E){
                    E.printStackTrace();
                }

            }
        });




        JButton check = new JButton("CHECK");
        check.setBounds(170, 300, 120, 30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    ResultSet resultSet = c.statement.executeQuery("SELECT * FROM patient_info where NUMBER = '"+choice.getSelectedItem()+"'");
                    while(resultSet.next()){
                        RNo.setText(resultSet.getString("ROOM_NUMBER"));
                        INTime.setText(resultSet.getString("TIME"));
                    }
                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }
        });



        JButton back = new JButton("BACK");
        back.setBounds(300, 300, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });








        setUndecorated(true);
        setSize(800, 400);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);


    }

    public static  void main(String args[]){
        new Patient_Discharge();

    }
}
