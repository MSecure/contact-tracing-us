package f.b.a.c.b.n;

import android.content.Context;
import android.content.ServiceConnection;
import androidx.annotation.RecentlyNonNull;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    public static final Object b = new Object();
    public static volatile a c;
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> a = new ConcurrentHashMap<>();

    public void a(@RecentlyNonNull Context context, @RecentlyNonNull ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
    }
}
