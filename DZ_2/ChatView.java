package DZ_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.function.Consumer;

public class ChatView extends JFrame {
    private JTextArea chatHistory;
    private JTextField messageField;
    private JButton sendButton;
    private Consumer<String> sendMessageHandler;

    public ChatView() {
        setTitle("Chat Server");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatHistory = new JTextArea();
        chatHistory.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatHistory);
        add(scrollPane, BorderLayout.CENTER);

        messageField = new JTextField();
        sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());

        // Add KeyListener for Enter key
        messageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void setChatHistory(String history) {
        chatHistory.setText(history);
    }

    public void appendMessageToChat(String message) {
        chatHistory.append(message + "\n");
    }

    public void setSendMessageHandler(Consumer<String> handler) {
        this.sendMessageHandler = handler;
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            if (sendMessageHandler != null) {
                sendMessageHandler.accept(message);
            }
            messageField.setText("");
        }
    }
}