#Graphical User Interface Design using Java Swing API

CODE:
Student Registration Form (Two JFrames)
    
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration {
    public static void main(String[] args) {
        new RegistrationForm();
    }
}

class RegistrationForm extends JFrame implements ActionListener {
    JTextField nameField, rollField;
    JRadioButton male, female;
    JCheckBox read, play, music;
    JComboBox<String> deptBox;
    JButton submit;

    RegistrationForm() {
        setTitle("Student Registration");
        setSize(350, 300);
        setLayout(new GridLayout(6, 2, 5, 5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JLabel("Name:"));
        nameField = new JTextField(); add(nameField);

        add(new JLabel("Roll No:"));
        rollField = new JTextField(); add(rollField);

        add(new JLabel("Gender:"));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup g = new ButtonGroup(); g.add(male); g.add(female);
        JPanel gp = new JPanel(); gp.add(male); gp.add(female);
        add(gp);

        add(new JLabel("Hobbies:"));
        read = new JCheckBox("Reading");
        play = new JCheckBox("Sports");
        music = new JCheckBox("Music");
        JPanel hp = new JPanel(); hp.add(read); hp.add(play); hp.add(music);
        add(hp);

        add(new JLabel("Department:"));
        deptBox = new JComboBox<>(new String[]{"CSE", "ECE", "EEE", "MECH", "CIVIL"});
        add(deptBox);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        add(submit);
        add(new JLabel());

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String roll = rollField.getText();
        String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "Not Selected");
        String hobbies = (read.isSelected() ? "Reading " : "") +
                         (play.isSelected() ? "Sports " : "") +
                         (music.isSelected() ? "Music " : "");
        if (hobbies.isEmpty()) hobbies = "None";
        String dept = (String) deptBox.getSelectedItem();

        JOptionPane.showMessageDialog(this,
            "Name: " + name + "\nRoll No: " + roll + "\nGender: " + gender +
            "\nHobbies: " + hobbies + "\nDepartment: " + dept,
            "Student Details", JOptionPane.INFORMATION_MESSAGE);
    }
}


CODE:
Simple Calculator (Single JFrame)

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    JTextField num1Field, num2Field;
    JButton addBtn, subBtn, mulBtn, divBtn;

    SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        num1Field = new JTextField();
        num2Field = new JTextField();
        addBtn = new JButton("Add");
        subBtn = new JButton("Subtract");
        mulBtn = new JButton("Multiply");
        divBtn = new JButton("Divide");

        add(new JLabel("First Number:"));
        add(num1Field);
        add(new JLabel("Second Number:"));
        add(num2Field);

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(addBtn);
        panel.add(subBtn);
        panel.add(mulBtn);
        panel.add(divBtn);
        add(panel);

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(num1Field.getText());
            double n2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            if (e.getSource() == addBtn) {
                result = n1 + n2;
            } else if (e.getSource() == subBtn) {
                result = n1 - n2;
            } else if (e.getSource() == mulBtn) {
                result = n1 * n2;
            } else if (e.getSource() == divBtn) {
                if (n2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!");
                    return;
                }
                result = n1 / n2;
            }

            JOptionPane.showMessageDialog(this, "Result: " + result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}

