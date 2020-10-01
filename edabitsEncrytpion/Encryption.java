package edabitsEncrytpion;


public class Encryption {


    public static void main(String[] args) {
        String test = "chillout";
        String withoutSpaces = removeSpaces(test);
        System.out.println("Without spaces: " + withoutSpaces + " length: " + withoutSpaces.length());
        char[][] asGrid = createGrid(withoutSpaces);
        System.out.println("Size of grid:  " + asGrid.length + " rows, " + asGrid[0].length + " chars in row.");
        showGrid(asGrid);
        String output = encrypt(asGrid);
        System.out.println("Encrypted: " + output);

//        String input = "chillout";
//        System.out.println("Input: " + input);
//        String output = encryption(input);
//        System.out.println("Output: " + output);

    }

    public static String encryption(String inputSentence) {
        String withoutSpaces = removeSpaces(inputSentence);
        char[][] asGrid = createGrid(withoutSpaces);
        return encrypt(asGrid);
    }

    private static String removeSpaces(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ') {
                output.append(c);
            }
        }
        return output.toString();
    }

    private static char[][] createGrid(String input) {
        double size = findSizeOfGrid(input);
        int rowsNumber = (int) size;
        int columnsNumber = (int) size;
        if (size % 1 > 0) {
            columnsNumber++;
        }
        if (size % 1 >= 0.5) {
            rowsNumber++;
        }
//        if ((size*size) == input.length()){
//            columnsNumber--;
//        }else if (rowsNumber * columnsNumber < input.length()) {
//            rowsNumber++;
//        }
        char[][] grid = new char[rowsNumber][columnsNumber];
        int indexOfChar;
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < columnsNumber; j++) {
                indexOfChar = ((i) * columnsNumber) + j;
                if (indexOfChar < input.length()) {
                    grid[i][j] = input.charAt(indexOfChar);
                }
            }
        }
        return grid;
    }

    private static double findSizeOfGrid(String input) {
        int length = input.length();
        double sqrt = Math.sqrt(length);
        return sqrt;
    }

    private static String encrypt(char[][] grid) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < grid[0].length; i++) {
            for (char[] chars : grid) {
                temp.append(chars[i]);
            }
            temp.append(' ');
        }
        temp.deleteCharAt(temp.length() - 1);
        return temp.toString();
    }

    private static void showGrid(char[][] grid) {
        StringBuilder temp;
        for (char[] chars : grid) {
            temp = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                temp.append(chars[j]);
            }
            System.out.println(temp.toString());
        }
    }
}
