package lesson5;


import java.util.Arrays;

public class HomeApp {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static final float[] arr = new float[SIZE];

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime + " ms"));
    }

    public static void secondMethod() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long startTime = System.currentTimeMillis();
        splitAndMergeArray(arr);
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime + " ms"));

    }

    public static void splitAndMergeArray(float[] arr) {
        System.out.println(Arrays.toString(arr));
//        System.out.println(arr.length);
        float[] leftHalf = new float[HALF];
        float[] rightHalf = new float[HALF];
        System.arraycopy(arr, 0, leftHalf, 0, HALF);
        System.arraycopy(arr, HALF + 1, rightHalf, 0, HALF - 1);
        System.out.println(Arrays.toString(leftHalf));
        System.out.println(Arrays.toString(rightHalf));

        float[] mergedArray = new float[SIZE];
        System.arraycopy(leftHalf, 0, mergedArray, 0, HALF);
        System.arraycopy(rightHalf, 0, mergedArray, HALF + 1, HALF - 1);
        System.out.println(Arrays.toString(mergedArray));
//        System.out.println(mergedArray.length);
    }


}
