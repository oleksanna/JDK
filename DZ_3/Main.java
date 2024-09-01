package DZ_3;

public class Main {
    public static void main(String[] args) {
        // Пример использования Calculator
        System.out.println("Sum: " + Calculator.sum(5, 3.5));
        System.out.println("Multiply: " + Calculator.multiply(4, 2.5));
        System.out.println("Divide: " + Calculator.divide(10, 2));
        System.out.println("Subtract: " + Calculator.subtract(9.5, 4));

        // Пример использования ArrayUtils
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3};
        Integer[] array3 = {1, 2, 4};
        System.out.println("Arrays equal: " + ArrayUtils.compareArrays(array1, array2));
        System.out.println("Arrays equal: " + ArrayUtils.compareArrays(array1, array3));

        // Пример использования Pair
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println("Pair: " + pair);

        // Пример использования DatabaseOperations через DatabaseManager
        DatabaseOperations dbOps = new DatabaseManager();
        dbOps.save("First Entry");
        dbOps.save("Second Entry");
        dbOps.fetch(1); // Should fetch "First Entry"
        dbOps.delete("First Entry");
        dbOps.fetch(1); // Should return null or indicate not found
    }
}