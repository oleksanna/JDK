package DZ_2;

public class ChatServer {
    public static void main(String[] args) {
        ChatRepository repository = new ChatRepository();
        ChatView view = new ChatView();
        ChatController controller = new ChatController(repository, view);
    }
}
