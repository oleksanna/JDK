package DZ_3;

import java.util.HashMap;
import java.util.Map;

public class DatabaseManager implements DatabaseOperations {
    private Map<Integer, String> database = new HashMap<>();
    private int currentId = 1;

    @Override
    public void save(String data) {
        database.put(currentId++, data);
        System.out.println("Data saved: " + data);
    }

    @Override
    public void delete(String data) {
        database.values().removeIf(value -> value.equals(data));
        System.out.println("Data deleted: " + data);
    }

    @Override
    public String fetch(int id) {
        String data = database.get(id);
        System.out.println("Fetched data: " + data);
        return data;
    }
}
