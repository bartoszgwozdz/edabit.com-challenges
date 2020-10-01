package palindrome;

public class Palindrome {

    public static void main(String[] args) {
        int test = 11211230;
        System.out.println(palindromeDescendant(test));
//        System.out.println(palindromeCheck(7));
    }

    public static boolean palindromeDescendant(int number) {
        boolean isPalindrome = false;
        if (numberValidate(number)) {
            isPalindrome = palindromeCheck(number);
            while ((!isPalindrome) && (number > 10)) {
                number = makeDescendant(number);
                isPalindrome = palindromeCheck(number);
            }
        }
        return isPalindrome;
    }

    private static boolean numberValidate(int number) {
        String temp = Integer.toString(number);
        if ((temp.length() % 2) == 0 && (number > 9)) return true;
        else return false;
    }

    private static boolean palindromeCheck(int number) {
//        String temp = Integer.toString(number);
//        if(number<10) return false;
//        for (int i = 0; i < temp.length() / 2; i++) {
//            if ( (temp.charAt(i) != temp.charAt((temp.length() - 1) - i))) {
//                return false;
//            }
//        }
//        return true;
        if(number < 10)return false;
        String temp = Integer.toString(number);
        String reversed = "";
        for(int i=temp.length()-1; i>= 0; i--){
            reversed += temp.charAt(i);
        }
        if (number == Integer.parseInt(reversed)){
            return true;
        }
        return false;
    }

    private static int makeDescendant (int number){
        String temp = Integer.toString(number);
        String descendant = "";
        for (int i=0; i < temp.length()-1; i +=2){
            int a, b;
            a = Integer.parseInt(String.valueOf(temp.charAt(i)));
            System.out.println("A is " + a);
            b = Integer.parseInt(String.valueOf(temp.charAt(i+1)));
            System.out.println("B is " + b);
            int sum = (a + b);
            descendant += sum;

        }
        System.out.println("New descendant is " + descendant);
        return Integer.parseInt(descendant);
    }
}
