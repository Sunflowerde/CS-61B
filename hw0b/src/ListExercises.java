import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int cnt = 0;
        if (L.isEmpty()) {
            return 0;
        } else {
            for (Integer integer : L) {
                cnt += integer;
            }
        }
        return cnt;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (int a : L) {
            if (a % 2 == 0) {
                evenNumbers.add(a);
            }
        }
        return evenNumbers;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> commonNumbers = new ArrayList<>();
        for (int a : L1) {
            if (L2.contains(a)) {
                commonNumbers.add(a);
            }
        }
        return commonNumbers;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int cnt = 0;
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}
