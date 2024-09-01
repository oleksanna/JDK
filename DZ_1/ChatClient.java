package DZ_1;


import javax.swing.SwingUtilities;

public class ChatClient {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatUI();
            }
        });
    }
}