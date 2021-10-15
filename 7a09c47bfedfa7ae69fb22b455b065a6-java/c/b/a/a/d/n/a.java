package c.b.a.a.d.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ServiceConnection;
import androidx.annotation.RecentlyNonNull;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final Object f3169b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f3170c;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> f3171a = new ConcurrentHashMap<>();

    @SuppressLint({"UntrackedBindService"})
    public void a(@RecentlyNonNull Context context, @RecentlyNonNull ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
    }
}
