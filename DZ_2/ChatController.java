package DZ_2;

public class ChatController {
    private ChatRepository repository;
    private ChatView view;

    public ChatController(ChatRepository repository, ChatView view) {
        this.repository = repository;
        this.view = view;
        initialize();
    }

    private void initialize() {
        String history = repository.loadHistory();
        if (history != null) {
            view.setChatHistory(history);
        }

        view.setSendMessageHandler(message -> {
            repository.saveMessage(message);
            view.appendMessageToChat(message);
        });
    }
}
