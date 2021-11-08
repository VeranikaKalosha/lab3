package tb.soft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginFrame extends JFrame implements ActionListener {


    Container container = getContentPane();
    JLabel ID = new JLabel("ID");
    JLabel password = new JLabel("PASSWORD");
    JTextField IDTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton login = new JButton("LOGIN");
    JButton cancel = new JButton("CANCEL");


    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setTitle("Login Form");
        setVisible(true);
        setBounds(10, 10, 350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        ID.setBounds(50, 50, 100, 30);
        password.setBounds(50, 120, 100, 30);
        IDTextField.setBounds(150, 50, 150, 30);
        passwordField.setBounds(150, 120, 150, 30);
        login.setBounds(50, 200, 100, 30);
        cancel.setBounds(200, 200, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(ID);
        container.add(password);
        container.add(IDTextField);
        container.add(passwordField);
        container.add(login);
        container.add(cancel);
    }

    public void addActionEvent() {
        login.addActionListener(this);
        cancel.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String userText;
            String pwdText;
            userText = IDTextField.getText();
            pwdText = String.valueOf(passwordField.getPassword());

            if (Mymap.getUser().containsKey(userText)) {
                if (Mymap.getUser().get(userText).equals(pwdText))
                    container.setBackground(Color.GREEN);
            } else container.setBackground(Color.RED);
        }
        if (e.getSource() == cancel) {
            IDTextField.setText("");
            passwordField.setText("");
            container.setBackground(null);
        }

    }

}

class Mymap {
    private static HashMap<String, String> user;

    static {
        user = new HashMap<String, String>();

        user.put("abcd", "1234");
        user.put("brrr", "brrr");
        user.put("noname", "nopassword");
    }

    public static HashMap<String, String> getUser() {
        return user;
    }
}

class Login {
    public static void main(String[] a) {

        LoginFrame frame = new LoginFrame();
    }

}
