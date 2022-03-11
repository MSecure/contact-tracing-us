package f.b.a.c.b.o;

import android.content.Context;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import java.util.Objects;

public final class a {
    @RecentlyNonNull
    public static boolean a(@RecentlyNonNull Context context, @RecentlyNonNull Throwable th) {
        try {
            Objects.requireNonNull(context, "null reference");
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }
}
