package DZ_3;

public interface DatabaseOperations {
    void save(String data);
    void delete(String data);
    String fetch(int id);
}