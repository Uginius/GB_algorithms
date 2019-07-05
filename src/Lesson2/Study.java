package Lesson2;

import java.util.Random;

public class Study {
    public static void main(String[] args) {
        int n = 100; // размер массива
        int range = 500; // диапазон для  генератора случайного числа
        Random rand = new Random();
        StudyArrayList<Integer> studyArray = new StudyArrayList<Integer>();

        for (int i = 0; i < n; i++) studyArray.add(rand.nextInt(range));
        System.out.println(studyArray);
        StudyArrayList<Integer> array1 = new StudyArrayList<Integer>();
        StudyArrayList<Integer> array2 = new StudyArrayList<Integer>();
//        NewArray(studyArray, array1, array2);

//        System.arraycopy(studyArray,0, array1,0, n);

        array1.sortInsertion(new MyComporator());
        System.out.println(studyArray);
//        array2.sortSelection(Integer::compareTo);
//        System.out.println(array2);
    }

    private static void NewArray(StudyArrayList<Integer> studyArray, StudyArrayList<Integer> array1, StudyArrayList<Integer> array2) {
        for (int i = 0; i < studyArray.getSize(); i++) {
            array1.add(studyArray[i]);
//            System.out.println(studyArray[i]);
        }
    }

}
