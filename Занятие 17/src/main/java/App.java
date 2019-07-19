public class App {

    public static void main(String[] args) throws ClassNotFoundException {
        QuaryUtil.getInstance().get(DBIndex.USERID);
        QuaryUtil.getInstance().get(DBIndex.LOGIN);
        QuaryUtil.getInstance().get(DBIndex.PASSWORD);
        QuaryUtil.getInstance().get(DBIndex.ADDRESSEE);
        QuaryUtil.getInstance().get(DBIndex.TEXT);
    }


}
