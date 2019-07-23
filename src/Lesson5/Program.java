package Lesson5;

public class Program {
    public static void main(String[] args) {
        //double start = System.currentTimeMillis();
        System.out.println(RaiseToDegreeRec(-2, 4));
    }

    //6. Дано целое число a и натуральное число b. Возвести a в степень b.
    //a^b = a * a * ... * a - b раз
    //b - четное число!
    public static int RaiseToDegreeRec(int number, int degree) {
        if (number == 0 && degree == 0) throw new IllegalArgumentException(); //Нуль в нулевой степени не определен
        if (number == 0) return 0;
        if (degree == 0) return 1;
        if (degree == 1) return number;

        return RaiseToDegreeRec(number, degree - 1) * number;
    }

    public static int RaiseToDegree(int number, int degree) {
        int result = number;
        if (number == 0 && degree == 0) throw new IllegalArgumentException(); //Нуль в нулевой степени не определен
        if (number == 0) return 0;
        if (degree == 0) return 1;
        for (int i = 1; i < degree; i++) result *= number;
        return result;
    }

    //5. Даны два целых неотрицательных числа a и b.
    //Без использования операция умножения найти произведение чисел a и b.
    //a * b = a + a + ... + a - b раз
    //a * b = p(a, b) = (a + a + ... + a) + a = p(a, b - 1) + a

    public static int productRec(int a, int b) {
        if (a == 0 || b == 0) return 0;
        else if (a == 1) return b;
        else if (b == 1) return a;
        else if (a > b) return productRec(a, b - 1) + a;
        else return productRec(b, a - 1) + b;
    }

    public static int product(int a, int b) {
        int sum = 0;
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b > 0) {
            sum += a;
            b--;
        }
        return sum;
    }

    //4. Дано натуральное число n. Найти сумму цифр числа n.
    //n = 3758 => sd(3758) = (3 + 5 + 7) + 8 = sd(357) + 8 = 23
    //3758 / 10 = 375
    //3758 % 10 = 8
    //sd(n) - сумма цифр числа n
    //sd(n) = sd(n / 10) + n % 10

    public static int digitSumRec(int n) {
        if (n < 10) return n;
        else return digitSumRec(n / 10) + n % 10;
    }

    public static int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            int disgit = n % 10;
            sum += disgit;
            n /= 10;
        }
        return sum;
    }


    //3. Дано натуральное число n. Найти n-ое треугольное число.
    //t(n) - n-ое треугольное число
    //t(n) = [1 + 2 + ... + (n - 1)] + n = t(n - 1) + n

    public static int triangleRec(int n) {
        if (n == 1) return 1;
        else return triangleRec(n - 1) + n;
    }

    public static int triangle(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n;
            n--;
        }
        return sum;
    }

    //2. Дано натуральное число n. Найти факториал числа n.
    //n! = [1 * 2 * 3 * ... * (n - 1)] * n = (n - 1)! * n
    //f(n) - метод для нахождения факториала числа n;
    //f(n) = f(n - 1) * n

    public static long factRec(int n) {
        if (n == 1) return 1;
        else return factRec(n - 1) * n;
    }

    public static long fact(int n) {
        long product = 1;

        while (n > 0) {
            product *= n;
            n--;
        }
        return product;
    }

    //1. Дано натуральное число n. Найти n-ый член последовательности чисел Фибоначчи
    //f(0) = 0 f(1) = 1, f(2) = 1, f(n) = f(n-1) + f(n-2)
    //f(3) = 2, f(4) = 3, f(5) = 5, f(6) = 8, f(7) = 13, f(8) = 21, f(9) = 34, f(10) = 55
    //f(n)/f(n-1) = 1.618 = число фи

    public static long phiboRec(int n) {
        System.out.print("f(" + n + ") -> ");
        if (n == 1 || n == 2) return 1;
        else return phiboRec(n - 1) + phiboRec(n - 2);
    }

    public static long phibo(int n) {
        long current = 1;
        int currentNumber = 1;
        long previous = 0;

        while (currentNumber < n) {
            long next = current + previous;
            previous = current;
            current = next;
            currentNumber++;
        }
        return current;
    }
}
