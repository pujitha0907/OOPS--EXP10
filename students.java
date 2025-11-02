#Graphical User Interface Design using Java Swing API

CODE:
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration {
    public static void main(String[] args) {
        new RegistrationFrame();
    }
}

class RegistrationFrame extends JFrame implements ActionListener {
    JTextField nameField, rollField;
    JRadioButton male, female;
    JCheckBox reading, sports, music;
    JComboBox<String> deptBox;
    JButton submitBtn;

    RegistrationFrame() {
        setTitle("Student Registration Form");
        setSize(400, 400);
        setLayout(new GridLayout(8, 2, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Roll Number:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout());
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderPanel.add(male);
        genderPanel.add(female);
        add(genderPanel);


        add(new JLabel("Hobbies:"));
        JPanel hobbyPanel = new JPanel(new FlowLayout());
        reading = new JCheckBox("Reading");
        sports = new JCheckBox("Sports");
        music = new JCheckBox("Music");
        hobbyPanel.add(reading);
        hobbyPanel.add(sports);
        hobbyPanel.add(music);
        add(hobbyPanel);

        add(new JLabel("Department:"));
        String[] departments = {"CSE", "ECE", "EEE", "MECH", "CIVIL"};
        deptBox = new JComboBox<>(departments);
        add(deptBox);

        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(this);
        add(submitBtn);

        add(new JLabel(""));

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String roll = rollField.getText();
        String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "Not Selected");

        StringBuilder hobbies = new StringBuilder();
        if (reading.isSelected()) hobbies.append("Reading ");
        if (sports.isSelected()) hobbies.append("Sports ");
        if (music.isSelected()) hobbies.append("Music ");
        if (hobbies.length() == 0) hobbies.append("None");

        String dept = (String) deptBox.getSelectedItem();

        new DisplayFrame(name, roll, gender, hobbies.toString(), dept);
        dispose(); 
    }
}

class DisplayFrame extends JFrame {
    DisplayFrame(String name, String roll, String gender, String hobbies, String dept) {
        setTitle("Student Details");
        setSize(350, 300);
        setLayout(new GridLayout(6, 1, 5, 5));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Name: " + name));
        add(new JLabel("Roll Number: " + roll));
        add(new JLabel("Gender: " + gender));
        add(new JLabel("Hobbies: " + hobbies));
        add(new JLabel("Department: " + dept));

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());
        add(closeBtn);

        setVisible(true);
    }
}

