package h.a.j1;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public interface z2 {
    public static final z2 a = new a();

    /* loaded from: classes.dex */
    public class a implements z2 {
        @Override // h.a.j1.z2
        public long a() {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        }
    }

    long a();
}
