package kaprekarsConstant;

import java.util.Arrays;


//
//6174 is known as one of Kaprekar's constants, after the Indian mathematician D. R. Kaprekar. Number 6174 is notable for the following rule:
//
//        Take any four-digit number, using at least two different digits (leading zeros are allowed).
//        Arrange the digits in descending and then in ascending order to get two four-digit numbers, adding leading zeros if necessary.
//        Subtract the smaller number from the bigger number.
//        Go back to step 2 and repeat.
//        The above process, known as Kaprekar's routine, will always reach its fixed point, 6174, in at most 7 iterations.
//        Once 6174 is reached, the process will continue yielding 7641 – 1467 = 6174. For example, choose 3524:


public class Kaprekar  {
    private static int kaprekarCount;


    public static void main(String[] args) {
        System.out.println(kaprekar(456));
    }

    public static int kaprekar(int number){
            kaprekarCount = 0;
	    kaprekarForm(number);
            return kaprekarCount;
    }

    public static int kaprekarForm(int number){
        kaprekarCount++;
        int [] fourDigit = createArray(number);
        int [] ascending = sortAscend(fourDigit);
        int [] descending = sortDescend(fourDigit);
        number = subtract(ascending, descending);
        if(number!=6174){
            number = kaprekarForm(number);
        }
        return number;
    }

    private static int [] createArray (int number){
        int [] array = new int[4];
        for(int i=0; i<array.length ; i++){
            array[((array.length - i)-1)] = number % 10;
            number /= 10;
        }
        return array;
    }

    private static int [] sortAscend(int [] fourDigit){
        int [] array = Arrays.copyOf(fourDigit, 4);
        Arrays.sort(array);
        return array;
    }

    private static int [] sortDescend(int [] fourDigit){
        int [] array = Arrays.copyOf(fourDigit, 4);
        Arrays.sort(array);
        int[] temp = new int[4];
        for (int i=0; i<4; i++){
            temp[i] = array[(array.length - i)-1];
        }

        return temp;
    }

    private static int subtract (int[] ascend, int[] descend){
        int a1 = toDigit(ascend);
        int a2 = toDigit(descend);
        int result = a1 - a2;
        System.out.println(a1 + " - " + a2 + " = " + result);
        return result;
    }

    private static int toDigit(int [] arr){
        int result = 0;
        for(int i = 0; i< arr.length; i++){
            result += arr[i] * Math.pow(10.00, (double)i);
        }
        return result;
    }
}
