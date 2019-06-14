
public class Task1_0 {

    public static void main(String[] args) {

        int a;
        int i = 7;
        a = ++i;
        System.out.println("a = " + a + "\ni = " + i);
//      Сначала i увеличили на 1, т.е. i = 8, потом a присвоили i. Т.е. a тоже равно 8
//      Вывод программы:
//        a = 8
//        i = 8

        int a2;
        int i2 = 7;
        a2 = i2++;
        System.out.println("a2 = " + a2 + "\ni2 = " + i2);
//        Тут сначала мы a2 присвоили i2, т.е.а2 = 7, i2 увеличивается на 1, т.е.i2 = 8
//        Вывод программы:
//        a2 = 7
//        i2 = 8
    }
}
