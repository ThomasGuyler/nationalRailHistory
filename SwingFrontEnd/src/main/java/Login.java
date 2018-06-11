import Message_Processing.HTTP_Utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    public static JLabel userLabel = new JLabel("User");
    public static JTextField userText = new JTextField(20);
    public static JLabel passwordLabel = new JLabel("Password");
    public static JPasswordField passwordText = new JPasswordField(20);
    public static JButton loginButton = new JButton("login");

    public static void main(String[] args) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("Login");
        // Setting the width and height of frame
        frame.setSize(300, 160);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Creating panel. This is same as a div tag in HTML
         * We can create several panels and add them to specific
         * positions in a JFrame. Inside panels we can add text
         * fields, buttons and other components.
         */
        JPanel panel = new JPanel();
        // adding panel to frame
        frame.add(panel);
        /* calling user defined method for adding components
         * to the panel.
         */
        defineComponents(panel);

        // Setting the frame visibility to true
        frame.setVisible(true);
    }

    private static void defineComponents(JPanel panel) {
        // Set the layout to null
        panel.setLayout(null);

        //User Label.
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        //User Field.
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        //Password Label.
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /*Password Field.
         *This is similar to text field but it hides the user
         *entered data and displays dots instead.*/
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        //Login Button.
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        //add action listener for Login Button.
        loginButton.addActionListener(new loginAction());
    }

    private static class loginAction implements ActionListener{

        public void actionPerformed(ActionEvent e){

            HTTP_Utilities.setUsername(userText.getText());
            HTTP_Utilities.setPassword(String.valueOf(passwordText.getPassword()));

            if (Test.loginTest()) {
                JOptionPane.showMessageDialog(null, "Login Successful",
               "Login Attempt", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed",
               "Login Attempt", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}
