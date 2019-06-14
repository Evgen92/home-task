import java.util.Scanner;

public class Task2_10 {

    public static void main(String[] args) {
        Scanner masScan = new Scanner(System.in);
        System.out.println("Введите размер массива при помощи клавиатуры: ");
        int size = masScan.nextInt();
        int[] mas = new int[size];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 10);
            System.out.print(mas[i] + " ");
        }

        System.out.println();
        boolean Posl = true;
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] <= mas[i - 1]) {
                Posl = false;
                break;
            }
        }
        if (Posl) {
            System.out.println("Массив является возрастающей последовательностью");
        } else {
            System.out.println("Массив не является возрастающей последовательностью");
        }
    }
}


