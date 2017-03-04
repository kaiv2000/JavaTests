package Reflection.GetCurrentClassName;

public class Helper {

    public static String getCurrentclassName() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            return e.getStackTrace()[1].getClassName();
        }
    }
}
