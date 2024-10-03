package hospital.management.system;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.chrono.MinguoDate;

public class Update_Patient_Detail extends JFrame {

    Update_Patient_Detail(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);



        JLabel label1 = new JLabel("UPDATE PATIENT DETAIL");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD, 20));
        label1.setForeground(Color.white);
        panel.add(label1);



        JLabel label2 = new JLabel("NAME :");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN, 14));
        label2.setForeground(Color.white);
        panel.add(label2);



        Choice choice = new Choice();
        choice.setBounds(248, 85, 140, 25);
        panel.add(choice);



        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("NAME"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }


        JLabel label3 = new JLabel("ROOM NUMBER :");
        label3.setBounds(25,129,150,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN, 14));
        label3.setForeground(Color.white);
        panel.add(label3);



        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248, 129, 140, 20);
        panel.add(textFieldR);



        JLabel label4 = new JLabel("IN TIME :");
        label4.setBounds(25,174,150,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN, 14));
        label4.setForeground(Color.white);
        panel.add(label4);



        JTextField textFieldINTime = new JTextField();
        textFieldINTime.setBounds(248, 174, 140, 20);
        panel.add(textFieldINTime);



        JLabel label5 = new JLabel("AMOUNT PAID(Rs) :");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN, 14));
        label5.setForeground(Color.white);
        panel.add(label5);



        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248, 216, 140, 20);
        panel.add(textFieldAmount);



        JLabel label6 = new JLabel("PENDING AMOUNT(Rs) :");
        label6.setBounds(25,261,200,14);
        label6.setFont(new Font("Tahoma",Font.PLAIN, 14));
        label6.setForeground(Color.white);
        panel.add(label6);



        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248, 261, 140, 20);
        panel.add(textFieldPending);



        JButton check = new JButton("CHECK");
        check.setBounds(281, 378, 89, 23);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "SELECT * FROM patient_info where NAME = '" +id+ "'";
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while(resultSet.next()){
                        textFieldR.setText(resultSet.getString("ROOM_NUMBER"));
                        textFieldINTime.setText(resultSet.getString("TIME"));
                        textFieldAmount.setText(resultSet.getString("DEPOSITE"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("SELECT * FROM ROOM where ROOM_NO = '"+textFieldR.getText()+"'");
                    while(resultSet1.next()){
                        String price = resultSet1.getString("PRICE");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);
                    }
                }
                catch(Exception E){
                    E.printStackTrace();
                }

            }
        });


        JButton update = new JButton("UPDATE");
        update.setBounds(56, 378, 89, 23);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTime.getText();
                    String amount = textFieldAmount.getText();
                    c.statement.executeUpdate("update patient_info set ROOM_NUMBER = '"+room+"', TIME = '"+time+"', DEPOSITE = '"+amount+"' where NAME = '"+q+"'");
                            JOptionPane.showConfirmDialog(null,"Update Successfully");
                    setVisible(false);
                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }
        });



        JButton back = new JButton("BACK");
        back.setBounds(168, 378, 89, 23);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });






        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);


        setUndecorated(true);
        setSize(950, 500);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    public static void main(String args[]){
        new Update_Patient_Detail();
    }
}
;