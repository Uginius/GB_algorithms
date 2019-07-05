package Lesson2;

import java.util.Random;

public class Study {
    public static void main(String[] args) {
        int n = 30;
        Random rand = new Random();
        int[] studyArray = new int[n];
        for (int i = 0; i < n; i++) {
            studyArray[i] = rand.nextInt(500);
//            System.out.print(studyArray[i] + "  ");
        }
    }
}
