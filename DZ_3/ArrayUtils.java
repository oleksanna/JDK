package DZ_3;

import java.util.Objects;

public class ArrayUtils {

    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!Objects.equals(array1[i], array2[i])) {
                return false;
            }
        }
        return true;
    }
}