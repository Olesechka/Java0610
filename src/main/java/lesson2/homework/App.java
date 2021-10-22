package lesson2.homework;

public class App {

    public static void main(String[] args) throws Exception {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        summArr(arr);
    }

    public static void checkArr(String[][] arr) throws Exception {
        int maxLength = 4;
        for (int k = 0; k < maxLength; k++) {
            if ((arr.length != maxLength) || (arr[k].length != maxLength)) {
                throw new MyArraySizeException();
            }
        }
    }

    public static void summArr(String[][] arr) throws Exception {
        int sum = 0;
        checkArr(arr);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println();
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println(sum);
    }


    static class MyArraySizeException extends Exception {
        public MyArraySizeException() {
            super("Не подходящий размер массива");
        }
    }

    static class MyArrayDataException extends Exception {
        public MyArrayDataException(int i, int j) {
            super("Error at (" + (i + 1) + ", " + (j + 1) + ")");
        }
    }
}
