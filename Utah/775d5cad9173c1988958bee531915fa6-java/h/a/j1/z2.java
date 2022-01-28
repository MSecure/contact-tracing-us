package h.a.j1;

import java.util.concurrent.TimeUnit;

public interface z2 {
    public static final z2 a = new a();

    public class a implements z2 {
        @Override // h.a.j1.z2
        public long a() {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        }
    }

    long a();
}
