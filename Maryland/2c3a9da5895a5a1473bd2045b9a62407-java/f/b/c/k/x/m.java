package f.b.c.k.x;

import android.util.Log;

public class m {

    public enum a {
        DEBUG,
        WARN,
        NONE
    }

    public static void a(a aVar, String str, String str2, Object... objArr) {
        if (aVar.ordinal() >= 1) {
            String str3 = String.format("(%s) [%s]: ", "21.6.0", str) + String.format(str2, objArr);
            int ordinal = aVar.ordinal();
            if (ordinal == 0) {
                Log.i("Firestore", str3);
            } else if (ordinal == 1) {
                Log.w("Firestore", str3);
            } else if (ordinal == 2) {
                throw new IllegalStateException("Trying to log something on level NONE");
            }
        }
    }
}
