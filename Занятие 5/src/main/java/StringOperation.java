public class StringOperation {

    public String getReplace(String str) {
        return str.replace('f', 'g');
    }

    public String getTrim(String str) {
        return str.trim();
    }

    public String stringToUpperCase(String str) {
        return str.toUpperCase();
    }

    public String getSubString(String str, int beginIndex) {
        return str.substring(beginIndex);
    }

    public String getReplaceAll(String str) {
        return str.replaceAll("bob", "pop");
    }
}
