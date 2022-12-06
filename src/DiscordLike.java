import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A class to fulfill the requirement of showing a GUI. In this case it imitates a text
 */
public class DiscordLike {
    /**
     * The psvm to run the GUI
     * @param args not used
     */
    public static void main(String[] args) {
        // Create the main frame for the GUI
        JFrame frame = new JFrame("Discord");
        frame.setLayout(new BorderLayout());

        // Create the panel for the chat messages
        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout());

        // Create the text area for the chat messages
        JTextArea chatBox = new JTextArea();
        chatBox.setEditable(false);
        chatBox.setLineWrap(true);
        chatBox.setWrapStyleWord(true);

        // Add the chat box to a scroll pane to allow scrolling
        JScrollPane chatScroll = new JScrollPane(chatBox);
        chatScroll.setPreferredSize(new Dimension(500, 300));

        // Add the chat scroll pane to the chat panel
        chatPanel.add(chatScroll, BorderLayout.CENTER);

        // Create the panel for the message input and send button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        // Create the text field for the message input
        JTextField inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(400, 30));

        // Create the button for sending messages
        JButton sendButton = new JButton("Send");

        // Add the input field and send button to the input panel
        inputPanel.add(inputField);
        inputPanel.add(sendButton);

        // Add the chat panel and input panel to the main frame
        frame.add(chatPanel, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.pack(); // Resize the window to fit the components
        frame.setVisible(true);

        // Add an action listener to the send button
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                if (!message.isEmpty()) {
                    chatBox.append(message + "\n");
                    inputField.setText("");
                }
            }
        });
    }
}
