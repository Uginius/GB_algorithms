package Lesson2;

import java.util.Random;

public class Study {
    public static void main(String[] args) {
        int n = 30;
        Random rand = new Random();
        StudyArrayList<Integer> studyArray = new StudyArrayList<Integer>();
        for (int i = 0; i < n; i++) studyArray.add(rand.nextInt(500));
        System.out.println(studyArray);
        System.out.println(studyArray.getSize());
        System.out.println(studyArray.indexOf(50));

    }
}
