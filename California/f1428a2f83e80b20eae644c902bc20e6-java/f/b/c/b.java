package f.b.c;

import androidx.annotation.RecentlyNonNull;
import e.b.a.m;

public class b extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(@RecentlyNonNull String str) {
        super(str);
        m.h.n(str, "Detail message must not be empty");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(@RecentlyNonNull String str, @RecentlyNonNull Throwable th) {
        super(str, th);
        m.h.n(str, "Detail message must not be empty");
    }
}
