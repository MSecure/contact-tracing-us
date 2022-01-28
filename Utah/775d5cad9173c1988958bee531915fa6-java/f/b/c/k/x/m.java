package f.b.c.k.x;

public class m {

    public enum a {
        DEBUG,
        WARN,
        NONE
    }

    public static void a(a aVar, String str, String str2, Object... objArr) {
        if (aVar.ordinal() >= 1) {
            String.format("(%s) [%s]: ", "21.6.0", str);
            String.format(str2, objArr);
            if (aVar.ordinal() == 2) {
                throw new IllegalStateException("Trying to log something on level NONE");
            }
        }
    }
}
