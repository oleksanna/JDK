package DZ_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChatUI extends JFrame {
    private JTextArea chatHistory;
    private JTextField messageField;
    private JButton sendButton;
    private ChatHistoryManager historyManager;

    public ChatUI() {
        setTitle("Chat Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatHistory = new JTextArea();
        chatHistory.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatHistory);
        add(scrollPane, BorderLayout.CENTER);

        messageField = new JTextField();
        messageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        historyManager = new ChatHistoryManager();
        loadChatHistory();

        setVisible(true);
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            chatHistory.append("You: " + message + "\n");
            historyManager.saveMessage("You: " + message + "\n");
            messageField.setText("");
        }
    }

    private void loadChatHistory() {
        String history = historyManager.loadHistory();
        if (history != null) {
            chatHistory.append(history);
        }
    }
}