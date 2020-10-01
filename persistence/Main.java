package persistence;

public class Main {
    //
//    The additive persistence of an integer, n, is the number of times you have to replace n with the sum of its digits until n becomes a single digit integer.
//
//    The multiplicative persistence of an integer, n, is the number of times you have to replace n with the product of its digits until n becomes a single digit integer.
//
//    Create two functions that take an integer as an argument and:
//
//    Return its additive persistence.
//    Return its multiplicative persistence.


    public static void main(String[] args) {
        System.out.println(addPersistence(1999999999));
        System.out.println(mltPersistence(123456));
    }

    public static long mltPersistence(int value){
        int counter = 0;
        int tempValue;
        int tempMlt = 0;
        while(value > 9){
            counter ++;
            tempValue = value;
            tempMlt = 1;
            while(tempValue > 0){
                tempMlt *= (tempValue % 10);
                tempValue /= 10;
            }
            value = tempMlt;
        }
        return counter;
    }

    public static int addPersistence(int value) {
        int counter = 0;
        int tempValue;
        int tempAdd = 0;
        while (value > 9) {
            counter++;
            tempValue = value;
            tempAdd = 0;
            while (tempValue > 0) {
                tempAdd += (tempValue % 10);
                tempValue = (tempValue / 10);
            }
            value = tempAdd;
        }
        return counter;
    }


}
