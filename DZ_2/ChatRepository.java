package DZ_2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class ChatRepository {
    private static final String LOG_FILE = "DZ_2" + File.separator + "chat_history.txt";

    public void saveMessage(String message) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(LOG_FILE, true), StandardCharsets.UTF_8))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadHistory() {
        if (Files.exists(Paths.get(LOG_FILE))) {
            StringBuilder history = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(LOG_FILE), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    history.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return history.toString();
        }
        return null;
    }
}