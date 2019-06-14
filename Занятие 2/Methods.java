package ht2;

public class Methods {


    public int minNumber(int a, int b) {
        int min;
        if (a > b) {
            min = a;
        } else min = b;
        return min;
    }

    public boolean isEven(int a) {
        boolean b;
        if (a % 2 == 0) {
            b = true;
        } else b = false;
        return b;
    }

    public int squareNumber(int a) {
        int b;
        b = (int) Math.pow(a, 2);
        return b;
    }

    public int cubeNumber(int a) {
        int b;
        b = (int) Math.pow(a, 3);
        return b;
    }
}
