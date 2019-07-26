package Lesson5;

public class HanoiTower {

    public static void main(String[] args) {
        int count = 3; // количество колец
        moveRings(count, 1, 2, 3);
    }

    private static void moveRings(int n, int rod_A, int rod_B, int rod_C) {
        if (n == 0) return;
        moveRings(n - 1, rod_A, rod_C, rod_B);
        System.out.println("from " + rod_A + " to " + rod_B);
        moveRings(n - 1, rod_C, rod_B, rod_A);
    }

}
