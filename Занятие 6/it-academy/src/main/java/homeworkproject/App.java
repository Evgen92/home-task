package homeworkproject;

public class App{

    public int countWords(String str) {
        return str.split(" ").length;
    }

    public String endWord(String str) {
        String[] wordsMas = str.split(" ");
        return wordsMas[wordsMas.length - 1];
    }

    public int getMult(int a, int b){
        return a * b;
    }
}
