package f.b.a.c.b.o;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import java.util.Objects;
/* loaded from: classes.dex */
public final class a {
    @RecentlyNonNull
    public static boolean a(@RecentlyNonNull Context context, @RecentlyNonNull Throwable th) {
        try {
            Objects.requireNonNull(context, "null reference");
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
