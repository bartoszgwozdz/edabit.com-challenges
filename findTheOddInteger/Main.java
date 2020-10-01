package findTheOddInteger;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Integer, Integer> numberOccurrences;

//    Create a function that takes an array and finds the integer which appears an odd number of times.
//
//    Examples
//    findOdd([1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5]) ➞ -1
//
//    findOdd([20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5]) ➞ 5
//
//    findOdd([10]) ➞ 10
//    Notes
//    There will always only be one integer that appears an odd number of times.

    public static void main(String[] args) {
        int [] temp = {20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5};

        System.out.println(findOdd(temp));
    }

    public static int findOdd(int[] tab) {
        numberOccurrences = createMap(tab);
        int numWithOddOccurrences = scanForOddOccurrences (numberOccurrences);
        return numWithOddOccurrences;
    }

    public static Map<Integer, Integer> createMap(int[] tab) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int arrayValue : tab) {
            int occurrence = tempMap.getOrDefault(arrayValue, 0);
            tempMap.put(arrayValue, ++occurrence);
        }
        return tempMap;
    }
    public static int scanForOddOccurrences (Map <Integer, Integer> tempMap ){
        for (Map.Entry <Integer, Integer> entry : tempMap.entrySet()){
            if((entry.getValue()%2) != 0){
                return entry.getKey();
            }
        }
        return 0;
    }
}
